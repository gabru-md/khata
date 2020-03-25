package yogdaan.gabru.khata.db;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yogdaan.gabru.khata.utils.Errors;

class DatabaseTest {

	@BeforeEach
	void setup() {
		Errors.clearAll();
	}
	
	@Test
	void itTestsDBConnection() {
		Connection conn = Database.getTestSQLDatabase();
		assertTrue(Errors.ok());
		assertNotNull(conn);
	}

}
