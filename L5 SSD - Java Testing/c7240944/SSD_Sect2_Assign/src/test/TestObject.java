package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import json.JSONArray;
import json.JSONException;
import json.JSONFactory;
import json.JSONNumber;
import json.JSONObject;

class TestObject {

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

	@SuppressWarnings({ "unlikely-arg-type", "rawtypes" })
	@Test
	void testObject() throws JSONException {
		JSONObject objectValue = JSONFactory.createObject();
		JSONObject objectValue2 = JSONFactory.createObject(objectValue);
		JSONObject objectValue3 = objectValue2.copy();
		JSONNumber numberValue = JSONFactory.createNumber(1);

		// isObject() method
		assertTrue(objectValue.isObject());
		assertTrue(objectValue2.isObject());
		assertTrue(objectValue3.isObject());

		// equals() method
		assertTrue(objectValue.equals(objectValue2));
		assertTrue(objectValue.equals(objectValue));
		assertFalse(objectValue.equals(null));
		assertFalse(objectValue.equals(numberValue));

		assertTrue(objectValue.equals(objectValue.asObject()));

		// hashCode() method
		assertEquals(objectValue.hashCode(), objectValue2.hashCode());
		assertEquals(objectValue2.hashCode(), objectValue.hashCode());
		assertEquals(objectValue.hashCode(), objectValue.hashCode());
		assertEquals(objectValue2.hashCode(), objectValue2.hashCode());

		// size() method
		assertEquals(0, objectValue.size());
		assertEquals(0, objectValue2.size());
		assertEquals(0, objectValue3.size());

		// iterator() method
		objectValue.addMember("Test", false);

		Iterator iter = objectValue.iterator();
		assertTrue(iter.hasNext());

		objectValue.members().clear();
		iter = objectValue.iterator();
		assertFalse(iter.hasNext());

		// hasMember() method
		objectValue.addMember("test", false);
		assertTrue(objectValue.hasMember("test"));
		objectValue.members().clear();

		// hasBooleanMember() method
		objectValue.addMember("test", true);
		assertTrue(objectValue.hasBooleanMember("test"));
		objectValue.members().clear();

		objectValue.addMember("test", "test");
		assertFalse(objectValue.hasBooleanMember("test"));
		objectValue.members().clear();

		// addMember() method
		JSONArray v1 = JSONFactory.createArray();
		objectValue.addMember("test", v1);
		objectValue.members().clear();

		objectValue.addMember("test", objectValue2);
		objectValue.members().clear();

		// values() method
		objectValue.addMember("test1", "one");
		assertEquals(1, objectValue.values().size());

		objectValue.addMember("test2", "two");
		objectValue.addMember("test3", "three");
		assertEquals(3, objectValue.values().size());

		objectValue.members().clear();
	}

}
