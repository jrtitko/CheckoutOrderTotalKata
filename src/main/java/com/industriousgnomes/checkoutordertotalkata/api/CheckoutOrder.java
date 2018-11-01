package com.industriousgnomes.checkoutordertotalkata.api;

public class CheckoutOrder {

    private double total = 0;

    public void scanItem(String item) {
        if (item.equalsIgnoreCase("bread")) {
            total = 1.00;
        } else if (item.equalsIgnoreCase("milk")) {
            total = 3.16;
        }
    }

    public double getTotal() {
        return total;
    }
}
