package testPackage;
import se.kth.iv1500.POS.model.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import se.kth.iv1500.POS.DTOs.*;
import java.util.List;
class SaleTest {

	@Test
	void testAddItemUpdateRunningTotal() {
		ItemDTO bread = new ItemDTO("bread",new Amount(30 ,"kr"), 0.2,"123654789");
		int quantity = 4;
		bread.setItemQuantity(quantity);
		Sale instance = new Sale();
		SaleDTO saleInfo = instance.addItem(bread);
		Amount runningTotal = saleInfo.getRunningTotal();
		int expRes = 4 * (int) Math.round(30+(0.2*30));
		int result = runningTotal.getAmount();
		assertEquals(expRes, result, "counted wrong running total");
	}
	@Test
	void testAddItemIsAddingItem() {
		ItemDTO bread = new ItemDTO("bread",new Amount(30 ,"kr"), 0.2,"123654789");
		int quantity = 4;
		bread.setItemQuantity(quantity);
		Sale instance = new Sale();
		SaleDTO saleInfo = instance.addItem(bread);
	    List<ItemDTO> itemInfo = saleInfo.getItemInfo();
		assertNotNull(itemInfo, "the item that should be added is not added");
	}
	@Test
	void testAddItemNotReturningNull() {
		ItemDTO bread = new ItemDTO("bread",new Amount(30 ,"kr"), 0.2,"123654789");
		Sale instance = new Sale();
		SaleDTO saleInfo = instance.addItem(bread);
		assertNotNull(saleInfo, "the item that should be add is not added");
	}
	
	@Test
	public void testCountPayment() {
		
		ItemDTO BREAD = new ItemDTO("bread", new Amount(100 ,"kr"), 0.2, "123456789");
		int quantity = 1;
		bread.setItemQuantity(quantity);
		Sale instance = new Sale();
		SaleDTO saleinfo = instance.addItem(bread);
		List<ItemDTO> itemInfo = saleInfo.getIteminfo();
		Amount amountPayed = new Amount (100, "kr");
		Amount result = instance.countPayment(amountPayed);
		assertEquals(100,result, "count payment should calculate correctly when paying 100 kr for 1 item that cost 100 kr ");
		
				

		
	}

}
