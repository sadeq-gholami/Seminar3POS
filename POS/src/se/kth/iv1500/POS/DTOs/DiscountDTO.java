package se.kth.iv1500.POS.DTOs;

public class DiscountDTO {
    private String discountType;
    private float percentage;
    private boolean avalilability;
    private String date;
    private Amount change;


    public DiscountDTO (String discountType, float percentage, boolean avalilability, String date, Amount change){
        this.discountType = discountType;
        this.percentage = percentage;
        this.avalilability = avalilability;
        this.date = date;
        this.change = change;
    }

    /**
     *
     * @return
     */
    public String getDiscountType(){ return this.discountType; }
    /**
     *
     * @return
     */
    public float getPercentage(){ return this.percentage; }

    /**
     *
     * @return
     */
    public boolean isAvalilability(){ return this.avalilability; }

    /**
     *
     * @return
     */
    public String getDate(){ return this.date; }

    /**
     *
     * @return
     */
    public Amount getChange (){ return this.change; }
}
