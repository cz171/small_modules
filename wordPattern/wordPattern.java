package wordPattern;
import java.util.*;
public class wordPattern {
	public boolean wordPatternMatch(String pattern, String str) {
	    Map<Character, String> map = new HashMap<>();
	    Set<String> set = new HashSet<>();

	    return isMatch(pattern, 0, str, 0, map, set);
	  }

	    boolean isMatch(String pattern, int iPattern, String str, int iStr, Map<Character, String> map, Set<String> set) {
	        if (iPattern == pattern.length() && iStr == str.length()) {
	            return true;
	        }
	        
	        if (iPattern == pattern.length() || iStr == str.length()) {
	            return false;
	        }
	        
	        char c = pattern.charAt(iPattern);
	        if (map.containsKey(c)) {
	            String s = map.get(c);
	            if (!str.startsWith(s, iStr)) {
	                return false;
	            }
	            
	            return isMatch(pattern, iPattern + 1, str, iStr + s.length(), map, set);
	        }
	        
	        //!map.contains(c)
	        
	        for (int i = iStr + 1; i <= str.length(); i++) {
	            String s = str.substring(iStr, i);
	            if (set.contains(s)) {
	                continue;
	            }
	            
	            map.put(c, s);
	            set.add(s);
	            if (isMatch(pattern, iPattern + 1, str, i, map, set)) {
	                return true;
	            }
	            
	            map.remove(c);
	            set.remove(s);
	            
	        }
	        
	        return false;
	    }
}
