//import java.util.Arrays;
//import java.util.HashMap;
//
//public class longestChain {
//	public static int checkLongest(String str, HashMap<String, Integer> map) {
//		if (str == null || str.length() == 0) {
//			return 0;
//		}
//		
//		if (!map.containsKey(str)) {
//			return 0;
//		}
//		
//		if (str.length() == 1) {
//			return 1;
//		}
//		
//		int max = 0;
//		
//		for (int i = 0; i < str.length(); i++) {
//			StringBuilder sb = new StringBuilder();
//			if (i == 0) {
//				sb.append(str.substring(1));
//			} else if (i == str.length() - 1) {
//				sb.append(str.substring(0, str.length()));
//			} else {
//				sb.append(str.substring(0,i)).append(str.substring(i + 1));
//			}
//			
//			System.out.println(sb.toString());
//			max = Math.max(1 + checkLongest(sb.toString(), map), max);
//		}
//		
//		return max;
//	}
//	
//	public static void main(String[] args) {
//		String[] strs = {"a", "b", "ab", "abd", "acd", "abcd"};
//		HashMap<String, Integer> map = new HashMap<String, Integer>();
//		for (String str : strs) {
//			char[] chars = str.toCharArray();
//			Arrays.sort(chars);
//			str = String.valueOf(chars); 
//			map.put(str, 0);
////			System.out.println(str);
//		}
//		
//		int max = 0;
//		
//		for (int i = strs.length - 1; i >= 0; i--) {
//			max = Math.max(max, checkLongest(strs[i], map));
//		}
//		
//
//		System.out.println(max);
//		
//	}
//}


import java.util.*; 
public class LongestChain { 
	  static HashMap<String, Integer> words = new HashMap<>();
	
	  private static  int getLongestChainHelper(Set<String> dict, String word) {
	    if(dict == null || dict.size() == 0){
	      return 0;
	    }
	    
	    if(word.length() == 1){
	      return 1;
	    }
	    
	    if(words.containsKey(word)) { 
	      return words.get(word);
	    }
	    
	    int maxLen = -1;
	    
	    for(int i = 0; i < word.length(); i++) {
	       String newWord = removeCharAt(word, i);
	       if(dict.contains(newWord)) {
	            int longestChainNewWord = getLongestChainHelper(dict, newWord);
	            if(longestChainNewWord + 1 > maxLen) {
	              maxLen = longestChainNewWord + 1;
	            }
	       }
	    }
	    
	    maxLen = maxLen == -1 ? 1 : maxLen;
	    words.put(word, maxLen);
	    
	    return maxLen;
	  }

	  private static int getLongestChain(Set<String> dict) {
	    if(dict == null || dict.size() == 0){
	      return 0;
	    }
	    
	    int longestChain = -1;
	    
	    for (String word : dict) {
	      int currLongest = getLongestChainHelper(dict, word);
	      if (currLongest > longestChain) {
	        longestChain = currLongest;
	      }
	    }
	    
	    return longestChain;
	  }
	  
	  private static String removeCharAt(String str, int index) {
		  StringBuilder sb = new StringBuilder();
		  if (index == 0) {
			  sb.append(str.substring(1));
		  } else if (index == str.length() - 1) {
			  sb.append(str.substring(0, str.length() - 1));
		  } else {
			  sb.append(str.substring(0, index)).append(str.substring(index + 1));
		  }
		  
		  return sb.toString();
	  }
	  
	  
	  public static void main(String[] args) {
		  //test
		  Scanner sc = new Scanner(System.in);
		  
		  int size = sc.nextInt();
		  ArrayList<String> strs = new ArrayList<String>();
		  
		  for (int i = 0; i < size; i++) {
			  strs.add(sc.next());
		  }
		  		  
		  Set<String> dict = new HashSet<String>();
		  int maxLen = -1;
		  
		  for (String str: strs) {
			  dict.add(str);
		  }
		  
		  maxLen = getLongestChain(dict);
		  
		  System.out.println(maxLen);
		  
	  }
	  
}