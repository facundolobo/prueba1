package prueba1

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ExpendidoServiceSpec extends Specification {

    ExpendidoService expendidoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Expendido(...).save(flush: true, failOnError: true)
        //new Expendido(...).save(flush: true, failOnError: true)
        //Expendido expendido = new Expendido(...).save(flush: true, failOnError: true)
        //new Expendido(...).save(flush: true, failOnError: true)
        //new Expendido(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //expendido.id
    }

    void "test get"() {
        setupData()

        expect:
        expendidoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Expendido> expendidoList = expendidoService.list(max: 2, offset: 2)

        then:
        expendidoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        expendidoService.count() == 5
    }

    void "test delete"() {
        Long expendidoId = setupData()

        expect:
        expendidoService.count() == 5

        when:
        expendidoService.delete(expendidoId)
        sessionFactory.currentSession.flush()

        then:
        expendidoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Expendido expendido = new Expendido()
        expendidoService.save(expendido)

        then:
        expendido.id != null
    }
}
