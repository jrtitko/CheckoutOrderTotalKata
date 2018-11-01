package com.industriousgnomes.checkoutordertotalkata.service;

import com.industriousgnomes.checkoutordertotalkata.exception.InvalidItemException;

public interface PriceService {

    double getPrice(String item) throws InvalidItemException;

}
