package reversePolish;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ReverseTest {

	static int reversePolish(String[] tokens) {
		Map<String, Op> map = new HashMap<String, Op>();
		  map.put("+", new Plus());
		  map.put("-", new Minus());
		  map.put("*", new Multiply());
		  map.put("/", new Divide());
		  
		  Stack<Integer> stack = new Stack<Integer>();
		  for (String s : tokens) {
			  if (map.containsKey(s)) {
				 int n1 = stack.pop();
				 int n2 = stack.pop();
				 stack.push(map.get(s).compute(n1, n2));
			  } else {
				  stack.push(Integer.valueOf(s));
			  }
		  }
		  
		  if (stack.isEmpty()) {
			  return -1;
		  }
		  
		  return stack.pop();
	}
	//reference 
	//http://stackoverflow.com/questions/4832933/performing-math-operation-when-operator-is-stored-in-a-string
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  
		  
		  
		  
	}

}
