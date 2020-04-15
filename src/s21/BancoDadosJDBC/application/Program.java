package s21.BancoDadosJDBC.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Scanner;



import common.utils.MyUtils;
import common.utils.db.DB;
import s21.BancoDadosJDBC.exceptions.ProgramException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		Connection conn = DB.getConnection();

//		iniciarAula("229_exemplo_01", input, conn);

//		iniciarAula("230_exemplo_01", input, conn);

//		iniciarAula("231_exemplo_01", input, conn);
//		iniciarAula("231_exemplo_02", input, conn);
//		iniciarAula("231_exemplo_03", input, conn);
		
		iniciarAula("232_exemplo_01", input, conn);

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
					String query = "SELECT * FROM coursejdbc.department d";
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
			
			case "231_exemplo_01": {

				PreparedStatement pst = null;
				try {
					pst = conn.prepareStatement("INSERT INTO coursejdbc.seller " 
												+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
												+ "VALUES "
												+ "(?, ?, ?, ?, ?)");
					
					pst.setString(1, "Another Carl Purple");
					pst.setString(2, "other_carl@gmail.com");
//					pst.setDate(3, new java.sql.Date(MyUtils.dbSimpleDateToDate.parse("1985-04-22").getTime()));
					pst.setDate(3, new java.sql.Date(MyUtils.simpleDateToDate.parse("22/04/1985").getTime()));
					pst.setDouble(4, 4500.00);
					pst.setInt(5, 4);

					int linhasAfetadas = pst.executeUpdate();
					System.out.println("Tabela de vendedores atualizada. Número de linhas atualizadas: " + linhasAfetadas);
					
				} catch (SQLException e) {
					throw new ProgramException(aula + ": " + e.getMessage());
				} finally {
					DB.closeStatement(pst);
				}

				break;
			}
			
			case "231_exemplo_02": {

				PreparedStatement pst = null;
				try {
					pst = conn.prepareStatement("INSERT INTO coursejdbc.seller " 
												+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
												+ "VALUES "
												+ "(?, ?, ?, ?, ?)"
												, Statement.RETURN_GENERATED_KEYS);
					
					pst.setString(1, "Another Carl Purple");
					pst.setString(2, "other_carl@gmail.com");
					pst.setDate(3, new java.sql.Date(MyUtils.simpleDateToDate.parse("22/04/1985").getTime()));
					pst.setDouble(4, 4500.00);
					pst.setInt(5, 4);

					int linhasAfetadas = pst.executeUpdate();
					if(linhasAfetadas > 0) {
						ResultSet rs = pst.getGeneratedKeys();
						while(rs.next()) {
							int id = rs.getInt(1);
							System.out.println("ID = " + id);
						}
						
						DB.closeResultSet(rs);
					} else {
						System.out.println("Nenhuma linha foi atualizada/criada pela query");
					}
					
				} catch (SQLException e) {
					throw new ProgramException(aula + ": " + e.getMessage());
				} finally {
					DB.closeStatement(pst);
				}

				break;
			}
			
			case "231_exemplo_03": {

				PreparedStatement pst = null;
				try {
					pst = conn.prepareStatement("INSERT INTO department (Name) VALUES ('D1'), ('D2')"
												, Statement.RETURN_GENERATED_KEYS);

					int linhasAfetadas = pst.executeUpdate();
					if(linhasAfetadas > 0) {
						ResultSet rs = pst.getGeneratedKeys();
						while(rs.next()) {
							int id = rs.getInt(1);
							System.out.println("ID = " + id);
						}
						
						DB.closeResultSet(rs);
					} else {
						System.out.println("Nenhuma linha foi atualizada/criada pela query");
					}
					
				} catch (SQLException e) {
					throw new ProgramException(aula + ": " + e.getMessage());
				} finally {
					DB.closeStatement(pst);
				}

				break;
			}
			
			case "232_exemplo_01": {
				
				PreparedStatement pst = null;
				try {
					pst = conn.prepareStatement("UPDATE coursejdbc.seller "
												+ "SET BaseSalary = BaseSalary + ? "
												+ "WHERE "
												+ "(DepartmentID = ?)");
					
					pst.setDouble(1, 200.00);
					pst.setInt(2, 2);
					
					int linhasAfetadas = pst.executeUpdate();
					System.out.println("Linhas atualizadas na tabela pela query: " + linhasAfetadas);
					
				} catch (SQLException e) {
					throw new ProgramException(aula + ": " + e.getMessage());
				} finally {
					DB.closeStatement(pst);
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
