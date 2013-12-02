package groovyempire

class Owner implements GroovyEmpireEntity {
    Entity entity

    static Owner establish(name,type){
        new Owner(entity: Entity.establish(type,name)).save(flush:true,failOnError: true)
    }

    String getName(){entity.name}

    static constraints = {
    }

}
