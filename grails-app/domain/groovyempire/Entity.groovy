package groovyempire

/**
 * Created by Alidad on 9/12/13.
 */

class Entity {
    EntityType type
    String code
    String name

    Date dateCreated
    Date lastUpdated

    static String nextCode() {
         UUID.randomUUID()
    }

    static Entity establish(type,name){
        new Entity(type:type,code:Entity.nextCode(),name:name).save(flush:true,failOnError: true)
    }

    static constraints= {
        code unique:true
    }

    static mapping = {
        sort id:"desc"
    }


    String toString() { return name }
}
