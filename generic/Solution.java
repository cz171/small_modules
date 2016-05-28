package generic;

import java.util.Arrays;

public class Solution<E> {
	private E e;
	public static <E> void swap(E[] arrays, int i, int j) {
		E tmp = arrays[i];
		arrays[i] = arrays[j];
		arrays[j] = tmp;
	}
	
	public E get() {
		return this.e;
	}
	
	public static void main(String[] args) {
		String[] strs = {"aaa", "BBB", "ccc"};
		swap(strs, 0, 2);
		System.out.println(Arrays.toString(strs));
	}
}
