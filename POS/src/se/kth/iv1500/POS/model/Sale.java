package se.kth.iv1500.POS.model;
import se.kth.iv1500.POS.DTOs.*;
import se.kth.iv1500.POS.dbHandler.*;
import java.util.ArrayList;
import java.util.List;
public class Sale {
	private Amount runningTotal = new Amount(0,"kr");
	private List<ItemDTO> itemsInCurrentSale = new ArrayList<>();
	private Amount change;
	private Amount totalPriceAfterDiscount;
	private SaleDTO saleInfo;
	
	/**
	 * Creates an instance of sale
	 */
	public Sale() {
		
	}
	
	/**
	 * adds an new item to the current sale, updates the running total including the VAT
	 * @param itemInfo an instance of <code>ItemDTO</code> that contains information about an item
	 * @param quantity the number of items to be added
	 * @return an instance of <code>SaleDTO</code> that contains information about current sale
	 */
	public SaleDTO addItem(ItemDTO itemInfo) {
		this.itemsInCurrentSale.add(itemInfo);
		int quantity = itemInfo.getItemQuantity();
		updateRunningTotal(itemInfo, quantity);
		saleInfo = new SaleDTO(this.runningTotal, this.itemsInCurrentSale, this.change, this.totalPriceAfterDiscount);
		return saleInfo;
	}
	private void updateRunningTotal(ItemDTO itemInfo, int quantity) {
		Amount priceAfterVat = this.countItemPriceIncludinVAT(itemInfo);
		int amountOfPriceAfterVat = priceAfterVat.getAmount();
		int amountToUpdateRunningTotal = quantity *amountOfPriceAfterVat;
		this.runningTotal.addAmount(amountToUpdateRunningTotal);
	}
	private Amount countItemPriceIncludinVAT(ItemDTO itemInfo) {
		Amount priceOfItem = itemInfo.getPrice();
		int amountOfPrice = priceOfItem.getAmount();
		double vatRate = itemInfo.getVateRate();
		double priceIncludingVAT = amountOfPrice +(amountOfPrice * vatRate);
		int roundedPriceAfterVat = (int) Math.round(priceIncludingVAT);
		return new Amount(roundedPriceAfterVat,"kr");
	}
	public Amount countDiscount(String customerID,CustomerRegistry customerRegistry){
		DiscountRules discountRules = new DiscountRules();
		Amount totalAmount = this.runningTotal;
		double countedDiscount = totalAmount.getAmount();
		if(customerRegistry.isEligible(customerID)){
			countedDiscount = countedDiscount * (1- discountRules.discountRateMember(this.saleInfo));
		}
		else{
			countedDiscount = countedDiscount * (1 - discountRules.discountRateNotMember(this.saleInfo));
		}
		int roundedPriceAfterDiscount = (int) Math.round(countedDiscount);
		this.totalPriceAfterDiscount = new Amount(roundedPriceAfterDiscount,"kr");
		return this.totalPriceAfterDiscount;
	}
	
	/**
	 * calculates the change amount to return to a customer.
	 * And creates an instance of <code>SaleDTO</code> that contains information about current sale,
	 * including the change amount
	 * @param amountPaid by the customer
	 * @return returns the change amount
	 */
	public Amount countPayment(Amount amountPaid) {
		int amountInChange = amountPaid.amountSubtraction(this.runningTotal);
		change = new Amount(amountInChange, "kr");
		saleInfo = new SaleDTO(this.runningTotal, this.itemsInCurrentSale, this.change, this.totalPriceAfterDiscount);
		return change;
	}
	
	/**
	* Prints a receipt for the current sale on the
	* specified printer.
	*/
	public void printReceipt(Printer printer) {
		Receipt receipt = new Receipt(saleInfo);
		System.out.println(receipt.createReceiptString());
		printer.printReceipt(receipt);
	}
}
	
