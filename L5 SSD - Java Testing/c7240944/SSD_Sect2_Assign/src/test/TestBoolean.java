package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import json.JSONBoolean;
import json.JSONFactory;

class TestBoolean {

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
	void testBoolean() {
		JSONBoolean trueValue = JSONFactory.createBoolean(true);
		JSONBoolean falseValue = JSONFactory.createBoolean(false);

		// INITIAL CHECK - trueValue
		assertTrue(trueValue.isBoolean());
		assertFalse(trueValue.isNumber());
		assertFalse(trueValue.isNull());
		assertFalse(trueValue.isArray());
		assertFalse(trueValue.isObject());
		assertFalse(trueValue.isString());
		// INITIAL CHECK - falseValue
		assertTrue(falseValue.isBoolean());
		assertFalse(falseValue.isNumber());
		assertFalse(falseValue.isNull());
		assertFalse(falseValue.isArray());
		assertFalse(falseValue.isObject());
		assertFalse(falseValue.isString());

		// OTHER METHODS
		// equals()
		assertTrue(trueValue.equals(JSONFactory.createBoolean(true)));
		assertFalse(trueValue.equals(falseValue));
		assertTrue(falseValue.equals(JSONFactory.createBoolean(false)));
		assertFalse(falseValue.equals(trueValue));
		// hashCode()
		assertEquals(1231, trueValue.hashCode());
		assertEquals(1237, falseValue.hashCode());
		// asBoolean()
		assertTrue(trueValue.asBoolean());
		assertFalse(falseValue.asBoolean());
		// toString()
		assertEquals("true", trueValue.toString());
		assertEquals("false", falseValue.toString());
	}

}
