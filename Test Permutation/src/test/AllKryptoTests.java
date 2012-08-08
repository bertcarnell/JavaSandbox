package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllKryptoTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for test");
		//$JUnit-BEGIN$
		suite.addTestSuite(calculateKryptoTest.class);
		suite.addTestSuite(CombinationArrayTest.class);
		suite.addTestSuite(KryptoUtilsTest.class);
		//$JUnit-END$
		return suite;
	}

}
