package adoption.services;

import adoption.entities.Dog;
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
        Dog dog = dogCreation();
        getDogPound().put(getDogPound().size() + 101, dog);
        System.out.println(getDogPound().size());
    }

    public Dog dogCreation() {
        System.out.println("\n -- DOG REGISTER --\n");
        Dog dog = new Dog();
        System.out.print("Name: ");
        dog.setName(ent.nextLine());
        System.out.print("Breed: ");
        dog.setBreed(ent.nextLine());
        System.out.print("Age: ");
        dog.setAge(ent.nextInt());
        ent.nextLine();
        System.out.print("Size: ");
        dog.setSize(ent.nextLine());
        return dog;
    }

    /**
     * Method that returns a dog from the hash map of the system.
     *
     * @return a dog.
     */
    public Entry<Integer, Dog> dogSelection() {
        System.out.println("\n -- DOG SELECTION --\n");
        System.out.print("Dog's ID: ");
        int selection = ent.nextInt();
        ent.nextLine();

        Entry<Integer, Dog> dog = null;
        if (getDogPound().containsKey(selection)) {
            for (Entry<Integer, Dog> entry : getDogPound().entrySet()) {
                if (entry.getKey() == selection) {
                    dog = entry;
                    break;
                }
            }
            return dog;
        } else {
            System.out.println("Dog not found.");
            return dog;
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
