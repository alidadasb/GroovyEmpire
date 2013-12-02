package groovyempire

/**
 * Created by Alidad on 12/1/13.
 */
public enum EntityType {
    ENTERPRISE,
    INDIVIDUAL



    String toString(){
        return (this==EntityType.INDIVIDUAL)?"Individual":"Enterprise"
    }
}
