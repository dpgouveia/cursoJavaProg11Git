package s21.DemoDaoJDBC.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

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

				// Caso o registro seja único, criamos um objeto, populamos os dados e
				// retornarmos a referência dele
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

			while(rs.next()) {
				
				Department dept = departments.get(rs.getInt("SellerDepartmentId")); 
				if(dept == null) {
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
