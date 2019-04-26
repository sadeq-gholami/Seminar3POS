/**
 * 
 */
package se.kth.iv1500.POS.controller;

import se.kth.iv1500.POS.model.*;
/**
 * @author Zeineb
 *
 * 
 */
public class Controller {
	    private Sale sale;
	    
	    public Controller() {
	    }
	    
	    public void startNewSale() {
	        this.sale = new Sale();
	    }
}
