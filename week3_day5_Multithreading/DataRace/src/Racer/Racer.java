package Racer;

public class Racer implements Runnable{

	private String name;
	
	public Racer(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			Executor.counter++;
		}
		System.out.println(this.name+" count:"+Executor.counter);
	}
	
}
