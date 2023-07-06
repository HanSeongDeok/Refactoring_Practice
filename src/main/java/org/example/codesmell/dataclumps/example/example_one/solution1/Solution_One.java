package org.example.codesmell.dataclumps.example.example_one.solution1;

/**
 * 방법 1: 메서드 시그니처에 있는 필드 값으로 객체를 만들어 파라미터로 받는다.
 */
public class Solution_One {
        private String solutionName;

        public Solution_One(String solutionName) {
            this.solutionName = solutionName;
        }
        /**
         * Data Clumps Smell 리팩토링 방법 1
         *
         * 기존에 데이터 뭉치로 사용되던 메서드의 시그니처를 클래스 추출 기법을 통해
         * Solution_One_Summary summary 로 빼낸 후 getter 를 통해 데이터 값을 불러온다.
         */
        public void printOrderSummary(Solution_One_Summary summary) {
            System.out.println("Customer: " + summary.getCustomerName());
            System.out.println("Address: " + summary.getCustomerAddress());
            System.out.println("Item: " + summary.getItemName());
            System.out.println("Quantity: " + summary.getQuantity());
        }
    }
