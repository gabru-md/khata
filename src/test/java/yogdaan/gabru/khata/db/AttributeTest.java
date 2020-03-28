package yogdaan.gabru.khata.db;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yogdaan.gabru.khata.utils.Errors;

class AttributeTest {

	@BeforeEach
	void setup() {
		Errors.clearAll();
	}

	@Test
	void itChecksForCorrectAttribute() {
		Attribute attribute = new Attribute("id", Attribute.Type.INT, false, true);
		assertEquals(attribute.getName(), "id");
		assertEquals(attribute.getType(), Attribute.Type.INT);
		assertTrue(attribute.getPrimaryKeyStatus());
		assertFalse(attribute.getNotNullStatus());
	}

	@Test
	void itChecksCustomAttribute() {
		Attribute attr = new Attribute("name", Attribute.Type.STRING);
		assertEquals(attr.getName(), "name");
		assertEquals(attr.getType(), Attribute.Type.STRING);
		assertFalse(attr.getPrimaryKeyStatus());
		assertFalse(attr.getNotNullStatus());

		attr.isNotNull();
		assertTrue(attr.getNotNullStatus());

		attr.isPrimaryKey();
		assertTrue(attr.getPrimaryKeyStatus());
	}

	@Test
	void itChecksForCorrectBuild() {
		Attribute attr = new Attribute("name", Attribute.Type.STRING);
		assertEquals(attr.build(), "name char(150)");

		attr.setName("id");
		attr.setType(Attribute.Type.INT);
		assertEquals(attr.build(), "id integer");

		attr.isNotNull().isPrimaryKey();
		assertEquals(attr.build(), "id integer PRIMARY KEY NOT NULL");
	}
}
