package test;

import junit.framework.TestCase;
import utils.KryptoUtils;

public class KryptoUtilsTest extends TestCase {

	/*
	 * Test method for 'utils.KryptoUtils.factorial(int)'
	 */
	public void testFactorial() {
		assertTrue(KryptoUtils.factorial(0)==1);
		assertTrue(KryptoUtils.factorial(4)==24);
		// this is not correct, not is it allowed, but it is how the method functions
		assertTrue(KryptoUtils.factorial(-1)==-1);
	}

	/*
	 * Test method for 'utils.KryptoUtils.allCombo(int, int)'
	 */
	public void testAllCombo() {
		// 16 = 4^(3-1)
		int[][] combos = KryptoUtils.allCombo(16, 3);
		for(int i=1; i<=4; i++){
			for(int j=1; j<=4; j++){
				assertTrue(combos[4*(i-1)+j-1][0]==i);
				assertTrue(combos[4*(i-1)+j-1][1]==j);
			}
		}
	}
}
