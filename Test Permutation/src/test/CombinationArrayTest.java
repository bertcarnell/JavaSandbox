package test;

import junit.framework.TestCase;
import utils.CombinationArray;
import java.util.Arrays;

public class CombinationArrayTest extends TestCase {

	/*
	 * Test method for 'utils.CombinationArray.CombinationArray(int)'
	 */
	public void testCombinationArray() {
		CombinationArray combos = new CombinationArray(3);
		int[][] combo = combos.combinationArray;
		int[][] test = {{1,2,3},{1,3,2},{2,1,3},{3,1,2},{2,3,1},{3,2,1}};
		for(int i=0; i<combo.length; i++){
			assertTrue(Arrays.equals(combo[i], test[i]));
		}
	}

}
