package reEntrantLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	private int cnt = 0;
	private Lock lock  = new ReentrantLock();
	
	private void increment() {
		for (int i = 0;i < 10000; i++) {
			cnt++;
		}
	}
	
	public void firstThread() {
		lock.lock();
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}
	
	public void secondThread() {
		lock.lock();
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}
	
	public void finish() {
		System.out.println("count is " + cnt);
	}
}
