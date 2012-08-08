package utils;

import java.util.Random;
import java.util.ArrayList;
import java.lang.Integer;
import utils.SudokuGrid;

/**
 * Utility class of Sudoku Operators
 * @author CARNELLR
 * @version 1.0 Feb 2006
 */
public class SudokuOperators {

	/**
	 * Creates holes in a Sudoku Grid to create the game
	 * @param A the valid sudoku grid to have the holes placed in it
	 * @param numHoles The number of holes to place in the game.  If numHoles==0 then a random number
	 * of holes is returned
	 * @return a sudoku game board
	 */
	public static SudokuGrid makeHoles(SudokuGrid A, int numHoles){
		Random a1 = new Random();
		Random b1 = new Random();
		return(makeHolesInternal(A, numHoles, a1, b1));
	}
	
	/**
	 * Creates holes in a Sudoku grid randomly with seed for debugging and testing
	 * @param A the valid sudoku grid to have the holes placed in it
	 * @param numHoles The number of holes to place in the game.  If numHoles==0 then a random number
	 * of holes is returned
	 * @param seed a random number generator seed
	 * @return a sudoku game board
	 */
	public static SudokuGrid makeHoles(SudokuGrid A, int numHoles, long seed){
		Random a1 = new Random(seed);
		Random b1 = new Random(seed+1);
		return(makeHolesInternal(A, numHoles, a1, b1));
	}
	
	/*
	 * internal hole creating procedure for the sudoku grid
	 */
	private static SudokuGrid makeHolesInternal(SudokuGrid A, int numHoles, Random a1, Random b1){
		int i, j;
		// if too many holes are asked for, put none it in
		if(numHoles>A.N*A.N) return A;
		// if too few holes are asked for, use a random number of holes
		if(numHoles==0) numHoles = a1.nextInt((int) A.N*A.N/2);
		// iteratre through the number of desired holes
		for(int k=0; k<numHoles; k++) {
			do{
				i = b1.nextInt(A.N);
				j = b1.nextInt(A.N);
			// find a random place and ensure it doesn't already have a hole
			} while(A.sudokuGrid[i][j]==0);
			// update the grid with a zero
			A.sudokuGrid[i][j] = 0;
		}
		return A;
	}
	
	/**
	 * Solve the Sudoku Grid game
	 * @param A The sudoku grid
	 * @return A solved sudoku grid
	 */
	public static SudokuGrid solve(SudokuGrid A){
		int[][] holesInt;
		SudokuGrid original = A;
		ArrayList holes;
        ArrayList<Integer> available = new ArrayList<Integer>(A.N);
		boolean bPass = true;
		int[] test;
		int counter = 0;
		
		// find all the holes in the grid
		holesInt = findAllHoles(A);
		// Change the array of holes into an ArrayList
		holes = new ArrayList(holesInt.length);
        for(int i=0; i<holesInt.length; i++){
        	holes.add(i, holesInt[i]);
        }
		// while there is one at least one spot that can be filled in 
        // where there was only one choice
		while(bPass==true){
			bPass = false;
			// iterate over the holes
			for(int i=0; i<holes.size(); i++){
				// get the available numbers at each hole
				test = (int[]) holes.get(i);
				available = getAvailable(A, test[0], test[1]);
				counter++;
				// if there is only one available
				if(available.size()==1){
					// fill it in 
					A.sudokuGrid[test[0]][test[1]] = available.get(0).intValue();
					// remove the filled in hole from the ArrayList
					holes.remove(i);
					// step backward one to iterate over the hole that just got
					// moved up
					i--;
					// indicate that at lease one hole was filled in on this pass
					bPass = true;
				}
			}
		}
		// if there are no holes left
		if(holes.isEmpty()){
			//System.out.println(counter + " calls were performed for easy choices.");
			return A;
		}
		// start the process of guessing
		int holesLength = holes.size();
		int[][] holesMatrix = new int[holesLength][3];
		int[] availablePosit = new int[holesLength];
		int index = 0;
		// build a matrix of holes
		for(int i=0; i<holesLength; i++){
			holesMatrix[i] = (int[]) holes.get(i);
		}
		// perform a backtracking algorithm
		do{
			do{
				// get the available holes
				available = getAvailable(A, holesMatrix[index][0], holesMatrix[index][1]);
				counter++;
				// if there are holes available
				if(!available.isEmpty()) {
					// fill one in
					A.sudokuGrid[holesMatrix[index][0]][holesMatrix[index][1]] = (int) available.get(availablePosit[index]);
					index++;
				}
			// keep repeating this as long we haven't reached the end of the holes
			// and there are still available numbers
			} while(index<holesLength && !available.isEmpty());
			// if all holes are filled in and the grid is valid
			if(index==holesLength && A.isValid()){
				//System.out.println(counter + " calls were performed.");
				return A;
			}
			// if not all holes are filled in
			do{
				if(index<holesLength){
					// erase the posit and Grid position
					availablePosit[index]=0;
					A.sudokuGrid[holesMatrix[index][0]][holesMatrix[index][1]] = 0;
				}	
				// backtrack one
				if(index>0) {
					index--;
				} else return(original);
				// check to see if there are other choices available than the one chosen
				A.sudokuGrid[holesMatrix[index][0]][holesMatrix[index][1]] = 0;
				available = getAvailable(A, holesMatrix[index][0], holesMatrix[index][1]);
				counter++;
				if(available.size()>availablePosit[index]+1){
					availablePosit[index]++;
					// go forward
					break;
				}
			// keep iterating while there are still choice available
			}while(available.size()<=availablePosit[index]+1);
		// start over if A is still not valid
		}while(!A.isValid());
		//System.out.println(counter + " calls were performed.");
		return A;
	}
	
	/*
	 * finds all the holes in a sudoku grid
	 */
	private static int[][] findAllHoles(SudokuGrid A){
		int[][] coords = new int[A.N*A.N][2];
		int index = 0;
		// count the available holes
		// and fill in a matrix that is too big
		for(int i=0; i<A.N; i++){
			for(int j=0; j<A.N; j++){
				if(A.sudokuGrid[i][j]==0){
					coords[index][0] = i;
					coords[index][1] = j;
					index++;
				}
			}
		}
		// not make a result matrix that is the right size
		// and fill it in
		int[][] result = new int[index][2];
		for(int i=0; i<index; i++){
			result[i]=coords[i];
		}
		return result;
	}
	
	/*
	 * Gets all the available numbers at a particular hole
	 */
	private static ArrayList<Integer> getAvailable(SudokuGrid C, int row, int col){
		ArrayList<Integer> rowHoles = rowAvailable(C, row);
		ArrayList<Integer> colHoles = colAvailable(C, col);
		ArrayList<Integer> squHoles = squareAvailable(C, C.squareID[row][col]);
		ArrayList<Integer> resultHoles = new ArrayList<Integer>(C.N);
		// if there is only one number available in a row
		// and the column and square have that available
		// then it can be the only number
		if(rowHoles.size()==1 && colHoles.contains(rowHoles.get(0)) && squHoles.contains(rowHoles.get(0))){
			return rowHoles;
		// if there is only one number available in a column
	    // and the row and square have that available
		// then it can be the only number
		} else if(colHoles.size()==1 && rowHoles.contains(colHoles.get(0)) && squHoles.contains(colHoles.get(0))){
			return colHoles;
		// if there is only one number avaiable in a square
		// and the row and column have that available
		// then it can be the only number
		} else if(squHoles.size()==1 && rowHoles.contains(squHoles.get(0)) && colHoles.contains(squHoles.get(0))){
			return squHoles;
		// else iterate through the row, column, and square and get all the available
		} else {
			for(Integer emptyRow : rowHoles){
				for(Integer emptyCol : colHoles){
					for(Integer emptySqu : squHoles){
						if(emptyRow.equals(emptyCol) && emptyRow.equals(emptySqu)){
							resultHoles.add(emptyRow);
						}
					}
				}
			}
			return resultHoles;
		}
	}
	
	/*
	 * find the numbers available for a hole in a row
	 */
	private static ArrayList<Integer> rowAvailable(SudokuGrid B, int row){
		ArrayList<Integer> rowContents = new ArrayList<Integer>(B.N);
		ArrayList<Integer> result = new ArrayList<Integer>(B.N);
		Integer jPrime;
		// find the numbers in the row
		for(int j=0; j<B.N; j++){
			jPrime = new Integer(B.sudokuGrid[row][j]);
			rowContents.add(jPrime);
		}
		// test to see if any of the numbers in 1 to N are already there
		for(int j=1; j<=B.N; j++){
			jPrime = new Integer(j);
			// if not, add them
			if(!rowContents.contains(jPrime)) result.add(jPrime);
		}
		return result;
	}
	
	private static ArrayList<Integer> colAvailable(SudokuGrid B, int col){
		ArrayList<Integer> colContents = new ArrayList<Integer>(B.N);
		ArrayList<Integer> result = new ArrayList<Integer>(B.N);
		Integer iPrime;
		// find the numbers in the column
		for(int i=0; i<B.N; i++){
			iPrime = new Integer(B.sudokuGrid[i][col]);
			colContents.add(iPrime);
		}
		// test to see if any of the numbers in 1 to N are already there
		for(int i=1; i<=B.N; i++){
			iPrime = new Integer(i);
			// if not, add them
			if(!colContents.contains(iPrime)) result.add(iPrime);
		}
		return result;
	}

	private static ArrayList<Integer> squareAvailable(SudokuGrid B, int square){
		ArrayList<Integer> sqContents = new ArrayList<Integer>(B.N);
		ArrayList<Integer> result = new ArrayList<Integer>(B.N);
		Integer iPrime;
		// find the numbers in the square
		for(int i=0; i<B.N; i++){
			for(int j=0; j<B.N; j++){
				if(B.squareID[i][j]==square){
					iPrime = new Integer(B.sudokuGrid[i][j]);
					sqContents.add(iPrime);
				}
			}
		}
		// test to see if any of the numbers in 1 to N are already there
		for(int i=1; i<=B.N; i++){
			iPrime = new Integer(i);
			if(!sqContents.contains(iPrime)) result.add(iPrime);
		}
		return result;
	}
	
}
