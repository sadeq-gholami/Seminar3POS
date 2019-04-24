package se.kth.iv1500.POS.DTOs;

public class Amount {
	private String currency;
	private double amount;
	public Amount (String currency, double amount) {
		this.currency = currency;
		this.amount =  amount;
	}
}
