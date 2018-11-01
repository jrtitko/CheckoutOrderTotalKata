package com.industriousgnomes.checkoutordertotalkata.service

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
class PriceServiceImplTest extends Specification {

    @Subject
    PriceService priceService

    private Map<String, Double> itemPrices = new HashMap<>();

    void setup() {
        itemPrices.put("bread", 1.00d)
        itemPrices.put("milk", 3.16d)

        priceService = new PriceServiceImpl(
                itemPrices: itemPrices
        )
    }

    def "Should get the price of #item"() {
        when:
            def price = priceService.getPrice(item)

        then:
            price == itemPrice

        where:
            item    | itemPrice
            "bread" | 1.00
            "milk"  | 3.16
    }

    def "Should throw an InvalidItemException if the item cannot be found"() {
        given:
            def item = "tofu"

        when:
            priceService.getPrice(item)

        then:
            def e = thrown(InvalidItemException)
            e.getMessage() == "tofu"
    }
}
