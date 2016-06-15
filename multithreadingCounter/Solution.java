package multithreadingCounter;
import java.util.concurrent.*;

public class Solution {
	//写一个可以被多线程访问的计数器？？每被访问一次count++，check被访问次数的method并不常用
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter t = new Counter();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		
		t1.start();
		t2.start();
	}

}
