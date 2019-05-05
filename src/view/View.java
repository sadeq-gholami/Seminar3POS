package view;
import controller.*;
import POS.DTOs.*;
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
	        String itemIdentifier = "123654789";
	        SaleDTO saleInfo = contr.addItem(itemIdentifier, 4);
	        int value = saleInfo.getRunningTotal().getAmount();
	        System.out.println("the item was added successfully \n "
	        		+ "running total is:" + value); 
	        String customerID = "ABC123";
	        Amount priceAfterDiscount =contr.discountRequest(customerID);
	        System.out.println("Discount has been added successfully Discount Amount is:"+ priceAfterDiscount);
	        Amount change = contr.pay(new Amount(200, "kr"));
	        System.out.println("The pay has been handled. Change is equal to " + change);
	    }
}
