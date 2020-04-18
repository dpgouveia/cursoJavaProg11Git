package s21.DemoDaoJDBC.application;

import common.utils.db.DB;
import s21.DemoDaoJDBC.model.dao.DaoFactory;
import s21.DemoDaoJDBC.model.dao.SellerDao;

public class Program {

	public static void main(String[] args) {

		System.out.println();
		System.out.println("-------------------------------");
		System.out.println("DEMO DAO JDBC - INICIO DO PROGRAMA...");
		System.out.println("-------------------------------");
		System.out.println();

		try {

//			Department dept = new Department(1, "Books");
//			System.out.println(dept);
//
//			Seller seller = new Seller(1, "Bob", "bob@gmail.com", MyUtils.simpleDateToDate.parse("17/04/1985"), 3000.00,
//					dept);
//			System.out.println(seller);

			SellerDao sellerDao = DaoFactory.createSellerDao();

			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("==== TEST: seller findById ====");
			System.out.println(sellerDao.findById(3));

			DB.closeConnection();

		} catch (ProgramException e) {
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("ProgramException: " + e.getMessage());
			System.out.println("-------------------------------");
			System.out.println();
		} catch (RuntimeException e) {
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("ERRO durante a execução da aplicação!");
			System.out.println("Causa: ");
			e.printStackTrace();
			System.out.println("-------------------------------");
			System.out.println();
		} catch (Exception e) {
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("ERRO INESPERADO durante a execução da aplicação!");
			System.out.println("Causa: ");
			e.printStackTrace();
			System.out.println("-------------------------------");
			System.out.println();
		} finally {
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("DEMO DAO JDBC - FIM DO PROGRAMA...");
			System.out.println("-------------------------------");
			System.out.println();
		}

	}

}
