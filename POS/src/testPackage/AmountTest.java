package testPackage;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import se.kth.iv1500.POS.DTOs.*;
class AmountTest {

	@Test
	void testAddAmount() {
		int amountOfOperand1 = 10;
		int amountOfOperand2 = 20;
		Amount amountUnderTest = new Amount (amountOfOperand1, "kr");
		amountUnderTest.addAmount(amountOfOperand2);
		int expRes = amountOfOperand1 + amountOfOperand2;
		int result = amountUnderTest.getAmount();
		assertEquals ("Wrong addition result", expRes, result);
	}
	@Test
	void testAddAmountNegResult() {
		int amountOfOperand1 = 10;
		int amountOfOperand2 = -20;
		Amount amountUnderTest = new Amount (amountOfOperand1, "kr");
		amountUnderTest.addAmount(amountOfOperand2);
		int expRes = amountOfOperand1 + amountOfOperand2;
		int result = amountUnderTest.getAmount();
		assertEquals ("Wrong addition result", expRes, result);
	}
	@Test
	void testAddAmountNZeorRes() {
		int amountOfOperand1 = 20;
		int amountOfOperand2 = -20;
		Amount amountUnderTest = new Amount (amountOfOperand1, "kr");
		amountUnderTest.addAmount(amountOfOperand2);
		int expRes = amountOfOperand1 + amountOfOperand2;
		int result = amountUnderTest.getAmount();
		assertEquals ("Wrong addition result", expRes, result);
	}

}
