/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videos.entidades;

import java.util.List;

/**
 *
 * @author paula
 */
public class Persona {
    //ASOCIACION INVERSA
    
    //una persona usa muchos autos
    private List<Auto> autos;
    
    //ASOCIACION RECURSIVA
    
    //en una red social, una persona tiene amigos que igual son personas
    private List<Persona> amigos;
    
}
