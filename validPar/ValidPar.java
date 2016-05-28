package validPar;
import java.util.*;

public class ValidPar {
	public static boolean isValid(String s) {
		if (s == null) {
			return false;
		}
		
		if (s.length() == 0) {
			return true;
		}
		
		int head = 0, tail = s.length() - 1;
		while (head < tail) {
			char cHead = s.charAt(head);
			char cTail = s.charAt(tail);
			if (!Character.isLetterOrDigit(cHead)) {
				head++;
			} else if (!Character.isLetterOrDigit(cTail)) {
				tail--;
			} else {
				if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
					return false;
				} 
				
				head++;
				tail--;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		//test case
		System.out.println(isValid("ab c 1 1 cba"));
		System.out.println(isValid("ab c* 1 1 cba"));

	}
}
