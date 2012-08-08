package utils;

import java.util.Arrays;

/**
 * A utility class with methods used in the calculation of Krypto Expressions
 * @author CARNELLR
 * @version 1.0 Feb 2006
 */
public class KryptoUtils {

	/**
	 * Calculates the factorial of an integer.  If p<0, p is returned.  If p>=0, the factorial is returned. 
	 * @param p the number for which the factorial is desired
	 * @return p!
	 * @since 1.0
	 */
	public static int factorial(int p){
		// in this application p cannot be negative, so no logic for negative factorials
		// is included.  if p=0 or 1 then 1 is returned.
		// if p>1 then p! is returned
		// also, in this application p is small (p will generally be 5, 
		// but could range from 2 to 7)
		// so no logic for large p or exception handling for memory overflow is included
		int returnValue = p;
		if(p > 1) {
			for(int m = 1; m < p; m++){
				returnValue = returnValue*(p-m);
			}
		} else if(p==0) {
			returnValue = 1;
		}
		return(returnValue);
	}

	/**
	 * Create the combinations of possible operations used in the Krypto Expression
	 * @param possibleOperations The number of permuations of possble operations
	 * @param N the number of numbers in the Krypto Expression
	 * @return matrix corresponding to the permutations of operations
	 */
	public static int[][] allCombo(int possibleOperations, int N){
		// in this application N is generally 5 but may range from 2 to 7
		// there are usually 4^(N-1) possibleOperations meaning that the 
		// four operations (+ - * /) can be arranged in 4^(5-1)=256 different ways
		// the N-1 power is used since there are N-1 operations between N numbers in
		// these expressions
		// create a 4x256 matrix to hold all permutions of the operations
		int[][] tempMatrix1 = new int[N-1][possibleOperations];
		int sectionLength;
		// populate the 4x256 matrix so that all permuations are created
		for(int i=0; i<(N-1); i++){ // rows
			sectionLength = (int)Math.pow(4, N-2-i);
			// iterate through the sections of length sectionLength
			for(int j=0; j<(int)Math.pow(4,i); j++){
				for(int k=0; k<4; k++){
					// fill the subsection with the right operation
					Arrays.fill(tempMatrix1[i], (4*j+k)*sectionLength, (4*j+k+1)*sectionLength, k+1);
				}
			}
		}
		// transpose the matrix
		int[][] tempMatrix2 = new int[possibleOperations][N-1];
		for(int i=0; i < (N-1); i++){
			for(int j=0; j<possibleOperations; j++) {
				tempMatrix2[j][i] = tempMatrix1[i][j];
			}
		}
		return tempMatrix2;
	}
	
	
}
