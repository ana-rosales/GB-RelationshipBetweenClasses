package adoption.entities;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;

public class Person {

    private String name;

    private String lastName;

    private int age;

    private DNI document;

    private HashMap<Integer, Dog> adoptedDogs;

    public Person(String name, String lastName, int age, DNI document) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.document = document;
        this.adoptedDogs = new HashMap<>();
    }

    public Person() {
        adoptedDogs = new HashMap<>();
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

    public DNI getDocument() {
        return document;
    }

    public void setDocument(DNI document) {
        this.document = document;
    }

    public HashMap<Integer, Dog> getAdoptedDogs() {
        return adoptedDogs;
    }

    public void setAdoptedDogs(HashMap<Integer, Dog> adoptedDogs) {
        this.adoptedDogs = adoptedDogs;
    }

    /**
     * Method that keeps a dog in the hash map of dogs that belong to the person,
     * as it is a hash map, there cannot be more than one register of one dog.
     * @param d
     */
    public void adopt(Entry<Integer, Dog> dog) {
        adoptedDogs.put(dog.getKey(),dog.getValue());
    }

    /**
     * Method that generates a String with the information of the dogs that
     * belong to the person.
     */
    public void showAdoptedDogs() {
        if(adoptedDogs.size()>0){
            System.out.println("\n -- ACQUIRED DOGS -- \n");
            for (Dog dog: adoptedDogs.values()) {
                System.out.println("\t - " + dog);
            }
        } else {
            System.out.println("You haven't got a puppy yet.");
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.lastName);
        hash = 41 * hash + this.age;
        hash = 41 * hash + Objects.hashCode(this.document);
        hash = 41 * hash + Objects.hashCode(this.adoptedDogs);
        return hash;
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
        if (!Objects.equals(this.document, other.document)) {
            return false;
        }
        if (!Objects.equals(this.adoptedDogs, other.adoptedDogs)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User = " + name + " " + lastName + ", age= " + age + ", DNI= " + document;
    }

}
