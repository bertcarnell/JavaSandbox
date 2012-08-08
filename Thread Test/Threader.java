
public class Threader extends Thread{
	private int number;
	private CubbyHole communicatorVar;
	
	public Threader(CubbyHole c, int n){
		super("Threader");
		number = n;
		communicatorVar = c;
	}
  
	public void run() {
		System.out.print("In a thread ");
		ThreadTest.loop(number);
		communicatorVar.add(number);
	}
}
