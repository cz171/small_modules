
public class ArrayLocation {
	private double[] coords;
	public ArrayLocation(double[]  coords){
		this.coords = coords;
	}
	
	private static String parity(String msg) {
		String parityStr = null;
		int n = msg.hashCode();
		System.out.println("the hashCode of " +  msg + " is " + n);
		switch(n % 2) {
		case 0:
			parityStr = "even";
			break;
		case 1: 
			parityStr = "odd";
			break;
		}
		return parityStr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test
		System.out.println(parity("a"));
		System.out.println(parity("b"));
		System.out.println(parity("aa"));
		System.out.println(parity("bb"));
		System.out.println(parity("ab"));
		System.out.println(parity("ba"));
		System.out.println(parity("aaa"));
		System.out.println(parity("a a"));
		System.out.println(parity("a%a"));
		System.out.println(parity("a_a"));
		System.out.println(parity("a$a"));
	}

}
