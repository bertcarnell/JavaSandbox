package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllWordDivisionTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for test");
		//$JUnit-BEGIN$
		suite.addTestSuite(WordDivisionGUITest.class);
		suite.addTestSuite(WordDivisionUtilsTest.class);
		suite.addTestSuite(PermutationGeneratorTest.class);
		suite.addTestSuite(WordCubbyTest.class);
		//$JUnit-END$
		return suite;
	}

}
