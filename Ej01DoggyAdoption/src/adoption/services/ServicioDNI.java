/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adoption.services;

import adoption.entities.DNI;
import java.util.Scanner;

/**
 *
 * @author paula
 */
public class ServicioDNI {
    private static Scanner ent;

    public ServicioDNI() {
        ent = new Scanner(System.in);
    }
    
    public DNI createDNI(){
        System.out.println("Ingresando DNI.");
        DNI documento = new DNI();
        System.out.print("\tIngrese la serie: ");
        documento.setSeries(ent.nextLine());
        System.out.print("\tIngrese el numero: ");
        documento.setNum(ent.nextInt());
        ent.nextLine();
        return documento;
    }
    
    
}