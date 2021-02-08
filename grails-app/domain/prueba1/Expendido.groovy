package prueba1

class Expendido {
    
    String cadena
    int entero
    Date fecha
    boolean booleano
    Byte bit_attr
    
    static constraints = {
        cadena size: 1..50 , unique:true , blank:false
        entero inList:[1,2,3]
        fecha nullable:true
    }
    
    static mapping={
        table 'tabla_extendida'
        version false
        cadena column: 'columna_cadena' 
    }
}
