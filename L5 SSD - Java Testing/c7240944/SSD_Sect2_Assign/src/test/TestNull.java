package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import json.JSONFactory;
import json.JSONNull;

class TestNull {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testNull() {
		JSONNull nullValue = JSONFactory.createNull();

		// INITIAL CHECK - value
		assertTrue(nullValue.isNull());
		assertFalse(nullValue.isArray());
		assertFalse(nullValue.isBoolean());
		assertFalse(nullValue.isNumber());
		assertFalse(nullValue.isObject());
		assertFalse(nullValue.isString());

		// OTHER METHODS
		assertTrue(nullValue.equals(JSONFactory.createNull()));
		assertFalse(nullValue.equals(null));
		assertEquals("null", nullValue.toString());
		assertEquals(953, nullValue.hashCode());
		assertNotNull(nullValue);
	}

}
