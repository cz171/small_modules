package Animal;

public class AnimalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal doggy = new Dog();
		Animal kitty = new Cat();

		doggy.setName("Xiao Xin");
		System.out.println(doggy.getSound());
		
		System.out.println(kitty.getSound());

		((Dog) doggy).bark();
		

	}

}
