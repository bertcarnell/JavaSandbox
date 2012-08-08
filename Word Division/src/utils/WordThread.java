package utils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import gui.WordDivisionGUI;

/**
 * Creates a Thread with which to run the solver to allow the GUI to remain on a separate thread
 * @author CARNELLR
 * @version 1.0 Feb 2006
 *
 */
public class WordThread extends Thread{
	private String[][] thisStringMatrix;
	private String[] thisOverallExpression;
	private WordCubby cubby;
	private JLabel jLabel;
	
	/**
	 * Constructor.  Contains information needed in the solver and a WordCubby for communication
	 * @param c a WordCubby used to communicate with the thread
	 * @param j The Jlabel used for ouput of the solved expression
	 * @param stringMatrix The matrix of the linear part of the word expression
	 * @param overallExpression The array of the division expression values
	 * @since 1.0
	 */
	public WordThread(WordCubby c, JLabel j, String[][] stringMatrix, String[] overallExpression){
		thisStringMatrix = stringMatrix;
		thisOverallExpression = overallExpression;
		cubby = c;
		jLabel = j;
	}
	
	/**
	 * Run method of the superclass Thread.  Starts the solver and communicates with the WordCubby.
	 * @since 1.0
	 */
	public void run(){
		cubby.setRunning();
		try{
			String s = WordDivisionGUI.solveWordExpression(thisStringMatrix, thisOverallExpression);
			cubby.set(100);
			jLabel.setText(s);
			cubby.setStopped();
		} catch(IllegalArgumentException iae) {
    		JOptionPane.showMessageDialog(null, "The expression must contain exactly 10 letters.  The expression cannot be solved.", "Invalid Format", JOptionPane.ERROR_MESSAGE);
		}
	}

}
