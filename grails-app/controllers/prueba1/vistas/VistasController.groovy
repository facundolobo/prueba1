package prueba1.vistas

import prueba1.interaccion.InteraccionesService

class VistasController {
    
    def interaccionesService
    
    def index() { 
    render (view:'index', model:[lista:interaccionesService.listarDatos()])
    }
    
    def otraVentana() {}
    
}
