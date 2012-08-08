package gui;

// import GUI components
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JProgressBar;
// import Word Division utilities
import utils.*;
// import other needed classes
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.awt.Graphics;

/**
 * Word Division GUI creates an applet that solver word division puzzles
 * @author CARNELLR
 * @version 1.0 Feb 2006
 *
 */
public class WordDivisionGUI extends JApplet implements ActionListener{

	private JPanel jContentPane = null;
	private JTextField jTextField = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;
	private JTextField jTextField3 = null;
	private JTextField jTextField4 = null;
	private JTextField jTextField5 = null;
	private JTextField jTextField6 = null;
	private JTextField jTextField7 = null;
	private JTextField jTextField8 = null;
	private JTextField jTextField9 = null;
	private JTextField jTextField10 = null;
	private JTextField jTextField11 = null;
	private JTextField jTextField12 = null;
	private JTextField jTextField13 = null;
	private JTextField jTextField14 = null;
	private JTextField jTextField15 = null;
	private JTextField jTextField16 = null;
	private JPanel jPanel = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JProgressBar jProgressBar = null;
	private JTextField jTextField17 = null;

	private WordThread wordThread;
	public static WordCubby wordCubby;
	
	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new java.awt.Rectangle(165,45,121,16));
			jTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
		}
		return jTextField;
	}

	/**
	 * This method initializes jTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new java.awt.Rectangle(15,45,121,16));
			jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		}
		return jTextField1;
	}

	/**
	 * This method initializes jTextField2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new java.awt.Rectangle(165,15,121,16));
			jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		}
		return jTextField2;
	}

	/**
	 * This method initializes jTextField3	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setBounds(new java.awt.Rectangle(165,90,61,16));
		}
		return jTextField3;
	}

	/**
	 * This method initializes jTextField4	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField4() {
		if (jTextField4 == null) {
			jTextField4 = new JTextField();
			jTextField4.setBounds(new java.awt.Rectangle(180,120,61,16));
		}
		return jTextField4;
	}

	/**
	 * This method initializes jTextField5	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField5() {
		if (jTextField5 == null) {
			jTextField5 = new JTextField();
			jTextField5.setBounds(new java.awt.Rectangle(180,135,61,16));
		}
		return jTextField5;
	}

	/**
	 * This method initializes jTextField6	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField6() {
		if (jTextField6 == null) {
			jTextField6 = new JTextField();
			jTextField6.setBounds(new java.awt.Rectangle(195,165,61,16));
		}
		return jTextField6;
	}

	/**
	 * This method initializes jTextField7	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField7() {
		if (jTextField7 == null) {
			jTextField7 = new JTextField();
			jTextField7.setBounds(new java.awt.Rectangle(195,180,61,16));
		}
		return jTextField7;
	}

	/**
	 * This method initializes jTextField8	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField8() {
		if (jTextField8 == null) {
			jTextField8 = new JTextField();
			jTextField8.setBounds(new java.awt.Rectangle(210,210,61,16));
		}
		return jTextField8;
	}

	/**
	 * This method initializes jTextField9	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField9() {
		if (jTextField9 == null) {
			jTextField9 = new JTextField();
			jTextField9.setBounds(new java.awt.Rectangle(210,225,61,16));
		}
		return jTextField9;
	}

	/**
	 * This method initializes jTextField10	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField10() {
		if (jTextField10 == null) {
			jTextField10 = new JTextField();
			jTextField10.setBounds(new java.awt.Rectangle(225,255,61,16));
		}
		return jTextField10;
	}

	/**
	 * This method initializes jTextField11	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField11() {
		if (jTextField11 == null) {
			jTextField11 = new JTextField();
			jTextField11.setBounds(new java.awt.Rectangle(225,270,61,16));
		}
		return jTextField11;
	}

	/**
	 * This method initializes jTextField12	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField12() {
		if (jTextField12 == null) {
			jTextField12 = new JTextField();
			jTextField12.setBounds(new java.awt.Rectangle(240,300,61,16));
		}
		return jTextField12;
	}

	/**
	 * This method initializes jTextField13	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField13() {
		if (jTextField13 == null) {
			jTextField13 = new JTextField();
			jTextField13.setBounds(new java.awt.Rectangle(240,315,61,17));
		}
		return jTextField13;
	}

	/**
	 * This method initializes jTextField14	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField14() {
		if (jTextField14 == null) {
			jTextField14 = new JTextField();
			jTextField14.setBounds(new java.awt.Rectangle(255,345,61,16));
		}
		return jTextField14;
	}

	/**
	 * This method initializes jTextField15	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField15() {
		if (jTextField15 == null) {
			jTextField15 = new JTextField();
			jTextField15.setBounds(new java.awt.Rectangle(255,360,61,16));
		}
		return jTextField15;
	}

	/**
	 * This method initializes jTextField16	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField16() {
		if (jTextField16 == null) {
			jTextField16 = new JTextField();
			jTextField16.setBounds(new java.awt.Rectangle(270,393,48,16));
		}
		return jTextField16;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Solution ...");
			jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jLabel1.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));
			jLabel1.setBounds(new java.awt.Rectangle(15,60,151,31));
			jLabel = new JLabel();
			jLabel.setText("0 1 2 3 4 5 6 7 8 9");
			jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jLabel.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));
			jLabel.setBounds(new java.awt.Rectangle(15,15,151,31));
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setBounds(new java.awt.Rectangle(300,15,181,166));
			jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Solution", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), null));
			jPanel.add(jLabel, null);
			jPanel.add(jLabel1, null);
			jPanel.add(getJButton(), null);
			jPanel.add(getJProgressBar(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new java.awt.Rectangle(45,105,91,16));
			jButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			jButton.setText("Solve");
		}
		return jButton;
	}

	/**
	 * This method initializes jProgressBar	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */
	private JProgressBar getJProgressBar() {
		if (jProgressBar == null) {
			jProgressBar = new JProgressBar();
			jProgressBar.setBounds(new java.awt.Rectangle(15,135,151,16));
		}
		return jProgressBar;
	}

	/**
	 * This method initializes jTextField17	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField17() {
		if (jTextField17 == null) {
			jTextField17 = new JTextField();
			jTextField17.setBounds(new java.awt.Rectangle(165,75,61,16));
		}
		return jTextField17;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new java.awt.Rectangle(345,210,91,16));
			jButton1.setText("Clear");
		}
		return jButton1;
	}

	/*
	 * Initialize the Applet
	 */
	public void init() {
		// initialize method
		this.setSize(500, 450);
		this.setContentPane(getJContentPane());
		// add ActionListeners for the solve and clear buttons
		jButton.addActionListener(this);
		jButton1.addActionListener(this);
		// WordCubby is a synchronized class used to communicate to the solver thread
		wordCubby = new WordCubby(jProgressBar);
	}
	
	/*
	 * Draw the division symbols
	 */
	public void paint(Graphics g){
		super.paint(g);
		// draw the division symbol
		int a = 150; // right
		int b = 38; // down
		g.drawLine(a, b, 285, b);
		g.drawLine(a, b, a, 65);
		// subtraction bars
		a = 165; // right
		b = 114;  // down
		int c = 60;  // length
		g.drawLine(a, b, a+c, b);
		// repeat subtraction bars
		for(int i=0; i<6; i++){
			a += 15;
			b += 45;
			g.drawLine(a, b, a+c, b);
		}
	}
	
	/*
	 * Create the Action Event logic
	 */
	public void actionPerformed(ActionEvent ae){
		// Solve Button
		if(ae.getSource() == jButton){
			// read from the GUI
			String[][] stringMatrix = parseMatrix();
			String[] overallExpression = parseExpression();
			if(stringMatrix!=null & overallExpression!=null){
				// if there are no problems with the input, start the solver
				// first set the WordCubby to show 2% of the progress
	    		wordCubby.set(2);
    			wordThread = new WordThread(wordCubby, jLabel1, stringMatrix, overallExpression);
    			wordThread.start();
	    	}
		} else if(ae.getSource() == jButton1){
			// Clear button
			// set the WordCubby to stopped to stop the Thread operation
			wordCubby.setStopped();
			wordCubby.set(0);
			// clear the GUI fields
			clear();
		}
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(getJTextField2(), null);
			jContentPane.add(getJTextField3(), null);
			jContentPane.add(getJTextField4(), null);
			jContentPane.add(getJTextField5(), null);
			jContentPane.add(getJTextField6(), null);
			jContentPane.add(getJTextField7(), null);
			jContentPane.add(getJTextField8(), null);
			jContentPane.add(getJTextField9(), null);
			jContentPane.add(getJTextField10(), null);
			jContentPane.add(getJTextField11(), null);
			jContentPane.add(getJTextField12(), null);
			jContentPane.add(getJTextField13(), null);
			jContentPane.add(getJTextField14(), null);
			jContentPane.add(getJTextField15(), null);
			jContentPane.add(getJTextField16(), null);
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getJTextField17(), null);
			jContentPane.add(getJButton1(), null);
		}
		return jContentPane;
	}

	/*
	 * parseMatrix takes the linear expressions from the GUI
	 */
	private String[][] parseMatrix(){
		int N = 0;
		// read the division Text Fields
		JTextField[] fields = getFields();
		for(int i=4; i<17; i+=2){
			if(fields[i].getText().equals("")){
				break;
			} else {
				N++;
			}
		}
		// If no fields are read, error and return
		if(N == 0) {
    		JOptionPane.showMessageDialog(null, "You must enter the proper number of Word Expressions", "Invalid Format", JOptionPane.ERROR_MESSAGE);
    		return null;
		}
		// create the result matrix and parse through the entries
		String[][] result = new String[N][3];
		String temp;
		for(int i=0; i<N; i++){
			// in division A - B = C and then you add a digit to C
			// and restart with C(+ a digit) - D = E
			// parse A and B
			result[i][0] = fields[2*i+3].getText();
			result[i][1] = fields[2*i+4].getText();
			// parse C
			temp = fields[2*i+5].getText().trim();
			// if C is not the last entry, then use all but one digit of C
			if(i!=(N-1)) {
				result[i][2] = temp.substring(0, temp.length()-1);
			} else result[i][2] = temp; // if C is the last entry (remainder)
			// ensure that only alphabetic characters are used
			if(!Pattern.matches("[A-Za-z]*", result[i][0]) | 
			    !Pattern.matches("[A-Za-z]*", result[i][1]) | 
			    !Pattern.matches("[A-Za-z]*", result[i][2])){
	    		JOptionPane.showMessageDialog(null, result[i][0] + ", " + result[i][1] + ", or " + result[i][2] + " contain illegal characters", "Invalid Format", JOptionPane.ERROR_MESSAGE);
	    		return null;
			}
		}
		return(result);
	}
	
	/*
	 * parseExpression reads the A / B = C + R statement 
	 */
	private String[] parseExpression(){
		int N = 0;
		// read in the TextFields
		JTextField[] fields = getFields();
		for(int i=4; i<17; i+=2){
			if(fields[i].getText().equals("")){
				break;
			} else {
				N++;
			}
		}
		// if the parsing fails, error and return
		if(N == 0) {
    		JOptionPane.showMessageDialog(null, "You must enter the Word Expression", "Invalid Format", JOptionPane.ERROR_MESSAGE);
    		return null;
		}
		// put the result into an array
		String[] result = new String[4];
		result[0] = fields[0].getText();
		result[1] = fields[1].getText();
		result[2] = fields[2].getText();
		result[3] = fields[2*N+3].getText();
		// ensure that only alphabetic characters are used
		if(!Pattern.matches("[A-Za-z]*", result[0]) | 
			    !Pattern.matches("[A-Za-z]*", result[1]) | 
			    !Pattern.matches("[A-Za-z]*", result[2]) | 
			    !Pattern.matches("[A-za-z]*", result[3])){
	    		JOptionPane.showMessageDialog(null, result[0] + ", " + result[1] + ", " + result[2] + ", or " + result[3] + " contain illegal characters", "Invalid Format", JOptionPane.ERROR_MESSAGE);
	    		return null;
			}
		return(result);
	}

	/*
	 * Clear the Text fields
	 */
	private void clear(){
		// clear the fields
		JTextField[] fields = getFields();
		for(int i=0; i<fields.length; i++){
			fields[i].setText("");
		}
		// set the progress bar to 0%
		jProgressBar.setValue(0);
		// reset the status label
		jLabel1.setText("Solution...");
	}
	
	/*
	 * create a Textfield array for use in the parsers
	 */
	private JTextField[] getFields(){
		JTextField[] fields = {jTextField, jTextField1, jTextField2, jTextField17, 
				   jTextField3, jTextField4, jTextField5, 
				   jTextField6, jTextField7, jTextField8, 
				   jTextField9, jTextField10, jTextField11, 
				   jTextField12, jTextField13, jTextField14, 
				   jTextField15, jTextField16};
		return fields;
	}

	/**
	 * Solves Word Division expressions found in many game magazines.
	 * @param stringMatrix  Matrix of the linear arguements used in solving 
	 * division problems such as {{A B C},{D E F}} in A - B = C, D - E = F where D is C with an additional ones digit
	 * @param overallExpression String Array containing {A B C R} in A / B = C + R
	 * @return String with the word solution
	 * @throws IllegalArgumentException("Not All Letters Included") when less than 10 letters are input
	 */
	public static String solveWordExpression(String[][] stringMatrix, String[] overallExpression){
		boolean bDone = false;
		int[] valueVector, test;
		int[] best = new int[stringMatrix.length + 1];
		double percentDone;
		double k = 9.0;
		String[] letters;
		StringBuffer result;
		HashMap<String, Integer> h = new HashMap<String, Integer>(10);
		PermutationGenerator perm = new PermutationGenerator(10);
		BigInteger total = perm.getTotal();
		
		// set up the hashmap of letters in the expression
		// the word games have a total of 10 letters, one for each digit
		h = WordDivisionUtils.createHashMap(stringMatrix, overallExpression);
		if(h.size()!=10) throw new IllegalArgumentException("Not All Letters Included");
		// create a String array of the letters
		letters = WordDivisionUtils.getAllLetters(h.keySet());
		// iterate through a new permutation of mapping from letters to numbers
		// while there are more permutations and while the Thread is still running
		// This is a brute force method
		while(perm.hasMore() && wordCubby.isRunning()){
			// get the next permutation in order
			test = perm.getNext();
			// update the hash map with the new numbers
			h = WordDivisionUtils.updateMap(h, letters, test);
			// Turn the words into a set of values
			valueVector = WordDivisionUtils.createVector(h, stringMatrix, overallExpression);
			// if the valueVector is an array of zeros, then the answer is found
			if(Arrays.equals(valueVector, best)){
				bDone = true;
				break;
			}
			// update the progress bar each 10%
			percentDone = perm.getNumLeft().doubleValue() / total.doubleValue();
			if(percentDone < k*0.1){
				int p = (int) Math.round((1.0 - k*0.1)*100.0);
				wordCubby.set(p);
				k--;
			}
		}
		// if the while statement exits before an answer is found...
		if(!bDone) return("No Solution");
		// create the final answer from the hash map
		result = WordDivisionUtils.hashToWord(h, letters);
		return(result.toString());
	}
}
