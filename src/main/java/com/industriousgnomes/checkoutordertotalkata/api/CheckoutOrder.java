package com.industriousgnomes.checkoutordertotalkata.api;

import com.industriousgnomes.checkoutordertotalkata.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckoutOrder {

    private double total = 0;

    @Autowired
    private PriceService priceService;

    public void scanItem(String item) {
        scanItem(item, 1);
    }

    public void scanItem(String item, double units) {
        total += priceService.getPrice(item) * units;
    }

    public double getTotal() {
        return total;
    }
}
