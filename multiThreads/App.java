package multiThreads;

import java.util.concurrent.*;

class Runner extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello! " + i);
				
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class App {
	
	public static void main(String[] args) throws InterruptedException {
		Runner t1 = new Runner();
		Runner t2 = new Runner();
		t1.start();
		t2.start();
					
	}

}