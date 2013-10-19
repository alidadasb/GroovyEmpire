package groovyempire

import grails.test.mixin.TestFor
import groovyempire.banking.Bank
import spock.lang.Specification
import grails.buildtestdata.mixin.Build

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */

@Build(Entity)
@TestFor(Bank)
class BankSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Create bank account"() {
        given:
        def entity = Entity.build()

        when:
        def bank = new Bank(entity: entity,name:"US-BANK").save()

        then:
        bank.name == "US-BANK"
    }

    void "Create bank with Account"(){

    }
}
