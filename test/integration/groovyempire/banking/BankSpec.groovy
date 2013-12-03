package groovyempire.banking

import groovyempire.EntityType
import groovyempire.Owner
import spock.lang.*

/**
 *
 */
class BankSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Create a bank"() {
        given:


        when:
        def bankOwner = Owner.establish("Alidad", EntityType.INDIVIDUAL)
        def bank = Bank.establishBank("US-BANK", bankOwner, new Money(1000))

        def accountOwner = Owner.establish("Alidad LLC", EntityType.ENTERPRISE)
        def account = bank.establishAccount(accountOwner, new Money(100))


        then:
        bankOwner.name == "Alidad"
        bank.name == "US-BANK"
        bank.balance == new Money(1000)

        accountOwner.name == "Alidad LLC"
        account.balance == new Money(100)

        account.withdraw(new Money(10))
        account.balance == new Money(90)

        account.deposit(new Money(5))
        account.balance == new Money(95)
    }
}
