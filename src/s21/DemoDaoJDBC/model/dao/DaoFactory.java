package s21.DemoDaoJDBC.model.dao;

import s21.DemoDaoJDBC.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}
	
}
