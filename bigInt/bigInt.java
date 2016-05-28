package bigInt;

public class bigInt {
	public String number;
	
	public bigInt(String number) {
		this.number = number;
	}
	
	public String add(String toAdd) {
		int i = number.length() - 1;
		int j = toAdd.length() - 1;
		int carry = 0;
		
		StringBuilder sb = new StringBuilder();
		while (i >= 0 && j >= 0) {
			int sum = number.charAt(i--) - '0' + (toAdd.charAt(j--) - '0') + carry;
			carry = sum / 10;
			sb.append(sum % 10);
		}
		
		while (i >= 0) {
			int sum = number.charAt(i--) - '0' + carry;
			carry = sum / 10;
			sb.append(sum % 10);
		}
		
		while (j >= 0) {
			int sum = number.charAt(j--) - '0' + carry;
			carry = sum / 10;
			sb.append(sum % 10);
		}
		
		if (carry == 1) {
			sb.append(carry);
		}
		
		return sb.reverse().toString();
	}
//	public String add(String toAdd) {
//		int i = number.length() - 1;
//		int j = toAdd.length() - 1;
//		int carrier = 0;
//		
//		StringBuilder sb = new StringBuilder();
//		
//		while (i >= 0 && j >= 0) {
//			int sum = number.charAt(i--) - '0' + (toAdd.charAt(j--) - '0') + carrier;
//			carrier = sum / 10;
//			sb.append(sum % 10);
//		}
//		
//		while (i >= 0) {
//			int sum = number.charAt(i--) - '0' + carrier;
//			carrier = sum / 10;
//			sb.append(sum % 10);
//		}
//		
//		while (j >= 0) {
//			int sum = number.charAt(j--) - '0' + carrier;
//			carrier = sum / 10;
//			sb.append(sum % 10);
//		}
//		
//		if (carrier != 0) {
//			sb.append(1);
//		}
//		
//		return sb.reverse().toString();
//	
//	}
//	
	public boolean isMore(String toMinus) {
		if (number.length() > toMinus.length()) {
			return true;
		} 
		
		if (number.length() < toMinus.length()) {
			return false;
		}
		
		int len = number.length();
		for (int i = 0; i < len; i++) {
			if (number.charAt(i) - '0' > toMinus.charAt(i) - '0') {
				return true;
			} 
			
			if (number.charAt(i) - '0' < toMinus.charAt(i) - '0') {
				return false;
			}
		}
		
		return true;
	}
	
	public String minus(String toMinus) {
		int i = number.length() - 1;
		int j = toMinus.length() - 1;
		int carrier = 0;
		StringBuilder sb = new StringBuilder();
		
		while (i >= 0 && j >= 0) {
			int sum = number.charAt(i--) - '0' - (toMinus.charAt(j--) - '0') + carrier;
			if (sum < 0) {
				carrier = -1;
			}			
			sb.append(Math.abs(sum));
		}
		
		while (i >= 0) {
			int sum = number.charAt(i--) - '0' + carrier;
			if (sum < 0) {
				carrier = -1;
			}
			
			sb.append(Math.abs(sum));
		}
		
		String result = sb.reverse().toString();
		int index = 0;
		while (index < result.length()) {
			if (result.charAt(index) == '0') {
				index++;
			} else {
				break;
			}
		}
		
		result = result.substring(index, result.length());
		return result.isEmpty() ? "0" : result;
	}
	
	public String multiply(String toMul) {
		int i = number.length();
		int j = toMul.length();
		int[] result = new int[i + j];
		
		for (i = number.length() - 1; i >= 0; i--) {
			for (j = toMul.length() - 1; j >= 0; j--) {
				int mul = (number.charAt(i) - '0') * (toMul.charAt(j) - '0') + result[i + j + 1];
				result[i + j + 1] = mul % 10;
				result[i + j] += mul / 10;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < result.length; k++) {
			if (sb.length() == 0 && result[k] == 0) {
				continue;
			}
			
			sb.append(result[k]);
		}
		
		return sb.length() == 0 ? "0" : sb.toString();
	}
}
