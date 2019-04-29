package se.kth.iv1500.POS.DTOs;

public class CustomerDTO {
    private String customerName;
    private String customerID;
    private double discountRate;
    private boolean avalability;



    public CustomerDTO(String customerName, String customerID, double discountRate, boolean avalability){
        this.customerName=customerName;
        this.customerID= customerID;
        this.discountRate= discountRate;
        this.avalability= avalability;

    }

    /**
     *
     * @return
     */
    public String getCustomerName(){
        return this.customerName;
    }

    /**
     *
     * @return
     */
    public String getCustomerID(){
        return this.customerID;
    }

    /**
     *
     * @return
     */

    public double getDiscountRate(){
        return this.discountRate;
    }





}
