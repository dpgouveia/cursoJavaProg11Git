package s21.DemoDaoJDBC.application;

import s21.DemoDaoJDBC.model.entities.Department;

public class Program {

	public static void main(String[] args) {

		System.out.println();
		System.out.println("-------------------------------");
		System.out.println("DEMO DAO JDBC - INICIO DO PROGRAMA...");

		try {

			Department dept = new Department(1, "Books");
			System.out.println(dept);

		} catch (ProgramException e) {
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("ProgramException: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("ERRO durante a execução da aplicação!");
			System.out.println("Causa: ");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("ERRO INESPERADO durante a execução da aplicação!");
			System.out.println("Causa: ");
			e.printStackTrace();
		} finally {
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("DEMO DAO JDBC - FIM DO PROGRAMA...");
		}

	}

}
