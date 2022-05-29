package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import json.JSONFactory;
import json.JSONString;

class TestString {

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
	void testString() {
		JSONString string1 = JSONFactory.createString("hello");
		JSONString string2 = JSONFactory.createString("hello");
		JSONString stringEmpty = JSONFactory.createString("");

		// hashCode() method
		assertEquals(string1.hashCode(), string2.hashCode());

		// toString() method
		assertEquals("\"hello\"", string1.toString());
		assertEquals("\"\"", stringEmpty.toString());

		// getString() method
		assertEquals("hello", string1.getString());

		// equals() method
		assertFalse(string1.equals(null));
		assertFalse(string1.equals(JSONFactory.createNumber(1)));
	}

}
