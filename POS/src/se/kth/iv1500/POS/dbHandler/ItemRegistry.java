package se.kth.iv1500.POS.dbHandler;
import se.kth.iv1500.POS.DTOs.*;
import se.kth.iv1500.POS.model.Amount;
import se.kth.iv1500.POS.model.exceptions.ItemNotFoundException;

import java.util.ArrayList;
import java.util.List;
public class ItemRegistry {
	private List<ItemDTO> items = new ArrayList<>();
	
	private final Amount MILKPRICE = new Amount (10,"kr");
	private final Amount COCACOLAPRICE = new Amount (15,"kr");
	private final Amount BREADPRICE = new Amount (30,"kr");
	private final double VAT10PERCENT = 0.1;
	private final double VAT15PERCENT = 0.15;
	private final double VAT20PERCENT = 0.2;
	private final String MILKITEMIDENTIFIER = "123456789";
	private final String COCACOLAITEMIDENTIFIER = "987654321";
	private final String BREADITEMIDENTIFIER = "123654789";
	
	
	/**
	 * Creats an instance of Item registry
	 */
	public ItemRegistry(){
		addItem();
	}
	/**
	 * checks if an item with the scanned identification is in the data base
	 * @param itemIdentifier   the identification of an item 
	 * @return  an object of  <code >itemDTO</code> if there is an item with the same identification else <code>null</code>
	 */
	public ItemDTO findItem(String itemIdentifier) throws ItemNotFoundException {
			ItemDTO itemInfo = null;
			for (ItemDTO item : items) {
				if (item.getItemIdentifier().equals(itemIdentifier)) {
					return item;
				}
			}
			throw new ItemNotFoundException("Item: "+ itemIdentifier +" is not registred.");
	}
	
	private void addItem() {
		items.add(new ItemDTO("milk", MILKPRICE, VAT10PERCENT, MILKITEMIDENTIFIER));
		items.add(new ItemDTO("cocacola", COCACOLAPRICE,VAT15PERCENT, COCACOLAITEMIDENTIFIER));
		items.add(new ItemDTO("bread", BREADPRICE, VAT20PERCENT, BREADITEMIDENTIFIER));
	}
}
