package test;

import utils.calculateKrypto;
import junit.framework.TestCase;

public class calculateKryptoTest extends TestCase {

	/*
	 * Test method for 'calculateKrypto.solveKrypto(int[], int, boolean, boolean)'
	 */
	public void testSolveKrypto() {
		int[] a;
		String A;
		
		a = new int[] {1, 2, 3, 4, 5}; 
		A = calculateKrypto.solveKrypto(a, 6, true, true);
		assertTrue(A.equals("  1 x 2  + 3  - 4  + 5 = 6"));
		
		A = calculateKrypto.solveKrypto(a, 6, false, true);
		assertTrue(A.equals("1 x 2 + 3 - 4 + 5 = 6"));

		A = calculateKrypto.solveKrypto(a, 6, false, false);
		assertTrue(A.equals("1 - 2 x 3 + 4 + 5 = 6"));

		a = new int[] {69, 6, 9, 7, 8}; 
		A = calculateKrypto.solveKrypto(a, 22, true, true);
		assertTrue(A.equals(" (69 - 6) / 9  + 7  + 8 = 22"));

		A = calculateKrypto.solveKrypto(a, 22, false, true);
		assertTrue(A.equals("69 - 6 / 9 + 7 + 8 = 22"));

		a = new int[] {15, 8, 22, 45, 23}; 
		A = calculateKrypto.solveKrypto(a, 22, true, true);
		assertTrue(A.equals(" (15 + 8  - 22) x 45  - 23 = 22"));

		a = new int[] {7, 22, 45, 23, 8}; 
		A = calculateKrypto.solveKrypto(a, 22, true, true);
		assertTrue(A.equals(" (7 x 22  + 45  - 23) / 8 = 22"));

		a = new int[] {7, 8, 22, 45, 23}; 
		A = calculateKrypto.solveKrypto(a, 21, true, true);
		assertTrue(A.equals("No answer can be found without a negative intermediate step!"));

		A = calculateKrypto.solveKrypto(a, 21, true, false);
		assertTrue(A.equals(" (7 - 23) / 8  - 22  + 45 = 21"));

		a = new int[] {0, 0, 0, 0, 0}; 
		A = calculateKrypto.solveKrypto(a, 21, true, true);
		assertTrue(A.equals("No answer can be found!"));

		A = calculateKrypto.solveKrypto(a, 21, true, false);
		assertTrue(A.equals("No answer can be found!"));

		a = new int[] {7, 7, 11, 13, 17}; 
		A = calculateKrypto.solveKrypto(a, 23, true, true);
		assertTrue(A.equals("((7 + 11) x 17  - 7) / 13 = 23"));

		a = new int[] {7}; 
		A = calculateKrypto.solveKrypto(a, 8, true, true);
		assertTrue(A.equals("There must be at least two numbers to build an expression"));
	
	}

}
