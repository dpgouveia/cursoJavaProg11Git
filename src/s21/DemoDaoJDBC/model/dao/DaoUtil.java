package s21.DemoDaoJDBC.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import s21.DemoDaoJDBC.model.entities.Department;
import s21.DemoDaoJDBC.model.entities.Seller;

public interface DaoUtil {
	
	default Seller instantiateSeller(ResultSet rs, Department dept) throws SQLException {
		return  new Seller(rs.getInt("Id"), 
				rs.getString("Name"),
				rs.getString("Email"),
				rs.getDate("BirthDate"),
				rs.getDouble("BaseSalary"),
				dept);
	}
	
	default Department instantiateDepartment(ResultSet rs) throws SQLException {
		return new Department(rs.getInt("DepartmentId"), rs.getString("DepName"));
	}

}
