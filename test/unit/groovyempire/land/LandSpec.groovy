package groovyempire.land

import grails.test.mixin.Mock
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import groovyempire.exceptions.NoMoreLandAvailableException
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@Mock([Land,City,LandOwnership])
class LandSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Establish a city"() {
        given:
        def columbus = City.establish('Columbus',65, 1000000,200,1)
        expect:
        City.findByName('Columbus')
    }

    void "Established city cannot have land more than landsize"() {
        given:
        def columbus = City.establish('Columbus',65, 1000000,3,1)

        when:
        def land
        land = Land.establish(name: '1',purchasedPrice: 1,currentPrice: 1,city:columbus)
        columbus.addToLands(land)

        land = Land.establish(name: '2',purchasedPrice: 1,currentPrice: 1,city:columbus)
        columbus.addToLands(land)

        land = Land.establish(name: '3',purchasedPrice: 1,currentPrice: 1,city:columbus)
        columbus.addToLands(land)

        land = Land.establish(name: '4',purchasedPrice: 1,currentPrice: 1,city:columbus)
        columbus.addToLands(land)

        columbus.save(flush:true)

        then:
        thrown(NoMoreLandAvailableException)
    }
}
