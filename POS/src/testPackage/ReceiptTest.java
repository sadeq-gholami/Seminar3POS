package testPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;



import se.kth.iv1500.POS.DTOs.Amount;
import se.kth.iv1500.POS.DTOs.ItemDTO;
import se.kth.iv1500.POS.DTOs.SaleDTO;
import se.kth.iv1500.POS.model.Receipt;

public class ReceiptTest {
	
	Receipt receipt;
	
	
	@Before
	public void before() {
		Amount amount = new Amount(11,"KR");
		List<ItemDTO> itemInfo = new ArrayList();
		Amount change = new Amount(1,"KR");
		
		SaleDTO saleDTO = new SaleDTO(amount,itemInfo,change);
		
		receipt = new Receipt(saleDTO);
		
		
	}
	
	@Test
	public void testCreateReceiptString() {
		
		String receiptString = receipt.createReceiptString();
		
		assertTrue(receiptString.startsWith("Sale Receipt"),"Sale dose not contain sale receipt");
				
		Assertions.assertTrue(
				receiptString.contains("Total price: 11 KR"));		
					
		Assertions.assertTrue(
				receiptString.contains("Change: 1 KR"));		
		
		Assertions.assertTrue(
				receiptString.contains("Sale time: "));
		
	}


}
