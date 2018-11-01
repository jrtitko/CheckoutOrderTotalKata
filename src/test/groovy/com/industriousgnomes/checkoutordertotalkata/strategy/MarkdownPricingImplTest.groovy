package com.industriousgnomes.checkoutordertotalkata.strategy

import spock.lang.Specification
import spock.lang.Subject

class MarkdownPricingImplTest extends Specification {

    @Subject
    MarkdownPricingImpl markdownPricing

    def "Should calculate the markdown price of an item"() {
        given:
            markdownPricing = new MarkdownPricingImpl(0.75, 0.25)

        when:
            def price = markdownPricing.calculatePrice()

        then:
            price == 0.50
    }
}
