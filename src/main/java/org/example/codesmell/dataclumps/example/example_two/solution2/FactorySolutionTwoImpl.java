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

    @Override
    public IFactorySolutionTwo setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
        return this;
    }
    @Override
    public IFactorySolutionTwo setCustomerName(String customerName) {
        this.customerName = customerName;
        return null;
    }
    @Override
    public IFactorySolutionTwo setItemName(String itemName) {
        this.itemName = itemName;
        return null;
    }

    @Override
    public IFactorySolutionTwo setQuantity(int quantity) {
        this.quantity = quantity;
        return null;
    }

    @Override
    public Solution_Two build() {
        return new Solution_Two(this);
    }

    public String getCustomerAddress() {return customerAddress;}
    public String getCustomerName() {return customerName;}
    public String getItemName() {return itemName;}
    public int getQuantity() {return quantity;}

}
