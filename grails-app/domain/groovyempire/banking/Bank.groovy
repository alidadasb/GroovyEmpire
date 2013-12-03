package groovyempire.banking

import groovyempire.Entity
import groovyempire.EntityType
import groovyempire.GroovyEmpireEntity
import groovyempire.Owner

class Bank implements GroovyEmpireEntity {
    Entity entity

    Money balance

    static embedded = ['balance']
    static hasMany = [accounts:Account]
    Owner owner

    Date dateCreated
    Date lastUpdated


    static mapping = {
        balance nullable:true
    }
    static constraints = {
    }

    static Bank establishBank(name,owner,Money initialInvestment){
        def newBank = new Bank(owner:owner,balance: initialInvestment)
        newBank.entity = Entity.establish(EntityType.ENTERPRISE,name)
        newBank.save()
    }

    Account establishAccount(owner,Money amount){
        def newAccount = Account.establish(owner,this,amount)
        this.addToAccounts(newAccount)
        this.save()
        newAccount
    }

    String getName(){
        entity.name
    }

}
