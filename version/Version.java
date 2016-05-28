package version;

public class Version {
	public boolean check(String v1, String v2) {
		int i = 0;
		while (i < v1.length()) {
			if (!Character.isAlphabetic(v1.charAt(i))) {
				break;
			}
			i++;
		}
		
		int j = 0;
		while (j < v2.length()) {
			if (!Character.isAlphabetic(v2.charAt(j))) {
				break;
			}
			j++;
		}
		
		
		for (int k = 0; k < i && k < j; k++) {
			if (v1.charAt(k) < v2.charAt(k)) {
				return false;
			} else if (v1.charAt(k) > v2.charAt(k)) {
				return true;
			}
		}
		
		String num1 = v1.substring(i);
		String num2 = v2.substring(i);
		
		return Integer.valueOf(num1) > Integer.valueOf(num2);
		
	}
}
