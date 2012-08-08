package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import utils.calculateKrypto;


import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.Arrays;

public class showKrypto {

	private JFrame jFrame = null;
	private JPanel jContentPane = null;
	private JTextField textNum5 = null;
	private JTextField textNum4 = null;
	private JTextField textNum3 = null;
	private JTextField textNum2 = null;
	private JTextField textTarget = null;
	private JPanel jPanel = null;
	private JTextField textNum1 = null;
	private JPanel jPanel1 = null;
	private JCheckBox parenCheck = null;
	private JCheckBox negCheck = null;
	private JButton solve = null;
	private JButton reset = null;
	private JLabel jLabel = null;
	private JLabel answerLabel = null;
	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	public JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setSize(new java.awt.Dimension(396,373));
			jFrame.setTitle("Krypto Solver");
			jFrame.setPreferredSize(new java.awt.Dimension(400,400));
			jFrame.setContentPane(getJContentPane());
		}
		return jFrame;
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
			jContentPane.setLayout(null);
			jContentPane.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 18));
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getJPanel1(), null);
			jContentPane.add(getSolve(), null);
			jContentPane.add(getReset(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTextNum5() {
		if (textNum5 == null) {
			textNum5 = new JTextField();
			textNum5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			textNum5.setBounds(new java.awt.Rectangle(195,30,31,31));
			textNum5.setColumns(2);
		}
		return textNum5;
	}

	/**
	 * This method initializes jTextField2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTextNum4() {
		if (textNum4 == null) {
			textNum4 = new JTextField();
			textNum4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			textNum4.setBounds(new java.awt.Rectangle(150,30,31,31));
			textNum4.setColumns(2);
		}
		return textNum4;
	}

	/**
	 * This method initializes jTextField3	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTextNum3() {
		if (textNum3 == null) {
			textNum3 = new JTextField();
			textNum3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			textNum3.setBounds(new java.awt.Rectangle(105,30,31,31));
			textNum3.setColumns(2);
		}
		return textNum3;
	}

	/**
	 * This method initializes jTextField4	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTextNum2() {
		if (textNum2 == null) {
			textNum2 = new JTextField();
			textNum2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			textNum2.setBounds(new java.awt.Rectangle(60,30,31,31));
			textNum2.setColumns(2);
		}
		return textNum2;
	}

	/**
	 * This method initializes jTextField6	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTextTarget() {
		if (textTarget == null) {
			textTarget = new JTextField();
			textTarget.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			textTarget.setBounds(new java.awt.Rectangle(285,30,31,31));
			textTarget.setColumns(2);
		}
		return textTarget;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new java.awt.Rectangle(240,30,38,31));
			jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			jLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238,238,238),0));
			jLabel.setText("=");
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setBounds(new java.awt.Rectangle(30,15,331,76));
			jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter The Krypto Expression", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
			jPanel.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 18));
			jPanel.add(getTextNum2(), null);
			jPanel.add(getTextNum3(), null);
			jPanel.add(getTextNum4(), null);
			jPanel.add(getTextNum5(), null);
			jPanel.add(getTextTarget(), null);
			jPanel.add(getTextNum1(), null);
			jPanel.add(jLabel, null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTextNum1() {
		if (textNum1 == null) {
			textNum1 = new JTextField();
			textNum1.setBounds(new java.awt.Rectangle(15,30,31,31));
			textNum1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			textNum1.setColumns(2);
		}
		return textNum1;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			answerLabel = new JLabel();
			answerLabel.setBounds(new java.awt.Rectangle(15,30,301,31));
			answerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			answerLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			answerLabel.setText("Answer...");
			answerLabel.setFont(new Font("Arial", Font.BOLD, 14));
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.setBounds(new java.awt.Rectangle(30,150,331,151));
			jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Solution", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jPanel1.add(getParenCheck(), null);
			jPanel1.add(getNegCheck(), null);
			jPanel1.add(answerLabel, null);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jCheckBox	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getParenCheck() {
		if (parenCheck == null) {
			parenCheck = new JCheckBox();
			parenCheck.setBounds(new java.awt.Rectangle(17,91,299,15));
			parenCheck.setSelected(true);
			parenCheck.setText("Show answer with parentheses");
		}
		return parenCheck;
	}

	/**
	 * This method initializes jCheckBox1	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getNegCheck() {
		if (negCheck == null) {
			negCheck = new JCheckBox();
			negCheck.setBounds(new java.awt.Rectangle(17,120,299,16));
			negCheck.setSelected(true);
			negCheck.setText("Ensure intermediate steps are positive valued");
		}
		return negCheck;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSolve() {
		if (solve == null) {
			solve = new JButton();
			solve.setBounds(new java.awt.Rectangle(120,105,151,31));
			solve.setText("Solve");
			solve.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); 
					solveAction(e);
				}
			});
		}
		return solve;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getReset() {
		if (reset == null) {
			reset = new JButton();
			reset.setBounds(new java.awt.Rectangle(270,315,67,16));
			reset.setText("Reset");
			reset.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()");
					solveAction(e);
				}
			});
		}
		return reset;
	}

   private static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        showKrypto dummy = new showKrypto();
    }

   	  // main method for string safe operations
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(
//        	new Runnable() {
//        		public void run() {
//        			createAndShowGUI();
//        		}
//        	}
//        );
//    }

    public static void main(String[] args) {
    	createAndShowGUI();
    }
	
    public showKrypto() {
        //Create and set up the window.
    	JFrame solverFrame;
        solverFrame = getJFrame();
        solverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set the default button.
        solverFrame.getRootPane().setDefaultButton(solve);

        //Display the window.
        solverFrame.pack();
        solverFrame.setVisible(true);
    }
    
    public void solveAction(ActionEvent event) {
    	double[] preNumbers = new double[6];
    	int[] numbers = new int[5];
    	String textResult;
    	int target = 0;
    	boolean bParenthesisOn = parenCheck.isSelected();
    	boolean bWantPositive = negCheck.isSelected();
    	boolean bExceptionThrown = false;
    	
    	// if the solve button is pushed
    	if(event.getSource()==solve){
    		// Double.parseDouble throws a NumberFormatException if the text is not a double
    		// Integer.parseInt was not used since it might force a 1.1 to a 1 without warning
	    	try{
	    		preNumbers[0] = Double.parseDouble(textNum1.getText());
	    		preNumbers[1] = Double.parseDouble(textNum2.getText());
	    		preNumbers[2] = Double.parseDouble(textNum3.getText());
	    		preNumbers[3] = Double.parseDouble(textNum4.getText());
	    		preNumbers[4] = Double.parseDouble(textNum5.getText());
	    		preNumbers[5] = Double.parseDouble(textTarget.getText());
	    	}
	    	catch (NumberFormatException nfe) {
	    		JOptionPane.showMessageDialog(null, "You must enter the values as integers", "Invalid Number Format", JOptionPane.ERROR_MESSAGE);
	    		bExceptionThrown = true;
	    	}
	    	// if there were no problems with parsing the expression
	    	if(!bExceptionThrown) {
	    		for(int i=0; i<6; i++){
	    			// check to make sure all double were also integers
	    			if(preNumbers[i]!=Math.floor(preNumbers[i])){
	    	    		JOptionPane.showMessageDialog(null, "You must enter the values as integers", "Invalid Number Format", JOptionPane.ERROR_MESSAGE);
	    	    		bExceptionThrown = true;
	    			} else if(i<5) { // if the numbers were integers, transfer them to numbers
	    				numbers[i] = (int) preNumbers[i];
	    			} else if(i==5) { // if the target was an integer, transfer it to target
	    				target = (int) preNumbers[5];
	    			}
	    		}
	    		
	    		// numbers should be an array of 5 based on the GUI
	    		// but could be any length from 2 to 6
	    		// at 7 and above, a memory overflow occurs
	    		if(!bExceptionThrown) {
	    			// solve the expression
		    		textResult = calculateKrypto.solveKrypto(numbers, target, bParenthesisOn, bWantPositive);
		    		answerLabel.setText(textResult);
		    		// set the font based on the result
		    		if(textResult=="There must be at least two numbers to build an expression"){
		    			answerLabel.setFont(new Font("Arial", Font.BOLD, 10));
		    		} else if(textResult=="No answer can be found without a negative intermediate step!"){
		    			answerLabel.setFont(new Font("Arial", Font.BOLD, 9));
		    		} else {
			    		answerLabel.setFont(new Font("Arial", Font.BOLD, 16));
		    		}
	    		}
	    	}
	    
	    // if the reset button is pushed
    	} else if(event.getSource()==reset) {
    		Arrays.fill(numbers, 0);
    		Arrays.fill(preNumbers, 0);
    		target = 0;
    		eraser();
    		parenCheck.setSelected(true);
    		negCheck.setSelected(true);
    	}
    }
    
    private void eraser(){
		textNum1.setText("");
		textNum2.setText("");
		textNum3.setText("");
		textNum4.setText("");
		textNum5.setText("");
		textTarget.setText("");
		answerLabel.setText("Answer...");
		answerLabel.setFont(new Font("Arial", Font.BOLD, 14));
    }
}
