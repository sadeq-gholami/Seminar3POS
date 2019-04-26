package se.kth.iv1500.POS.DTOs;
/**
 * this is a place holder for sale information 
 * @author Sadeq
 *
 */
public class SaleDTO {
	private Amount runningTotal;
	private ItemDTO itemInfo;
	private String dateAndTime;
	private String message;
	
	/**
	 * creates a new instance representing a new sale; 
	 * @param  runningTotal     total price after scanning each item
	 * @param  itemInfo         an instance of itemDTO which is a place holder for information about an item 
	 * @param  dateAndTime     	the date and time of the running sale
	 * @param  message 	 		message that contains information about the sale e.g       	  
	 */
	public SaleDTO(Amount runningTotal, ItemDTO itemInfo, String dateAndTime, String message) {
		this.runningTotal = runningTotal;
		this.itemInfo = itemInfo;
		this.dateAndTime = dateAndTime;
		this.message = message;
	}
	
	/**
	 * returns the running total 5
	 *@return the running total after each sale  
	 */
	public Amount getRunnigTotal() {
		return this.runningTotal;
	}
	
	/**
	 * returns information about an item as an instance of ItemDTO
	 *@return the name of an item  
	 */
	public ItemDTO getIteminfo() {
		return this.itemInfo;
	}
	
	/**
	 * returns the date and time of the running sale 
	 *@return the date and time of sale
	 */
	public String getdateAndTime() {
		return this.dateAndTime;
	}
	
	/**
	 * returns the identification of an item 
	 *@return the identification of an item  
	 */
	public String  getMessage() {
		return this.message;
	}

}
