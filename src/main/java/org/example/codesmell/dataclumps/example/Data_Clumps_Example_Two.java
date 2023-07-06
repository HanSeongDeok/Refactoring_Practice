package org.example.codesmell.dataclumps.example;

public class Data_Clumps_Example_Two {
        private String solutionName;
        private String customerAddress;
        private String itemName;
        private int quantity;

    // 기존 3~4개의 데이터 뭉치로 사용되던 생성자 파라미터
    public Data_Clumps_Example_Two(String solutionName, String customerAddress, String itemName, int quantity) {
        this.solutionName = solutionName;
        this.customerAddress = customerAddress;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    // 기존 3~4개의 데이터 뭉치로 사용되던 메서드
        public void printOrderSummary(String customerName, String customerAddress, String itemName, int quantity) {
            System.out.println("Customer: " + customerName);
            System.out.println("Address: " + customerAddress);
            System.out.println("Item: " + itemName);
            System.out.println("Quantity: " + quantity);
        }
}
