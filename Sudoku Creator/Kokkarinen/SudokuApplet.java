//package Kokkarinen;

/* Copyright 2005 Ilkka Kokkarinen.
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * @author Ilkka Kokkarinen
 * @version 0.01
 */

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class SudokuApplet extends Applet implements ActionListener {

    private TextField[][] digits;
    private Button start;
    private Button clear;
    private Panel topPanel;
    private Panel digitPanel;

    public void init() {
        setLayout(new BorderLayout());
        topPanel = new Panel();
        start = new Button("Solve");
        clear = new Button("Clear");
        topPanel.add(start);
        topPanel.add(clear);
        start.addActionListener(this);
        clear.addActionListener(this);
        digitPanel = new Panel();
        digitPanel.setLayout(new GridLayout(9,9));
        digits = new TextField[9][9];
        Font f = new Font("Times", Font.BOLD, 12);
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                digits[i][j] = new TextField(2);
                digits[i][j].setFont(f);
                digitPanel.add(digits[i][j]);
            }
        }
        add(topPanel, BorderLayout.NORTH);
        add(digitPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == clear) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    digits[i][j].setText("");
                }
            }
            return;            
        }
        new Thread(new Runnable() {
            public void run() {
                int[][] initBoard = new int[9][9];

                for(int i = 0; i < 9; i++) {
                    for(int j = 0; j < 9; j++) {
                        String s = digits[i][j].getText();
                        if(!s.equals("")) {
                            int v;
                            try {
                                v = Integer.parseInt(s);
                                if(v < 1 || v > 9) return;
                            } catch(NumberFormatException e) {
                                return;
                            }
                            initBoard[i][j] = v;
                        }
                    }
                }

                start.setLabel("Busy");
                Sudoku s = new Sudoku();
                if(s.solve(initBoard)) {
                    for(int i = 0; i < 9; i++) {
                        for(int j = 0; j < 9; j++) {
                            digits[i][j].setText("" + s.board[i][j].value);
                        }
                    }
                }
                start.setLabel("Solve");
            }
        }).start();
    }
}

