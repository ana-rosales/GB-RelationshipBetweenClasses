package guiarelaciones;

import guiarelaciones.entidades.DNI;
import guiarelaciones.entidades.Equipo;
import guiarelaciones.entidades.Jugador;
import guiarelaciones.entidades.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class main {

    public static void main(String[] args) {
        System.out.println("\nEJERCICIO 01 PERSONA. Asociacion simple, uno a uno.\n");
        DNI dni = new DNI("AAA", 023112);
        Persona p = new Persona("Ana Paula", "Rosales Olguin", dni);
        System.out.println(p);
        System.out.println("\nEJERCICIO 02 JUGADOR. Asociacion simple, uno a muchos.\n");
        Jugador j1 = new Jugador("Ana Pau", "Rosales", 189, 46378);
        Jugador j2 = new Jugador("Yahir", "Limas", 14, 42783);
        ArrayList<Jugador> jugadores = new ArrayList(Arrays.asList(j1, j2));
        Equipo equipo = new Equipo("Atomico", jugadores);
        Iterator<Jugador> it = equipo.getJugadores().iterator();
        System.out.println("Equipo " + equipo.getNombre());
        while (it.hasNext()) {
            Jugador next = it.next();
            System.out.println(" - " + next);
        }
    }
}
