package threadPool;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {
	private int id;
	
	public Processor(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Starting ... " + id);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Completed ... " + id);
		
	}
	
}
public class App {

	public static void main(String[] args) throws InterruptedException {
		// create workers
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		for (int i = 0; i < 5; i++) {
			executor.submit(new Processor(i));
		}
		
		executor.shutdown();
		
		System.out.println("Tasks Sumbitted");
		
		executor.awaitTermination(1, TimeUnit.DAYS);
		
		System.out.println("Tasks Completed");
		

	}

}
