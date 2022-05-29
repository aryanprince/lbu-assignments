package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import json.JSONException;
import json.JSONObject;
import json.JSONParser;
import json.JSONValue;

class TestParser {

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
	void testParser() {
		try {
			JSONValue value = JSONParser.parse("{}");

			assertNotNull(value);

			assertTrue(value.isObject());
			assertFalse(value.isArray());
			assertFalse(value.isNumber());
			assertFalse(value.isBoolean());
			assertFalse(value.isNull());
			assertFalse(value.isString());

			JSONObject jsonObj = value.asObject();
			assertTrue(jsonObj.isObject());

		} catch (IOException e) {
			e.printStackTrace();
			fail("ERROR: Unexpected IOException in testParser()");
		} catch (JSONException e) {
			e.printStackTrace();
			fail("ERROR: Unexpected JSONException in testParser()");
		}
	}

	@Test
	void testParseFileExample() throws FileNotFoundException, IOException, JSONException {
		JSONValue exampleFile = JSONParser.parseFile("example.json");
		assertTrue(exampleFile.isObject());

		assertEquals(exampleFile, exampleFile.copy());

		assertThrows(JSONException.class, () -> exampleFile.asArray());
		assertThrows(JSONException.class, () -> exampleFile.asString());
		assertThrows(JSONException.class, () -> exampleFile.asBoolean());
		assertThrows(JSONException.class, () -> exampleFile.asDouble());
		assertThrows(JSONException.class, () -> exampleFile.asFloat());
		assertThrows(JSONException.class, () -> exampleFile.asLong());
		assertThrows(JSONException.class, () -> exampleFile.asInteger());
		assertThrows(JSONException.class, () -> exampleFile.asShort());
		assertThrows(JSONException.class, () -> exampleFile.asByte());

		JSONObject exampleFileObject = exampleFile.asObject();
		String exampleAsString = exampleFileObject.toString();
		assertEquals(
				"{\"prop1\":\"A string\",\"prop2\":0,\"prop3\":3.142,\"prop4\":true,\"prop5\":false,\"prop6\":null,\"prop7\":{\"prop7_A\":true,\"prop7_B\":false,\"prop7_C\":\"nested string\"},\"array1\":[0,1,2,3],\"array2\":[\"this\",\"is\",\"an\",\"array\"],\"array3\":[\"this\",\"is\",\"a\",\"mixed\",\"array\",0,true,false,null,6.232,{\"array_prop\":\"array_val\"},[1,2,3,4]],\"escape_string\":\"\\\"\\\\\\/\\b\\f\\n\\r\\tA\"}",
				exampleFileObject.toString());
		assertEquals(
				"{\"prop1\":\"A string\",\"prop2\":0,\"prop3\":3.142,\"prop4\":true,\"prop5\":false,\"prop6\":null,\"prop7\":{\"prop7_A\":true,\"prop7_B\":false,\"prop7_C\":\"nested string\"},\"array1\":[0,1,2,3],\"array2\":[\"this\",\"is\",\"an\",\"array\"],\"array3\":[\"this\",\"is\",\"a\",\"mixed\",\"array\",0,true,false,null,6.232,{\"array_prop\":\"array_val\"},[1,2,3,4]],\"escape_string\":\"\\\"\\\\\\/\\b\\f\\n\\r\\tA\"}",
				exampleAsString);

		JSONValue exampleMember1 = exampleFileObject.getMember("prop1");
		assertTrue(exampleMember1.isString());
		assertFalse(exampleMember1.isArray());
		assertFalse(exampleMember1.isBoolean());
		assertFalse(exampleMember1.isNull());
		assertFalse(exampleMember1.isNumber());
		assertFalse(exampleMember1.isObject());
		String prop1 = exampleMember1.asString();
		assertEquals("A string", prop1);

		JSONValue exampleMember2 = exampleFileObject.getMember("prop2");
		assertTrue(exampleMember2.isNumber());
		assertFalse(exampleMember2.isString());
		assertFalse(exampleMember2.isArray());
		assertFalse(exampleMember2.isBoolean());
		assertFalse(exampleMember2.isNull());
		assertFalse(exampleMember2.isObject());
		int prop2 = exampleMember2.asInteger();
		assertEquals(0, prop2);

		JSONValue exampleMember3 = exampleFileObject.getMember("prop3");
		assertTrue(exampleMember3.isNumber());
		assertFalse(exampleMember3.isString());
		assertFalse(exampleMember3.isArray());
		assertFalse(exampleMember3.isBoolean());
		assertFalse(exampleMember3.isNull());
		assertFalse(exampleMember3.isObject());
		float prop3 = exampleMember3.asFloat();
		assertEquals(3.142f, prop3);

		JSONValue exampleMember4 = exampleFileObject.getMember("prop4");
		assertTrue(exampleMember4.isBoolean());
		assertFalse(exampleMember4.isNumber());
		assertFalse(exampleMember4.isString());
		assertFalse(exampleMember4.isArray());
		assertFalse(exampleMember4.isNull());
		assertFalse(exampleMember4.isObject());
		boolean prop4 = exampleMember4.asBoolean();
		assertEquals(true, prop4);

		JSONValue exampleMember5 = exampleFileObject.getMember("prop5");
		assertTrue(exampleMember5.isBoolean());
		assertFalse(exampleMember5.isNumber());
		assertFalse(exampleMember5.isString());
		assertFalse(exampleMember5.isArray());
		assertFalse(exampleMember5.isNull());
		assertFalse(exampleMember5.isObject());
		boolean prop5 = exampleMember5.asBoolean();
		assertEquals(false, prop5);

		JSONValue exampleMember6 = exampleFileObject.getMember("prop6");
		assertTrue(exampleMember6.isNull());
		assertFalse(exampleMember6.isBoolean());
		assertFalse(exampleMember6.isNumber());
		assertFalse(exampleMember6.isString());
		assertFalse(exampleMember6.isArray());
		assertFalse(exampleMember6.isObject());
		assertNotNull(exampleMember6);

	}

	@Test
	void testParseFileAddMembers() throws FileNotFoundException, IOException, JSONException {
		JSONValue addMembersValue = JSONParser.parseFile("addMembers.json");
		JSONObject addMembersObject = addMembersValue.asObject();

		// Adding values to the empty JSON file
		addMembersObject.addMember("mem1");
		addMembersObject.addMember("mem2", true);
		addMembersObject.addMember("mem3", false);
		addMembersObject.addMember("mem3", (double) 5000);
		addMembersObject.addMember("mem3", (float) 3.14);
		addMembersObject.addMember("mem3", (long) 300);
		addMembersObject.addMember("mem3", "Ipsum");

		// Checking each member of the now populated JSON file
		JSONValue addMembersMember2 = addMembersObject.getMember("mem2");
		assertTrue(addMembersMember2.isBoolean());
		boolean member2 = addMembersMember2.asBoolean();
		assertEquals(true, member2);

		JSONValue addMembersMember3 = addMembersObject.getMember("mem2");
		assertTrue(addMembersMember3.isBoolean());
		boolean member3 = addMembersMember3.asBoolean();
		assertEquals(true, member3);

	}

	@Test
	void testParserThrows() throws FileNotFoundException, IOException, JSONException {
		// Throws an error since this JSON file does not contain a closing curly bracket
		// -> }
		assertThrows(JSONException.class, () -> JSONParser.parseFile("incomplete.json"));

		// Thorws an error by containing a non-existent escape sequence (\j)
		assertThrows(JSONException.class, () -> JSONParser.parseFile("escape.json"));

		// Throws an error since JSON file contains a float value while conditions only
		// checks for an integer type value for unicode 'code'
		assertThrows(JSONException.class, () -> JSONParser.parseFile("unicode1.json"));

		// Throws an error since JSON file contains less than 4 digits like the
		// condition requires for a unicode escape sequence 'code'
		assertThrows(JSONException.class, () -> JSONParser.parseFile("unicode2.json"));

		// Throws an error since the buffer only checks for each letter when lowercase
		// -> 'null' exactly only
		assertThrows(JSONException.class, () -> JSONParser.parseFile("nullThrow.json"));

		// Throws an error since the buffer only checks for each letter when lowercase
		// -> 'true' exactly only
		assertThrows(JSONException.class, () -> JSONParser.parseFile("parseTrueThrow.json"));

		// Throws an error since the buffer only checks for each letter when lowercase
		// -> 'false' exactly only
		assertThrows(JSONException.class, () -> JSONParser.parseFile("parseFalseThrow.json"));

		// Throws an error since the buffer sees a comma indicating a new array element
		// but is empty
		assertThrows(JSONException.class, () -> JSONParser.parse("{\"array\" : [ 0,]}"));

		// Throws an error since the buffer sees an array but cannot see closing square
		// brackets
		assertThrows(JSONException.class, () -> JSONParser.parse("{\"array\" : [0}"));

		// Throws an error since the buffer does not see a seperator between object and
		// member
		assertThrows(JSONException.class, () -> JSONParser.parse("{\"throw\" \"throw\""));

		// Throws an error since the buffer does not see a comma between two objects
		assertThrows(JSONException.class, () -> JSONParser.parse("{\"throw\" : \"throw\" \"throw\" : \"throw\""));

		// Throws an error since the buffer sees a number at first but sees a non-digit
		// value which throws an error
		assertThrows(JSONException.class, () -> JSONParser.parse("{ \"throw\" : 9c "));
	}

}
