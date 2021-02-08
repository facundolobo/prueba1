package prueba1.otro

class OtroController {

    def index() { }
    
    def otroMetodo(){
        render (view: 'nadaQueVer',model:[palabra:'esto es una palabra'])
    }
}
