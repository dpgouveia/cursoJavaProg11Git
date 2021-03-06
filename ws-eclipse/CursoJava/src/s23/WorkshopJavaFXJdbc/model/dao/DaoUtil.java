 package s23.WorkshopJavaFXJdbc.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import s23.WorkshopJavaFXJdbc.model.entities.Department;
import s23.WorkshopJavaFXJdbc.model.entities.Seller;


public interface DaoUtil {
	
	default Seller instantiateSeller(ResultSet rs, Department dept) throws SQLException {
		return  new Seller(rs.getInt("SellerID"), 
				rs.getString("SellerName"),
				rs.getString("SellerEmail"),
				new Date(rs.getTimestamp("SellerBirthDate").getTime()),
				rs.getDouble("SellerBaseSalary"),
				dept);
	}
	
	default Department instantiateDepartment(ResultSet rs) throws SQLException {
		return new Department(rs.getInt("SellerDepartmentId"), rs.getString("DepartmentName"));
	}

}
