
package adoption.services;

import adoption.entities.Dog;
import adoption.entities.Person;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author paula
 */
public class PersonService {
    private static Scanner ent;
    private static List<Person> users;
    private Person person;

    public PersonService() {
        ent = new Scanner(System.in);
        users = new ArrayList<>();
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
        System.out.print("First name: ");
        String firstName = ent.nextLine();
        System.out.print("Last name: ");
        String lastName = ent.nextLine();
        System.out.print("Age: ");
        int age = ent.nextInt();
        ent.nextLine();
        System.out.print("DNI: ");
        String document = ent.nextLine();
        return new Person(firstName, lastName, age, document);
    }
    
    public void selectUser(){
        if(showUsers()){
            System.out.println("\n -- LOG IN -- \n");
            System.out.print("DNI = ");
            String dni = ent.nextLine();
            for (Person user : users) {
                if (user.getDocument().equals(dni)) {
                    person = user;
                }
            }
            if (person == null) {
                System.out.println("The DNI you wrote is incorrect.");  
            }
        } else {
            System.out.println("\nNo users registered.\n");
        }
        
    }
    
    public boolean showUsers(){
        System.out.println("\n -- USERS -- \n");
        if(users.size()>0){
            Iterator<Person> it = users.iterator();
            while (it.hasNext()) {
                Person next = it.next();
                System.out.println(" - " + next);
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
            Dog selectedDog = dogser.dogSelection();
            if(selectedDog != null){
                person.adopt(selectedDog);
                System.out.println("Full adoption!");
            } else {
                System.out.println("No coincidences match the dog you're looking for.");
            }           
            
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
