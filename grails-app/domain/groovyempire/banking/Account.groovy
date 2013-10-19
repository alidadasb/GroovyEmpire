package groovyempire.banking

import groovyempire.Entity

class Account {
    Entity entity
    Long balance = 0

    static hasMany = [transactions:Transaction]

    static constraints = {
    }
}
