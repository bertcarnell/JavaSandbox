package test;

import junit.framework.TestCase;

import java.math.BigInteger;
import utils.PermutationGenerator;
import java.util.Arrays;

public class PermutationGeneratorTest extends TestCase {
	protected PermutationGenerator p;
	private final int N = 3;
	
	protected void setUp(){
		try{
			p = new PermutationGenerator(N);
		} catch(IllegalArgumentException iae){
			assertTrue(false);
		}
	}
	/*
	 * Test method for 'utils.PermutationGenerator.PermutationGenerator(int)'
	 */
	public void testPermutationGenerator() {
		try{
			PermutationGenerator p1 = new PermutationGenerator(-1);
		} catch(IllegalArgumentException iae){
			assertTrue(true);
		}
	}

	/*
	 * Test method for 'utils.PermutationGenerator.reset()'
	 */
	public void testReset() {
		p.getNext();
		p.getNext();
		p.reset();
		assertTrue(p.getNumLeft().equals(BigInteger.valueOf(6)));
	}

	/*
	 * Test method for 'utils.PermutationGenerator.getNumLeft()'
	 */
	public void testGetNumLeft() {
		p.reset();
		assertTrue(p.getNumLeft().equals(BigInteger.valueOf(6)));
		p.getNext();
		assertTrue(p.getNumLeft().equals(BigInteger.valueOf(5)));
		for(int i=0; i<5; i++){
			p.getNext();
		}
		assertTrue(p.getNumLeft().equals(BigInteger.valueOf(0)));
	}

	/*
	 * Test method for 'utils.PermutationGenerator.getTotal()'
	 */
	public void testGetTotal() {
		assertTrue(p.getTotal().equals(BigInteger.valueOf(6)));
	}

	/*
	 * Test method for 'utils.PermutationGenerator.hasMore()'
	 */
	public void testHasMore() {
		p.reset();
		assertTrue(p.hasMore());
		for(int i=0; i<5; i++){
			p.getNext();
			assertTrue(p.hasMore());
		}
		p.getNext();
		assertTrue(!p.hasMore());
	}

	/*
	 * Test method for 'utils.PermutationGenerator.getNext()'
	 */
	public void testGetNext() {
		int[][] test = {{0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,0,1},{2,1,0}};
		p.reset();
		for(int i=0; i<6; i++){
			assertTrue(Arrays.equals(p.getNext(), test[i]));
		}
	}

}
