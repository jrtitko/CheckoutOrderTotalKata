package com.industriousgnomes.checkoutordertotalkata.service

import spock.lang.Specification
import spock.lang.Subject

class PriceServiceImplTest extends Specification {

    @Subject
    PriceService priceService

    void setup() {
        priceService = new PriceServiceImpl()
    }

    def "Should get the price of an item"() {
        given:
            def item = "bread"

        when:
            def price = priceService.getPrice(item)

        then:
            price == 1.00
    }

    def "Should get the price of a different item"() {
        given:
            def item = "milk"

        when:
            def price = priceService.getPrice(item)

        then:
            price == 3.16
    }
}
