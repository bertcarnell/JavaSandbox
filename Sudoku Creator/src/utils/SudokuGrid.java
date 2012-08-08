package utils;

import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

/**
 * A Class which represents a Sudoku game grid.
 * @author CARNELLR
 * @version 1.0 Feb 2006
 */
public class SudokuGrid {
	// The number digits in the grid (an N=4 grid has digits 1-4 and 16 cells)
	// N must be a perfect square
	public int N;
	// The grid of integers
	public int[][] sudokuGrid;
	// sqrt of N
	public int sqrtN;
	// An array that shows which square an element is in
	public int[][] squareID;

	/**
	 * Constructor.  Creates an instance of a Sudoku game grid
	 * @param newN The size of the grid
	 * @since 1.0
	 */
	public SudokuGrid(int newN){
		N = newN;
		sqrtN = (int) Math.sqrt(N);
		// if N is not a perfect square then return a 1 x 1 grid
		if(Math.floor(Math.sqrt(N)) != (double) sqrtN) {
			sudokuGrid = new int[1][1];
			sudokuGrid[0][0] = 1;
		} else {
			// create the square ID grid
			squareID = new int[N][N];
			fillSquareID();
			// create and randomize the Sudoku Grid
			sudokuGrid = new int[N][N];
			fillStandard();
			randomize();
		}
	}
	
	/*
	 * Fill the sudoku grid with the standard set of numbers
	 */
	private void fillStandard(){
		// "Standard" Sudoku Grid - Rob coined phrase Jan 2006
		// 1 2 3 4 5 6 7 8 9	1 2 3 4
		// 4 5 6 7 8 9 1 2 3	3 4 1 2
		// 7 8 9 1 2 3 4 5 6	2 1 4 3
		// 2 3 1 5 6 4 8 9 7	4 3 2 1
		// 5 6 4 8 9 7 2 3 1
		// 8 9 7 2 3 1 5 6 4
		// 3 1 2 6 4 5 9 7 8
		// 6 4 5 9 7 8 3 1 2
		// 9 7 8 3 1 2 6 4 5
		int count;
		int[] vector = new int[sqrtN];
		int squareCol = 0;
		int col;
		int row;

		// This loop fills the first sqrtN lines by sequentially counting
		// starting from a sequentially increasing value
		// when the end of the digits are reached, the count starts back at 1
		// 1 2 3 4 5 6 7 8 9	1 2 3 4
		// 4 5 6 7 8 9 1 2 3	3 4 1 2
		// 7 8 9 1 2 3 4 5 6
		for(int i=0; i<sqrtN; i++){
			// start at 1, 4, 7 or 1, 3
			count = sqrtN*i + 1;
			for(int j=0; j<N; j++){
				// if you reach 9 or 4, reset the counter
				if((count + j) > N) count = count - N;
				sudokuGrid[i][j] = count+j;
			}
		}
		// This loop fills in the rest of the cells by noticing a pattern
		for(int j=0; j<N; j++){
			// create a vector of sqrtN values from a column, ex 1,4,7
			// *1* 2 3 4 5 6 7 8 9
			// *4* 5 6 7 8 9 1 2 3
			// *7* 8 9 1 2 3 4 5 6
			for(int i=0; i<sqrtN; i++){
				vector[i] = sudokuGrid[i][j];
			}
			// now notice where that column goes
			// *1* 2  3  4 5 6 7 8 9
			// *4* 5  6  7 8 9 1 2 3
			// *7* 8  9  1 2 3 4 5 6
			// 2   3 *1* 5 6 4 8 9 7
			// 5   6 *4* 8 9 7 2 3 1
			// 8   9 *7* 2 3 1 5 6 4
			// 3  *1* 2  6 4 5 9 7 8
			// 6  *4* 5  9 7 8 3 1 2
			// 9  *7* 8  3 1 2 6 4 5
			// basically, the column of three numbers moves left and down 3 spaces
			col = j;
			for(int squareRow=1; squareRow<sqrtN; squareRow++){
				// move left
				col--;
				// if you've moved left outside the group of 3, then reset
				if(col < squareCol*sqrtN) col = (squareCol+1)*sqrtN - 1;
				// write out the vector of three in the new spot
				for(int i=0; i<sqrtN; i++){
					row = i + squareRow*sqrtN;
					sudokuGrid[row][col] = vector[i];
				}
			}
			// squareCol advances from 0, to 1, to 2 working in three groups of three columns each
			if((j % sqrtN)==(sqrtN - 1)) squareCol++;
		}
	}

	/*
	 * fills in the array which tells which square a certain element is in
	 */
	private void fillSquareID(){
		// 0 0 0 1 1 1 2 2 2	0 0 1 1 
		// 0 0 0 1 1 1 2 2 2	0 0 1 1
		// 0 0 0 1 1 1 2 2 2	2 2 3 3 
		// 3 3 3 4 4 4 5 5 5	2 2 3 3
		// 3 3 3 4 4 4 5 5 5
		// 3 3 3 4 4 4 5 5 5
		// 6 6 6 7 7 7 8 8 8
		// 6 6 6 7 7 7 8 8 8
		// 6 6 6 7 7 7 8 8 8
		int count = 0;
		// for each row
		for(int i=0; i<N; i++){
			// for sqrtN (3) groups
			for(int j=0; j<sqrtN; j++){
				// fill in from 0 to 3 with 0, then from 3 to 7 with 1, ...
				Arrays.fill(squareID[i], j*sqrtN, (j+1)*sqrtN, j+count);
			}
			// if get to a new group of sqrtN (3) then advance the count from 0 to 3 to 6
			if(i%sqrtN==(sqrtN-1)) count = count + sqrtN;
		}
	}
	
	/*
	 * The procedure to turn the standard Sudoku grid into a random one
	 */
	private void randomize(){
		Random a1 = new Random();
		Random b1 = new Random();
		Random iterations = new Random();
		randomizeInternal(a1, b1, iterations);
	}

	/*
	 * a randomize procedure used for debugging and testing since the seed is defined
	 */
	private void randomize(long seed){
		Random a1 = new Random(seed);
		Random b1 = new Random(seed+1);
		Random iterations = new Random(seed+2);
		randomizeInternal(a1, b1, iterations);
	}
	
	/*
	 * The randomizing procedure
	 */
	private void randomizeInternal(Random a1, Random b1, Random iterations){
		// The main idea is that if you start with a valid grid and you pick two numbers
		// say 5 and 8 and interchange every value of 5 and 8, then you will still
		// have a valid grid
		// and I conjecture that any valid grid is reachable from a series of these operations
		int a, b, c, maxIter;
		// the number of switching iterations to perform
		// from 50 to 100
		maxIter = iterations.nextInt(50) + 50;
		for(int iter=0; iter<maxIter; iter++){
			a = a1.nextInt(N)+1;
			// pick a new value from b until b!=a
			do{
				b = b1.nextInt(N)+1;
			} while(b==a);
			// iterate through all the cells
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					c = sudokuGrid[i][j];
					// if the cell matches a or b
					// then switch in the new value b or a
					if(c==a){
						sudokuGrid[i][j] = b;
					} else if(c==b){
						sudokuGrid[i][j] = a;
					}
				}
			}
		}
	}

	/**
	 * a utility funciton to print the sudoku grid to the console
	 * @since 1.0
	 */
	public void print(){
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(sudokuGrid[i]));
		}
	}
	
	/**
	 * determine if a sudoku grid is valid.  The validity check checks that one of each integer
	 * is in each road, column, square
	 * @return true if valid
	 * @since 1.0
	 */
	public boolean isValid(){
		int sum;
		int[] sums = new int[N];
		// the sum of the 1st k integers is k(k+1)/2, ex 1+2+3+4+5+6 = 6*7/2 = 21
		int total = N*(N+1)/2;
		// iterate through, summing the rows
		for(int i=0; i<N; i++){
			sum = 0;
			for(int j=0; j<N; j++){
				// sum up the cells
				sum = sum + sudokuGrid[i][j];
				sums[squareID[i][j]] = sums[squareID[i][j]] + sudokuGrid[i][j];
			}
			// compare with the correct answer for sum of the row
			if(sum != total) return false;
		}
		// iterate through, summing the columns
		for(int j=0; j<N; j++){
			sum = 0;
			for(int i=0; i<N; i++){
				// sum up the cells
				sum = sum + sudokuGrid[i][j];
			}
			// compare with the correct answer for sum of the column
			if(sum != total) return false;
		}
		// check the sums of the squares
		for(int j=0; j<N; j++){
			if(sums[j] != total) return false;
		}
		return true;
	}
	
	/**
	 * Determine if the sudoku grid is consistent, i.e. only one instance of a number 
	 * in each row, column, and square
	 * @return true if consistent
	 * @since 1.0
	 */
	public boolean isConsistent(){
		ArrayList constraint = new ArrayList(N);
		// rows
		for(int i=0; i<N; i++){
			// for each row, create a new list of constraints
			constraint = new ArrayList(N);
			for(int j=0; j<N; j++){
				// if there is not a hole in the cell
				if(sudokuGrid[i][j]!=0){
					// check to see if the constaint list already has that number
					if(constraint.contains(sudokuGrid[i][j])) {
						return false;
					// if it doesn't have it, then add it	
					} else constraint.add(sudokuGrid[i][j]);
				}
			}
		}
		//columns
		for(int j=0; j<N; j++){
			constraint = new ArrayList(N);
			for(int i=0; i<N; i++){
				if(sudokuGrid[i][j]!=0){
					if(constraint.contains(sudokuGrid[i][j])) {
						return false;
					} else constraint.add(sudokuGrid[i][j]);
				}
			}
		}
		//squares
		for(int square=0; square<N; square++){
			constraint = new ArrayList(N);
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					if(sudokuGrid[i][j]!=0 && squareID[i][j]==square){
						if(constraint.contains(sudokuGrid[i][j])) {
							return false;
						} else constraint.add(sudokuGrid[i][j]);
					}
				}
			}
		}
		return true;
	}
	
}
