
public class ThreadEnd extends Thread{
	private long Now;
	private CubbyHole communicatorVar;
	
	public ThreadEnd(CubbyHole c, long now){
		super("ThreadEnd");
		Now = now;
		communicatorVar = c;
	}
	
	public void run(){
		long then;
		double diff;
		boolean bTest = false;
		bTest = communicatorVar.checkDone();
		if(bTest){
			then = System.currentTimeMillis();
			System.out.println(then);
			diff = ((double)then - (double) Now)/1000.0;
			System.out.println(diff + " seconds");
		}
	}
}
