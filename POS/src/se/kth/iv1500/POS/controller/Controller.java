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
	    private RegistryCreator regCreator;
	    /**
	     * Creates an instance of Controller which connects all the calls from view to classes in model and
	     * classes in integration layer
	     */
	    public Controller(RegistryCreator regCreator, ExternalSystemGenerator extSys, CashRegister cashRegister) {
	    	this.cashRegister = cashRegister;
	    	this.extSys = extSys;
	    	this.regCreator = regCreator;
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
	    	ItemRegistry itemRegistry =  regCreator.getItemRegistry();
	    	ItemDTO itemInfo = itemRegistry.findItem(itemIdentifier);
	    	if (itemInfo != null) {
	    		itemInfo.setItemQuantity(itemQuantity);
	    		currentSale = this.sale.addItem(itemInfo);	    		
	    	}
	    	return currentSale;
	    }
	    
	    public Amount discountRequest(String CustomerID){
	    	CustomerRegistry customerRegistry = regCreator.getCustomerRegistry();
	        Amount totalPriceAfterDiscount = sale.countDiscount(CustomerID, customerRegistry);
	    	return totalPriceAfterDiscount;
		}
	    
	     
	    /**
	     * Handles sale payment. Updates the cash register here
	     * the payment was performed and records the payment.
	     * Calculates change. Prints the receipt.
	     * @param amtPaid the amount paid
	     * @return change the amount of change for customer to recieve
	     */
	    public Amount pay(Amount amtPaid) {
	    	Amount change = sale.countPayment(amtPaid);
	    	CashPayment payment = new CashPayment(amtPaid);
	    	cashRegister.recordPayment(payment);
	    	Printer printer = extSys.getPrinter();
	    	sale.printReceipt(printer);
	    	return change;
	    }
}
