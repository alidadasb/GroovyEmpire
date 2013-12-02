package groovyempire.banking

/**
 * Created by Alidad on 9/12/13.
 */
class Transaction {
    Long amount
    Account fromAccount
    Account toAccount
    String description

    static belongsTo = [account:Account]



}
