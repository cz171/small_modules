package multithreadingCounter;

public class Counter implements Runnable {
	int counter = 1;
	
	synchronized void increment() {
		System.out.println(Thread.currentThread().getName() + " " + counter);
		counter++;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (counter < 10000) {
			increment();
		}
	}
	
	
	
}
