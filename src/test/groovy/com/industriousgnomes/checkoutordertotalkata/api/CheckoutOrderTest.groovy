package com.industriousgnomes.checkoutordertotalkata.api

import com.industriousgnomes.checkoutordertotalkata.service.PriceService
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

/*
    IntelliJ IDEA Commands and shortcuts used during this course can be found at
    https://github.com/jrtitko/CheckoutOrderTotalKata/blob/master/IntelliJ%20IDEA%20Commands%20%26%20Shortcuts.md

    An basic explanation of the Spock Framework annotations and structure can be found at
    https://github.com/jrtitko/CheckoutOrderTotalKata/blob/master/Spock.md
 */

/*
    Items to scan, if it is weighed, and prices that we will use in this course.
    ItemToScan  | Weighed | Price
    Bread       | No      | 1.00
    Milk        | No      | 3.16
    Bananas     | Yes     | 0.50
    Cheese      | Yes     | 2.00
 */

@Unroll
class CheckoutOrderTest extends Specification {

    @Subject
    CheckoutOrder checkoutOrder

    PriceService priceService = Mock()

    void setup() {
        checkoutOrder = new CheckoutOrder(
                priceService: priceService
        )

        priceService.getPrice("bread") >> 1.00
        priceService.getPrice("milk")  >> 3.16
    }

    def "Should successfully scan an item"() {
        given:
            def itemToScan = "bread"

        when:
            checkoutOrder.scanItem(itemToScan)

        then:
            noExceptionThrown()
    }

    def "Should retrieve the value of scanned item #itemToScan"() {
        given:
            checkoutOrder.scanItem(itemToScan)

        when:
            def total = checkoutOrder.getTotal()

        then:
            total == price

        where:
            itemToScan | price
            "bread"    | 1.00
            "milk"     | 3.16
    }

    def "Should scan multiple items together into a running total"() {
        given:
            checkoutOrder.scanItem("bread")
            checkoutOrder.scanItem("milk")

        when:
            def total = checkoutOrder.getTotal()

        then:
            total == 4.16
    }

    def "Should successfully scan an item with a price by weight"() {
        given:
            def itemToScan = "bananas"
            def weight = 1.6

        when:
            checkoutOrder.scanItem(itemToScan, weight)

        then:
            noExceptionThrown()
    }

    def "Should retrieve the value of a scanned item with a price by weight"() {
        given:
            checkoutOrder.scanItem("bananas", 1.6)

        when:
            def total = checkoutOrder.getTotal()

        then:
            total == 0.80
    }
}
