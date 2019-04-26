/**
 * 
 */
package se.kth.iv1500.POS.controller;

import se.kth.iv1500.POS.model.*;
/**
 * @author Sadeq
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
