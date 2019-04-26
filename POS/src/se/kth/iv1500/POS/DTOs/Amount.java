package se.kth.iv1500.POS.DTOs;
/**
 * 
 * @author Sadeq
 *The class shows amount which contains the amount of money and the currency 
 */
public class Amount {
	private String currency;
	private int amount;
	/**
	 * creats an instans of Amount
	 * @param amount    the amount of money
	 * @param currency  the currency for money
	 */
	public Amount (int amount, String currency) {
		this.currency = currency;
		this.amount =  amount;
	}
	/**
	 * returns the amount of mony
	 * @return amount of mony
	 */
	public int getAmount() {
		return this.amount;
	}
	/**
	 * returns corruncy 
	 * @return
	 */
	public String getCurrency() {
		return this.currency;
	}
}
