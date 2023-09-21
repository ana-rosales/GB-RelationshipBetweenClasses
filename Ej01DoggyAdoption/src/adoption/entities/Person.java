package adoption.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Person {

    private String name;

    private String lastName;

    private int age;

    private String document;

    private HashSet<Dog> adoptedDogs;

    public Person(String name, String lastName, int age, String document) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.document = document;
        this.adoptedDogs = new HashSet<>();
    }

    public Person() {
        adoptedDogs = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public HashSet<Dog> getAdoptedDogs() {
        return adoptedDogs;
    }

    public void setAdoptedDogs(HashSet<Dog> adoptedDogs) {
        this.adoptedDogs = adoptedDogs;
    }

    /**
     * Method that keeps a dog in the hash map of dogs that belong to the person,
     * as it is a hash map, there cannot be more than one register of one dog.
     * @param d
     */
    public void adopt(Dog dog) {
        adoptedDogs.add(dog);
    }

    /**
     * Method that generates a String with the information of the dogs that
     * belong to the person.
     */
    public void showAdoptedDogs() {
        if(adoptedDogs.size()>0){
            System.out.println("\n -- ACQUIRED DOGS -- \n");
            for (Dog adoptedDog : adoptedDogs) {
                System.out.println(" - " + adoptedDog);
            }
        } else {
            System.out.println("You haven't got a puppy yet.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (Objects.equals(this.document, other.document)) {
            return true;
        }
        if (!Objects.equals(this.adoptedDogs, other.adoptedDogs)) {
            return false;
        }  
        return true;
    }

    @Override
    public String toString() {
        return "DNI= " + document + ". " + name + " " + lastName;
    }

}
