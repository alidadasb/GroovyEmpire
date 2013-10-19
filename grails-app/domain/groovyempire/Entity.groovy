package groovyempire

/**
 * Created by Alidad on 9/12/13.
 */
class Entity {
    EntityType type
    String code
    String name

    String toString(){return name}
}

enum EntityType {
    ENTERPRISE,
    INDIVIDUAL

    String toString(){

        return (this==EntityType.INDIVIDUAL)?"Individual":"Enterprise"
    }
}
