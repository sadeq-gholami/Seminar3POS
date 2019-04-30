package testPackage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import se.kth.iv1500.POS.controller.*;
import se.kth.iv1500.POS.DTOs.*;
import se.kth.iv1500.POS.dbHandler.*;
import se.kth.iv1500.POS.model.*;
class ControllerTest {
	private Controller instanceCont;
	private Sale newSale;
	
	@BeforeEach
	public void setUp() {
		RegistryCreator regCreator = new RegistryCreator();
		ExternalSystemGenerator extSys = new ExternalSystemGenerator();
		CashRegister cashRegister = new CashRegister(); 
		this.instanceCont = new Controller(regCreator, extSys, cashRegister);
		this.newSale = instanceCont.startNewSale();
	}
	
	@AfterEach
	public void tearDown(){
		instanceCont = null;
		newSale = null;
	}
	
	@Test
	void testStartNewSale() {
		assertNotNull(newSale, "New sale was not started");
	}

	@Test
	void testAddItemReturnRightObject() {
		String milkId = "123456789";
		int itemQuantity = 4;
		SaleDTO saleInfo = instanceCont.addItem(milkId, itemQuantity);
		List<ItemDTO> itemInfo = saleInfo.getItemInfo();
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
	
	@Test
	void testPay() {
		
		String milkId = "123456789";
		int itemQuantity = 10;
		SaleDTO saleInfo = instanceCont.addItem(milkId, itemQuantity);
		
		instanceCont.discountRequest("CustomerID1");
		
		Amount result = instanceCont.pay(new Amount(200,"kr"));
		
		assertEquals(90, result.getAmount(),"should give customer discount and change should be correct." );

	}
	
	

}
