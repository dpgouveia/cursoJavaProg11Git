package s23.WorkshopJavaFXJdbc.model.dao;

import common.utils.db.DB;
import s23.WorkshopJavaFXJdbc.model.dao.impl.DepartmentDaoJDBC;
import s23.WorkshopJavaFXJdbc.model.dao.impl.SellerDaoJDBC;


public class DaoFactory {

	// métodos estáticos
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());

	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}

}
