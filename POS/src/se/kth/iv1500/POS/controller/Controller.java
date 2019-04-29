/**
 * 
 */
package se.kth.iv1500.POS.controller;

import se.kth.iv1500.POS.model.*;
import se.kth.iv1500.POS.DTOs.*;
import se.kth.iv1500.POS.dbHandler.*;

public class Controller {
	    private Sale sale;
	    private ExternalSystemGenerator extSys;
	    private CashRegister cashRegister;
	    /**
	     * Creates an instance of Controller which connects all the calls from view to classes in model and
	     * classes in integration layer
	     */
	    public Controller(ExternalSystemGenerator extSys, CashRegister cashRegister) {
	    	this.cashRegister = cashRegister;
	    	this.extSys = extSys;
	    }
	    
	    /**
	     * Starts a new sale by making an instance of Sale object.
	     */
	    public Sale startNewSale() {
	        this.sale = new Sale();
	        return this.sale;
	    }
	    
	    /**
	     * adds an item to the current sale
	     * @param itemIdentifier   the identification of an item
	     * @param itemQuantitiy     the number of items 
	     * @return returns an object of type <code>SaleDTO</code>which contains information about the price of an item, VAT rate and running total 
	     */
	    public SaleDTO addItem(String itemIdentifier, int itemQuantity) {
	    	SaleDTO currentSale = null; 
	    	ItemRegistry itemRegistry = new ItemRegistry();
	    	ItemDTO itemInfo = itemRegistry.findItem(itemIdentifier);
	    	if (itemInfo != null) {
	    		currentSale = this.sale.addItem(itemInfo, itemQuantity);
	    		
	    	}
	    	return currentSale;
	    }
	    
	    public Amount pay(Amount amtPaid) {
	    	Amount change = sale.countPayment(amtPaid);
	    	CashPayment payment = new CashPayment(amtPaid);
	    	cashRegister.recordPayment(payment);
	    	//sale.printReceipt(extSys.getPrinter());
	    	return change;
	    }
}
