package yogdaan.gabru.khata.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import yogdaan.gabru.khata.utils.Checker;
import yogdaan.gabru.khata.utils.Errors;

public class Database {
  private static final String DATABASE_FOLDER = ".khata/db";
  private static final String DATABASE_NAME = "khata.db";
  private static final String DATABASE_HOME = System.getProperty("user.home");
  private static final String DATABASE_LOCATION =
    DATABASE_HOME + "/" + DATABASE_FOLDER + "/" + DATABASE_NAME;
  private static final String DATABASE_URI = "jdbc:sqlite:" + DATABASE_LOCATION;

  private static final String TEST_DATABASE_NAME = "test_khata.db";
  private static final String TEST_DATABASE_LOCATION =
    DATABASE_HOME + "/" + DATABASE_FOLDER + "/" + TEST_DATABASE_NAME;
  private static final String TEST_DATABASE_URI = "jdbc:sqlite:" + TEST_DATABASE_LOCATION;

  private static Database testDatabase = null;
  private static Database localDatabase = null;

  private Connection conn;

  private Database(Connection conn) {
    this.conn = conn;
  }

  public static Database getSQLDatabase() {
    if (localDatabase != null) return localDatabase;

    Connection conn;
    try {
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection(DATABASE_URI);
      if (conn == null) {
        Errors.pushError(Checker.newException("Error while connecting to database!"));
        return null;
      }
    } catch (Exception e) {
      Errors.pushError(e);
      return null;
    }
    return localDatabase = new Database(conn);
  }

  public ResultSet runQueryAndFetchResult(SQLContext sqlQuery) {
    return runQueryAndFetchResult(sqlQuery.build());
  }

  public ResultSet runQueryAndFetchResult(String sqlQuery) {
    Statement stmt;
    ResultSet result;

    if (conn == null) {
      Errors.pushError(Checker.newException("conn object is null"));
      return null;
    }

    try {
      stmt = conn.createStatement();
      result = stmt.executeQuery(sqlQuery);
    } catch (SQLException e) {
      Errors.pushError(e);
      return null;
    }
    return result;
  }

  // runs Insert, Create, Update queries since it does not return any ResultSet.
  public int runICUQuery(SQLContext sqlQuery) {
    return runICUQuery(sqlQuery.build());
  }

  public int runICUQuery(String sqlQuery) {
    Statement stmt;
    int result;

    if (conn == null) {
      Errors.pushError(Checker.newException("conn object is null"));
      return -1;
    }

    try {
      stmt = conn.createStatement();
      result = stmt.executeUpdate(sqlQuery);
    } catch (SQLException e) {
      Errors.pushError(e);
      return -1;
    }
    return result;
  }

  public static Database getTestSQLDatabase() {
    if (testDatabase != null) return testDatabase;

    Connection conn;
    try {
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection(TEST_DATABASE_URI);
      if (conn == null) {
        Errors.pushError(Checker.newException("Error while connecting to database!"));
        return null;
      }
    } catch (Exception e) {
      Errors.pushError(e);
      return null;
    }
    return testDatabase = new Database(conn);
  }

  public static String getTestDBLocation() {
    return TEST_DATABASE_LOCATION;
  }
}
