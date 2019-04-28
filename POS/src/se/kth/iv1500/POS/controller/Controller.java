/**
 * 
 */
package se.kth.iv1500.POS.controller;

import se.kth.iv1500.POS.model.*;
import se.kth.iv1500.POS.DTOs.*;
import se.kth.iv1500.POS.dbHandler.*;
/**
<<<<<<< HEAD
 * @author Zeineb
=======
 * @author Sadeq
>>>>>>> master
 *
 * 
 */
public class Controller {
	    private Sale sale;
	    /**
	     * Creates an instance of Controller which connects all the calls from view to classes in model and
	     * classes in integration layer
	     */
	    public Controller() {
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
}
