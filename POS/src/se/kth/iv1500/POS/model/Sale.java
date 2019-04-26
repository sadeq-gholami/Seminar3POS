package se.kth.iv1500.POS.model;
import se.kth.iv1500.POS.DTOs.*;
import java.util.ArrayList;
import java.util.List;
public class Sale {
	private Amount runningTotal = new Amount(0,"kr");
	private List<ItemDTO> itemsInCurrentSale = new ArrayList<>();
	private Amount change;
	private String dateAndtime;
	public Sale() {
		
	}
	public SaleDTO addItem(ItemDTO itemInfo, int quantity) {
		this.itemsInCurrentSale.add(itemInfo);
		updateRunningTotal(itemInfo, quantity);
		return new SaleDTO(this.runningTotal, this.itemsInCurrentSale, this.dateAndtime);
		
	}
	private void updateRunningTotal(ItemDTO itemInfo, int quantity) {
		int amountOfPriceOfAnItem = itemInfo.getPrice().getAmount();
		int amountToUpdateRunningTotal = quantity * amountOfPriceOfAnItem;
		this.runningTotal.addAmount(amountToUpdateRunningTotal);
	}
	}
	
