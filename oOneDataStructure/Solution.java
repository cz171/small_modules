package oOneDataStructure;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastDataStructure<Integer> fds = new FastDataStructure<>();
		fds.add(new Integer(1));
		fds.add(new Integer(2));
		fds.printAllEle();
		System.out.println();
		fds.remove(new Integer(1));
		fds.remove(new Integer(5));
		fds.printAllEle();
	}

}
