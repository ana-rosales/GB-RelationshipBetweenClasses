package adoption.services;

import adoption.entities.Dog;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author paula
 */
public class DoggyService {

    private static Scanner ent;
    private HashMap<Integer, Dog> dogPound;

    public DoggyService() {
        ent = new Scanner(System.in);
        dogPound = new HashMap<>();
    }

    public HashMap<Integer, Dog> getDogPound() {
        return dogPound;
    }

    public void setDogPound(HashMap<Integer, Dog> dogPound) {
        this.dogPound = dogPound;
    }

    public void dogRegister() {
        Dog p = dogCreation();
        getDogPound().put(getDogPound().size() + 101, p);
        System.out.println(getDogPound().size());
    }

    public Dog dogCreation() {
        System.out.println("\n -- DOG REGISTER --\n");
        Dog d = new Dog();
        System.out.print("Name: ");
        d.setName(ent.nextLine());
        System.out.print("Breed: ");
        d.setBreed(ent.nextLine());
        System.out.print("Age: ");
        d.setAge(ent.nextInt());
        ent.nextLine();
        System.out.print("Size: ");
        d.setSize(ent.nextLine());
        return d;
    }

    /**
     * Method that returns a dog from the hash map of the system.
     *
     * @return a dog.
     */
    public Entry<Integer, Dog> dogSelection() {
        System.out.println("\n -- DOG SELECTION --\n");
        System.out.print("Dog's ID: ");
        int sel = ent.nextInt();
        ent.nextLine();

        Entry<Integer, Dog> d = null;
        if (getDogPound().containsKey(sel)) {
            for (Entry<Integer, Dog> entry : getDogPound().entrySet()) {
                if (entry.getKey() == sel) {
                    d = entry;
                    break;
                }
            }
            return d;
        } else {
            System.out.println("Dog not found.");
            return d;
        }
    }

    public boolean availableDogs() {
        System.out.println("\n -- DOGGY STOCK -- \n");
        if (getDogPound().size() > 0) {
            for (Map.Entry<Integer, Dog> entry : getDogPound().entrySet()) {
                Integer key = entry.getKey();
                Dog value = entry.getValue();
                System.out.println(" - " + key + " : " + value);
            }
            return true;
        } else {
            System.out.println("There are no puppies available for the moment :(");
            return false;
        }
    }

}
