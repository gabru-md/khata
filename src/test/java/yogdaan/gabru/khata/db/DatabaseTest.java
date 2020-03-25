package yogdaan.gabru.khata.db;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yogdaan.gabru.khata.utils.Errors;
import yogdaan.gabru.khata.utils.Logger;

class DatabaseTest {

	void clearDB() {
		String cmd = "rm " + Database.getTestDBLocation();
		try {
			Process prc = Runtime.getRuntime().exec(cmd);
			int result = prc.waitFor();
			Logger.debug("DB Clearance exited with %d", result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Logger.error("DB Clearnance not completed. Exec Failed");
		}
	}

	@BeforeEach
	void setup() {
		Errors.clearAll();
		clearDB();
	}

	@Test
	void itTestsDBConnection() {
		Database db = Database.getTestSQLDatabase();
		assertTrue(Errors.ok());
		assertNotNull(db);
	}

	@Test
	void itCreatesTestTables() {
		Database db = Database.getTestSQLDatabase();
		assertTrue(Errors.ok());
		assertNotNull(db);

		String sqlQuery =
			"create table bank(" + "id integer PRIMARY KEY," + "name char(50)" + ");";

		int result = db.runICUQuery(sqlQuery);
		assertTrue(Errors.ok());
		assertEquals(result, 0);
	}
}
