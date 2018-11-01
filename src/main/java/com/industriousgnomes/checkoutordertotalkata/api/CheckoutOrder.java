package com.industriousgnomes.checkoutordertotalkata.api;

import com.industriousgnomes.checkoutordertotalkata.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckoutOrder {

    private double total = 0;

    @Autowired
    private PriceService priceService;

    public void scanItem(String item) {
        total += priceService.getPrice(item);
    }

    public void scanItem(String item, double weight) {
        total += priceService.getPrice(item) * weight;
    }

    public double getTotal() {
        return total;
    }
}
