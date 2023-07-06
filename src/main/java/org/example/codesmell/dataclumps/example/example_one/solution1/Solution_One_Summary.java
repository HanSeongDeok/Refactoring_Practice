package org.example.codesmell.dataclumps.example.example_one.solution1;

public class Solution_One_Summary {
    private String customerName;
    private String customerAddress;
    private String itemName;
    private int quantity;

    public Solution_One_Summary(String customerName, String customerAddress, String itemName, int quantity) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.itemName = itemName;
        this.quantity = quantity;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }
    public String getItemName() {return itemName;}
    public int getQuantity() {
        return quantity;
    }
}
