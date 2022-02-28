//By: Lorne Huxtable
import java.util.InputMismatchException;
import java.util.Scanner;
public class PakuriProgram {



    /*public int setMaxPakudex() {

    }*/

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        int maxPakudex = 0;
        while (true) {
            System.out.print("Enter max capacity of the Pakudex: ");
            try {
                maxPakudex = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid size.");
                input.next();
                continue;
            }
            System.out.println("The Pakudex can hold " + maxPakudex + " species of Pakuri.");
            break;
        }
        Pakudex pakudex = new Pakudex(maxPakudex);

        int menuSelect = 0;
            while (true) {
                while (menuSelect != 6) {
                    System.out.println("");
                    System.out.println("Pakudex Main Menu");
                    System.out.println("----------------- ");
                    System.out.println("1. List Pakuri");
                    System.out.println("2. Show Pakuri");
                    System.out.println("3. Add Pakuri");
                    System.out.println("4. Evolve Pakuri");
                    System.out.println("5. Sort Pakuri");
                    System.out.println("6. Exit");
                    System.out.println();
                    System.out.print("What would you like to do? ");
                try {
                    menuSelect = input.nextInt();
                } catch (InputMismatchException f) {
                    System.out.println("Unrecognized menu selection!");
                    input.next();
                    continue;
                }
                break;
            }

            if (menuSelect < 1 || menuSelect > 6) {
                System.out.println("Unrecognized menu selection!");
            }
            if (menuSelect == 1) {

                pakudex.getSpeciesArray();

            }
            if (menuSelect == 2) {

                System.out.print("Enter the name of the species to display: ");
                String speciesStats = input.next();
                pakudex.getStats(speciesStats);

            }
            if (menuSelect == 3) {

                System.out.print("Enter the name of the species to add: ");
                String addSpecies = input.next();
                pakudex.addPakuri(addSpecies);

            }
            if (menuSelect == 4) {

                System.out.print("Enter the name of the species to evolve: ");
                String evolvePakuri = input.next();
                pakudex.evolveSpecies(evolvePakuri);

            }
            if (menuSelect == 5) {

                pakudex.sortPakuri();

            }
            if (menuSelect == 6) {

                System.out.println("Thanks for using Pakudex! Bye!");
                break;

            }

        }

    }


}
