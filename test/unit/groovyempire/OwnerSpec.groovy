package groovyempire

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Owner)
@Mock([Entity])
class OwnerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Create an owner"() {
        given:

        when:
        def owner = Owner.establish("Alidad", EntityType.INDIVIDUAL)

        then:
        owner.name == "Alidad"
        owner.entity.type == EntityType.INDIVIDUAL
    }
}
