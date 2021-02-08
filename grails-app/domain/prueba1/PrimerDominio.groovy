package prueba1

class PrimerDominio {
    String frutas;
    String sabores;
    static constraints = {
        frutas blank: false, size: 5..150
    }
}
