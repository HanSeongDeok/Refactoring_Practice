package org.example.codesmell.dataclumps.example.example_two.solution2;

/**
 * 추상 팩토리 패턴을 활용
 * 아예 생성자 매개변수를 추상화 시켜서 사용하는 방법.
 */
public class FactorySolutionTwoImpl implements IFactorySolutionTwo {
    private String customerAddress;
    private String customerName;
    private String itemName;
    private int quantity;
    FactorySolutionTwoImpl(){}
    @Override
    public Solution_Two build() {
        return IFactorySolutionTwo.solution_Two_Factory(this).create();
    }
    @Override
    public IFactorySolutionTwo setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
        return this;
    }
    @Override
    public IFactorySolutionTwo setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }
    @Override
    public IFactorySolutionTwo setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }
    @Override
    public IFactorySolutionTwo setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getCustomerAddress() {return customerAddress;}
    public String getCustomerName() {return customerName;}
    public String getItemName() {return itemName;}
    public int getQuantity() {return quantity;}
}
