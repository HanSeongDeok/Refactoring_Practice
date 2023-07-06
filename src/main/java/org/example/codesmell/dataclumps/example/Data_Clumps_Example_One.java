package org.example.codesmell.dataclumps.example;

/**
 * 방법 1: 메서드 시그니처에 있는 필드 값으로 객체를 만들어 파라미터로 받는다.
 */
/**
 * 방법 2: 객체를 통째로 넘겨서 객체 안의 필드에 저장된 값을 불러온다.
 */
public class Data_Clumps_Example_One {
    private String solutionName;
    private String customerAddress;

    public Data_Clumps_Example_One(String solutionName) {
        this.solutionName = solutionName;
    }

    // 기존에 데이터 뭉치로 사용되던 메서드
    public void printOrderSummary(String customerName, String customerAddress, String itemName, int quantity) {
        System.out.println("Customer: " + customerName);
        System.out.println("Address: " + customerAddress);
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
    }
}
