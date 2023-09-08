
package adoption.services;

import adoption.entities.Person;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author paula
 */
public class PersonService {
    private static Scanner ent;
    private static HashMap<String,Person> users;
    private Person p;
    private ServicioDNI dnis;

    public PersonService() {
        ent = new Scanner(System.in);
        users = new HashMap<>();
        dnis = new ServicioDNI();
    }

    public static HashMap<String, Person> getUsers() {
        return users;
    }

    public static void setUsers(HashMap<String, Person> users) {
        PersonService.users = users;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }
    
    public void signUp(){
        Person p = createUser();
        users.put(p.getDocument().toString(), p);
    }
    
    public Person createUser(){
        System.out.println("\n -- SIGN UP -- \n");
        Person p = new Person();
        System.out.print("First name: ");
        p.setName(ent.nextLine());
        System.out.print("Last name: ");
        p.setLastName(ent.nextLine());
        System.out.print("Age: ");
        p.setAge(ent.nextInt());
        ent.nextLine();
        p.setDocument(dnis.createDNI());
        return p;
    }
    
    public void selectUser(){
        showUsers();
        System.out.println("\n -- LOG IN -- \n");
        System.out.print("DNI = ");
        String dni = ent.nextLine();
        p = users.get(dni);
        if(p == null){
            System.out.println("The DNI you wrote is incorrect.");
        }
    }
    
    public boolean showUsers(){
        System.out.println("\n -- USERS -- \n");
        if(users.size()>0){
            for (Map.Entry<String, Person> entry : users.entrySet()) {
                String key = entry.getKey();
                Person value = entry.getValue();
                System.out.println(" - " + key + " : " + value);
            }
            return true;
        } else {
            System.out.println("There are no registered users.");
            return false;
        }
        
    }
    
    /**
     * Method that keeps a new dog into the hash map of dogs of the person.
     * @param dogser 
     */
    public void adoption(DoggyService dogser){
        //if there is a selected user and the dog pound isn't empty then it's
        //possible to do the adoption
        if(p != null && dogser.availableDogs()){
            p.adopt(dogser.dogSelection());
            users.put(p.getDocument().toString(), p); //actualizar info en hashmap
            System.out.println("Full adoption!");
        } else {
            System.out.println("Unsuccesful operation.");
        }
    }
    
    public void mostrarUsuario(){
        System.out.println("\n--ADOPCIONES REALIZADAS--\n");
        p.showAdoptedDogs();
    }
    
    public void salir(){
        p = null;
    }
    
}
