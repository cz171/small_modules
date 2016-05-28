package contructTree;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		if (s.constructTree("(x,y), (x,z), (z,w)")) {
			s.inorderPrint(s.root);
		}
	}

}
