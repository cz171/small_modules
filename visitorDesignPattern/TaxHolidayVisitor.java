package visitorDesignPattern;

import java.text.DecimalFormat;

public class TaxHolidayVisitor implements Visitor{
	DecimalFormat df = new DecimalFormat("#.##");
	
	public TaxHolidayVisitor() {
		
	}
	
	@Override
	public double visit(Liquor liquorItem) {
		System.out.println("Liquor item: Price with Tax");
		return liquorItem.getPrice() * .10 + liquorItem.getPrice();
	}

	@Override
	public double visit(Tobacco tobaccoItem) {
		System.out.println("Tobacco item: Price with Tax");
		return tobaccoItem.getPrice() * .30 + tobaccoItem.getPrice();	
	}

	@Override
	public double visit(Necessity necessityItem) {
		System.out.println("Necessity item: Price with Tax");
		return necessityItem.getPrice() * 0 + necessityItem.getPrice();	
	}
}
