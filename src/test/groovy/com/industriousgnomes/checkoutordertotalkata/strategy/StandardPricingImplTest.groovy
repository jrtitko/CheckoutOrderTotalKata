package com.industriousgnomes.checkoutordertotalkata.strategy

import spock.lang.Specification
import spock.lang.Subject

class StandardPricingImplTest extends Specification {

    @Subject
    StandardPricingImpl standardPricing

    def "Should calculate the standard price of an item"() {
        given:
            standardPricing = new StandardPricingImpl(1.00)

        when:
            def price = standardPricing.calculatePrice()

        then:
            price == 1.00
    }
}
