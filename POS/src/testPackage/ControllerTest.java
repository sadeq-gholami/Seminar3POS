package testPackage;
import se.kth.iv1500.POS.DTOs.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1500.POS.controller.*;
import se.kth.iv1500.POS.model.Sale;
class ControllerTest {
	private Controller instanceCont;
	private Sale newSale;
	
	@BeforeEach
	public void setUp() {
		this.instanceCont = new Controller();
		this.newSale = instanceCont.startNewSale();
	}
	
	@AfterEach
	public void tearDown(){
		instanceCont = null;
		newSale = null;
	}
	
	@Test
	void testStartNewSale() {
		assertNotNull("New sale was not started", newSale);
	}

	@Test
	void testAddItemReturnRightObject() {
		String milkId = "123456789";
		int itemQuantity = 4;
		SaleDTO saleInfo = instanceCont.addItem(milkId, itemQuantity);
		List<ItemDTO> itemInfo = saleInfo.getIteminfo();
		ItemDTO addedItem = itemInfo.get(0);
		String result = addedItem.getName();
		String expRes = "milk";
		assertEquals(expRes, result,"the returned object is not correct" );
		
	}
	

	@Test
	void testAddItemReturnNull() {
		String invalidId = "wrongId";
		int itemQuantity = 4;
		SaleDTO saleInfo = instanceCont.addItem(invalidId, itemQuantity);
		assertNull(saleInfo, "the returned object with ivalidId is not null");
	}
	
	

}
