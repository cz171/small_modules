package simplyPath;

import java.util.Arrays;

public class Sokution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = "/a/./b/../../c/".split("/");
		System.out.println(Arrays.toString(strs));
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 1; i--) {
            if (strs[i].isEmpty() || strs[i].equals(".")) {
                continue;
            }
            
            if (strs[i].equals("..")) {
                cnt++;
                continue;
            }
            
            if (cnt == 0) {
                sb.insert(0, "/" + strs[i]);
            } else {
            	cnt--;
            }
        }
         
		System.out.println(sb.toString());
	}

}
