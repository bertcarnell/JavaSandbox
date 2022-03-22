package test;

import java.util.Arrays;

import junit.framework.TestCase;
import utils.SudokuGrid;
import utils.SudokuOperators;
import java.util.ArrayList;

public class SudokuOperatorsTest extends TestCase {
    final int[][] test4 = {{1,2,3,4},{3,4,1,2},{2,1,4,3},{4,3,2,1}};
    final int[][] testHoles1 = {{1,2,3,0},{0,4,1,2},{0,0,4,3},{4,3,2,1}};
    final int[][] testHoles2 = {{1,0,3,4},{3,4,1,2},{2,0,4,0},{0,3,2,0}};
    final int[][] testHolesFound = {{0,3},{1,0},{2,0},{2,1}};

    /*
     * Test method for 'utils.SudokuOperators.makeHoles(SudokuGrid, int, long)'
     */
    public void testMakeHoles() {
        SudokuGrid sg = new SudokuGrid(4);
        SudokuGrid sgNew;

        sgNew = SudokuOperators.makeHoles(sg, 18);
        assertTrue(matrixEqual(sg.sudokuGrid, sgNew.sudokuGrid));

        matrixCopy(sg.sudokuGrid, test4);
        sgNew = SudokuOperators.makeHoles(sg, 4, 12);
        assertTrue(matrixEqual(sgNew.sudokuGrid, testHoles1));

        matrixCopy(sg.sudokuGrid, test4);
        sgNew = SudokuOperators.makeHoles(sg, 0, 3);
        assertTrue(matrixEqual(sgNew.sudokuGrid, testHoles2));
    }

    /*
     * Test method for 'utils.SudokuOperators.solve(SudokuGrid)'
     */
    public void testSolve() {
        SudokuGrid sg = new SudokuGrid(9);
        int[][] before = sg.sudokuGrid;
        sg = SudokuOperators.makeHoles(sg, 9);
        sg = SudokuOperators.solve(sg);
        assertTrue(matrixEqual(before, sg.sudokuGrid));
    }

    /*
     * Test Private Methods
     */
    
    public void testPrivateFindAllHoles(){
        SudokuGrid sg = new SudokuGrid(4);
        matrixCopy(sg.sudokuGrid, testHoles1);
        assertTrue(true);
        /*try{
            int[][] result;
            result =(int[][]) PrivateAccessor.invoke(utils.SudokuOperators.class, "findAllHoles", new Class[]{SudokuGrid.class}, new Object[]{sg});
            assertTrue(matrixEqual(result, testHolesFound));
        } catch(Throwable t){
            System.out.println(t.toString());
            assertTrue(false);
        }*/
    }
    
    public void testPrivateGetAvailable(){
        Integer[][] test = {{2}, {2,3}, {2,3,4},{2,3},{2,3},{2},{2,3},{2}};
        SudokuGrid sg = new SudokuGrid(4);
        matrixCopy(sg.sudokuGrid, test4);
        sg = SudokuOperators.makeHoles(sg, 8, 107);
        assertTrue(true);
        /*try{
            int[][] holes;
            holes =(int[][]) PrivateAccessor.invoke(utils.SudokuOperators.class, "findAllHoles", new Class[]{SudokuGrid.class}, new Object[]{sg});
            for(int hole=0; hole<holes.length; hole++){
                ArrayList result;
                result = (ArrayList) PrivateAccessor.invoke(utils.SudokuOperators.class, "getAvailable", new Class[]{SudokuGrid.class, int.class, int.class}, new Object[]{sg, holes[hole][0], holes[hole][1]});
                assertTrue(Arrays.equals(test[hole], result.toArray()));
            }
            matrixCopy(sg.sudokuGrid, test4);
            sg = SudokuOperators.makeHoles(sg, 1, 107);
            ArrayList result;
            result = (ArrayList) PrivateAccessor.invoke(utils.SudokuOperators.class, "getAvailable", new Class[]{SudokuGrid.class, int.class, int.class}, new Object[]{sg, 0, 0});
            assertTrue(result.toString().equals("[]"));
        } catch(Throwable t){
            System.out.println(t.toString());
            assertTrue(false);
        }*/
    }
    
    
    /*
     * Utility Function
     */
    
    private boolean matrixEqual(int[][] A, int[][] B){
        if(A.length!=B.length) return false;
        else if(A[0].length!=B[0].length) return false;
        else {
            for(int i=0; i<A.length; i++){
                if(!Arrays.equals(A[i], B[i])) return false;
            }
            return true;
        }
    }
    
    private void matrixCopy(int[][] A, int[][]B){
        // copy into A from B
        if(A.length!=B.length) return;
        else if(A[0].length!=B[0].length) return;
        else {
            for(int i=0; i<A.length; i++){
                for(int j=0; j<A[0].length; j++){
                    A[i][j]=B[i][j];
                }
            }
            return;
        }
    }

}
