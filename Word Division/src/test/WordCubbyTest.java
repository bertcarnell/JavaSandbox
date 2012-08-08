package test;

import junit.framework.TestCase;

import utils.WordCubby;
import javax.swing.JProgressBar;

public class WordCubbyTest extends TestCase {
	private JProgressBar j;
	protected WordCubby w;
	
	protected void setUp(){
		j = new JProgressBar(JProgressBar.VERTICAL, 0, 100);
		w = new WordCubby(j);
	}
	
	/*
	 * Test method for 'utils.WordCubby.WordCubby(JProgressBar)'
	 */
	//public void testWordCubby() {
	//	
	//}

	/*
	 * Test method for 'utils.WordCubby.set(int)'
	 */
	public void testSet() {
		w.set(10);
		assertTrue(j.getValue()==10);
	}

	/*
	 * Test method for 'utils.WordCubby.setRunning()'
	 */
	public void testSetRunning() {
		w.setRunning();
		assertTrue(w.isRunning());
	}

	/*
	 * Test method for 'utils.WordCubby.isRunning()'
	 */
	public void testIsRunning() {
		w.setRunning();
		assertTrue(w.isRunning());
		w.setStopped();
		assertTrue(!w.isRunning());
	}

	/*
	 * Test method for 'utils.WordCubby.setStopped()'
	 */
	public void testSetStopped() {
		w.setStopped();
		assertTrue(!w.isRunning());
	}

}
