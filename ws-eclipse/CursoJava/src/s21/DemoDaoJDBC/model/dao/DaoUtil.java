package s21.DemoDaoJDBC.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import s21.DemoDaoJDBC.model.entities.Department;
import s21.DemoDaoJDBC.model.entities.Seller;

public interface DaoUtil {
	
	default Seller instantiateSeller(ResultSet rs, Department dept) throws SQLException {
		return  new Seller(rs.getInt("SellerID"), 
				rs.getString("SellerName"),
				rs.getString("SellerEmail"),
				rs.getDate("SellerBirthDate"),
				rs.getDouble("SellerBaseSalary"),
				dept);
	}
	
	default Department instantiateDepartment(ResultSet rs) throws SQLException {
		return new Department(rs.getInt("SellerDepartmentId"), rs.getString("DepartmentName"));
	}

}
