
public class Threader2 extends Thread{
	private int number;
	
	public Threader2(int n){
		super("Threader2");
		number = n;
	}
  
	public void run() {
		System.out.print("In a thread ");
		ThreadTest.loop(number);
	}

}
