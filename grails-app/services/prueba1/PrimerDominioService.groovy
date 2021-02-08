package prueba1

import grails.gorm.services.Service

@Service(PrimerDominio)
interface PrimerDominioService {

    PrimerDominio get(Serializable id)

    List<PrimerDominio> list(Map args)

    Long count()

    void delete(Serializable id)

    PrimerDominio save(PrimerDominio primerDominio)

}