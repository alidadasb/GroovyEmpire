package groovyempire.banking

/**
 * Created by Alidad on 9/12/13.
 */
class Transaction {
    Money amount
    Account account
    String description
    TransactionType transactionType

    static embedded = ['amount']

    static mapping = {
        description nullable: true,blank:true
    }

    Date dateCreated
    Date lastUpdated

    static Transaction establish(Account from, Money money, TransactionType transactionType, description) {
        def tx = new Transaction(account: from, transactionType: transactionType, amount: money, description: description)
        tx.save(flush: true, failOnError: true)
    }

    static belongsTo = [account: Account]


}
