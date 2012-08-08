
public class CubbyHole {
    private int contents;
    private boolean bDone = false;
    private boolean bAvailable = true;
    private int totalContents;
    
    public CubbyHole(int total){
    	totalContents = total;
    }

    public synchronized boolean checkDone() {
        while (!bDone) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        System.out.println("Theads are finished");
        return true;
    }

    public synchronized void add(int who) {
    	while(!bAvailable) {
    		try{
    			wait();
    		} catch(InterruptedException e){}
    	}
    	bAvailable = false;
        contents = contents + who;
        System.out.println("Thread " + who + " added.  Total = " + contents);
    	if(contents >= totalContents) bDone = true;
    	bAvailable = true;
    	notifyAll();
    }
}
