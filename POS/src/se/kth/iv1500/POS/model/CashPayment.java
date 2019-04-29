package se.kth.iv1500.POS.model;
import se.kth.iv1500.POS.DTOs.*;

public class CashPayment {
	private Amount amtPaid;
	
	public CashPayment(Amount amtPaid) {
		this.amtPaid = amtPaid;
	}
	
	/*public Amount getChange() {
		Amount totalCost = getRunningTotal();
		return totalCost.amountSubtraction(amtPaid);
	}*/

}