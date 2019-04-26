package se.kth.iv1500.POS.view;
import se.kth.iv1500.POS.controller.*;
import se.kth.iv1500.POS.DTOs.*;
public class View {
	 private Controller contr;
	    
	    public View(Controller contr) {
	        this.contr = contr;
	    }
	    
	    public void runFakeSale() {
	        contr.startNewSale();
	        System.out.println("New sale was started.");
	        
	        String itemIdentifier = "1234567989";
	        SaleDTO saleInfo = contr.addItem(itemIdentifier, 4);
	        
	        System.out.println("the item wa added successfully");
	    }
}
