package org.example.codesmell.dataclumps.example.example_two.solution2;

public class Solution_Two_Builder {
        private String customerName;
        private String customerAddress;
        private String itemName;
        private int quantity;
        public Solution_Two_Builder setCustomerAddress(String customerAddress) {
            this.customerAddress = customerAddress;
            return this;
        }
        public Solution_Two_Builder setCustomerName(String customerName){
            this.customerName = customerName;
            return this;
        }
        public Solution_Two_Builder setItemName(String itemName) {
            this.itemName = itemName;
            return this;
        }
        public Solution_Two_Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }
        public String getCustomerName() {return customerName;}
        public String getCustomerAddress() {return customerAddress;}
        public String getItemName() {return itemName;}
        public int getQuantity() {return quantity;}
}
