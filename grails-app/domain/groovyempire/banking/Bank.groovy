package groovyempire.banking

import groovyempire.Entity
import groovyempire.EntityType
import groovyempire.GroovyEmpireEntity
import groovyempire.Owner

class Bank implements GroovyEmpireEntity {
    Entity entity

    Long amount

    static hasMany = [accounts:Account]
    Owner owner


    static constraints = {
    }

    static Bank establishBank(name,owner,initialInvestment){
        def newBank = new Bank(owner:owner,amount: initialInvestment)
        newBank.entity = Entity.establish(EntityType.ENTERPRISE,name)
        newBank.save(flush:true)
    }


    Account establishAccount(owner,amount){
        def newAccount = Account.establish(owner,this,amount)
        this.accounts << newAccount
        this.save(flush: true)
    }

    String getName(){
        entity.name
    }

}
