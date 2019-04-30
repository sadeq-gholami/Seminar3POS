package se.kth.iv1500.POS.DTOs;

public class CustomerDTO {
    private String customerName;
    private String customerID;




    public CustomerDTO(String customerName, String customerID){
        this.customerName = customerName;
        this.customerID = customerID;


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


}

