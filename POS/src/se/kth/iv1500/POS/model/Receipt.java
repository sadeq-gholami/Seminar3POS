package se.kth.iv1500.POS.model;
//import se.kth.iv1500.POS.DTOs.SaleDTO;
//import se.kth.iv1500.POS.DTOs.ItemDTO;
import se.kth.iv1500.POS.DTOs.*;
import java.time.LocalDateTime;
import java.util.*;

public class Receipt {
	private final SaleDTO saleInfo;
	//private StoreDTO storeInfo;
	
	public Receipt(SaleDTO saleInfo) {
		this.saleInfo = saleInfo;
	}
	
	/*private ItemDTO iteratorForTheIteminformationLoop() {
		Iterator<ItemDTO> iterator = itemsincurrentsale.iterator();
		while(iterator.hasNext()) {
			ItemDTO next = iterator.next();
		}
	}*/
	
	 /**
	 * Creates a well-formatted string with the entire content
	 * of the receipt.
	 *
	 * @return The well-formatted receipt string.
	 */
	 public String createReceiptString() {
		 StringBuilder builder = new StringBuilder();
		 appendLine(builder, "Sale Receipt");
		 endSection(builder);
	
		 LocalDateTime saleTime = LocalDateTime.now();
		 builder.append("Sale time: ");
		 appendLine(builder, saleTime.toString());
		 endSection(builder);
		 
		 for(ItemDTO next : saleInfo.getItemInfo()) {
			 builder.append("Bought item: ");
			 appendLine(builder, next.getName());
			 builder.append("Price: ");
			 appendLine(builder, next.getPrice().toString());
			 endSection(builder);
		 }
		 
		 builder.append("Total price: ");
		 appendLine(builder, saleInfo.getRunningTotal().toString());
		 endSection(builder);
		 
		 builder.append("Amount paid: ");
		 appendLine(builder, calculateAmountPaid(saleInfo));
		 endSection(builder);
		 
		 builder.append("Change: ");
		 appendLine(builder, saleInfo.getChange().toString());
		 endSection(builder);
		 
		 return builder.toString();
	 }
		 
		 private void appendLine(StringBuilder builder, String line) {
			 builder.append(line);
			 builder.append("\n");
		 }
			
		 private void endSection(StringBuilder builder) {
			 builder.append("\n");
		 }
		 
		 private String calculateAmountPaid(SaleDTO saleInfo) {
			 int change = saleInfo.getChange().getAmount();
			 int totalPrice = saleInfo.getRunningTotal().getAmount();
			 int amountPaid = change + totalPrice;
			 return amountPaid + " ";
		 }
}