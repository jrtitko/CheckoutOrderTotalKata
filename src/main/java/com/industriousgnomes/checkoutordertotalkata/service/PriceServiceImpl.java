package com.industriousgnomes.checkoutordertotalkata.service;

import java.util.Map;

public class PriceServiceImpl implements PriceService {

    private Map<String, Double> prices;

    @Override
    public double getPrice(String item) {
        if (item.equalsIgnoreCase("bread")) {
            return 1.00;
        } else if (item.equalsIgnoreCase("milk")) {
            return 3.16;
        }
        return 0.0;
    }
}
