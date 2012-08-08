
public class ThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		System.out.println(now);
		loop(1);
		loop(2);
		long then = System.currentTimeMillis();
		System.out.println(then);
		double diff = ((double)then - (double) now)/1000.0;
		System.out.println(diff + " seconds");

		System.out.println("\nStarting Threaded Processes");
		System.out.println("\nThis process has little speed improvement");
		now = System.currentTimeMillis();
		System.out.println(now);
		Threader2 E = new Threader2(3);
		Threader2 F = new Threader2(4);
		E.start();
		F.start();
		while(true){
			// wait for threads to finish
			if(!E.isAlive() && !F.isAlive()) break;
		}
		then = System.currentTimeMillis();
		System.out.println(then);
		diff = ((double)then - (double) now)/1000.0;
		System.out.println(diff + " seconds");
		
		System.out.println("\nStarting Threaded Processes 2");
		System.out.println("\nThis process has great speed improvement");
		now = System.currentTimeMillis();
		System.out.println(now);
		CubbyHole c = new CubbyHole(11);
		Threader A = new Threader(c, 5);
		Threader B = new Threader(c, 6);
		ThreadEnd D = new ThreadEnd(c, now);
		A.start();
		B.start();
		D.start();
	}
	
	public static void loop(int number){
		System.out.println("Loop " + number + " Started");
		int temp=0;
		for(int i=0; i<1E7; i++){
			for(int j=0; j<1000; j++){
				temp = temp + j;
			}
		}
		System.out.println("Loop " + number + " Ended");
	}	
}

