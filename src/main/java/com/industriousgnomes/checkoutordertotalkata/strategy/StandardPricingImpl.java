package com.industriousgnomes.checkoutordertotalkata.strategy;

public class StandardPricingImpl implements Pricing {

    private double price;

    public StandardPricingImpl(double price) {
        this.price = price;
    }

    @Override
    public double calculatePrice() {
        return price;
    }
}
