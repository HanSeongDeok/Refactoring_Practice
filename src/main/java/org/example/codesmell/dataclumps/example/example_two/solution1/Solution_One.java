package org.example.codesmell.dataclumps.example.example_two.solution1;

/**
 * 방법 1: 빌더 패턴, 팩토리 패턴을 이용하여 생성자를 만드는 위임자를 따로 만들고
 * 생성자의 매개변수로 들어갈 빌더 객체를 만들어 데이터 뭉치 냄세를 해결한다.
 */
public class Solution_One {
    private String customerName;
    private String customerAddress;
    private String itemName;
    private int quantity;

    /**
     * 팩토리 패턴을 사용하여 Solution_One 인스턴스를 생성하는 팩토리 메서드.
     * 장점 -> OOP 관점에서 캡슐화가 잘 된다. / 종속성을 자동 주입하기 때문에 결합도를 낮출 수 있다.
     * @return
     */
    public static Solution_One_Builder solutionBuilder(){
        return new Solution_One_Builder();
    }
    /**
     * 빌더 패턴을 사용하여 생성자에 몰려있는 데이터 뭉치를 해결함.
     * 장점 -> 중복을 최소화 할 수 있다. / 가독성을 높일 수 있다.
     * @param builder
     */
    private Solution_One(Solution_One_Builder builder) {
        this.customerName = builder.getCustomerName();
        this.customerAddress = builder.getCustomerAddress();
        this.itemName = builder.getItemName();
        this.quantity = builder.getQuantity();
    }

    // 객체를 통째로 넘기기 기법을 사용해서 데이터 뭉치 냄세 해결
    public void printOrderSummary(Solution_One entity) {
        System.out.println("Customer: " + entity.customerName);
        System.out.println("Address: " + entity.customerAddress);
        System.out.println("Item: " + entity.itemName);
        System.out.println("Quantity: " + entity.quantity);
    }
    public String getCustomerName() {return customerName;}
    public String getCustomerAddress() {return customerAddress;}
    public String getItemName() {return itemName;}
    public int getQuantity() {return quantity;}

    // Solution_One 생성자 생성을 위임 받은 정적 내부 클래스
        public static class Solution_One_Builder {
        private String customerName;
        private String customerAddress;
        private String itemName;
        private int quantity;
        public Solution_One_Builder setCustomerAddress(String customerAddress) {
            this.customerAddress = customerAddress;
            return this;
        }
        public Solution_One_Builder setCustomerName(String customerName){
            this.customerName = customerName;
            return this;
        }
        public Solution_One_Builder setItemName(String itemName) {
            this.itemName = itemName;
            return this;
        }
        public Solution_One_Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }
        public Solution_One build(){
            return new Solution_One(this);
        }
        private String getCustomerName() {return customerName;}
        private String getCustomerAddress() {return customerAddress;}
        private String getItemName() {return itemName;}
        private int getQuantity() {return quantity;}
    }
}
