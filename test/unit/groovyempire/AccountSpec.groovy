package groovyempire

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import groovyempire.banking.Account
import groovyempire.banking.Bank
import groovyempire.banking.Money
import groovyempire.exceptions.NotEnoughBalanceException
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */

@TestFor(Account)
@Mock([Entity, Owner, Bank])
class AccountSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Create account for a bank"() {
        given:
        def bankOwner = Owner.establish("Alidad", EntityType.INDIVIDUAL)
        def bank = Bank.establishBank("US-BANK", bankOwner, new Money(1000))

        def accountOwner = Owner.establish("Alidad", EntityType.INDIVIDUAL)
        when:
        def account = bank.establishAccount(accountOwner, new Money(100))

        then:
        account.balance == new Money(100)
        account.owners[0] == accountOwner
    }

    void "Deposit to bank account"() {
        given:
        def bankOwner = Owner.establish("Alidad", EntityType.INDIVIDUAL)
        def bank = Bank.establishBank("US-BANK", bankOwner, new Money(1000))
        def accountOwner = bankOwner
        def account = bank.establishAccount(accountOwner, new Money(100))

        when:
        account.deposit(new Money(150))


        then:
        account.balance == new Money(250)
    }

    void "Withdraw from bank account"() {
        given:
        def bankOwner = Owner.establish("Alidad", EntityType.INDIVIDUAL)
        def bank = Bank.establishBank("US-BANK", bankOwner, new Money(1000))
        def accountOwner = bankOwner
        def account = bank.establishAccount(accountOwner, new Money(100))

        when:
        account.withdraw(new Money(20))


        then:
        account.balance == new Money(80)
    }

    void "Withdraw more than balance should return error "() {
        given:
        def bankOwner = Owner.establish("Alidad", EntityType.INDIVIDUAL)
        def bank = Bank.establishBank("US-BANK", bankOwner, new Money(1000))
        def accountOwner = bankOwner
        def account = bank.establishAccount(accountOwner, new Money(100))

        when:
        account.withdraw(new Money(200))


        then:
        account.balance == new Money(100)
        thrown(NotEnoughBalanceException)
    }
}
