package guiarelaciones.entidades;

public class DNI {

    private String serie;

    private int numero;

    public DNI(String serie, int numero) {
        this.serie = serie;
        this.numero = numero;
    }

    public DNI() {
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "DNI{" + "serie=" + serie + ", numero=" + numero + '}';
    }
}
