package com.industriousgnomes.checkoutordertotalkata.api

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

    void setup() {
        checkoutOrder = new CheckoutOrder()
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
}
