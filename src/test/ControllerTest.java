package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import controller.*;
import POS.DTOs.*;
import dbHandler.*;
import model.*;
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
	void testCalculateDiscountforMembers() {
		
		String milkId = "123456789";
		int itemQuantity = 8;
		SaleDTO saleInfo = instanceCont.addItem(milkId, itemQuantity);
		
		Amount result = instanceCont.discountRequest("123ABC");
		
		assertEquals(62, result.getAmount(),"Should calculate the discount for members correctly." );

	}
	
	
	@Test
	void testCalculateDiscountforNoNMembers() {
		
		String milkId = "123456789";
		int itemQuantity = 8;
		SaleDTO saleInfo = instanceCont.addItem(milkId, itemQuantity);
		
		Amount result = instanceCont.discountRequest("NON_member");
		assertEquals(66, result.getAmount(),"Should calculate the discount for non members correctly." );

	}
	
	
	@Test
	void testPayWhenCustomerIsAMember() {
		
		String bread = "123654789";
		int itemQuantity = 3;
		SaleDTO saleInfo = instanceCont.addItem(bread, itemQuantity);
		instanceCont.discountRequest("123ABC");
		Amount result = instanceCont.pay(new Amount(200,"kr"));
		assertEquals(124, result.getAmount(),"Should give customer discount and change should be correct." );

	}
	
	@Test
	void testPayWhenCustomerIsNotMember() {
		
		String bread = "123654789";
		int itemQuantity = 3;
		SaleDTO saleInfo = instanceCont.addItem(bread, itemQuantity);
		
		instanceCont.discountRequest("NON_MEMBER_CUSTOMER");
		Amount result = instanceCont.pay(new Amount(200,"kr"));
		
		assertEquals(108, result.getAmount(),"Should give customer discount and change should be correct." );

	}
	
	

}
