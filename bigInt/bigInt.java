package bigInt;

import java.util.ArrayList;
import java.util.Arrays;

public class bigInt {
	int sign;
	int[] nums;
	public bigInt(String number) {
		sign = 1;
		int i = 0;
		while (i < number.length()) {
			if (number.charAt(i) != ' ') {
				break;
			}
			i++;
		}
		
		if (number.charAt(0) == '-') {
			i++;
			sign = -1;
		}
		
		String numPart = number.substring(i).trim();
		nums = new int[numPart.length()];
		for (int k = 0; k < nums.length; k++) {
			nums[k] = numPart.charAt(k) - '0';
		}
	}
	
	public String add(String toAdd) {
		bigInt adder = new bigInt(toAdd);
		int adderSign = adder.sign;
		int[] adderNums = adder.nums;
		
		if (adderSign == 1 && sign == 1) {
			return addHelper(nums, adderNums);
		}
		
		if (adderSign == -1 && sign == -1) {
			return "-" + addHelper(nums, adderNums);
		}
		
		if (adderSign == -1 && sign == 1) {
			return subHelper(nums, adderNums);
		}
		
		return subHelper(adderNums, nums);
	}
	
	private boolean check(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return true;
		}
		
		if (nums1.length < nums2.length) {
			return false;
		}
		
		for (int i = 0; i < nums1.length; i++) {
			if (nums1[i] < nums2[i]) {
				return false;
			} else if (nums1[i] > nums2[i]) {
				return true;
			}
		}
		
		return true;
	}
	
	public String subHelper(int[] nums1, int[] nums2) {
		if (!check(nums1, nums2)) {
			return "-" + subHelper(nums2, nums1);
		}
		
		StringBuilder sb = new StringBuilder();
		int carry = 0;

		int i = nums1.length - 1;
		int j = nums2.length - 1;
		while (i >= 0 && j >= 0) {
			int sum = nums1[i--] - nums2[j--] + carry;
			if (sum < 0) {
				sum += 10;
				carry = -1;
			} else {
				carry = 0;
			}
			
			sb.append(sum);
		}
		
		while (i >= 0) {
			int sum = nums1[i--] + carry;
			if (sum < 0) {
				sum += 10;
				carry = -1;
			}
			sb.append(sum);
		}
		
		while (j >= 0) {
			int sum = -nums2[j--] + carry;
			if (sum < 0) {
				sum += 10;
				carry = -1;
			}
			sb.append(sum);
		}
		
		int start = sb.length() - 1;
		while (sb.charAt(start) == '0') {
			start--;
		}
		
		//好恶心的代码， 我自己都看不下去了！
		return sb.reverse().toString().substring(sb.length() - start - 1);
	}
	
	
	public String addHelper(int[] nums1, int[] nums2) {
		StringBuilder sb = new StringBuilder();
		int i = nums1.length - 1;
		int j = nums2.length - 1;
		int carry = 0;
		while (j >= 0 && i >= 0) {
			int sum = nums1[i--] + nums2[j--] + carry;
			carry = sum / 10;
			sb.append(sum % 10);
		}
		
		while (i >= 0) {
			int sum = nums1[i--] + carry;
			carry = sum / 10;
			sb.append(sum % 10);
		}
		
		while (j >= 0) {
			int sum = nums2[j--] + carry;
			carry = sum / 10;
			sb.append(sum % 10);
		}
		
		if (carry == 1) {
			sb.append(1);
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
//	public boolean isMore(String toMinus) {
//		if (number.length() > toMinus.length()) {
//			return true;
//		} 
//		
//		if (number.length() < toMinus.length()) {
//			return false;
//		}
//		
//		int len = number.length();
//		for (int i = 0; i < len; i++) {
//			if (number.charAt(i) - '0' > toMinus.charAt(i) - '0') {
//				return true;
//			} 
//			
//			if (number.charAt(i) - '0' < toMinus.charAt(i) - '0') {
//				return false;
//			}
//		}
//		
//		return true;
//	}
//	
//	public String minus(String toMinus) {
//		int i = number.length() - 1;
//		int j = toMinus.length() - 1;
//		int carrier = 0;
//		StringBuilder sb = new StringBuilder();
//		
//		while (i >= 0 && j >= 0) {
//			int sum = number.charAt(i--) - '0' - (toMinus.charAt(j--) - '0') + carrier;
//			if (sum < 0) {
//				carrier = -1;
//			}			
//			sb.append(Math.abs(sum));
//		}
//		
//		while (i >= 0) {
//			int sum = number.charAt(i--) - '0' + carrier;
//			if (sum < 0) {
//				carrier = -1;
//			}
//			
//			sb.append(Math.abs(sum));
//		}
//		
//		String result = sb.reverse().toString();
//		int index = 0;
//		while (index < result.length()) {
//			if (result.charAt(index) == '0') {
//				index++;
//			} else {
//				break;
//			}
//		}
//		
//		result = result.substring(index, result.length());
//		return result.isEmpty() ? "0" : result;
//	}
//	
//	public String multiply(String toMul) {
//		int i = number.length();
//		int j = toMul.length();
//		int[] result = new int[i + j];
//		
//		for (i = number.length() - 1; i >= 0; i--) {
//			for (j = toMul.length() - 1; j >= 0; j--) {
//				int mul = (number.charAt(i) - '0') * (toMul.charAt(j) - '0') + result[i + j + 1];
//				result[i + j + 1] = mul % 10;
//				result[i + j] += mul / 10;
//			}
//		}
//		
//		StringBuilder sb = new StringBuilder();
//		for (int k = 0; k < result.length; k++) {
//			if (sb.length() == 0 && result[k] == 0) {
//				continue;
//			}
//			
//			sb.append(result[k]);
//		}
//		
//		return sb.length() == 0 ? "0" : sb.toString();
//	}
}
