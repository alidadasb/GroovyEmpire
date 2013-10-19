package groovyempire.banking

import groovyempire.Entity

class Bank {

    Entity entity
    String name

    static hasMany = [accounts:Account]



    static constraints = {
    }
}
