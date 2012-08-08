package utils;

import java.util.Arrays;

/**
 * A class with a recursive algorithm for creating permutations
 * @author CARNELLR
 * @version 1.0 Feb 2006
 *
 */
public class CombinationArray {
	private static int ind;
	private int facN;
	public int[][] combinationArray;
	private int[] values;
	
	/**
	 * Constructor.  Creates an array of integers which are the permutations of the set of N integers
	 * @param N the number of integers in the permutation
	 * @since 1.0
	 */
	public CombinationArray(int N){
		values = new int[N];
		Arrays.fill(values, 0);
		facN = KryptoUtils.factorial(N);
		combinationArray = new int[facN][N];
		ind = 0;
		
		visit(values, N, 0, -1, combinationArray);
		
	}
	
	/*
	 * Recursive algorithm for creating permutations of N integers
	 */
	private static void visit(int[] value, int N, int k, int level, int combinationArray[][]) {
		// visit is a recursive algorithm for creating the combinations of N integers
		// initially, Value is an array of N=5 zeros
		//            N=5
		//            k = 0
		//            level = -1
		//            results is a N!xN matrix = 120 x 5
		// the ind variable is initially 0 when the class is called
		// the ind variable must be public so that its value can increment with
		// each recursive call to visit
		level = level + 1; 
		value[k] = level;
		if (level == N){
			//System.out.println(Arrays.toString(Value));
			for(int j = 0; j < N; j++){
				combinationArray[ind][j] = value[j];
			}
			ind = ind + 1;
		} else {
			for (int i = 0; i < N; i++)
				if (value[i] == 0)
					visit(value, N, i, level, combinationArray);
		}
		level = level - 1; 
		value[k] = 0;
	}

}
