package groovyempire.land

/**
 * Created by Alidad on 12/3/13.
 */
class City {
    String name
    Long population
    Long attractionIndex
    Integer landSize
    Long basePrice

    static hasMany = [lands: Land]

    static constraints = {
        attractionIndex max: 100l
    }

    static City establish(name,attractionIndex, population, landSize, basePrice) {
        City.withTransaction {
            new City(
                    name: name,
                    population: population,
                    attractionIndex: attractionIndex,
                    landSize: landSize,
                    basePrice: basePrice,

            ).save(failOnError: true)
        }
    }


}
