package org.example.codesmell;
public class Data_Clumps {
    private String customerName;
    private String customerAddress;
    private String itemName;
    private int quantity;
    public Data_Clumps(String customerName, String customerAddress, String itemName, int quantity) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    // 기존에 데이터 뭉치로 사용되던 메서드
    public void printOrderSummary(String customerName, String customerAddress, String itemName, int quantity) {
        System.out.println("Customer: " + customerName);
        System.out.println("Address: " + customerAddress);
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
    }
}
