package test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({ TestArray.class, TestBoolean.class, TestFactory.class, TestNull.class, TestNumber.class, TestObject.class, TestParser.class, TestString.class })
public class AllTests {

}