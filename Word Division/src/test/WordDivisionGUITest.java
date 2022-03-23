package test;

import gui.WordDivisionGUI;
import utils.WordCubby;
import javax.swing.JProgressBar;

import junit.framework.TestCase;

public class WordDivisionGUITest extends TestCase {

    /*
     * Test method for 'gui.WordDivisionGUI.solveWordExpression(String[][], String[])'
     */
    public void testSolveWordExpression() {
        WordDivisionGUI w = new WordDivisionGUI();
        //w.init();
        w.wordCubby = new WordCubby(new JProgressBar());
        w.wordCubby.set(2);
        w.wordCubby.setRunning();
        
        // stringMatrix is a representation of the linear equations in the subtration
        // part of long division
        // for example GROW - LION = HANH, HANHL - HGLHR = OGNA
        // overallExpress is a representation of the division expression
        // for example GROWLER / LION = HERA Remainder LOWL
        String[][] stringMatrix = {
                    {"GROW", "LION", "HANH"}, 
                    {"HANHL", "HGLHR", "OGNA"}, 
                    {"OGNAE", "OONAE", "LWWW"}, 
                    {"LWWWR", "ORIWL", "LOWL"}
                    };
        String[] overallExpression = {"GROWLER", "LION", "HERA", "LOWL"};
        assertTrue("wholegrain".equalsIgnoreCase(WordDivisionGUI.solveWordExpression(stringMatrix, overallExpression)));
        String[][] stringMatrix2 = {
                {"BUZZ", "ZTNN", "BZB"}, 
                {"BZBE", "BUIS", "ST"}, 
                {"STS", "IZK", "ZSB"},
                };
        String[] overallExpression2 = {"BUZZES", "BIT", "TAB", "ZSB"};
        assertTrue("uzbekistan".equalsIgnoreCase(WordDivisionGUI.solveWordExpression(stringMatrix2, overallExpression2)));
    }

}
