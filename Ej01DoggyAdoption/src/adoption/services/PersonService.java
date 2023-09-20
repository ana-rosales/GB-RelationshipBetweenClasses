
package adoption.services;

import adoption.entities.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author paula
 */
public class PersonService {
    private static Scanner ent;
    private static List<Person> users;
    private Person person;
    private ServicioDNI dniService;

    public PersonService() {
        ent = new Scanner(System.in);
        users = new ArrayList<>();
        dniService = new ServicioDNI();
    }

    public static List<Person> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<Person> users) {
        PersonService.users = users;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    public void signUp(){
        Person newUser = createUser();
        users.add(newUser);
    }
    
    public Person createUser(){
        System.out.println("\n -- SIGN UP -- \n");
        Person newUser = new Person();
        System.out.print("First name: ");
        newUser.setName(ent.nextLine());
        System.out.print("Last name: ");
        newUser.setLastName(ent.nextLine());
        System.out.print("Age: ");
        newUser.setAge(ent.nextInt());
        ent.nextLine();
        newUser.setDocument(dniService.createDNI());
        return newUser;
    }
    
    public void selectUser(){
        showUsers();
        System.out.println("\n -- LOG IN -- \n");
        System.out.print("DNI = ");
        String dni = ent.nextLine();
        person = users.get(dni);
        if(person == null){
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
        if(person != null && dogser.availableDogs()){
            person.adopt(dogser.dogSelection());
            users.put(person.getDocument().toString(), person); //actualizar info en hashmap
            System.out.println("Full adoption!");
        } else {
            System.out.println("Unsuccesful operation.");
        }
    }
    
    public void showUser(){
        System.out.println("\n--ADOPTIONS--\n");
        person.showAdoptedDogs();
    }
    
    public void signOut(){
        person = null;
    }
    
}
