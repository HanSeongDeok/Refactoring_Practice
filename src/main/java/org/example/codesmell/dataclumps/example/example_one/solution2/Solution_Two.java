package org.example.codesmell.dataclumps.example.example_one.solution2;

public class Solution_Two {
    private String customerName;
    private String customerAddress;
    private String itemName;
    private int quantity;

    public Solution_Two(String customerName, String customerAddress, String itemName, int quantity) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.itemName = itemName;
        this.quantity = quantity;
    }
    /**
     * Data Clumps Smell 리팩토링 방법 2
     * 객체 통째로 넘기기 기법을 사용해서 메서드 시그니처에 자기 자신의 객체를 넘겨 값을 불러온다.
     */
    public void printOrderSummary(Solution_Two solutionTwo) {
        System.out.println("Customer: " + solutionTwo.getCustomerName());
        System.out.println("Address: " + solutionTwo.getCustomerAddress());
        System.out.println("Item: " + solutionTwo.getItemName());
        System.out.println("Quantity: " + solutionTwo.getQuantity());
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }
}
