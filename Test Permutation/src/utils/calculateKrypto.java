package utils;

import java.util.Arrays;

/**
 * A class of utilities to calculate the solution to Kryto expressions
 * @author CARNELLR
 * @version 1.0 Feb 2006
 *
 */
public class calculateKrypto {
	
	/**
	 * Solve Krypto Expressions
	 * @param numbers the 5 (normally) numbers which must be arranged to equal the target
	 * @param intTarget the target of the 5 number expression
	 * @param bParenthesisOn an indicator of whether or not parenthesis are desired in the expression
	 * @param bWantPositive an indicator of whether or not intermediate steps are to be kept positive
	 * @return the Krypto expression solution
	 * @since 1.0
	 */
	public static String solveKrypto(int[] numbers, int intTarget, boolean bParenthesisOn, boolean bWantPositive) {
		  // N is the lenght of the numbers in the krypto expression
		  int N = numbers.length;
		  // facN is the factorial of N;
		  int facN = KryptoUtils.factorial(N);
		  // Class CombinationArray creates all combinations of numbers 1 through N
		  CombinationArray ca = new CombinationArray(N);
		  // array of Combinations of numbers
		  int[][] results;
		  // array of operations that can be done between the numbers
		  // in the krypto expression
		  int[][] operations;
		  // the number of possible operations
		  // can can be between the numbers, usually 4^(5-1) = 256
		  int possibleOperations = (int)Math.pow(4, N-1); // 4^(N-1)
		  // create a matrix to hold the result of each calculation
		  // and another matrix to indicate if an intermediate step was negative
		  // combined has a unique entry for each of the 120 combinations of numbers 
		  // and 256 permuations of operations
		  double[][] combined = new double[facN][possibleOperations];
		  boolean[][] combinedIndicator = new boolean[facN][possibleOperations];
		  // results 2 will hold some intermediate calculations as a double
		  double[][] results2 = new double[facN][N];
		  // tempValue hold double valued intermediate calculations
		  double tempValue = 0;
		  // target is a double valued target of the expression
		  double target = (double)intTarget;
		  // finalOrder is the final order of the numbers in the expression
		  int[] finalOrder = new int[N];
		  // finalOperations is the final order of the operations in the expression
		  int[] finalOperations = new int[N-1];
		  // indicator values in the logic to determine if a correct answer is found
		  boolean bDone = false;
		  boolean bDoneWithNeg = false;
		  
		  if(N==1) {
			  return("There must be at least two numbers to build an expression");
		  }

		  // create all combination of the numbers 1 through 5
		  // in the CombinationArrary Class
		  // and put them in the results array
		  results = ca.combinationArray;
		  
		  // transform the combination of the numbers 1 through 5
		  // into the combination of the numbers that make up the expression
		  for(int i=0; i < facN; i++){
			  for(int j=0; j < N; j++){
				  // a 1 in results corresponds to the 0th number in numbers, etc.
				  results[i][j] = numbers[results[i][j] - 1];
			  }
		  }
		  
		  // create the matrix of all permuations of the 4 operations in (N-1)=4 places
		  operations = KryptoUtils.allCombo(possibleOperations, N);
		  
		  // calculate each entry of combined
		  for(int i = 0; i < facN; i++){
			  for(int j = 0; j < possibleOperations; j++){
				  for(int k = 0; k < (N-1); k++){
					  // if the (double) notation is not used, rounding occurs
					  // with integer operations before the double tempValue is stored
					  if(k!=0) { // operations after the first
						  if(operations[j][k]==1){
							  tempValue = results2[i][k] + (double) results[i][k+1];
						  } else if(operations[j][k]==2){
							  tempValue = results2[i][k] - (double) results[i][k+1];
						  } else if(operations[j][k]==3){
							  tempValue = results2[i][k] * (double) results[i][k+1];
						  } else if(operations[j][k]==4 & (double) results[i][k+1]!=0){
							  tempValue = results2[i][k] / (double) results[i][k+1];
						  }
					  } else { // first operation
						  if(operations[j][k]==1){
							  tempValue = (double) results[i][k] + (double) results[i][k+1];
						  } else if(operations[j][k]==2){
							  tempValue = (double) results[i][k] - (double) results[i][k+1];
						  } else if(operations[j][k]==3){
							  tempValue = (double) results[i][k] * (double) results[i][k+1];
						  } else if(operations[j][k]==4 & (double) results[i][k+1]!=0){
							  tempValue = (double) results[i][k] / (double) results[i][k+1];
						  }
					  }
					  results2[i][k+1] = tempValue;
					  // if any tempValues is negative then 
					  // combinedIndicator = TRUE when the previous value was TRUE
					  //                          when the previous value was FALSE
					  // I'm not sure why combinedIndicator[i][j]=true wouldn't work
					  if(tempValue<0) combinedIndicator[i][j] = (combinedIndicator[i][j] | true);
				  }
				  combined[i][j] = tempValue;
			  }
		  }
		  
		  // seach for correct answer
		  for(int i = 0; i < facN; i++){
			  for(int j = 0; j < possibleOperations; j++){
				  // if the correct answer is found
				  // store the result and operations
				  if(combined[i][j]==target) {
					  finalOrder = results[i];
					  finalOperations = operations[j];
					  // if we only want positive intermediate steps and we had negative steps
					  // then we found the answer, but with negative steps
					  // I'm not sure why bDoneWithNeg=true wouldn't work
					  if(bWantPositive & combinedIndicator[i][j]) bDoneWithNeg = (bDoneWithNeg | true);
					  // if we want only positive intermediate steps and we had all positive steps
					  // or if we didnt care about negative intermediate steps
					  // then we have the answer
					  if((bWantPositive & !combinedIndicator[i][j]) | !bWantPositive) bDone = true;
				  }
				  // when the first correct expression is found break
				  if(bDone) break;
			  }
			  // when the first correct expression is found break
			  if(bDone) break;
		  }
		  if(bDone){
			  return(printResult(finalOrder, finalOperations, target, bParenthesisOn));
		  } else if(bDoneWithNeg){
			  return("No answer can be found without a negative intermediate step!");
		  } else {
			  return("No answer can be found!");
		  }
	}

	/*
	 * Print the result of the Krypto expression with parenthesis if desired
	 */
	private static String printResult(int[] finalOrder, int[]finalOperations, double target, boolean bParenthesisOn){
		int N = finalOrder.length;
		String [] charOperations = new String [N-1];
		String [] charParenthesis = new String [5];
		Arrays.fill(charParenthesis, " ");
		// a stringBuilder is used since it has append and toString methods
		StringBuilder charAnswer = new StringBuilder(8*N+6);
		// convert numerical operations coding to text operations coding
		for(int i = 0; i < (N-1); i++){
			if(finalOperations[i] == 1){
				charOperations[i] = " + ";
			} else if(finalOperations[i] == 2){
				charOperations[i] = " - ";
			} else if(finalOperations[i] == 3){
				charOperations[i] = " x ";
			} else if(finalOperations[i] == 4){
				charOperations[i] = " / ";
			}
		}
		// parenthesis support only for N=5
		if(N == 5 & bParenthesisOn){
			// these are the possible places for parentheses and operations 
			// but not all at once.  "x" = any number, "+" = any operation
			// ((x+x)+x )+x )+x = x
			// 01   2   3   4              parentheses index
			//    0  1   2   3             operations index
			//   0 1  2   3   4   target   numbers index
			for(int i = 0; i<3; i++) {
				// right parentheses are needed when / or * follows + or -
				if((finalOperations[i]==1 | finalOperations[i]==2) & 
				   (finalOperations[i+1]==3 | finalOperations[i+1]==4)) {
					charParenthesis[i+2] = ")";
					// two left parentheses are needed when
					// ((x +- x) */ x +- x) */ x
					if((finalOperations[0]==1 | finalOperations[0]==2) &&
					   (finalOperations[1]==3 | finalOperations[1]==4) &&
					   (finalOperations[2]==1 | finalOperations[2]==2) &&
					   (finalOperations[3]==3 | finalOperations[3]==4)) {
						charParenthesis[0] = "(";
						charParenthesis[1] = "(";
					} else { // else only one left parenthesis is needed
						charParenthesis[1] = "(";
					}
				}
			}
			// append parenthesis at 0 and 1 positions in the answer
			charAnswer.append(charParenthesis[0]);
			charAnswer.append(charParenthesis[1]);
		}
		// enter the rest of the numbers, operations, and parenthesis that are needed
		// in number position 0 through operation position 3
		for(int i = 0; i<(N-1); i++){
			charAnswer.append(finalOrder[i]);
			if((i==1 | i==2 | i==3) & N==5 & bParenthesisOn) 
				charAnswer.append(charParenthesis[i+1]);
			charAnswer.append(charOperations[i]);
		}
		int target2;
		target2 = (int)target;
		// enter number position 4, equals, and the target
		charAnswer.append(finalOrder[N-1] + " = " + target2);
		//System.out.println(charAnswer);
		return(charAnswer.toString());
	}
}
