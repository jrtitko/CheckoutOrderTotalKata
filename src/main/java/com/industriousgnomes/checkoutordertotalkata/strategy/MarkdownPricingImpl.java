package com.industriousgnomes.checkoutordertotalkata.strategy;

public class MarkdownPricingImpl implements Pricing {

    private double price;
    private double markdown;

    public MarkdownPricingImpl(double price, double markdown) {
        this.price = price;
        this.markdown = markdown;
    }

    @Override
    public double calculatePrice() {
        return price - markdown;
    }
}
