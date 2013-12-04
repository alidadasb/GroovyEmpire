package groovyempire.land

import groovyempire.exceptions.NoMoreLandAvailableException

/**
 * Created by Alidad on 12/3/13.
 */
class Land {
    String name
    Long purchasedPrice
    Long currentPrice

    Land(){}

    static Land establish(Map map){
        checkTotalCount(map.city)
        new Land(map).save(failOnError: true)
    }

    private static void checkTotalCount(city) {
        if (Land.countByCity(city) >= city.landSize) {
            throw new NoMoreLandAvailableException()
        }
    }

    static belongsTo = [city:City]

    static constraints = {
    }

    static mapping = {
        name nullable:true
    }
}
