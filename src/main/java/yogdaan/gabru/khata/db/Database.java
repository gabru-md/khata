package yogdaan.gabru.khata.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import yogdaan.gabru.khata.utils.Checker;
import yogdaan.gabru.khata.utils.Errors;

public class Database {
	private final static String DATABASE_FOLDER = ".khata/db";
	private final static String DATABASE_NAME = "khata.sqlite3";
	private final static String DATABASE_HOME = System.getProperty("user.home");
	private final static String DATABASE_LOCATION = DATABASE_HOME + "/" + DATABASE_FOLDER + "/" + DATABASE_NAME;
	private final static String DATABASE_URI = "jdbc:sqlite:" + DATABASE_LOCATION;
	
	private final static String TEST_DATABASE_NAME = "test_khata.sqlite3";
	private final static String TEST_DATABASE_LOCATION = DATABASE_HOME + "/" + DATABASE_FOLDER + "/" + TEST_DATABASE_NAME;
	private final static String TEST_DATABASE_URI = "jdbc:sqlite:" + TEST_DATABASE_LOCATION;
	
	public static Connection getSQLDatabase() {
		Connection conn;
		try {
			conn = DriverManager.getConnection(DATABASE_URI);
			if(conn == null) {
				Errors.pushError(Checker.newException("Error while connecting to database!"));
				return null;
			}
		} catch(SQLException e) {
			Errors.pushError(e);
			return null;
		}
		return conn;
	}
	
	public static ResultSet runQueryAndFetchResult(Connection conn, SQLContext sqlQuery) {
		Statement stmt;
		ResultSet result;
		
		if(conn == null) {
			Errors.pushError(Checker.newException("conn object is null"));
			return null;
		}
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeQuery(sqlQuery.build());
		} catch (SQLException e) {
			Errors.pushError(e);
			return null;
		}
		return result;
	}
	
	
	public static Connection getTestSQLDatabase() {
		Connection conn;
		try {
			conn = DriverManager.getConnection(TEST_DATABASE_URI);
			if(conn == null) {
				Errors.pushError(Checker.newException("Error while connecting to database!"));
				return null;
			}
		} catch(SQLException e) {
			Errors.pushError(e);
			return null;
		}
		return conn;
	}
	
}
