package se.kth.iv1500.POS.model;
//import se.kth.iv1500.POS.DTOs.SaleDTO;
//import se.kth.iv1500.POS.DTOs.ItemDTO;
import se.kth.iv1500.POS.DTOs.*;
import java.time.LocalDateTime;
import java.util.*;

public class Receipt {
	private final SaleDTO saleInfo;
	private StoreDTO storeInfo;
	
	Receipt(SaleDTO saleInfo) {
		this.saleInfo = saleInfo;
	}
	
	public StoreDTO getstoreInfo(){
		this.storeInfo = getStoreInformation();
		return storeInfo;
	}
	
	private ItemDTO iteratorForTheIteminformationLoop() {
		Iterator<ItemDTO> iterator = itemsincurrentsale.iterator();
		while(iterator.hasNext()) {
			ItemDTO next = iterator.next();
		}
	}
	
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
		 
		 builder.append("Store: ");
		 appendLine(builder, storeInfo);
		 endSection(builder);
		 
		 for(ItemDTO next : itemsincurrentsale) {
			 builder.append("Bought item: ");
			 appendLine(builder, saleInfo.getItemInfo().getName();
			 builder.append("Price: ");
			 appendLine(builder, saleInfo.getItemInfo().getPrice().toString());
			 endSection(builder);
		 }
		 
		 builder.append("Total price: ");
		 appendLine(builder, saleInfo.getRunningTotal().toString());
		 endSection(builder);
		 
		 builder.append("Amount paid: ");
		 appendLine(builder, saleInfo.getRunningTotal().toString());
		 endSection(builder);
		 
		 builder.append("Change: ");
		 appendLine(builder, saleInfo.getChange().countPayment());
		 endSection(builder);
	 }
		 
		 private void appendLine(StringBuilder builder, String line) {
			 builder.append(line);
			 builder.append("\n");
		 }
			
		 private void endSection(StringBuilder builder) {
			 builder.append("\n");
		 }
}