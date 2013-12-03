package groovyempire

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class EntitySpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Create an owner"() {
        given:

        when:
        def entity = Entity.establish(EntityType.INDIVIDUAL, "Alidad")

        then:
        entity.name == "Alidad"
        entity.type == EntityType.INDIVIDUAL
    }

}
