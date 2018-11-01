package com.industriousgnomes.checkoutordertotalkata.api;

public class CheckoutOrder {

    private double total = 0;

    public void scanItem(String item) {
        total = 1.00;
    }

    public double getTotal() {
        return total;
    }
}
