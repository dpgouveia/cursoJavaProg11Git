package common.utils.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	// atributos
	private static Connection conn = null;

	// metodos estaticos da classe
	private static Properties loadProperties() {
		String propertiesFilePath = ".\\properties\\db.properties";
		try (FileInputStream fis = new FileInputStream(propertiesFilePath)) {
			Properties props = new Properties();
			props.load(fis);
			return props;
		} catch (IOException e) {
			throw new DBException(e.getMessage());
		}
	}

	public static Connection getConnection() {

		if (conn == null) {
			Properties props = loadProperties();
			String url = props.getProperty("dburl");

			try {
				conn = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}

		}

		return conn;
	}

	public static void closeConnection() {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}

	}

	public static void closeStatement(Statement st) {

		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}

	}

	public static void closeResultSet(ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}

	}

}
