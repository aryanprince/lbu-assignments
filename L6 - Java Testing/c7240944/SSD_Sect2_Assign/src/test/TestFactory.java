package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import json.JSONBoolean;
import json.JSONException;
import json.JSONFactory;
import json.JSONNull;
import json.JSONNumber;
import json.JSONObject;
import json.JSONString;

class TestFactory {

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
	void testFactory() throws JSONException {
		// createBoolean()
		JSONBoolean booleanValue = JSONFactory.createBoolean(true);
		assertTrue(booleanValue.isBoolean());

		// createNull()
		JSONNull nullValue = JSONFactory.createNull();
		assertTrue(nullValue.isNull());

		// createString()
		JSONString stringValue = JSONFactory.createString("Hello World");
		assertTrue(stringValue.isString());

		stringValue = JSONFactory.createString(null);
		stringValue = JSONFactory.createString("");
		assertTrue(stringValue.isString());

		// createNumber() long
		JSONNumber numberValue = JSONFactory.createNumber(5000);
		assertTrue(numberValue.isNumber());

		// createNumber() float
		numberValue = JSONFactory.createNumber(3.14156f);
		assertTrue(numberValue.isNumber());

		// createNumber() double
		numberValue = JSONFactory.createNumber(1000000d);
		assertTrue(numberValue.isNumber());

		// createObject()
		JSONObject objectValue = JSONFactory.createObject();
		assertTrue(objectValue.isObject());

		JSONObject objectValue2 = JSONFactory.createObject(objectValue);
		assertTrue(objectValue.isObject());
		assertTrue(objectValue.equals(objectValue2));
	}

}
