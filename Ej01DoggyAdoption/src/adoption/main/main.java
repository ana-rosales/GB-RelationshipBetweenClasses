package adoption.main;

import adoption.services.DoggyService;
import adoption.services.PersonService;
import java.util.Scanner;

/**
 *
 * @author paula
 */
public class main {

    private static final Scanner ENT = new Scanner(System.in);

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        DoggyService dogService = new DoggyService();
        boolean opc = true, notUser;
        int sel;
        do {
            notUser = personService.getPerson() == null;
            String title = (notUser)? "MENU" : personService.getPerson().getName().toUpperCase();
            System.out.println("\n-- " + title + " --\n");
            
            if (notUser) {
                System.out.println("1. SIGN UP.");
                System.out.println("2. LOG IN.");
                System.out.println("3. PLACE FOR ADOPTION");
                System.out.println("4. EXIT");
            } else {
                System.out.println("1. ADOPT A DOG.");
                System.out.println("2. ACQUIRED DOGS.");
                System.out.println("3. LOG OUT");
                System.out.println("4. EXIT");
            }
            System.out.print("Select an option from the menu: ");
            sel = sel();

            switch (sel) {
                case 1:
                    if (notUser) {
                        personService.signUp();
                    } else {
                        personService.adoption(dogService);
                    }
                    break;
                case 2:
                    if (notUser) {
                        personService.selectUser();
                    } else {
                        personService.showUser();
                    }
                    break;
                case 3:
                    if (notUser) {
                        dogService.dogRegister();
                    } else {
                        personService.signOut();
                    }
                    break;
                case 4:
                    System.out.print("Exit? Y/N: ");
                    opc = !cont();
                    break;
                default:
                    System.out.println("Please, insert a correct option.");
            }

        } while (opc);

    }

    public static boolean cont() {
        return ENT.nextLine().equalsIgnoreCase("Y");
    }

    public static int sel() {
        int sel = ENT.nextInt();
        ENT.nextLine();
        return sel;
    }
}
