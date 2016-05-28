package validAbbre;
import java.util.*;
public class ValidWordAbbr {
HashMap<String, String> map;
    
    public ValidWordAbbr(String[] dictionary) {
    	map = new HashMap<>();
        for (String s: dictionary) {
            String key = getKey(s);
            if (!map.containsKey(key)) {
                map.put(key, s);
            } else {
                if (!map.get(key).equals(s)) {
                    map.put(key, "");
                }   
            }
            
        }
    }

    public boolean isUnique(String word) {
        return !map.containsKey(getKey(word)) ||
                map.get(getKey(word)).equals(word);
    }
    
    private String getKey(String s) {
        if (s.length() <= 2) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0)).append(s.length() - 2).append(s.charAt(s.length() - 1));
        return sb.toString();
    }
}
