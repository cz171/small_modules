package person;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		Person Mike = new Person("Mike");
		Person Mitch = new Person("Mitch");
		Person Ryan = new Person("Ryan");
		Person Lila = new Person("Lila");
		Mike.addFriend(Mitch);
		Mike.addFriend(Ryan);
		Mitch.addFriend(Mike);
		Ryan.addFriend(Mike);
		Ryan.addFriend(Lila);
		Lila.addFriend(Ryan);
		
		ArrayList<Person> result = Mike.printFriendsGraph();
		for (Person p : result) {
			System.out.println(p.name);
		}

		
	}

}
