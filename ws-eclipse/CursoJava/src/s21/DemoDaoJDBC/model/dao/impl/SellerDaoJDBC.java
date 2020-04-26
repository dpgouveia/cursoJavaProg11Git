package s21.DemoDaoJDBC.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.utils.db.DB;
import s21.DemoDaoJDBC.application.ProgramException;
import s21.DemoDaoJDBC.model.dao.DaoUtil;
import s21.DemoDaoJDBC.model.dao.SellerDao;
import s21.DemoDaoJDBC.model.entities.Department;
import s21.DemoDaoJDBC.model.entities.Seller;

public class SellerDaoJDBC implements SellerDao, DaoUtil {

	// atributos
	private Connection conn;

	// construtores
	public SellerDaoJDBC(Connection conn) {
		super();
		this.conn = conn;
	}

	// métodos
	@Override
	public void insert(Seller obj) {

		if (obj != null) {

			if (obj.getId() != null) {
				throw new ProgramException(
						"Não é possível inserir um seller com ID previamente preenchido na base de dados");
			}

			PreparedStatement pst = null;
			try {

				pst = conn.prepareStatement(DaoJDBCQuerys.SELLER_INSERT.returnQuery(), Statement.RETURN_GENERATED_KEYS);
				pst.setString(1, obj.getName());
				pst.setString(2, obj.getEmail());
				pst.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
				pst.setDouble(4, obj.getBaseSalary());
				pst.setInt(5, obj.getDepartament().getId());

				if (pst.executeUpdate() > 0) {
					conn.commit();
					ResultSet rs = pst.getGeneratedKeys();
					if (rs.next()) {
						obj.setId(rs.getInt(1));
					}
					DB.closeResultSet(rs);
				} else {
					conn.rollback();
					throw new ProgramException("Erro durante a insercao do Seller na base de dados");
				}

			} catch (SQLException e) {
				throw new ProgramException(e.getMessage());
			} finally {
				DB.closeStatement(pst);
			}
		} else {
			throw new ProgramException("Nao é possível inserir um seller NULO na base de dados");
		}

	}

	@Override
	public void update(Seller obj) {

		if (obj != null) {

			if (obj.getId() == null) {
				throw new ProgramException("Não é possível atualizar um seller com ID NULO na base de dados");
			}

			PreparedStatement pst = null;
			try {

				pst = conn.prepareStatement(DaoJDBCQuerys.SELLER_UPDATE.returnQuery());
				pst.setString(1, obj.getName());
				pst.setString(2, obj.getEmail());
				pst.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
				pst.setDouble(4, obj.getBaseSalary());
				pst.setInt(5, obj.getDepartament().getId());
				pst.setInt(6, obj.getId());

				if (pst.executeUpdate() > 0) {
					conn.commit();
				} else {
					conn.rollback();
					throw new ProgramException("Erro durante o update do Seller na base de dados");
				}

			} catch (SQLException e) {
				throw new ProgramException(e.getMessage());
			} finally {
				DB.closeStatement(pst);
			}
		} else {
			throw new ProgramException("Nao é possível atualizar um seller NULO na base de dados");
		}

	}

	@Override
	public void deleteById(Integer id) {

		if (id == null) {
			throw new ProgramException("Não é possível excluir registro com ID NULO da base de dados");
		}

		if (findById(id) == null) {
			throw new ProgramException("O Seller ID informado não existe na base de dados");
		}

		PreparedStatement pst = null;
		try {

			pst = conn.prepareStatement(DaoJDBCQuerys.SELLER_DELETEBYID.returnQuery());
			pst.setInt(1, id);

			if (pst.executeUpdate() > 0) {
				conn.commit();
			} else {
				conn.rollback();
				throw new ProgramException("Erro durante o delete do Seller na base de dados");
			}

		} catch (SQLException e) {
			throw new ProgramException(e.getMessage());
		} finally {
			DB.closeStatement(pst);
		}

	}

	@Override
	public Seller findById(Integer id) {

		Seller seller = null;

		if (id == null) {
			throw new ProgramException("Não é possível buscar registros de Seller com ID NULO na base de dados");
		}

		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			pst = conn.prepareStatement(DaoJDBCQuerys.SELLER_FINDBYID.returnQuery());
			pst.setInt(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {
				seller = instantiateSeller(rs, instantiateDepartment(rs));
			}

		} catch (SQLException e) {
			throw new ProgramException(e.getMessage());
		} finally {
			DB.closeStatement(pst);
			DB.closeResultSet(rs);
		}

		return seller;
	}

	@Override
	public List<Seller> findByDepartment(Integer id) {

		List<Seller> sellers = new ArrayList<Seller>();

		if (id != null) {
			PreparedStatement pst = null;
			ResultSet rs = null;
			try {

				pst = conn.prepareStatement(DaoJDBCQuerys.SELLER_FINDBYDEPARTMENT.returnQuery());
				pst.setInt(1, id);
				rs = pst.executeQuery();

				if (rs.next()) {
					Department dept = instantiateDepartment(rs);
					sellers.add(instantiateSeller(rs, dept));
					while (rs.next()) {
						sellers.add(instantiateSeller(rs, dept));
					}
				}

			} catch (SQLException e) {
				throw new ProgramException(e.getMessage());
			} finally {
				DB.closeStatement(pst);
				DB.closeResultSet(rs);
			}
		}

		return sellers;
	}

	@Override
	public List<Seller> findAll() {
		List<Seller> sellers = new ArrayList<Seller>();
		Map<Integer, Department> departments = new HashMap<Integer, Department>();

		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			pst = conn.prepareStatement(DaoJDBCQuerys.SELLER_FINDALL.returnQuery());
			rs = pst.executeQuery();

			while (rs.next()) {
				Department dept = departments.get(rs.getInt("SellerDepartmentId"));
				if (dept == null) {
					dept = instantiateDepartment(rs);
					departments.put(dept.getId(), dept);
				}

				sellers.add(instantiateSeller(rs, dept));
			}

		} catch (SQLException e) {
			throw new ProgramException(e.getMessage());
		} finally {
			DB.closeStatement(pst);
			DB.closeResultSet(rs);
		}

		return sellers;
	}

}
