package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import POS.DTOs.*;
import dbHandler.*;
class ItemRegistryTest {

	@Test
	void testFindItem() {
		String breadIdentifier = "123654789";
		ItemRegistry instance = new ItemRegistry ();
		ItemDTO returnedObject = instance.findItem(breadIdentifier);
		String expRes = breadIdentifier;
		String result = returnedObject.getItemIdentifier();
		assertEquals (expRes, result, "Available item was not found");
	}
	
	@Test
	void testFindItemWithWrongId() {
		String wrongId = "someWrongId";
		ItemRegistry instance = new ItemRegistry ();
		ItemDTO expRes = null;
		ItemDTO result = instance.findItem(wrongId);
		assertEquals (expRes, result, "An item with wrong identification was found");
	}


}
