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
import json.JSONValue;

class TestArray {

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

	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testArray() throws JSONException {
		JSONArray array = JSONFactory.createArray(10);
		JSONArray arrayEmpty = JSONFactory.createArray(5);

		// isArray() & other checks
		assertTrue(array.isArray());
		assertFalse(array.isBoolean());
		assertFalse(array.isNull());
		assertFalse(array.isNumber());
		assertFalse(array.isObject());
		assertFalse(array.isString());

		// equals() method
		assertTrue(array.equals(array));
		assertTrue(array.equals(arrayEmpty));
		assertTrue(array.equals(JSONFactory.createArray()));
		assertFalse(array.equals(null));
		assertFalse(array.equals(JSONFactory.createBoolean(false)));

		// hashCode() method
		assertEquals(arrayEmpty.hashCode(), array.hashCode());

		// copy() method
		assertEquals(array, array.copy());

		// asArray() method
		assertTrue(array.equals(array.asArray()));

		// addValue() & testing added values
		String arrayStringValue = "Lorem";
		array.addValue(arrayStringValue);

		array.addValue((double) 8);
		array.addValue((float) 5.5);
		array.addValue((long) 10);
		array.addValue(true);
		array.addValue(false);
		array.addValue();
		array.addValue(arrayEmpty);
		array.addValue(JSONFactory.createObject());

		assertEquals(JSONFactory.createString("Lorem"), array.get(0));
		assertEquals(JSONFactory.createNumber((double) 8), array.get(1));
		assertEquals(JSONFactory.createNumber((float) 5.5), array.get(2));
		assertEquals(JSONFactory.createNumber((long) 10), array.get(3));
		assertEquals(JSONFactory.createBoolean(true), array.get(4));
		assertEquals(JSONFactory.createBoolean(false), array.get(5));
		assertEquals(JSONFactory.createNull(), array.get(6));
		assertEquals(JSONFactory.createArray(), array.get(7));
		assertEquals(JSONFactory.createObject(), array.get(8));

		// size() method
		assertEquals(9, array.size());
		assertEquals(0, arrayEmpty.size());

		// get() method
		JSONValue arrayValue1 = array.get(1);
		assertTrue(arrayValue1.isNumber());

		// toString() method
		String toStr = array.toString();
		assertFalse(toStr.isEmpty());
		assertEquals("[\"Lorem\",8.0,5.5,10,true,false,null,[],{}]", array.toString());

		// iterator() method
		JSONArray iterArray = JSONFactory.createArray(arrayEmpty);
		Iterator<JSONValue> iter = iterArray.iterator();
		assertFalse(iter.hasNext());

		iterArray.addValue();
		iterArray.addValue();
		assertTrue(iter.hasNext());

	}

}
