package groovyempire.banking

import groovyempire.Owner

class Account {

    Long balance = 0

    static hasMany = [owners:Owner,transactions:Transaction]
    static belongsTo = [bank:Bank]

    static constraints = {
    }

    static mapping = {
        transactions nullable:true
    }

    static Account establish(owner,bank,balance){
        println "-" * 20
        println "owner:$owner"
        println "bank:$bank"
        println "initial:$balance"
        println "-" * 20
        def newAccount = new Account(bank:bank,balance:balance,owners:[owner])
        newAccount.save(flush: true,failOnError: true)
    }
}
