package groovyempire.banking

import groovyempire.Owner
import groovyempire.exceptions.NotEnoughBalanceException

class Account {

    Money balance

    static embedded = ['balance']
    static hasMany = [owners:Owner,transactions:Transaction]
    static belongsTo = [bank:Bank]

    Date dateCreated
    Date lastUpdated

    static constraints = {
    }

    static mapping = {
        transactions nullable:true
    }

    static Account establish(owner,bank,balance){
        def newAccount = new Account(bank:bank,balance:balance,owners:[owner])
        newAccount.save(flush: true,failOnError: true)
    }

    Boolean deposit(Money money) {
        def transaction = Transaction.establish(this,money,TransactionType.DEPOSIT,"Deposit")
        if(transaction) {
            balance.plus(money)
            return true
        }
        false
    }

    Boolean withdraw(Money money) {
        if (!isFundAvailable(money)) throw new NotEnoughBalanceException()
        def transaction = Transaction.establish(this,money,TransactionType.WITHDRAW,"Withdraw")
        if (transaction){
            balance.minus(money)
            return true
        }
        false
    }

    Boolean isFundAvailable(Money money) {
         (this.balance.compareTo(money)>=0)
    }
}
