package s21.DemoDaoJDBC.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import common.utils.db.DB;
import s21.DemoDaoJDBC.application.ProgramException;
import s21.DemoDaoJDBC.model.dao.SellerDao;
import s21.DemoDaoJDBC.model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

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
		
		if(id != null) {	
			Connection conn = DB.getConnection();
			PreparedStatement pstCheck = null;
			ResultSet rsCheck = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
				
				// Verificando se temos um registro unico para o ID
				String sqlCheck = "select\r\n" + 
						"	count(s.Id) as 'count'\r\n" + 
						"from\r\n" + 
						"	seller s\r\n" + 
						"where\r\n" + 
						"	s.Id = ?;";
				pstCheck = conn.prepareStatement(sqlCheck);
				pstCheck.setInt(1, id);
				rsCheck = pstCheck.executeQuery();
				int numeroRegistros = 0;
				while(rsCheck.next()) {
					numeroRegistros = rsCheck.getInt("count"); 
				}
				if(numeroRegistros > 1) {
					throw new ProgramException(getClass() + ": findById retornou dois registros para um ID único na base!");
				}
				
				// Caso positivo, retornamos este registro na forma de objeto
				String sql = "select\r\n" + 
						"	s.*\r\n" + 
						"	,d.Name as 'DepName'\r\n" + 
						"from\r\n" + 
						"	seller s \r\n" + 
						"inner join department d \r\n" + 
						"	on s.Id = d.Id \r\n" + 
						"where \r\n" + 
						"	s.Id = ?";
				
				pst = conn.prepareStatement(sql);
				pst.setInt(1, id);
				rs = pst.executeQuery();
				
				while(rs.next()) {
//					seller = new Seller(rs.getInt("Id"),
//								name, email, birthDate, baseSalary, departament)
				}
				
				
				
				 
			} catch (SQLException e) {
				throw new ProgramException(e.getMessage());
			} finally {
				DB.closeStatement(pstCheck);
				DB.closeResultSet(rsCheck);
				DB.closeStatement(pst);
				DB.closeResultSet(rs);
				DB.closeConnection();
			}
			
		}
		
		return seller;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
