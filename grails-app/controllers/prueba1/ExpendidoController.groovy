package prueba1

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ExpendidoController {

    ExpendidoService expendidoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond expendidoService.list(params), model:[expendidoCount: expendidoService.count()]
    }

    def show(Long id) {
        respond expendidoService.get(id)
    }

    def create() {
        respond new Expendido(params)
    }

    def save(Expendido expendido) {
        if (expendido == null) {
            notFound()
            return
        }

        try {
            expendidoService.save(expendido)
        } catch (ValidationException e) {
            respond expendido.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'expendido.label', default: 'Expendido'), expendido.id])
                redirect expendido
            }
            '*' { respond expendido, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond expendidoService.get(id)
    }

    def update(Expendido expendido) {
        if (expendido == null) {
            notFound()
            return
        }

        try {
            expendidoService.save(expendido)
        } catch (ValidationException e) {
            respond expendido.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'expendido.label', default: 'Expendido'), expendido.id])
                redirect expendido
            }
            '*'{ respond expendido, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        expendidoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'expendido.label', default: 'Expendido'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'expendido.label', default: 'Expendido'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
