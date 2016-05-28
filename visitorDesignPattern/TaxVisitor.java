package visitorDesignPattern;
import java.text.DecimalFormat;

class TaxVisitor implements Visitor{
	DecimalFormat df = new DecimalFormat("#.##");
	
	public TaxVisitor() {
		
	}
	@Override
	public double visit(Liquor liquorItem) {
		// TODO Auto-generated method stub
		System.out.println("Liquor item: Price with Tax");
		return liquorItem.getPrice() * .18 + liquorItem.getPrice();
	}

	@Override
	public double visit(Tobacco tobaccoItem) {
		// TODO Auto-generated method stub
		System.out.println("Tobacco item: Price with Tax");
		return tobaccoItem.getPrice() * .32 + tobaccoItem.getPrice();	
	}

	@Override
	public double visit(Necessity necessityItem) {
		// TODO Auto-generated method stub
		System.out.println("Necessity item: Price with Tax");
		return necessityItem.getPrice() * 0 + necessityItem.getPrice();	
	}
	
	
}
