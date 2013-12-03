package groovyempire

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import groovyempire.banking.Bank
import groovyempire.banking.Money
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */

@TestFor(Bank)
@Mock([Owner, Entity])
class BankSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Create bank account"() {
        given:
        def owner = Owner.establish("Alidad", EntityType.INDIVIDUAL)

        when:
        def bank = Bank.establishBank("US-BANK", owner, new Money(1000))

        then:
        bank.name == "US-BANK"
        bank.balance == new Money(1000)
        bank.owner.name == "Alidad"
    }

}
