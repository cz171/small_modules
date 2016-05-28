package visitorDesignPattern;

public class Liquor implements Visitable{
	private double price;
	
	Liquor(double price) {
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
