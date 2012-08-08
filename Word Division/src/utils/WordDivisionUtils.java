package utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * Utility functions for the Word Division Solver
 * @author CARNELLR
 * @version 1.0 Feb 2006
 *
 */
public class WordDivisionUtils {

	/**
	 * Translates the hash map of 10 letters into a word according to thier associated numbers
	 * @param hMap a hashmap with a key of 10 letters (Strings) and values of Integers 0-9
	 * @param allLetters an array of the 10 letters used in the division problem
	 * @return the answer in word format
	 * @since 1.0
	 */
	public static StringBuffer hashToWord(HashMap<String, Integer> hMap, String[] allLetters){
		String[] preResult = new String[10];
		StringBuffer result = new StringBuffer(0);
		int posit;
		// cycle through each letter in allLetters, get the associated number, put the letter in
		// right place in the preResult String array
		for(int i=0; i<10; i++){
			posit = hMap.get(allLetters[i]);
			preResult[posit] = allLetters[i];
		}
		// change the String array into a StringBuffer word
		for(int i=0; i<10; i++){
			result.append(preResult[i]);
		}
		return(result);
	}
	
	/**
	 * Finds and reports all the individual letters in the set
	 * @param letterSet a Set of letters from the word expression
	 * @return an array of letters used in the expression
	 * @since 1.0
	 */
	public static String[] getAllLetters(Set<String> letterSet){
		String[] result = new String[letterSet.size()];
		int iter = 0;
		// iterate through the set, recording letters in the array
		for(String i: letterSet){
			result[iter]=i;
			iter++;
		}
		Arrays.sort(result);
		return(result);
	}
	
	/**
	 * Updates the hash map of letters and numbers
	 * @param hMap a hash map with letters (String) as the key, and Integers as the values
	 * @param l an array of letters (String) to have their values updated corresponding to the num array
	 * @param num an array of numbers (int) corresponding to the letters (l)
	 * @return an updated hash map
	 * @since 1.0
	 */
	public static HashMap<String, Integer> updateMap(HashMap<String, Integer> hMap, String[] l, int[] num){
		// if the inputs are of different sizes, return null
		if(hMap.size()!=l.length | l.length!=num.length) return null;
		// iterate through the letters, update the hash map with the corresponding number
		for(int i=0; i<l.length; i++){
			hMap.put(l[i], num[i]);
		}
		return(hMap);
	}

	/**
	 * Creates a hash map with the letters from the word expresssion
	 * @param sm a matrix of Strings containing the elements of the linear 
	 * part of the word expression (A - B = C)
	 * @param s an array of Strings containing the elements of the division 
	 * part of the word expression (A / B = C + R)
	 * @return a hash map with letters (String) as the key and Integers as the values
	 * @since 1.0
	 */
	public static HashMap<String, Integer> createHashMap(String[][] sm, String[] s){
		HashMap<String, Integer> h = new HashMap<String, Integer>(11, (float) 1.0);
		char[] oneSetOfChars;
		// iterate through the matrix
		for(int i=0; i<sm.length; i++){
			for(int j=0; j<sm[i].length; j++){
				// parse the expression of that matrix element into a character array
				oneSetOfChars = parser(sm[i][j]);
				// add those letters to the hash map as keys with default values
				h = addLetters(h, oneSetOfChars);
			}
		}
		// iterate through the array
		for(int i=0; i<s.length; i++){
			// parse the expression of that matrix element into a character array
			oneSetOfChars = parser(s[i]);
			// add those letters to the hash map as keys with default values
			h = addLetters(h, oneSetOfChars);
		}
		return h;
	}

	/**
	 * Change the hash map and the word expressions into the results of the expressions
	 * @param hMap a hash map with letters (String) as the key and Integers as values
	 * @param sM a matrix of Strings containing the elements of the linear 
	 * part of the word expression (A - B = C) 
	 * @param s an array of Strings containing the elements of the division 
	 * part of the word expression (A / B = C + R)
	 * @return an array giving the results of the expressions based on the hash map values
	 * @since 1.0
	 */
	public static int[] createVector(HashMap<String, Integer> hMap, String[][] sM, String[] s) {
		// example:
		// key:    A B C D E F G H I J
		// values: 0 1 2 3 4 5 6 7 8 9
		// sM = {{IJ, BC, HH}, {DAA, EF, CFF}}
		// s = {BD, E, D, B}
		// vector = {89 - 12 - 77 = 0, 300 - 45 - 255 = 0, 4 * 3 + 1 - 13 = 0} = {0, 0, 0}
		
		// if the inputs are of the wrong size, return null
		if(sM[0].length!=3 | s.length!=4) return null;
		int[][] preResult = new int[sM.length][sM[0].length];
		char[] letters;
		int[] result = new int[preResult.length+1];
		int[] lastNumbers = new int[s.length];
		// parse through the matrix of linear expressions
		for(int i=0; i<sM.length; i++){
			for(int j=0; j<sM[i].length; j++){
				// parse the expression of that matrix element into a character array
				letters = parser(sM[i][j]);
				// calculate the value of that group of letters (eg. change IJ to 89 above)
				preResult[i][j] = calculateValueOfLetters(hMap, letters);
			}
		}
		// perform the linear combination of the values and store the result
		// (eg., the 89 - 12 - 77 and 300 - 45 - 255)
		for(int i=0; i<preResult.length; i++){
			result[i] = preResult[i][0] - preResult[i][1] - preResult[i][2];
		}
		// parse through the array of the division expression
		for(int i=0; i<s.length; i++){
			// parse the expression of that element into a character array
			letters = parser(s[i]);
			// calculate the value of that group of letters(eg. change BD to 13)
			lastNumbers[i] = calculateValueOfLetters(hMap, letters);
		}
		// perform the linear combination of the division expression and store the result
		// (eg., the 4 * 3 + 1 - 13)
		result[result.length-1] = lastNumbers[1] * lastNumbers[2] + lastNumbers[3] - lastNumbers[0];
		return(result);
	}
	
	/**
	 * Change a string element of letters into a character array
	 * @param exp String expression (ABCD)
	 * @return an array of characters {a, b, c, d}
	 * @since 1.0
	 */
	public static char[] parser(String exp){
		exp = exp.trim();
		exp = exp.toLowerCase();
		return(exp.toCharArray());
	}
	
	/**
	 * Add key values (letters) to the hash map
	 * @param hToAdd hash map to be appended
	 * @param charToAdd key to add
	 * @return an appended hash map
	 * @since 1.0
	 */
	public static HashMap<String, Integer> addLetters(HashMap<String, Integer> hToAdd, char[] charToAdd){
		String individChar;
		Integer individNum = Integer.valueOf(0);
		// iterate through the character array
		for(int i=0; i<charToAdd.length; i++){
			individChar = String.valueOf(charToAdd[i]);
			// if the hash map does not already contains the key, then add it with a default value of 0
			if(!hToAdd.containsKey(individChar)){
				hToAdd.put(individChar, individNum);
			}
		}
		return(hToAdd);
	}
	
	/**
	 * Calculate the value of a character array of letters using a the hasmap values
	 * @param hMap a hash map with letters (String) as the key and Integers as values 
	 * @param charToSum an array of characters representing a number (eg. ABCD = 1543)
	 * @return the value of the character array
	 * @since 1.0
	 */
	public static int calculateValueOfLetters(HashMap<String, Integer> hMap, char[] charToSum){
		int result = 0;
		// iterate through the letters in the character array and assign them value based on their position
		// A B C D
		// 1 5 4 3 = 1000*1 + 100*5 + 10*4 + 1*3 = 10^3*1 + 10^2*5 + 10^1*4 + 10^0*3
		for(int i=0; i<charToSum.length; i++){
			result = result + (int) hMap.get(String.valueOf(charToSum[i])) * (int) Math.pow(10, (charToSum.length - 1) - i);
		}
		return(result);
	}
}
