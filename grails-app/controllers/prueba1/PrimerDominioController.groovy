package prueba1

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import prueba1.PrimerDominio

class PrimerDominioController {

    PrimerDominioService primerDominioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond primerDominioService.list(params), model:[primerDominioCount: primerDominioService.count()]
    }

    def show(Long id) {
        respond primerDominioService.get(id)
    }

    def create() {
        respond new PrimerDominio(params)
    }

    def save(PrimerDominio primerDominio) {
        if (primerDominio == null) {
            notFound()
            return
        }

        try {
            primerDominioService.save(primerDominio)
        } catch (ValidationException e) {
            respond primerDominio.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'primerDominio.label', default: 'PrimerDominio'), primerDominio.id])
                redirect primerDominio
            }
            '*' { respond primerDominio, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond primerDominioService.get(id)
    }

    def update(PrimerDominio primerDominio) {
        if (primerDominio == null) {
            notFound()
            return
        }

        try {
            primerDominioService.save(primerDominio)
        } catch (ValidationException e) {
            respond primerDominio.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'primerDominio.label', default: 'PrimerDominio'), primerDominio.id])
                redirect primerDominio
            }
            '*'{ respond primerDominio, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        primerDominioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'primerDominio.label', default: 'PrimerDominio'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'primerDominio.label', default: 'PrimerDominio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
