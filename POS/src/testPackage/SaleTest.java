package testPackage;
import se.kth.iv1500.POS.model.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;
import se.kth.iv1500.POS.DTOs.*;
import java.util.List;
class SaleTest {

	@Test
	void testAddItemUpdateRunningTotal() {
		ItemDTO bread = new ItemDTO("bread",new Amount(30 ,"kr"), 0.2,"123654789");
		int quantity = 4;
		Sale instance = new Sale();
		SaleDTO saleInfo = instance.addItem(bread, quantity);
		Amount runningTotal = saleInfo.getRunnigTotal();
		int expRes = 4 * (int) Math.round(30+(0.2*30));
		int result = runningTotal.getAmount();
		assertEquals("counted wrong running total", expRes, result);
	}
	@Test
	void testAddItemIsAddingItem() {
		ItemDTO bread = new ItemDTO("bread",new Amount(30 ,"kr"), 0.2,"123654789");
		int quantity = 4;
		Sale instance = new Sale();
		SaleDTO saleInfo = instance.addItem(bread, quantity);
	    List<ItemDTO> itemInfo = saleInfo.getIteminfo();
		assertNotNull("the item that should be added is not added",itemInfo);
	}
	@Test
	void testAddItemNotReturningNull() {
		ItemDTO bread = new ItemDTO("bread",new Amount(30 ,"kr"), 0.2,"123654789");
		int quantity = 4;
		Sale instance = new Sale();
		SaleDTO saleInfo = instance.addItem(bread, quantity);
		assertNotNull("the item that should be add is not added",saleInfo);
	}
	

}
