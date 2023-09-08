
package videos.entidades;

import java.util.Date;
import java.util.List;
import videos.enumenraciones.SexoHumano;

/**
 *
 * @author paula
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private Integer dni;
    private Date nacimiento;
    private String pais;
    private SexoHumano sexo;
    private Mascota mascotaFavorita; //asociacion simple
    private List<Mascota> mascotas; //asociacion uno muchos

    
    public Usuario() {
        //RELACION DE USO, MUY DEBIL
        //APARECE EN EL METODO EN EL QUE SE USA
        //Y LUEGO DESAPARECE
        
        double PI = Math.PI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public SexoHumano getSexo() {
        return sexo;
    }

    public void setSexo(SexoHumano sexo) {
        this.sexo = sexo;
    }

    public Mascota getMascotaFavorita() {
        return mascotaFavorita;
    }

    public void setMascotaFavorita(Mascota mascotaFavorita) {
        this.mascotaFavorita = mascotaFavorita;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", nacimiento=" + nacimiento + ", pais=" + pais + ", sexo=" + sexo + ",\n mascotaFavorita=" + mascotaFavorita + ", \nmascotas=" + mascotas + '}';
    }

}
