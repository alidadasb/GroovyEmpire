package groovyempire.banking

import groovyempire.EntityType
import groovyempire.Owner
import spock.lang.*

/**
 *
 */
class AccountSpec extends Specification {

    Account account
    def setup() {
        def bankOwner = Owner.establish("Alidad", EntityType.INDIVIDUAL)
        def bank = Bank.establishBank("US-BANK", bankOwner, new Money(1000))

        def accountOwner = Owner.establish("Alidad LLC", EntityType.ENTERPRISE)
        account = bank.establishAccount(accountOwner, new Money(100))
    }

    def cleanup() {
    }


}
