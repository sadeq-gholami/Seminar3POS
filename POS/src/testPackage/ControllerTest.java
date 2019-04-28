package testPackage;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

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
	@Test
	void testStartNewSale() {
		assertNotNull("New sale was not started", newSale);
	}

	@Test
	void testAddItemReturnRightObject() {
		String milkId = "123456789";
		int itemQuantity = 4;
		
	}

}
