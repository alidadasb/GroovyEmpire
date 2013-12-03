package groovyempire.banking

import groovyempire.Owner
import groovyempire.exceptions.NotEnoughBalanceException

class Account {

    Money balance

    static embedded = ['balance']
    static hasMany = [owners:Owner,transactions:Transaction]
    static belongsTo = [bank:Bank]

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
        balance.plus(money)
        true
    }

    Boolean withdraw(Money money) {
        if (!isFundAvailable(money)) throw new NotEnoughBalanceException()
        balance.minus(money)
        true
    }

    Boolean isFundAvailable(Money money) {
         (this.balance.compareTo(money)>=0)
    }
}
