package utils;

import javax.swing.JProgressBar;


/**
 * A class which allows the GUI to communicate with the solver Thread in a synchronized manner.
 * @author CARNELLR
 * @version 1.0 Feb 2006
 * 
 */
public class WordCubby {
	private boolean bAvailable = true;
	private JProgressBar jProgressBar;
	private boolean bRunning = false;
	
	/**
	 * Constructor of the WordCubby Class.  Identifies the JProgressBar to be updated with the set method.
	 * @param jpb
	 * @since 1.0
	 */
	public WordCubby(JProgressBar jpb){
		jProgressBar = jpb;
	}
	
	/**
	 * This synchornized method allows the update of the progress bar by only one thread at a time</p>
	 * @param p percentage of permutations already used
	 * @since 1.0
	 */
    public synchronized void set(int p){
    	while(!bAvailable){
    		try{
    			wait();
    		} catch(InterruptedException ie){
    			System.out.println(ie.toString());
    		}
    	}
    	bAvailable = false;
    	jProgressBar.setValue(p);
    	bAvailable = true;
    	notifyAll();
    }
    
    /**
     * Puts the WordCubby in a running state.  Indicates that the solver Thread is running
     * @since 1.0
     */
    public synchronized void setRunning(){
    	bRunning = true;
    }
    
    /**
     * Checks to ensure that the solver Thread has not been manually stopped
     * @return true if the Thread is running
     * @since 1.0
     */
    public synchronized boolean isRunning(){
    	return(bRunning);
    }
    
    /**
     * Puts the WordCubby in a stopped state and subsequently stops the solver Thread
     * @since 1.0
     *
     */
    public synchronized void setStopped(){
    	bRunning = false;
    }
    
 }
