package groovyempire

import grails.buildtestdata.mixin.Build
import grails.test.mixin.TestFor
import groovyempire.banking.Account
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */

@Build(Entity)
@TestFor(Account)
class AccountSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Create account for entity"() {
        given:
        def entity = Entity.build(code:"123",type:EntityType.ENTERPRISE)
        when:
        def account = new Account(entity:entity)

        then:
        account.balance == 0

    }
}
