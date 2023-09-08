package videos.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import videos.entidades.Mascota;
import videos.entidades.Usuario;
import videos.enumenraciones.RazaGatuna;
import videos.enumenraciones.RazaPerruna;
import videos.enumenraciones.SexoHumano;

/**
 *
 * @author paula
 */
public class main {

    public static void main(String[] args) {
        
        //VALORES ENUM RAZA
        System.out.println("----VALOR ENUM RAZA----");
        for (RazaPerruna raza : RazaPerruna.values()) {
            System.out.println(raza);
        }
        
        
        //TRABAJAR CON ENUM COMO CADENA
        //VALOR_ENUM.TOSTRING()
        System.out.println("----ENUM CADENA----");
        String razaInput = "BEAGLE";
        
        for (RazaPerruna raza : RazaPerruna.values()) {
            if(raza.toString().equals(razaInput)){
                System.out.println("Raza input es igual al enum " + raza);
            }
        }
        
        //ALGUNOS METODOS DE ELEMENTOS DEL ENUM
        //COMPARE TO compara con otro valor del enum
        //NAME devuelve el nombre de ese valor de enum
        //ORDINAL devuelve el indice
        
        //UTILIZAR EL ENUM EN UN OBJETO
        System.out.println("----ENUM EN OBJETO----");
        Usuario u = new Usuario();
        u.setSexo(SexoHumano.MUJER);
        System.out.println(u.getSexo());
        
        //UTILIZAR ATRIBUTO DE ENUM DE UN VALOR
        System.out.println("----ATRIBUTO DE ENUM----");
        System.out.println(RazaPerruna.BEAGLE.getCodigo());
        
        //ENUM GENERALIZADO
        System.out.println("----ENUM GENERALIZADO----");
        Mascota m1 = new Mascota<RazaPerruna>("Fer", "Chiquito", "Perro");
        m1.setRaza(RazaPerruna.BEAGLE);
        System.out.println(m1.toString());
        Mascota m2 = new Mascota<RazaGatuna>("Pepa", "Lola", "Gato");
        m2.setRaza(RazaGatuna.NAPANJOSO);
        System.out.println(m2.toString());
        
        //PRACTICANDO RELACIONES, MOSTRANDO RELACIONES DE USO
        System.out.println("----PRACTICANDO RELACIONES----");
        List<Mascota> mascotas = new ArrayList<>(Arrays.asList(m1,m2));
        u.setApellido("Fiorde");
        u.setSexo(SexoHumano.HOMBRE);
        u.setNacimiento( new Date("01/11/1991") );
        u.setMascotaFavorita(m2);
        u.setMascotas(mascotas);
        System.out.println(u.toString());
        
        
                
    }
    
}
