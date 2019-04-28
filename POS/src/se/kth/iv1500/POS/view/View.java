package se.kth.iv1500.POS.view;
import se.kth.iv1500.POS.controller.*;
import se.kth.iv1500.POS.DTOs.*;
public class View {
	 private Controller contr;
	    
	    public View(Controller contr) {
	        this.contr = contr;
	    }
	    /**
	     * a fake method which is used instead of real user interface
	     */
	    
	    public void runFakeSale() {
	        contr.startNewSale();
	        System.out.println("New sale was started.");
	        String itemIdentifier = "123456789";
	        SaleDTO saleInfo = contr.addItem(itemIdentifier, 4);
	        int value = saleInfo.getRunnigTotal().getAmount();
	        System.out.println("the item was added successfully \n "
	        		+ "running total is:" + value);        
	    }
}
