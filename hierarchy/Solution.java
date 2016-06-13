package hierarchy;
import java.util.*;
//第二轮是个亚裔小哥，题目是input一个text file，
//里面是last name, first name, mm/dd/yy, manager's full name这样的格式，
//按照他的要求parse然后按照hierarchy print出来。题目不难，
//但是细节讨论了蛮久，写了一半，最后时间都木有写完。。。
//虽然小哥说没关系，毕竟这题毕竟难（？有咩？我觉得其实不难，是自己时间没掌控好没写完，我的错，哎），但是我觉得没写完还是很糟糕。 

public class Solution {
	static class Person {
		String lastname;
		String firstname;
		String manager;
		public Person(String lastname, String firstname, String manager) {
			this.lastname = lastname;
			this.firstname = firstname;
			this.manager = manager;
		}
	}
	
	public static void printHierarchy(List<Person> employees) {
		Map<String, HashSet<String>> map = new HashMap<>();
		//decide who is the boss
		Set<String> manager = new HashSet<>();
		String boss = "";
		for (Person employee: employees) {
			if (!map.containsKey(employee.manager)) {
				map.put(employee.manager, new HashSet<>());
			}
			
			map.get(employee.manager).add(employee.firstname + " " + employee.lastname);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
