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

//			System.out.println();
//			System.out.println("==== TEST: seller insert()");
//
//			Department dept = new Department(1, "Computers");
//			Seller seller = new Seller(null, "Daniel", "daniel@gmail.com", MyUtils.simpleDateToDate.parse("02/03/1984"), 1000.00,
//					dept);
//			Seller seller = new Seller(8, "Daniel", "daniel@gmail.com", MyUtils.simpleDateToDate.parse("02/03/1984"), 1000.00,
//					dept);
//			
//			System.out.println("Before insert: " + seller);
//			sellerDao.insert(seller);
//			sellerDao.insert(null);
//			System.out.println("After insert: " + seller);

			
//			System.out.println();
//			System.out.println("==== TEST: seller update()");
//			Seller seller = sellerDao.findById(9);
//			seller.setId(null);
//			System.out.println("Before update: " + seller);
//			seller.setName("Martha Wayne");
//			sellerDao.update(seller);
//			System.out.println(" After update: " + seller);
			
			System.out.println();
			System.out.println("==== TEST: seller delete()");
			System.out.println("Before delete...");
			sellerDao.findAll().forEach(System.out::println);
//			sellerDao.deleteById(null);
//			sellerDao.deleteById(351);
			sellerDao.deleteById(8);
			System.out.println();
			System.out.println("After delete...");
			sellerDao.findAll().forEach(System.out::println);
			
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
			System.out.println("ERRO durante a execu��o da aplica��o!");
			System.out.println("Causa: ");
			e.printStackTrace();
			System.out.println("-------------------------------");
			System.out.println();
		} catch (Exception e) {
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("ERRO INESPERADO durante a execu��o da aplica��o!");
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
