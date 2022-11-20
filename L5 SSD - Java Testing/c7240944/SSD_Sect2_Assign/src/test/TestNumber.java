package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import json.JSONException;
import json.JSONFactory;
import json.JSONNumber;

class TestNumber {

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
	void testNumberLong() throws JSONException {
		JSONNumber long1 = JSONFactory.createNumber((long) 1);
		JSONNumber long0 = JSONFactory.createNumber((long) 0);

		// Checks if objects are JSONNumber values
		assertTrue(long1.isNumber());
		assertFalse(long1.isNull());
		assertFalse(long1.isArray());
		assertFalse(long1.isBoolean());
		assertFalse(long1.isObject());
		assertFalse(long1.isString());
		// Checks if objects are JSONNumber values
		assertTrue(long0.isNumber());
		assertFalse(long0.isNull());
		assertFalse(long0.isArray());
		assertFalse(long0.isBoolean());
		assertFalse(long0.isObject());
		assertFalse(long0.isString());

		// toString() method
		assertEquals("1", long1.toString());
		assertEquals("0", long0.toString());

		// getNumber() method
		assertEquals(1, long1.getNumber());
		assertEquals(0, long0.getNumber());

		// equals() method - long1
		assertTrue(long1.equals(long1));
		assertFalse(long1.equals(null));
		assertTrue(long1.equals(JSONFactory.createNumber(1)));
		// Extra branches
		assertFalse(long1.equals(long0));
		assertFalse(long1.equals(1));
		assertFalse(long1.equals("1"));
		Integer num = (Integer) long1.getNumber();
		assertFalse(long1.equals(num));

		// equals() method - long0
		assertTrue(long0.equals(long0));
		assertFalse(long0.equals(null));
		assertTrue(long0.equals(JSONFactory.createNumber(0)));
		// Extra branches
		assertFalse(long0.equals(long1));
		assertFalse(long0.equals(0));
		assertFalse(long0.equals("0"));
		num = (Integer) long0.getNumber();
		assertFalse(long0.equals(num));

		// hashCode() method
		assertEquals(JSONFactory.createNumber(1).hashCode(), long1.hashCode());

		// asInteger() method
		assertEquals(1, long1.asInteger());
		assertEquals(999, JSONFactory.createNumber(999l).asInteger());
		assertThrows(JSONException.class, () -> JSONFactory.createNumber(6.022f).asInteger());

		// asLong() method
		assertEquals(1L, long1.asLong());
		assertEquals(521L, JSONFactory.createNumber(521).asLong());
		assertEquals(312L, JSONFactory.createNumber(312).asLong());
		assertThrows(JSONException.class, () -> JSONFactory.createNumber(6.022f).asLong());
	}

	@Test
	void testNumberFloat() throws JSONException {
		JSONNumber float1 = JSONFactory.createNumber(3.14f);
		JSONNumber float0 = JSONFactory.createNumber(0.0f);

		// Checks if objects are JSONNumber values
		assertTrue(float1.isNumber());
		assertFalse(float1.isNull());
		assertFalse(float1.isArray());
		assertFalse(float1.isBoolean());
		assertFalse(float1.isObject());
		assertFalse(float1.isString());
		// Checks if objects are JSONNumber values
		assertTrue(float0.isNumber());
		assertFalse(float0.isNull());
		assertFalse(float0.isArray());
		assertFalse(float0.isBoolean());
		assertFalse(float0.isObject());
		assertFalse(float0.isString());

		// OTHER METHODS
		assertEquals("3.14", float1.toString());
		assertEquals(3.14f, float1.getNumber());
		assertEquals("0.0", float0.toString());
		assertEquals(0.0f, float0.getNumber());

		// asFloat() method
		assertEquals(50f, JSONFactory.createNumber(50).asFloat());
		assertEquals(50f, JSONFactory.createNumber(50f).asFloat());
		assertEquals(50f, JSONFactory.createNumber(50L).asFloat());
		assertEquals(50f, JSONFactory.createNumber(50d).asFloat());

	}

	@Test
	void testNumberDouble() throws JSONException {

		JSONNumber double1 = JSONFactory.createNumber(1);
		JSONNumber double0 = JSONFactory.createNumber(0);

		// Checks if objects are JSONNumber values
		assertTrue(double1.isNumber());
		assertFalse(double1.isNull());
		assertFalse(double1.isArray());
		assertFalse(double1.isBoolean());
		assertFalse(double1.isObject());
		assertFalse(double1.isString());
		// Checks if objects are JSONNumber values
		assertTrue(double0.isNumber());
		assertFalse(double0.isNull());
		assertFalse(double0.isArray());
		assertFalse(double0.isBoolean());
		assertFalse(double0.isObject());
		assertFalse(double0.isString());

		// OTHER METHODS
		assertEquals("1", double1.toString());
		assertEquals(1, double1.getNumber());
		assertEquals("0", double0.toString());
		assertEquals(0, double0.getNumber());

		// asDouble() method
		assertEquals(3, JSONFactory.createNumber(3.0f).asDouble());
		assertEquals(3, JSONFactory.createNumber(3L).asDouble());

	}

	@Test
	void testNumberException() throws JSONException {

		JSONNumber value1 = JSONFactory.createNumber(10);
		JSONNumber valueMaxByte = JSONFactory.createNumber(128);
		JSONNumber valueMaxShort = JSONFactory.createNumber(32768);
		JSONNumber valueMaxInteger = JSONFactory.createNumber(2147483647d);

		assertTrue(value1.isNumber());
		assertTrue(valueMaxByte.isNumber());

		// Checks and throws an error for asByte()
		byte v1 = value1.asByte();
		assertEquals(10, v1);
		assertThrows(JSONException.class, () -> valueMaxByte.asByte());

		// Checks and throws an error for asShort()
		long v2 = value1.asShort();
		assertEquals(10, v2);
		assertThrows(JSONException.class, () -> valueMaxShort.asShort());

		// Checks and throws an error for asInteger()
		int v3 = value1.asShort();
		assertEquals(10, v3);
		assertThrows(JSONException.class, () -> valueMaxInteger.asInteger());
	}

}
