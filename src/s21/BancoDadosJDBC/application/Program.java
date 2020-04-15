package s21.BancoDadosJDBC.application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Scanner;

import common.utils.db.DB;
import s21.BancoDadosJDBC.exceptions.ProgramException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		Connection conn = DB.getConnection();

//		iniciarAula("229_exemplo_01", input, conn);
		iniciarAula("230_exemplo_01", input, conn);

		input.close();
		DB.closeConnection();

	}

	public static void iniciarAula(String aula, Scanner input, Connection conn) {

		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("INICIO DO PROGRAMA. AULA: " + aula);
		System.out.println();

		try {

			switch (aula) {

			case "229_exemplo_01": {
				// nada... somente para testar se a crição da conexão com o banco de dados
				// funcionou corretamente
				break;
			}

			case "230_exemplo_01": {

				Statement st = null;
				ResultSet rs = null;
				try {
					st = conn.createStatement();
					String query = "select * from coursejdbc.department d;";
					rs = st.executeQuery(query);

					while (rs.next()) {
						System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
					}

				} catch (SQLException e) {
					throw new ProgramException(aula + ": " + e.getMessage());
				} finally {
					DB.closeStatement(st);
					DB.closeResultSet(rs);
				}

				break;
			}

			default: {
				throw new ProgramException("Aula inexistente");
			}

			}

		} catch (ProgramException e) {
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println("ERRO NO PROGRAMA: " + e.getMessage());
			System.out.println("Encerrando programa....");
		} catch (RuntimeException e) {
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println("ERRO INESPERADO durante a execução do programa!");
			System.out.println("Encerrando programa....");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println("ERRO FATAL NA MAQUINA VIRTUAL JAVA durante a execução do programa!");
			System.out.println("Encerrando programa....");
			e.printStackTrace();
		} finally {
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println("FIM DO PROGRAMA. AULA: " + aula);
		}

	}
}
