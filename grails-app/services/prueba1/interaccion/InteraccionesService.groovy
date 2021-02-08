package prueba1.interaccion

import grails.gorm.transactions.Transactional
import prueba1.PrimerDominio
import otro.OtroDomino

@Transactional
class InteraccionesService {

   
        
        def listarDatos(){
            def lista = PrimerDominio.list()
            
        return lista
       
    }
    

}
