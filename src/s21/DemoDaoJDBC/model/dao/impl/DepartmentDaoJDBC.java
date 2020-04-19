package s21.DemoDaoJDBC.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	// m�otodos
	@Override
	public void insert(Department obj) {

		if(obj == null ) {
			throw new ProgramException("N�o � poss�vel inserir um Department NULO na base de dados");
		}
		
		if(obj.getId() != null) {
			throw new ProgramException("N�o � poss�vel inserir um Department com ID previamente preenchido na base de dados");
		}
		
		PreparedStatement pst = null;		
		try {
			pst = conn.prepareStatement(DaoJDBCQuerys.DEPARTMENT_INSERT.returnQuery(), Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, obj.getName());
			
			if (pst.executeUpdate() > 0) {
				conn.commit();
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					obj.setId(rs.getInt(1));
				}
				DB.closeResultSet(rs);
			} else {
				conn.rollback();
				throw new ProgramException("Erro durante a insercao do Department na base de dados");
			}
			
		} catch (SQLException e) {
			throw new ProgramException(e.getMessage());
		} finally {
			DB.closeStatement(pst);
		}
		
	}

	@Override
	public void update(Department obj) {
		
		if(obj == null ) {
			throw new ProgramException("N�o � poss�vel atualizar um Department NULO na base de dados");
		}
		
		if(obj.getId() == null) {
			throw new ProgramException("N�o � poss�vel atualizar um Department sem um ID previamente preenchido na base de dados");
		}
		
		PreparedStatement pst = null;		
		try {
			pst = conn.prepareStatement(DaoJDBCQuerys.DEPARTMENT_UPDATE.returnQuery());
			pst.setString(1, obj.getName());
			pst.setInt(2, obj.getId());
			
			if (pst.executeUpdate() > 0) {
				conn.commit();
			} else {
				conn.rollback();
				throw new ProgramException("Erro durante a atualiza��o do Department na base de dados");
			}
			
		} catch (SQLException e) {
			throw new ProgramException(e.getMessage());
		} finally {
			DB.closeStatement(pst);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		
		if(id == null ) {
			throw new ProgramException("N�o � poss�vel excluir um Department com ID NULO da base de dados");
		}
				
		PreparedStatement pst = null;		
		try {
			pst = conn.prepareStatement(DaoJDBCQuerys.DEPARTMENT_DELETEBYID.returnQuery());
			pst.setInt(1, id);
			
			if (pst.executeUpdate() > 0) {
				conn.commit();
			} else {
				conn.rollback();
				throw new ProgramException("Erro durante a exclus�o do Department na base de dados");
			}
			
		} catch (SQLException e) {
			throw new ProgramException(e.getMessage());
		} finally {
			DB.closeStatement(pst);
		}
		
	}

	@Override
	public Department findById(Integer id) {
		Department department = null;
		
		if(id == null) {
			throw new ProgramException("N�o � poss�vel buscar registros de Department com ID NULO na base de dados");
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
