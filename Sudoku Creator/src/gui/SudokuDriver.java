package gui;

import utils.SudokuGrid;
import utils.SudokuOperators;

public class SudokuDriver {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SudokuGrid C = new SudokuGrid(9);
        if(C.isValid()){
            C = SudokuOperators.makeHoles(C,30);
            C.print();
            C = SudokuOperators.solve(C);
            System.out.println();
            C.print();
            System.out.println();
            System.out.println(C.isValid());
        }
    }

}
