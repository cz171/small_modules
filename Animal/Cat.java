package Animal;

public class Cat extends Animal{
	public Cat() {
		super();
		
		setSound("Muw");
		System.out.println("I am a cute cat!");
	}
	
	public void bark() {
		System.out.println("Muw!");
	}
}
	