package groovyempire

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import groovyempire.banking.Account
import groovyempire.banking.Bank
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */

@TestFor(Account)
@Mock([Entity,Owner,Bank])
class AccountSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Create account for a bank"() {
        given:
        def bankOwner =  Owner.establish("Alidad",EntityType.INDIVIDUAL)
        def bank = Bank.establishBank("US-BANK",bankOwner,1000)

        def accountOwner =  Owner.establish("Alidad",EntityType.INDIVIDUAL)
        when:
        def account = bank.establishAccount(accountOwner,100)

        then:
        account.amount == 100
        account.owner  == accountOnwer

    }
}
