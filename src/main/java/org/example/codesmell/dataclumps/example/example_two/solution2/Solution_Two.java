package org.example.codesmell.dataclumps.example.example_two.solution2;

public class Solution_Two {
        private String customerName;
        private String customerAddress;
        private String itemName;
        private int quantity;

        /**
         * 팩토리 패턴을 사용하여 Solution_One 인스턴스를 생성하는 팩토리 메서드.
         * 장점 -> OOP 관점에서 캡슐화가 잘 된다. / 종속성을 자동 주입하기 때문에 결합도를 낮출 수 있다.
         * @return
         */

        public static FactorySolutionTwoImpl Solution_Two_Builder(){
            return new FactorySolutionTwoImpl();
        }

    public Solution_Two(FactorySolutionTwoImpl factory) {
        this.customerName = factory.getCustomerName();
        this.customerAddress = factory.getCustomerAddress();
        this.itemName = factory.getItemName();
        this.quantity = factory.getQuantity();
    }

        /**
         * 빌더 패턴을 사용하여 생성자에 몰려있는 데이터 뭉치를 해결함.
         * 장점 -> 중복을 최소화 할 수 있다. / 가독성을 높일 수 있다.
         * @param
         */
        /*private Solution_Two(FactorySolutionImpl factory) {
            this.customerName = factory.getCustomerName();
            this.customerAddress = factory.getCustomerAddress();
            this.itemName = factory.getItemName();
            this.quantity = factory.getQuantity();
        }*/

        // 객체를 통째로 넘기기 기법을 사용해서 데이터 뭉치 냄세 해결
        public void printOrderSummary(Solution_Two entity) {
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
        // 빌더 클래스
}
