package com.industriousgnomes.checkoutordertotalkata.service;

import java.util.Map;

public class PriceServiceImpl implements PriceService {

    private Map<String, Double> prices;

    @Override
    public double getPrice(String item) {
        return 1.00;
    }
}
