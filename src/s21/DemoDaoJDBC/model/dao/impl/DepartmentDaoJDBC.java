package s21.DemoDaoJDBC.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.utils.db.DB;
import s21.DemoDaoJDBC.application.ProgramException;
import s21.DemoDaoJDBC.model.dao.DaoUtil;
import s21.DemoDaoJDBC.model.dao.DepartmentDao;
import s21.DemoDaoJDBC.model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao, DaoUtil {

	// atributos
	private Connection conn;
	
	// construtores
	public DepartmentDaoJDBC(Connection conn) {
		super();
		this.conn = conn;
	}
	
	// méotodos
	@Override
	public void insert(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findById(Integer id) {
		Department department = null;
		
		if(id == null) {
			throw new ProgramException("Não é possível buscar registros de Department com ID NULO na base de dados");
		}
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			pst = conn.prepareStatement(DaoJDBCQuerys.DEPARTMENT_FINDBYID.returnQuery());
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				department = instantiateDepartment(rs);
			}
					
		} catch (SQLException e) {
			throw new ProgramException(e.getMessage());
		} finally {
			DB.closeStatement(pst);
			DB.closeResultSet(rs);
		}
		
		return department;
	}

	@Override
	public List<Department> findAll() {
		List<Department> departments = new ArrayList<Department>();
				
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			pst = conn.prepareStatement(DaoJDBCQuerys.DEPARTMENT_FINDALL.returnQuery());
			rs = pst.executeQuery();
			
			while(rs.next()) {
				departments.add(instantiateDepartment(rs));
			}
					
		} catch (SQLException e) {
			throw new ProgramException(e.getMessage());
		} finally {
			DB.closeStatement(pst);
			DB.closeResultSet(rs);
		}
		
		return departments;
	}

}
