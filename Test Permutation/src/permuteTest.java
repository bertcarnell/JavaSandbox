import java.util.Arrays;
//import java.util.concurrent.atomic.AtomicIntegerArray;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class permuteTest implements ActionListener{

	/**
	 * @param args
	 */
    JFrame solverFrame;
    JPanel solverPanel;
    JTextField num1, num2, num3, num4, num5, textTarget;
    JLabel num1Label, num2Label, num3Label, num4Label, num5Label, answerLabel, targetLabel;
    JButton solve, reset;
    JSeparator sep1, sep2;
    JCheckBox parenCheck, negCheck;
	
	public static int ind = 0;
	
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        permuteTest dummy = new permuteTest();
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(
        	new Runnable() {
        		public void run() {
        			createAndShowGUI();
        		}
        	}
        );
    }
	
	
	
    public permuteTest() {
        //Create and set up the window.
        solverFrame = new JFrame("Solve a Krypto Expression");
        solverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        solverFrame.setSize(new Dimension(1200, 1200));

        //Create and set up the panel.
        solverPanel = new JPanel(new GridBagLayout());

        //Add the widgets.
        addWidgets();

        //Set the default button.
        solverFrame.getRootPane().setDefaultButton(solve);

        //Add the panel to the window.
        solverFrame.getContentPane().add(solverPanel, BorderLayout.CENTER);

        //Display the window.
        solverFrame.pack();
        solverFrame.setVisible(true);
    }

    /**
     * Create and add the widgets.
     */
    private void addWidgets() {
        //Create widgets.
    	num1 = new JTextField(2);
    	num1.setHorizontalAlignment(SwingConstants.CENTER);
    	num2 = new JTextField(2);
    	num2.setHorizontalAlignment(SwingConstants.CENTER);
    	num3 = new JTextField(2);
    	num3.setHorizontalAlignment(SwingConstants.CENTER);
    	num4 = new JTextField(2);
    	num4.setHorizontalAlignment(SwingConstants.CENTER);
    	num5 = new JTextField(2);
    	num5.setHorizontalAlignment(SwingConstants.CENTER);
    	sep1 = new JSeparator();
       	targetLabel = new JLabel(" = ", SwingConstants.CENTER);
    	textTarget = new JTextField(2);
    	textTarget.setHorizontalAlignment(SwingConstants.CENTER);
    	sep2 = new JSeparator();
     	num1Label = new JLabel("A", SwingConstants.CENTER);
    	num2Label = new JLabel("B", SwingConstants.CENTER);
    	num3Label = new JLabel("C", SwingConstants.CENTER);
    	num4Label = new JLabel("D", SwingConstants.CENTER);
    	num5Label = new JLabel("E", SwingConstants.CENTER);
    	solve = new JButton("Solve");
    	reset = new JButton("Reset");
    	answerLabel = new JLabel("Answer...", SwingConstants.CENTER);
    	parenCheck = new JCheckBox("Show answer with parentheses", true);
    	negCheck = new JCheckBox("Ensure intermediate steps are positive valued", true);
    	
        //Listen to events from the Convert button.
        solve.addActionListener(this);
        reset.addActionListener(this);
        
        //Add item listeners to the checkboxes
        //parenCheck.addItemListener(this);
        //negCheck.addItemListener(this);

        //Add the widgets to the container.
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        c = posit(c, 1, 1, 1);
        solverPanel.add(num1, c);
        c = posit(c, 1, 1, 1);
        solverPanel.add(num2, c);
        c = posit(c, 1, 1, 1);
        solverPanel.add(num3, c);
        c = posit(c, 1, 1, 1);
        solverPanel.add(num4, c);
        c = posit(c, 1, 1, 1);
        solverPanel.add(num5, c);
        c = posit(c, 1, 1, 1);
        solverPanel.add(targetLabel, c);
        c = posit(c, 1, 1, GridBagConstraints.REMAINDER);
        solverPanel.add(textTarget, c);
        
        c = posit(c, 1, 1, 1);
        solverPanel.add(num1Label, c);
        c = posit(c, 1, 1, 1);
        solverPanel.add(num2Label, c);
        c = posit(c, 1, 1, 1);
        solverPanel.add(num3Label, c);
        c = posit(c, 1, 1, 1);
        solverPanel.add(num4Label, c);
        c = posit(c, 1, 1, 1);
        solverPanel.add(num5Label, c);
        c = posit(c, 1, 1, GridBagConstraints.REMAINDER);
        solverPanel.add(sep2, c);

        //c = posit(c, 1, 1, 1);
        //solverPanel.add(sep1, c);

        c = posit(c, 1, 1, GridBagConstraints.REMAINDER);
        solverPanel.add(solve, c);
        c = posit(c, 1, 1, GridBagConstraints.REMAINDER);
        solverPanel.add(answerLabel,c);
        c = posit(c, 1, 1, GridBagConstraints.REMAINDER);
        solverPanel.add(reset, c);
        
        //answerLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        //num1Label.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        
        c = posit(c, 1, 1, GridBagConstraints.REMAINDER);
        solverPanel.add(parenCheck, c);
        c = posit(c, 1, 1, GridBagConstraints.REMAINDER);
        solverPanel.add(negCheck, c);
    }
    
    public GridBagConstraints posit(GridBagConstraints G, int a, int b, int c){
    	G.weightx = a;
    	G.weighty = b;
    	G.gridwidth = c;
    	return(G);
    }

    public void actionPerformed(ActionEvent event) throws NumberFormatException {
    	double[] preNumbers = new double[6];
    	int[] numbers = new int[5];
    	int target = 0;
    	boolean bParenthesisOn = parenCheck.isSelected();
    	boolean bWantPositive = negCheck.isSelected();
    	//System.out.println(event.getSource());
    	//if(event.getSource()==solve) System.out.println("test sat");
    	if(event.getSource()==solve){
	    	try{
	    		preNumbers[0] = Double.parseDouble(num1.getText());
	    		preNumbers[1] = Double.parseDouble(num2.getText());
	    		preNumbers[2] = Double.parseDouble(num3.getText());
	    		preNumbers[3] = Double.parseDouble(num4.getText());
	    		preNumbers[4] = Double.parseDouble(num5.getText());
	    		preNumbers[5] = Double.parseDouble(textTarget.getText());
	    		for(int i=0; i<6; i++){
	    			if(preNumbers[i]!=Math.floor(preNumbers[i])){
	    				throw new NumberFormatException();
	    			} else if(i<5) {
	    				numbers[i] = (int) preNumbers[i];
	    			} else if(i==5) {
	    				target = (int) preNumbers[5];
	    			}
	    		}
	    		
	    		// numbers should be an array of 5, but could be any length up to 6
	    		// at 7, memory overflow
	    		//int[] numbers = {1, 1, 1, 1, 1};
	    		target = (int)Double.parseDouble(textTarget.getText());
	    		//int target = 2;
	        	//bParenthesisOn = parenCheck.
	        	//System.out.println("parenthesis " + parenCheck.isSelected());
	        	//System.out.println("negative " + negCheck.isSelected());
	    		answerLabel.setText(solveKryptic(numbers, target, bParenthesisOn, bWantPositive));
	    		answerLabel.setFont(new Font("Arial", Font.BOLD, 16));
	    	}
	    	catch (NumberFormatException nfe) {
	    		JOptionPane.showMessageDialog(null, "You must enter the values as integers", "Invalid Number Format", JOptionPane.ERROR_MESSAGE);
	    		Arrays.fill(numbers, 0);
	    		target = 0;
	    		num1.setText("");
	    		num2.setText("");
	    		num3.setText("");
	    		num4.setText("");
	    		num5.setText("");
	    		textTarget.setText("");
	    		answerLabel.setText("Answer...");
	    	}
    	} else if(event.getSource()==reset) {
    		Arrays.fill(numbers, 0);
    		target = 0;
    		num1.setText("");
    		num2.setText("");
    		num3.setText("");
    		num4.setText("");
    		num5.setText("");
    		textTarget.setText("");
    		answerLabel.setText("Answer...");
    		parenCheck.setSelected(true);
    		negCheck.setSelected(true);
    	}
    }
    
	
	public static String solveKryptic(int[] numbers, int intTarget, boolean bParenthesisOn, boolean bWantPositive) {
		  //AtomicIntegerArray tempArray = new AtomicIntegerArray(numbers);
		  //int N = tempArray.length();
		  int N = numbers.length;
		  if(N==1) {
			  //System.out.println("There must be at least two numbers to build an expression");
			  return("There must be at least two numbers to build an expression");
		  }
		  int facN = factorial(N);
		  ind = 0;
		  int[] Value = new int[N];
		  int level = -1;
		  int[][] results = new int[facN][N];
		  Arrays.fill(Value, 0);
		  visit(Value, N, 0, level, results);
		  for(int i =0; i < facN; i++){
			  for(int j=0; j<N; j++){
				  results[i][j] = numbers[results[i][j] - 1];
			  }
		  }
		  //for(int i = 0; i < facN; i++){
		  //	  System.out.println(Arrays.toString(results[i]));
		  //}
		  int possibleOperations = (int)Math.pow(4, N-1); // 4^(N-1)
		  int[][] operations = new int[possibleOperations][N-1];
		  operations = allCombo(possibleOperations, N);
		  //for(int i = 0; i < possibleOperations; i++){
		  //	  System.out.println(i + Arrays.toString(operations[i]));
		  //}
		  double[][] combined = new double[facN][possibleOperations];
		  boolean[][] combinedIndicator = new boolean[facN][possibleOperations];
		  //initialize(combinedIndicator, false);
		  //for(int i = 0; i < facN; i++){
		  //	  System.out.println(i + Arrays.toString(combinedIndicator[i]));
		  //}
		  double[][] results2 = new double[facN][N];
		  double tempValue = 0;
		  for(int i = 0; i < facN; i++){
			  for(int j = 0; j < possibleOperations; j++){
				  for(int k = 0; k < (N-1); k++){
					  if(k!=0) {
						  if(operations[j][k]==1){
							  tempValue = results2[i][k] + results[i][k+1];
						  } else if(operations[j][k]==2){
							  tempValue = results2[i][k] - results[i][k+1];
						  } else if(operations[j][k]==3){
							  tempValue = results2[i][k] * results[i][k+1];
						  } else if(operations[j][k]==4 & results[i][k+1]!=0){
							  tempValue = results2[i][k] / results[i][k+1];
						  }
						  //results2[i][k+1] = tempValue;
					  } else {
						  if(operations[j][k]==1){
							  tempValue = results[i][k] + results[i][k+1];
						  } else if(operations[j][k]==2){
							  tempValue = results[i][k] - results[i][k+1];
						  } else if(operations[j][k]==3){
							  tempValue = results[i][k] * results[i][k+1];
						  } else if(operations[j][k]==4 & results[i][k+1]!=0){
							  tempValue = results[i][k] / results[i][k+1];
						  }
						  //results2[i][k+1] = tempValue;
					  }
					  results2[i][k+1] = tempValue;
					  if(tempValue<0) combinedIndicator[i][j] = (combinedIndicator[i][j] | true);
				  }
				  combined[i][j] = tempValue;
			  }
		  }
		  //for(int i = 0; i < 3; i++){
		  //	  System.out.println(i + Arrays.toString(combined[i]));
		  //}
		  double target = (double)intTarget;
		  int[] finalOrder = new int[N];
		  int[] finalOperations = new int[N-1];
		  boolean bDone = false;
		  boolean bDoneWithNeg = false;
		  //boolean bWantPositive = false;
		  for(int i = 0; i < facN; i++){
			  for(int j = 0; j < possibleOperations; j++){
				  if(combined[i][j]==target) {
					  finalOrder = results[i];
					  finalOperations = operations[j];
					  if(bWantPositive & combinedIndicator[i][j]) bDoneWithNeg = (bDoneWithNeg | true);
					  if((bWantPositive & !combinedIndicator[i][j]) | !bWantPositive) bDone = true;
				  }
				  if(bDone) break;
			  }
			  if(bDone) break;
		  }
		  if(bDone){
			  return(printResult(finalOrder, finalOperations, target, bParenthesisOn));
		  } else if(bDoneWithNeg){
			  return("No answer can be found without a negative intermediate step!");
		  } else {
			  //System.out.println("No answer can be found");
			  return("No answer can be found!");
		  }
		  //System.out.println(Arrays.toString(finalOrder) + Arrays.toString(finalOperations));
	}

	static void visit(int[] Value, int N, int k, int level, int results[][]) {
	  level = level + 1; 
	  Value[k] = level;
	  if (level == N){
	    //System.out.println(Arrays.toString(Value));
	    for(int j = 0; j < N; j++){
	    	results[ind][j] = Value[j];
	    }
		ind = ind + 1;
	  } else {
	    for (int i = 0; i < N; i++)
	      if (Value[i] == 0)
	        visit(Value, N, i, level, results);
	  }
	  level = level-1; 
	  Value[k] = 0;
	}
	
	static int factorial(int p){
		int returnValue = p;
		if(p==1) {
			return(p);
		} else {
			for(int m = 1; m < p; m++){
				returnValue = returnValue*(p-m);
			}
		}
		return(returnValue);
	}
	
	static int[][] allCombo(int possibleOperations, int N){
		int[][] tempMatrix1 = new int[N-1][possibleOperations];
		int sectionLength;
		for(int i=0; i<N-1; i++){ // rows
			sectionLength = (int)Math.pow(4, N-2-i);
			for(int j=0; j<(int)Math.pow(4,i); j++){
				for(int k=0; k<4; k++){
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
	
	static String printResult(int[] finalOrder, int[]finalOperations, double target, boolean bParenthesisOn){
        //AtomicIntegerArray tempArray = new AtomicIntegerArray(finalOrder);
		//int N = tempArray.length();
		int N = finalOrder.length;
		//boolean bParenthesisOn = false;
		String [] charOperations = new String [N-1];
		String [] charParenthesis = new String [5];
		Arrays.fill(charParenthesis, " ");
		StringBuilder charAnswer = new StringBuilder(8*N+6);
		for(int i = 0; i < (N-1); i++){
			if(finalOperations[i] == 1){
				charOperations[i] = " + ";
			} else if(finalOperations[i] == 2){
				charOperations[i] = " - ";
			} else if(finalOperations[i] == 3){
				charOperations[i] = " x ";
			} else if(finalOperations[i] == 4){
				charOperations[i] = " / ";
			}
		}
		// parenthesis support only for N=5
		if(N == 5 & bParenthesisOn){
			for(int i = 0; i<3; i++) {
				if((finalOperations[i]==1 | finalOperations[i]==2) & 
				   (finalOperations[i+1]==3 | finalOperations[i+1]==4)) {
					charParenthesis[i+2] = ")";
					if((finalOperations[0]==1 | finalOperations[0]==2) &&
					   (finalOperations[1]==3 | finalOperations[1]==4) &&
					   (finalOperations[2]==1 | finalOperations[2]==2) &&
					   (finalOperations[3]==3 | finalOperations[3]==4)) {
						charParenthesis[0] = "(";
						charParenthesis[1] = "(";
					} else {
						charParenthesis[1] = "(";
					}
				}
			}
			charAnswer.append(charParenthesis[0]);
			charAnswer.append(charParenthesis[1]);
		}
		for(int i = 0; i<(N-1); i++){
			charAnswer.append(finalOrder[i]);
			if((i==1 | i==2 | i==3) & N==5 & bParenthesisOn) 
				charAnswer.append(charParenthesis[i+1]);
			charAnswer.append(charOperations[i]);
		}
		int target2;
		target2 = (int)target;
		charAnswer.append(finalOrder[N-1] + " = " + target2);
		//System.out.println(charAnswer);
		return(charAnswer.toString());
	}
	
	//static void initialize(boolean[][] A, boolean b) {
		//int Acols = A[1].length;
		//int Arows = A.length / Acols;
		//for(int i = 0; i<Arows; i++){
		//	Arrays.fill(A[i], false);
		//}
		
	//}
}
