package com.industriousgnomes.checkoutordertotalkata

import com.industriousgnomes.checkoutordertotalkata.api.CheckoutOrder
import com.industriousgnomes.checkoutordertotalkata.service.PriceService
import com.industriousgnomes.checkoutordertotalkata.service.PriceServiceImpl
import spock.lang.Specification
import spock.lang.Subject

class CheckoutOrderIT extends Specification {

    @Subject
    CheckoutOrder checkoutOrder

    PriceService priceService;

    void setup() {
        Map<String, Double> prices = new HashMap<>();
        prices.put("bread", 1.00)
        prices.put("milk", 3.16)

        priceService = new PriceServiceImpl(
                prices: prices
        )

        checkoutOrder = new CheckoutOrder(
                priceService: priceService
        )
    }

    def "Should get an order total using the PriceService"() {
        given:
            checkoutOrder.scanItem("bread")
            checkoutOrder.scanItem("milk")

        when:
            def total = checkoutOrder.getTotal();

        then:
            total == 4.16
    }
}
