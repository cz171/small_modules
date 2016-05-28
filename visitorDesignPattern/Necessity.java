package visitorDesignPattern;

public class Necessity implements Visitable{
	private double price;
	
	Necessity(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public double accept(Visitor visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}
	
}
