package se.kth.iv1500.POS.model;
import se.kth.iv1500.POS.DTOs.*;
import se.kth.iv1500.POS.dbHandler.Printer;
import java.util.ArrayList;
import java.util.List;
public class Sale {
	private Amount runningTotal = new Amount(0,"kr");
	private List<ItemDTO> itemsInCurrentSale = new ArrayList<>();
	private Amount change;
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
	public SaleDTO addItem(ItemDTO itemInfo, int quantity) {
		this.itemsInCurrentSale.add(itemInfo);
		updateRunningTotal(itemInfo, quantity);
		saleInfo = new SaleDTO(this.runningTotal, this.itemsInCurrentSale);
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
	
	public Amount countPayment(Amount amountPaid) {
		int amountInChange = amountPaid.amountSubtraction(this.runningTotal);
		change = new Amount(amountInChange, "kr");
		return change;
	}
	
	/**
	* Prints a receipt for the current sale on the
	* specified printer.
	*/
	public void printReceipt(Printer printer) {
		Receipt receipt = new Receipt(saleInfo);
		printer.printReceipt(receipt);
	}
}
	
