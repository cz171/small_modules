package decode;

public class Solution {
	/**
	 * value = boolean | string | array;
	boolean = “true” | “false”;
	array = “[”, elements, “]”;
	elements = [ value, {“, ”, value} ];
	string = “'”, characters, “'”;
	characters = { literal | escaped };
	literal = “a” | “b” | “c” | “d” | “e” | “f” | “g” | “h” |
	“i” | “j” | “k” | “l” | “m” | “n” | “o” | “p” | “q” |
	“r” | “s” | “t” | “u” | “v” | “w” | “x” | “y” | “z” |
	“ ” | “,” | “[”, “]”;
	escaped = “\'” | “\\”;
	 * @param args
	 */
	
	public static void convertBack(String s) {
		String[] text = s.split("=");
		if (text.length != 2) {
			return;
		}
		
		String var = text[0];
		String value = text[1];
		if (value.charAt(0) == '\'' && value.charAt(value.length() - 1) == '\'') {  
			value = value.substring(1, value.length() - 1);
		}
		
		System.out.println(var + " " + value);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		convertBack("$input = 'true'");

	}

}
