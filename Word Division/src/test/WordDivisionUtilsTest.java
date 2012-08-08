package test;

import junit.framework.TestCase;
import java.util.HashMap;
import utils.WordDivisionUtils;
import java.util.Arrays;

public class WordDivisionUtilsTest extends TestCase {
	protected HashMap<String, Integer> hMap = new HashMap<String, Integer>(11, (float) 1.0);
	protected String[] s = {"j", "i", "h", "g", "f", "e", "d", "c", "b", "a"};
	protected String[][] sm = {{"abcd", "efg", "hij"},{"ab", "cd", "ef"}};
	protected String[] oa = {"eeee", "dddd", "ff", "ggg"};
	
	protected void setUp(){
		for(int i=0; i<10; i++){
			hMap.put(s[9-i], Integer.valueOf(i));
		}
	}

	/*
	 * Test method for 'utils.WordDivisionUtils.hashToWord(HashMap<String, Integer>, String[])'
	 */
	public void testHashToWord() {
		assertTrue("abcdefghij".equals(WordDivisionUtils.hashToWord(hMap, s).toString()));
	}

	/*
	 * Test method for 'utils.WordDivisionUtils.getAllLetters(Set<String>)'
	 */
	public void testGetAllLetters() {
		Arrays.sort(s);
		assertTrue(Arrays.equals(s, WordDivisionUtils.getAllLetters(hMap.keySet())));
	}

	/*
	 * Test method for 'utils.WordDivisionUtils.updateMap(HashMap<String, Integer>, String[], int[])'
	 */
	public void testUpdateMap() {
		HashMap<String, Integer> hMap2 = hMap;
		String[] s2 = {"t", "u"};
		int[] z = {11, 22};
		assertTrue(null==WordDivisionUtils.updateMap(hMap2, s2, z));
		assertTrue(null==WordDivisionUtils.updateMap(hMap2, s, z));
		int[] y = {0,11,22,33,44,55,66,77,88,99};
		for(int i=0; i<10; i++){
			hMap2.put(s[i], Integer.valueOf(y[i]));
		}
		assertTrue(hMap2.equals(WordDivisionUtils.updateMap(hMap, s, y)));
	}

	/*
	 * Test method for 'utils.WordDivisionUtils.createHashMap(String[][], String[])'
	 */
	public void testCreateHashMap() {
		HashMap hMap3 = WordDivisionUtils.createHashMap(sm, oa);
		Object[] sNew = hMap3.keySet().toArray();
		Arrays.sort(sNew);
		Arrays.sort(s);
		for(int j=0; j<10; j++){
			assertTrue(sNew[j].toString().toUpperCase().equals(s[j].toUpperCase()));
		}
		int[] i = new int[10];
		assertTrue(hMap3.values().toString().equals(Arrays.toString(i)));
	}

	/*
	 * Test method for 'utils.WordDivisionUtils.createVector(HashMap<String, Integer>, String[][], String[])'
	 */
	public void testCreateVector() {
		int[] testResult = {-1122, -67, 179537};
		assertTrue(Arrays.equals(testResult, WordDivisionUtils.createVector(hMap, sm, oa)));
		String[][] smTest = {{"abcd", "efg", },{"cd", "ef"}};		
		assertTrue(null==WordDivisionUtils.createVector(hMap, smTest, oa));
		String[] oaTest = {"eeee", "dddd", "ff"};
		assertTrue(null==WordDivisionUtils.createVector(hMap, sm, oaTest));		
	}

	/*
	 * Test method for 'utils.WordDivisionUtils.parser(String)'
	 */
	public void testParser() {
		String let = "abc";
		assertTrue(Arrays.equals(let.toCharArray(), WordDivisionUtils.parser("   AbC ")));
	}

	/*
	 * Test method for 'utils.WordDivisionUtils.addLetters(HashMap<String, Integer>, char[])'
	 */
	public void testAddLetters() {
		String let = "xyz";
		HashMap hMap3 = WordDivisionUtils.addLetters(hMap, let.toCharArray());
		assertTrue(hMap3.containsKey("x") & hMap3.containsKey("y") & hMap3.containsKey("z"));
		assertTrue(hMap3.get("x").equals(Integer.valueOf(0)));
		assertTrue(hMap3.get("y").equals(Integer.valueOf(0)));
		assertTrue(hMap3.get("z").equals(Integer.valueOf(0)));
	}

	/*
	 * Test method for 'utils.WordDivisionUtils.calculateValueOfLetters(HashMap<String, Integer>, char[])'
	 */
	public void testCalculateValueOfLetters() {
		String let = "abc";
		assertTrue(12==WordDivisionUtils.calculateValueOfLetters(hMap, let.toCharArray()));
		let = "fdeacg";
		assertTrue(534026==WordDivisionUtils.calculateValueOfLetters(hMap, let.toCharArray()));
	}

}
