package s21.DemoDaoJDBC.model.dao;

import common.utils.db.DB;
import s21.DemoDaoJDBC.model.dao.impl.DepartmentDaoJDBC;
import s21.DemoDaoJDBC.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

	// métodos estáticos
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}

}
