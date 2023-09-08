package adoption.main;

import adoption.services.ServicioDNI;
import adoption.services.DoggyService;
import adoption.services.PersonService;
import java.util.Scanner;

/**
 *
 * @author paula
 */
public class main {

    private static Scanner ent = new Scanner(System.in);

    public static void main(String[] args) {
        PersonService spers = new PersonService();
        DoggyService sperr = new DoggyService();
        ServicioDNI sdni = new ServicioDNI();
        boolean opc = true, notUser;
        int sel;
        do {
            notUser = spers.getP() == null;
            String title = (notUser)? "MENU" : spers.getP().getName().toUpperCase();
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
                        spers.signUp();
                    } else {
                        spers.adoption(sperr);
                    }
                    break;
                case 2:
                    if (notUser) {
                        spers.selectUser();
                    } else {
                        spers.mostrarUsuario();
                    }
                    break;
                case 3:
                    if (notUser) {
                        sperr.dogRegister();
                    } else {
                        spers.salir();
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
        return ent.nextLine().equalsIgnoreCase("Y");
    }

    public static int sel() {
        int sel = ent.nextInt();
        ent.nextLine();
        return sel;
    }
}
