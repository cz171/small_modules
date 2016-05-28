package person;
import java.util.*;
public class Person {
	String name;
	int id;
	ArrayList<Person> friendList;
	public Person(String name) {
		this.name = name;
		friendList = new ArrayList<Person>();
	}
	
	public ArrayList<Person> printFriendsGraph() {
		Set<Person> set = new HashSet<Person>();
		dfs(this, this, set);
		return new ArrayList<Person>(set);
	}
	
	public void addFriend(Person p) {
		friendList.add(p);
	}
	
	public ArrayList<Person> getFriendList() {
		return friendList;
	}
	
	//bfs, dfs, both ok
	public void dfs(Person self, Person person, Set<Person> set) {
		for (Person p : person.getFriendList()) {
			if (p == self) {
				continue;
			}
			
			if (!set.contains(p)) {
				set.add(p);
				dfs(self, p, set);
			}
		}
	}
}
