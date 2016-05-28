package producerConsumer;

public class Processor {
	public void produce() throws InterruptedException {
		synchronized(this) {
			System.out.println("Producer thread running ...");
			wait();
			System.out.println("Resume");
		}
	}
	
	public void consume() throws InterruptedException {
		Thread.sleep(2000);
		
		synchronized(this) {
			System.out.println("Consumer thread running ...");
			Thread.sleep(5000);
			System.out.println("Completed");
			notify();
		}
	}
}
