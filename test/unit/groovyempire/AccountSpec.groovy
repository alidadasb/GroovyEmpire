package groovyempire

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import groovyempire.banking.Account
import groovyempire.banking.Bank
import groovyempire.banking.Money
import groovyempire.banking.Transaction
import groovyempire.banking.TransactionType
import groovyempire.exceptions.NotEnoughBalanceException
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */

@TestFor(Account)
@Mock([Entity, Owner, Bank, Transaction])
class AccountSpec extends Specification {

    Account account

    def setup() {
        def bankOwner = Owner.establish("Alidad", EntityType.INDIVIDUAL)
        def bank = Bank.establishBank("US-BANK", bankOwner, new Money(1000))
        def accountOwner = bankOwner
        account = bank.establishAccount(accountOwner, new Money(100))
    }

    def cleanup() {
    }

    void "Deposit to bank account"() {
        given:

        when:
        account.deposit(new Money(150))

        then:
        account.balance == new Money(250)
    }

    void "Withdraw from bank account"() {
        given:

        when:
        account.withdraw(new Money(20))

        then:
        account.balance == new Money(80)
    }

    void "Withdraw more than balance should return error "() {
        given:
        when:
        account.withdraw(new Money(200))

        then:
        account.balance == new Money(100)
        thrown(NotEnoughBalanceException)
    }

    void "Each deposit should generate a transaction record"() {
        given:
        when:
        account.deposit(new Money(50))

        then:
        account.balance == new Money(150)
        def savedTransaction = Transaction.findByAccount(account)

        savedTransaction
        savedTransaction.amount == new Money(50)
        savedTransaction.transactionType == TransactionType.DEPOSIT
    }
    void "Each withdrawal should generate a transaction record"() {
        given:
        when:
        account.withdraw(new Money(10))

        then:
        account.balance == new Money(90)
        def savedTransaction = Transaction.findByAccount(account)

        savedTransaction
        savedTransaction.amount == new Money(10)
        savedTransaction.transactionType == TransactionType.WITHDRAW
    }
}
