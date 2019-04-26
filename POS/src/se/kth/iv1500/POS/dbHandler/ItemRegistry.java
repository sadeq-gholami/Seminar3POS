package se.kth.iv1500.POS.dbHandler;
import se.kth.iv1500.POS.DTOs.*;
import java.util.ArrayList;
import java.util.List;
public class ItemRegistry {
	private List<ItemDTO> items = new ArrayList<>();
	private static final Amount SOMEAMOUNT = new Amount (10,"kr");
	private static final Amount SOMEOTHERAMOUNT = new Amount (15,"kr");
	private static final Amount ANOTHERAMOUNT = new Amount (30,"kr");
	private static final double VAT10PERCENT = 0.1;
	private static final double VAT15PERCENT = 0.15;
	private static final double VAT20PERCENT = 0.1;
	private static final String FIRSTITEMIDENTIFIER = "123456789";
	private static final String SECONDITEMIDENTIFIER = "987654321";
	private static final String THIRDITEMIDENTIFIER = "123654789";
	
	
	
	public ItemRegistry(){
		addItem();
	}

	/**
	 * the method adds item to the list of items that represents a fake database 
	 */
	public void addItem() {
		items.add(new ItemDTO("milk", SOMEAMOUNT, VAT10PERCENT, FIRSTITEMIDENTIFIER));
		items.add(new ItemDTO("cocacola", SOMEOTHERAMOUNT,VAT15PERCENT, SECONDITEMIDENTIFIER));
		items.add(new ItemDTO("bread", ANOTHERAMOUNT, VAT20PERCENT, THIRDITEMIDENTIFIER));
		
		
	}
}
