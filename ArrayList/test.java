package ArrayList;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayListCustom<Integer> arr = new ArrayListCustom<Integer>();
		for (int i = 0; i < 15; i++) {
			arr.add(i);
		}
		
		arr.remove(5);		
		
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

}
