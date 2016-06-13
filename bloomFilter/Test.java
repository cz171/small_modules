package bloomFilter;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bloomfilter<String> bf = new Bloomfilter<>(334, 100);
		
		bf.add("snaps");
		bf.add("happy");
		
		System.out.println(bf.mightContain("snaps"));
		System.out.println(bf.mightContain("happy"));
		System.out.println(bf.mightContain("ds"));


	}

}
