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

    void "Creating Individual"() {
        given:
        def individual = new Entity( name:'Ali',type:EntityType.INDIVIDUAL,code:"12312").save()
        def id = individual.id

        when:
        def ind = Entity.get(id)

        then:
        ind.name == "Ali"
        ind.type.toString()=="Individual"
        ind.code == "12312"
    }

    void "Creating Enterprise"() {
        given:
        def individual = new Entity( name:'Google',type:EntityType.ENTERPRISE,code:"12312").save()
        def id = individual.id

        when:
        def ind = Entity.get(id)

        then:
        ind.name == "Google"
        ind.type.toString()=="Enterprise"
        ind.code == "12312"
    }
}
