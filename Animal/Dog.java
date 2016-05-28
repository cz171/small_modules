package Animal;

public class Dog extends Animal{
	public Dog() {
		super();
		
		setSound("Wang");
		System.out.println("I am a cute dog!");
	}
	
	public void bark() {
		System.out.println("WANG!");
	}
	
}
