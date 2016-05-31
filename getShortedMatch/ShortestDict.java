package getShortedMatch;
import java.util.*;

//我有一个输入字符，然后我有一个英文字典，说白了就是字符串数组，然后写一个function返回字典里拥有输入字符串里所有字母(非数字或者空格等符号，就是纯字母)的最短的那个字符串。举个例子：.1point3acres缃�
//输入字符串"SR 456 T"，字符串数组里有"SORT"，而且是最短的，那么就返回它。

//每个String表示成一个int，然后利用AND判断两个String里字符的交集，这样对已每个字典里的词只需要花O(1)的时间
public class ShortestDict {
	private static ArrayList<String> wordList;
	private static ArrayList<Integer> maskList;
	
	public ShortestDict(String[] words) {
		wordList = new ArrayList<>();
		maskList = new ArrayList<>();
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		
		for (String word: words) {
			wordList.add(word);
			maskList.add(getMask(word));
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] dict = {"sort", "skyporte", "apppples"};
		ShortestDict d = new ShortestDict(dict);
		System.out.println(d.getShortest("SR 456 T"));
	}
	
	public static String getShortest(String input) {
		int inputMask = getMask(input);
		for (int i = 0; i < maskList.size(); i++) {
			if (inputMask == (inputMask & maskList.get(i))) { 
				return wordList.get(i);
			}
		}
		
		return "";
	}

	
	private static int getMask(String s) {
		int res = 0;
		s = s.toLowerCase();
		for (char c: s.toCharArray()) {
			if (Character.isLetter(c)) {
				res |= 1 << (c - 'a');
			}
		}
		return res;
	}

}
