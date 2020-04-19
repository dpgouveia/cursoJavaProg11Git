package s21.DemoDaoJDBC.application;

import common.utils.MyUtils;
import common.utils.db.DB;
import s21.DemoDaoJDBC.model.dao.DaoFactory;
import s21.DemoDaoJDBC.model.dao.SellerDao;
import s21.DemoDaoJDBC.model.entities.Department;
import s21.DemoDaoJDBC.model.entities.Seller;

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

//			System.out.println();
//			System.out.println("==== TEST: seller findById()");
//			System.out.println(sellerDao.findById(14));
//
//			System.out.println();
//			System.out.println("==== TEST: seller findByDepartment()");
//			sellerDao.findByDepartment(2).forEach(System.out::println);
//			sellerDao.findByDepartment(4).forEach(System.out::println);
//			sellerDao.findByDepartment(14).forEach(System.out::println);
//
//			System.out.println();
//			System.out.println("==== TEST: seller findAll()");
//			sellerDao.findAll().forEach(System.out::println);

			System.out.println();
			System.out.println("==== TEST: seller insert()");

			Department dept = new Department(1, "Computers");
			Seller seller = new Seller(1, "Daniel", "daniel@gmail.com", MyUtils.simpleDateToDate.parse("02/03/1984"), 1000.00,
					dept);
			
			System.out.println();
			System.out.println("Insering this seller into database: " + seller);
			sellerDao.insert(seller);
			
			System.out.println();
			sellerDao.findAll().forEach(System.out::println);
			System.out.println("After insert this seller: "  + seller);
			
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
