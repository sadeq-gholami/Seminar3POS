package se.kth.iv1500.POS.dbHandler;
import se.kth.iv1500.POS.DTOs.*;

import java.util.List;

public class DiscountRules {
    private final int ITEMQUANTETYFORDISCOUNT = 4;
    private final double FIVEPROCENTDISCOUNT = 0.05;
    private final double TENPROCENTDISCOUNT = 0.1;
    private final double TWENTYPROCENTDISOCUNT = 0.2;
    private final double THIRTYROCENTDISOCUNT = 0.3;



    public double discountRateMember(SaleDTO saleInfo ){
        double discount = 0.0;
        Amount totalAmount = saleInfo.getRunningTotal();
        int totalPrice = totalAmount.getAmount();
        List<ItemDTO> itemInfo = saleInfo.getItemInfo();

        if(totalPrice >= 50){
            discount = discount + TENPROCENTDISCOUNT;
        }
        if(isItemBread (itemInfo)){
            discount = discount + TWENTYPROCENTDISOCUNT;
        }
        if(isQuantityMorethenfour(itemInfo)){
            discount = discount + THIRTYROCENTDISOCUNT;
        }
        return discount;

    }
    public  double discountRateNotMember(SaleDTO saleInfo){
        double discount = 0.0;
        Amount totalAmount = saleInfo.getRunningTotal();
        List<ItemDTO> itemInfo = saleInfo.getItemInfo();
        int totalPrice = totalAmount.getAmount();
        if(totalPrice >= 50){
            discount = discount + FIVEPROCENTDISCOUNT;
        }
        if(isItemBread(itemInfo)){
            discount = discount + TENPROCENTDISCOUNT;
        }
        if(isQuantityMorethenfour(itemInfo)){
            discount = discount + TWENTYPROCENTDISOCUNT;
        }
        return discount;
    }

    private boolean isItemBread (List<ItemDTO> itemInfo) {
        boolean isbread = false;
        for (ItemDTO item : itemInfo) {

            if (item.getName() == "bread") {
                isbread = true;
                break;
            }
        }
        return isbread;
    }




    private boolean isQuantityMorethenfour (List<ItemDTO> itemInfo){
        int totalQuantity = 0;

        for (ItemDTO item: itemInfo){
        	totalQuantity += item.getItemQuantity();
        }
        return totalQuantity >= ITEMQUANTETYFORDISCOUNT;
    }
}