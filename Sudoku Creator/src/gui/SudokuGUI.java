package gui;

import javax.swing.JApplet;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.applet.*;
import java.awt.event.*;
import javax.swing.JLabel;

import utils.SudokuGrid;
import utils.SudokuOperators;
import javax.swing.JSlider;


public class SudokuGUI extends Applet implements ActionListener{

	private JApplet jApplet = null;  //  @jve:decl-index=0:visual-constraint="159,64"
	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JPanel jPanel1 = null;
	private JRadioButton jRadioButton = null;
	private JRadioButton jRadioButton1 = null;
	private JRadioButton jRadioButton2 = null;
	private JRadioButton jRadioButton3 = null;
	private JPanel jPanel2 = null;
	private JTextField[][] digits;
	private int M;
	SudokuGrid grid;
	private JLabel messageBox = null;
	private JSlider jSlider = null;

	/**
	 * This method initializes jApplet	
	 * 	
	 * @return javax.swing.JApplet	
	 */
	private JApplet getJApplet() {
		if (jApplet == null) {
			jApplet = new JApplet();
			jApplet.setSize(new java.awt.Dimension(219,142));
			jApplet.setContentPane(getJContentPane());
		}
		return jApplet;
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.SystemColor.windowBorder,1));
			jContentPane.add(getJPanel(), java.awt.BorderLayout.NORTH);
			jContentPane.add(getJPanel1(), java.awt.BorderLayout.SOUTH);
			jContentPane.add(getJPanel2(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.add(getJButton(), null);
			jPanel.add(getJButton1(), null);
			jPanel.add(getJButton2(), null);
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
			jButton.setText("Clear");
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Create");
		}
		return jButton1;
	}

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Solve");
		}
		return jButton2;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			messageBox = new JLabel();
			messageBox.setText("Ready...");
			messageBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jPanel1 = new JPanel();
			jPanel1.add(messageBox, null);
			jPanel1.add(getJRadioButton(), null);
			jPanel1.add(getJRadioButton1(), null);
			jPanel1.add(getJRadioButton2(), null);
			jPanel1.add(getJRadioButton3(), null);
			jPanel1.add(getJSlider(), null);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton() {
		if (jRadioButton == null) {
			jRadioButton = new JRadioButton();
			jRadioButton.setText("4");
		}
		return jRadioButton;
	}

	/**
	 * This method initializes jRadioButton1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			jRadioButton1.setText("9");
		}
		return jRadioButton1;
	}

	/**
	 * This method initializes jRadioButton2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton2() {
		if (jRadioButton2 == null) {
			jRadioButton2 = new JRadioButton();
			jRadioButton2.setText("16");
		}
		return jRadioButton2;
	}

	/**
	 * This method initializes jRadioButton3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton3() {
		if (jRadioButton3 == null) {
			jRadioButton3 = new JRadioButton();
			jRadioButton3.setText("25");
		}
		return jRadioButton3;
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
		}
		return jPanel2;
	}

	public void init(){
		add(getJApplet());
		jButton.addActionListener(this);
		jButton1.addActionListener(this);
		jButton2.addActionListener(this);
		jRadioButton.addActionListener(this);
		jRadioButton1.addActionListener(this);
		jRadioButton2.addActionListener(this);
		jRadioButton3.addActionListener(this);
		jRadioButton1.setSelected(true);
		M = 9;
		setGridSize();
	}
	
    public void actionPerformed(ActionEvent ae) {
    	double numberOfHoles;
    	if(ae.getSource()==jButton){
    		//System.out.println("Clear");
    		clear();
    	} else if(ae.getSource()==jButton1){
    		//System.out.println("Create");
    		grid = new SudokuGrid(M);
    		numberOfHoles = (double) jSlider.getValue()/100.0*M*M;
    		grid = SudokuOperators.makeHoles(grid, (int) numberOfHoles);
    		fillGrid(grid.sudokuGrid);
    	} else if(ae.getSource()==jButton2){
    		//System.out.println("Solve");
    		grid = new SudokuGrid(M);
    		grid.sudokuGrid = readGrid();
    		if(grid.isConsistent()) {
    			//System.out.println("Consistent");
    			messageBox.setText("Solving...");
    			jContentPane.setCursor(new Cursor(Cursor.WAIT_CURSOR));
    			SudokuOperators.solve(grid);
	    		if(grid.isValid()) {
	    			fillGrid(grid.sudokuGrid);
	    			messageBox.setText("Solved.");
	    			jContentPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	    		} else {
	    			messageBox.setText("No Valid Sudoku Found");
	    			jContentPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	    		}
    		} else {
    			messageBox.setText("Input Grid is not Consistent");
    		}
    	} else if(ae.getSource()==jRadioButton){
    		//System.out.println("4");
    		nullButtons(0);
    		M = 4;
    		setGridSize();
    	} else if(ae.getSource()==jRadioButton1){
    		//System.out.println("9");
    		nullButtons(1);
    		M = 9;
    		setGridSize();
    	} else if(ae.getSource()==jRadioButton2){
    		//System.out.println("16");
    		nullButtons(2);
    		M = 16;
    		setGridSize();
    	} else if(ae.getSource()==jRadioButton3){
    		//System.out.println("25");
    		nullButtons(3);
    		M = 25;
    		setGridSize();
    	} 
    }

    private void nullButtons(int B){
		if(B!=0) jRadioButton.setSelected(false);
		if(B!=1) jRadioButton1.setSelected(false);
		if(B!=2) jRadioButton2.setSelected(false);
		if(B!=3) jRadioButton3.setSelected(false);
    }
    
	private void setGridSize(){
		jPanel2.removeAll();
		jPanel2.validate();
		jPanel2.repaint();
		jPanel2.setLayout(new GridLayout(M,M));
		digits = new JTextField[M][M];
		for(int i=0; i<M; i++){
			for(int j=0; j<M; j++){
				digits[i][j] = new JTextField(2);
				digits[i][j].setHorizontalAlignment(JTextField.CENTER);
				digits[i][j].setBorder(getCustomBorder(i, j, M, Color.black));
				jPanel2.add(digits[i][j]);
			}
		}
		jPanel2.validate();
		jPanel2.repaint();
	}
	
	private void clear(){
		for(int i=0; i<M; i++){
			for(int j=0; j<M; j++){
				digits[i][j].setText("");
			}
		}
		messageBox.setText("Ready...");
	}
	
	private void fillGrid(int[][] A){
		for(int i=0; i<A.length; i++){
			for(int j=0; j<A.length; j++){
				if(A[i][j]!=0){ 
					digits[i][j].setText("" + A[i][j]);
				} else digits[i][j].setText("");
			}
		}
	}
	
	private int[][] readGrid(){
		int[][] A = new int[M][M];
		String temp;
		for(int i=0; i<M; i++){
			for(int j=0; j<M; j++){
				temp = digits[i][j].getText();
				try{
					A[i][j] = (int) Integer.parseInt(temp);
				} catch(NumberFormatException nfe){
					//System.out.println(nfe.toString());
					A[i][j] = 0;
				}
			}
		}
		return A;
	}
	
	private MatteBorder getCustomBorder(int R, int C, int N, Color col){
		int top, left, bot, right, sqrtN;
		sqrtN = (int) Math.sqrt((double) N);
		if(R%sqrtN == 0) top = 2; else top = 1;
		if(C%sqrtN == 0) left = 2; else left = 1;
		if(R%sqrtN == sqrtN-1) bot = 2; else bot = 1;
		if(C%sqrtN == sqrtN-1) right = 2; else right = 1;
		MatteBorder result = new MatteBorder(top, left, bot, right, col);
		return(result);
	}

	/**
	 * This method initializes jSlider	
	 * 	
	 * @return javax.swing.JSlider	
	 */
	private JSlider getJSlider() {
		if (jSlider == null) {
			jSlider = new JSlider();
			jSlider.setToolTipText("\"Percentage of sqaures which are not filled\"");
			jSlider.setMaximum(100);
			jSlider.setValue(50);
			jSlider.setPaintLabels(false);
			jSlider.setSnapToTicks(true);
			jSlider.setMinorTickSpacing(5);
			jSlider.setMajorTickSpacing(10);
			jSlider.setPaintTicks(true);
		}
		return jSlider;
	}


}
