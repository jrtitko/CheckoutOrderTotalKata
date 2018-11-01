package com.industriousgnomes.checkoutordertotalkata

import com.industriousgnomes.checkoutordertotalkata.api.CheckoutOrder
import com.industriousgnomes.checkoutordertotalkata.service.PriceService
import com.industriousgnomes.checkoutordertotalkata.service.PriceServiceImpl
import com.industriousgnomes.checkoutordertotalkata.strategy.MarkdownPricingImpl
import com.industriousgnomes.checkoutordertotalkata.strategy.Pricing
import com.industriousgnomes.checkoutordertotalkata.strategy.StandardPricingImpl
import spock.lang.Specification
import spock.lang.Subject

class CheckoutOrderIT extends Specification {

    @Subject
    CheckoutOrder checkoutOrder

    PriceService priceService;

    Pricing breadPricing = new StandardPricingImpl(1.00)
    Pricing milkPricing = new StandardPricingImpl(3.16)
    Pricing bananasPricing = new StandardPricingImpl(0.50)
    Pricing cheesePricing = new StandardPricingImpl(2.00)
    Pricing soupPricing = new MarkdownPricingImpl(0.75, 0.25)

    void setup() {
        Map<String, Double> prices = new HashMap<>();
        prices.put("bread", breadPricing)
        prices.put("milk", milkPricing)
        prices.put("bananas", bananasPricing)
        prices.put("cheese", cheesePricing)
        prices.put("soup", soupPricing)

        priceService = new PriceServiceImpl(
                itemPrices: prices
        )

        checkoutOrder = new CheckoutOrder(
                priceService: priceService
        )
    }

    def "Should get an order total using the PriceService"() {
        given:
            checkoutOrder.scanItem("bread")
            checkoutOrder.scanItem("milk")
            checkoutOrder.scanItem("bananas", 1.6)
            checkoutOrder.scanItem("cheese", 1.25)
            checkoutOrder.scanItem("soup")

        when:
            def total = checkoutOrder.getTotal();

        then:
            total == 7.96
    }
}
