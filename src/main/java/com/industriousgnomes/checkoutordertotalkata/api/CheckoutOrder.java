package com.industriousgnomes.checkoutordertotalkata.api;

import com.industriousgnomes.checkoutordertotalkata.exception.InvalidItemException;
import com.industriousgnomes.checkoutordertotalkata.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

public class CheckoutOrder {

    private double total = 0;

    Logger logger = Logger.getLogger("CheckoutOrder");

    @Autowired
    private PriceService priceService;

    public void scanItem(String item) {
        scanItem(item, 1);
    }

    public void scanItem(String item, double units) {
        try {
            total += priceService.getPrice(item) * units;
        } catch (InvalidItemException e) {
            logger.info("Invalid item: " + e.getMessage());
        }
    }

    public double getTotal() {
        return total;
    }
}
