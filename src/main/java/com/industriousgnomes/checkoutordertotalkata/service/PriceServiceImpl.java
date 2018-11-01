package com.industriousgnomes.checkoutordertotalkata.service;

import com.industriousgnomes.checkoutordertotalkata.exception.InvalidItemException;
import com.industriousgnomes.checkoutordertotalkata.strategy.Pricing;

import java.util.HashMap;
import java.util.Map;

public class PriceServiceImpl implements PriceService {

    private Map<String, Pricing> itemPrices = new HashMap<>();

    @Override
    public double getPrice(String item) throws InvalidItemException {
        if (itemPrices.containsKey(item)) {
            return itemPrices.get(item).calculatePrice();
        }
        throw new InvalidItemException(item);
    }
}
