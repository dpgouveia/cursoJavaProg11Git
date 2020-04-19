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

	// m�todos
	@Override
	public void insert(Seller obj) {

		if (obj != null) {
			PreparedStatement pst = null;
			try {

				pst = conn.prepareStatement(DaoJDBCQuerys.SELLER_INSERT.returnQuery(), Statement.RETURN_GENERATED_KEYS);
				pst.setString(1, obj.getName());
				pst.setString(2, obj.getEmail());
				pst.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
				pst.setDouble(4, obj.getBaseSalary());
				pst.setInt(5, obj.getDepartament().getId());

				conn.setAutoCommit(false);
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
		}

	}

	@Override
	public void update(Seller obj) {
	
		if (obj != null) {
			PreparedStatement pst = null;
			try {

				pst = conn.prepareStatement(DaoJDBCQuerys.SELLER_UPDATE.returnQuery());
				pst.setString(1, obj.getName());
				pst.setString(2, obj.getEmail());
				pst.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
				pst.setDouble(4, obj.getBaseSalary());
				pst.setInt(5, obj.getDepartament().getId());
				pst.setInt(6, obj.getId());

				conn.setAutoCommit(false);
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
		}

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {

		Seller seller = null;

		if (id != null) {
			PreparedStatement pstCheck = null;
			ResultSet rsCheck = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			try {

				// Verificando se temos um registro unico para o ID
				pstCheck = conn.prepareStatement(DaoJDBCQuerys.SELLER_FINDBYID_CHECK.returnQuery());
				pstCheck.setInt(1, id);
				rsCheck = pstCheck.executeQuery();

				// Caso o registro seja �nico, criamos um objeto, populamos os dados e
				// retornarmos a refer�ncia dele
				if (rsCheck.next() && rsCheck.getInt("count") == 1) {
					pst = conn.prepareStatement(DaoJDBCQuerys.SELLER_FINDBYID.returnQuery());
					pst.setInt(1, id);
					rs = pst.executeQuery();

					if (rs.next()) {
						seller = instantiateSeller(rs, instantiateDepartment(rs));
					}

				}

			} catch (SQLException e) {
				throw new ProgramException(e.getMessage());
			} finally {
				DB.closeStatement(pstCheck);
				DB.closeResultSet(rsCheck);
				DB.closeStatement(pst);
				DB.closeResultSet(rs);
			}
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
