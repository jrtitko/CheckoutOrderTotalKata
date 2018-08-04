# Spock Framework

### Spock API
    http://spockframework.org/spock/javadoc/1.1-rc-4/index.html

### Spock Test Example

    import spock.lang.Specification
    import spock.lang.Subject
    import spock.lang.Unroll

    @Unroll     // Indicates that iterations of a data-driven feature should be made visible as separate features to the outside world
    class CheckoutOrderTest extends Specification {

        @Subject    // Indicates which objects/classes are the subjects of a specification
        CheckoutOrder checkoutOrder

        def setup() {  // Performs these actions before the start of every test
            checkoutOrder = new CheckoutOrder()
        }

        def cleanup() { // Performs these actions after the end of every test
            
        }

        def "Retrieve the value of the scanned item #itemToScan"() {  // Defines a test case with a unique description of the test
            given:      // Setup specifically required for this test
                checkoutOrder.scanItem(itemToScan)

            when:       // The action that is being tested for this test
                def total = checkoutOrder.getTotal()

            then:       // The assertions for truthy for this test
                noExceptionThrown()
                total == price
            
            where:      // Data-driven inputs for this test.  Each row represents a separate test to be executed.
                itemToScan  | price
                "bread"     | 1.00
                "milk"      | 3.16
        }
    }
