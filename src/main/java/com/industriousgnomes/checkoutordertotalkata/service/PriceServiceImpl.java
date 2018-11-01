package com.industriousgnomes.checkoutordertotalkata.service;

import com.industriousgnomes.checkoutordertotalkata.exception.InvalidItemException;

import java.util.HashMap;
import java.util.Map;

public class PriceServiceImpl implements PriceService {

    private Map<String, Double> itemPrices = new HashMap<>();

    @Override
    public double getPrice(String item) throws InvalidItemException {
        return itemPrices.get(item);
    }
}
