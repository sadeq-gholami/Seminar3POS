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
	private Amount change;
	
	/**
	 * creates a new instance representing a new sale; 
	 * @param  runningTotal     total price after scanning each item
	 * @param  itemInfo         an instance of itemDTO which is a place holder for information about an item      	  
	 */
	public SaleDTO(Amount runningTotal,List <ItemDTO> itemInfo, Amount change) {
		this.runningTotal = runningTotal;
		this.itemsInCurrentSale = itemInfo;
		this.change = change;
	}
	
	/**
	 * returns the running total 
	 *@return the running total after each sale  
	 */
	public Amount getRunningTotal() {
		return this.runningTotal;
	}
	
	public Amount getChange() {
		return this.change;
	}
	
	/**
	 * returns information about an item as an instance of ItemDTO
	 *@return the name of an item  
	 */
	public List<ItemDTO> getItemInfo() {
		return this.itemsInCurrentSale;
	}
}
