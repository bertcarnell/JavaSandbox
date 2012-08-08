package test;

import junit.framework.TestCase;
import junitx.util.PrivateAccessor;
import utils.SudokuGrid;

import java.util.Arrays;

public class SudokuGridTest extends TestCase {
	protected int[][] test4 = {{1,2,3,4},{3,4,1,2},{2,1,4,3},{4,3,2,1}};
	protected int[][] test9 = {{1, 2, 3, 4, 5, 6, 7, 8, 9},
	 		 {4, 5, 6, 7, 8, 9, 1, 2, 3},
	 		 {7, 8, 9, 1, 2, 3, 4, 5, 6},
	 		 {2, 3, 1, 5, 6, 4, 8, 9, 7}, 
	 		 {5, 6, 4, 8, 9, 7, 2, 3, 1},
	 		 {8, 9, 7, 2, 3, 1, 5, 6, 4},
	 		 {3, 1, 2, 6, 4, 5, 9, 7, 8},
	 		 {6, 4, 5, 9, 7, 8, 3, 1, 2},
	 		 {9, 7, 8, 3, 1, 2, 6, 4, 5}};
	protected int[][] testTrick = new int[9][9];
	
	protected void setUp(){
		for(int i=0; i<9; i++){
			Arrays.fill(testTrick[i], 5);
		}
	}

	/*
	 * Test method for 'utils.SudokuGrid.SudokuGrid(int)'
	 */
	public void testSudokuGrid() {
		SudokuGrid sg4 = new SudokuGrid(4);
		SudokuGrid sg9 = new SudokuGrid(9);
		assertTrue(sg4.N==4);
		assertTrue(sg4.sqrtN==2);
		assertTrue(sg9.N==9);
		assertTrue(sg9.sqrtN==3);
	}

	/*
	 * Test method for 'utils.SudokuGrid.isValid()'
	 */
	public void testIsValid() {
		SudokuGrid sg4 = new SudokuGrid(4);
		SudokuGrid sg9 = new SudokuGrid(9);
		assertTrue(sg4.isValid());
		assertTrue(sg9.isValid());
		
		matrixCopy(sg4.sudokuGrid, test4);
		matrixCopy(sg9.sudokuGrid, test9);
		assertTrue(sg4.isValid());
		assertTrue(sg9.isValid());

		sg4.sudokuGrid[2][2] = 0;
		sg9.sudokuGrid[4][7] = 0;
		assertTrue(!sg4.isValid());
		assertTrue(!sg9.isValid());
		
		// This test is of a SudokuGrid that is not valid, but it should still pass.
		// The consistency check should catch this one.
		matrixCopy(sg9.sudokuGrid, testTrick);
		assertTrue(sg9.isValid());
	}

	/*
	 * Test method for 'utils.SudokuGrid.isConsistent()'
	 */
	public void testIsConsistent() {
		SudokuGrid sg4 = new SudokuGrid(4);
		SudokuGrid sg9 = new SudokuGrid(9);
		assertTrue(sg4.isConsistent());
		assertTrue(sg9.isConsistent());

		matrixCopy(sg4.sudokuGrid, test4);
		matrixCopy(sg9.sudokuGrid, test9);
		assertTrue(sg4.isConsistent());
		assertTrue(sg9.isConsistent());

		sg4.sudokuGrid[2][2] = 3;
		sg9.sudokuGrid[4][7] = 1;
		assertTrue(!sg4.isConsistent());
		assertTrue(!sg9.isConsistent());

		matrixCopy(sg9.sudokuGrid, testTrick);
		assertTrue(!sg9.isConsistent());
	}

	/*
	 * Test Private Class Methods
	 */
	
	public void testPrivateFillStandard(){
		SudokuGrid sg4 = new SudokuGrid(4);
		SudokuGrid sg9 = new SudokuGrid(9);
		try{
			PrivateAccessor.invoke(sg4, "fillStandard", null, null);
			PrivateAccessor.invoke(sg9, "fillStandard", null, null);
		} catch(Throwable t){
			System.out.println(t.toString());
			assertTrue(false);
		}
		assertTrue(matrixEqual(test4, sg4.sudokuGrid));
		assertTrue(matrixEqual(test9, sg9.sudokuGrid));
	}

	public void testPrivateRandomize(){
		SudokuGrid sg = new SudokuGrid(4);
		int[][] test = {{2,3,1,4},{1,4,2,3},{3,2,4,1},{4,1,3,2}};
		try{
			PrivateAccessor.invoke(sg, "fillStandard", null, null);
			PrivateAccessor.invoke(sg, "randomize", new Class[]{long.class}, new Object[]{new Long(5)});
		} catch(Throwable t){
			System.out.println(t.toString());
			assertTrue(false);
		}
		assertTrue(matrixEqual(test, sg.sudokuGrid));
	}
	
	public void testFillSquareID(){
		SudokuGrid sg = new SudokuGrid(4);
		int[][] test = {{0,0,1,1},{0,0,1,1},{2,2,3,3},{2,2,3,3}};
		assertTrue(matrixEqual(test, sg.squareID));
	}

	/*
	 * Utility Function
	 */
	
	private boolean matrixEqual(int[][] A, int[][] B){
		if(A.length!=B.length) return false;
		else if(A[0].length!=B[0].length) return false;
		else {
			for(int i=0; i<A.length; i++){
				if(!Arrays.equals(A[i], B[i])) return false;
			}
			return true;
		}
	}

	private void matrixCopy(int[][] A, int[][]B){
		// copy into A from B
		if(A.length!=B.length) return;
		else if(A[0].length!=B[0].length) return;
		else {
			for(int i=0; i<A.length; i++){
				for(int j=0; j<A[0].length; j++){
					A[i][j]=B[i][j];
				}
			}
			return;
		}
	}

}
