package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllSudokuTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for test");
		//$JUnit-BEGIN$
		suite.addTestSuite(SudokuOperatorsTest.class);
		suite.addTestSuite(SudokuGridTest.class);
		//$JUnit-END$
		return suite;
	}

}
