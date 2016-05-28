package ThreadSync;

import java.util.Scanner;
import java.util.concurrent.*;

class Processor extends Thread {
	static volatile boolean isRunning = true;
	
	public void run() {
		
		while (isRunning) {
			System.out.println("Hello");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void shutDown() {
		isRunning = false;
	}
}

public class App { 
	public static void main(String[] args) {
		Processor proc1 = new Processor();
		proc1.start();
		
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		
		proc1.shutDown();
	}
}
