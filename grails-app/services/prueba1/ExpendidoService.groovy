package prueba1

import grails.gorm.services.Service

@Service(Expendido)
interface ExpendidoService {

    Expendido get(Serializable id)

    List<Expendido> list(Map args)

    Long count()

    void delete(Serializable id)

    Expendido save(Expendido expendido)

}