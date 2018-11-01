package com.industriousgnomes.checkoutordertotalkata.service

import com.industriousgnomes.checkoutordertotalkata.exception.InvalidItemException
import com.industriousgnomes.checkoutordertotalkata.strategy.Pricing
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
class PriceServiceImplTest extends Specification {

    @Subject
    PriceService priceService

    private Map<String, Double> itemPrices = new HashMap<>();

    Pricing breadPricing = Mock()
    Pricing milkPricing = Mock()
    Pricing soupPricing = Mock()

    void setup() {
        breadPricing.calculatePrice() >> 1.00
        milkPricing.calculatePrice() >> 3.16
        soupPricing.calculatePrice() >> 0.50

        itemPrices.put("bread", breadPricing)
        itemPrices.put("milk", milkPricing)
        itemPrices.put("soup", soupPricing)

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

    def "Should retrieve the price of a marked down item"() {
        given:
            def item = "soup"

        when:
            def price = priceService.getPrice(item);

        then:
            price == 0.50
    }

}
