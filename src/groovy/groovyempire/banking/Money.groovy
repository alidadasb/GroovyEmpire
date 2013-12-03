package groovyempire.banking

/**
 * Created by Alidad on 12/2/13.
 */
import groovy.transform.EqualsAndHashCode
@EqualsAndHashCode
class Money {
    Long amount = 0

    Money(Long money){
        this.amount=money
    }
    Money(){
        this.amount=0
    }

    void minus(Money money) {
        this.amount -= money.amount
    }

    void plus(Money money) {
        this.amount += money.amount
    }

    int compareTo(Money m){
        this.amount <=> m.amount
    }


    String toString(){this.amount}
}
