package testTest;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test {
	public void test() {
		Test myUnit = new Test();
		Solution t = new Solution();
		assertEquals(t.getSum(1, 2), 3);
	}
}
