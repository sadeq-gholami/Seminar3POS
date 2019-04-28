package se.kth.iv1500.POS.DTOs;

import java.util.ArrayList;
import java.util.List;

/**
 * this is a place holder for sale information 
 * @author Sadeq
 *
 */
public class SaleDTO {
	private Amount runningTotal;
	private List<ItemDTO> itemsInCurrentSale = new ArrayList<>();
	private String dateAndTime;
	
	/**
	 * creates a new instance representing a new sale; 
	 * @param  runningTotal     total price after scanning each item
	 * @param  itemInfo         an instance of itemDTO which is a place holder for information about an item 
	 * @param  dateAndTime     	the date and time of the running sale       	  
	 */
	public SaleDTO(Amount runningTotal,List <ItemDTO> itemInfo, String dateAndTime) {
		this.runningTotal = runningTotal;
		this.itemsInCurrentSale = itemInfo;
		this.dateAndTime = dateAndTime;
	}
	
	/**
	 * returns the running total 
	 *@return the running total after each sale  
	 */
	public Amount getRunnigTotal() {
		return this.runningTotal;
	}
	
	/**
	 * returns information about an item as an instance of ItemDTO
	 *@return the name of an item  
	 */
	public List<ItemDTO> getIteminfo() {
		return this.itemsInCurrentSale;
	}
	
	/**
	 * returns the date and time of the running sale 
	 *@return the date and tisdfghjklöä'me of sale
	 */
	public String getdateAndTime() {
		return this.dateAndTime;
	}
	
	
}
