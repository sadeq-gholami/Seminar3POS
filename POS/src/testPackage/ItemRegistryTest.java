package testPackage;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import se.kth.iv1500.POS.DTOs.*;
import se.kth.iv1500.POS.dbHandler.*;
class ItemRegistryTest {

	@Test
	void testFindItem() {
		String breadIdentifier = "123654789";
		ItemRegistry instance = new ItemRegistry ();
		ItemDTO returnedObject = instance.findItem(breadIdentifier);
		String expRes = breadIdentifier;
		String result = returnedObject.getItemIdentifier();
		assertEquals ("Available item was not found", expRes, result);
	}
	
	@Test
	void testFindItemWithWrongId() {
		String wrongId = "someWrongId";
		ItemRegistry instance = new ItemRegistry ();
		ItemDTO expRes = null;
		ItemDTO result = instance.findItem(wrongId);
		assertEquals ("An item with wrong identification was found", expRes, result);
	}


}
