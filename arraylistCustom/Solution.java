package arraylistCustom;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayListCustom<Integer> list = new ArrayListCustom<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		
		list.add(10);
		list.add(11);
		
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		
		System.out.println();
		list.remove(5);
	
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		
		list.set(4,  5);
		
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
	
	

}
