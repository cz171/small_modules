package visitorDesignPattern;

public class Tobacco implements Visitable{
	private double price;
	
	Tobacco(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
	
	public double accept(Visitor visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}
}
