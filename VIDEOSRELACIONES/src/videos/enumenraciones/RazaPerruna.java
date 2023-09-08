/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videos.enumenraciones;

/**
 *
 * @author paula
 */
public enum RazaPerruna {
    //cada elememto tiene indice desde 0 a 4 en este caso
    BEAGLE(21312,"Beagle"), COCKER(16273,"Cocker"), PITBULL(71238, "Pitbull"), BORDER_COLLIE(17823,"Border Collie");

    //para el formato bonito (integer, nombre)
    //es necesario programar atributos y constructor
    //para el enum
    private Integer codigo;
    private String valor;
    
    private RazaPerruna(Integer codigo, String valor){
        this.codigo = codigo;
        this.valor = valor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
}
