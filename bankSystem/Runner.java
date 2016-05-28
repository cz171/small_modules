package bankSystem;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	
	private Account acc1 = new Account();
	private Account acc2 = new Account();

	public void firstThread() {
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			lock1.lock();
			try {
				Account.transfer(acc1, acc2, random.nextInt(100));
			} finally {
				lock1.unlock();
			}
		}
		
	}
	
	public void secondThread() {
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			lock1.lock();
			try {
				Account.transfer(acc2, acc1, random.nextInt(100));
			} finally {
				lock1.unlock();
			}
		}
	}
	
	public void finish() {
		System.out.println("Account 1 balance: " + acc1.getBalance());
		System.out.println("Account 2 balance: " + acc2.getBalance());
		System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()));


		
	}
}
