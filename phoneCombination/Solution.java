package phoneCombination;
import java.util.*;
public class Solution {
	public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        
        String[] mapping = {"", "" ,"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(res, mapping, "", digits, 0);
        return res;
    }
    
    public static void dfs(List<String> res, String[] mapping, String path, String digits, int pos) {
        if (pos == digits.length()) {
            res.add(path);
            System.out.println(path);
            return;
        }
        
        for (char c: mapping[digits.charAt(pos) - '0'].toCharArray()) {
            path += String.valueOf(c);
            dfs(res, mapping, path, digits, pos + 1);
            path = path.substring(0, path.length() - 1);
        }
    }
    
	public static void main(String[] args) {
		letterCombinations("22");
	}

}
