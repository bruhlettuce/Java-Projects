//By: Lorne Huxtable
import java.util.Arrays;

public class Pakudex {

    int defaultPakudex;
    String[] pakuriArray;
    int[] pakuriStats;
    Pakuri pakuri;

    public Pakudex () { //Default constructor; if called, the default size for the Pakudex should be 20

    defaultPakudex = 20;

    }

    public Pakudex (int capacity) { // Initializes this object to contain exactly capacity objects when completely full

        defaultPakudex = capacity;
        pakuriArray = new String [capacity];

    }

    public int getSize() { //get number of pakuri in array
        int getSizeCount = 0;
        for (int i = 0; i < getSpeciesArray().length; i++) {
            if (pakuriArray[i] == null) {
                continue;
            }
            if (pakuriArray[i] != null) {
                getSizeCount++;
            }
        }
        return getSizeCount;
    }

    public int getCapacity() { //max amount the array can hold
        //Returns the number of critters that the Pakudex has the capacity to hold at most
        return defaultPakudex;
    }

    public String[] getSpeciesArray() {
        //Returns a String array containing the species of the critters as
        // ordered in the Pakudex; if there are no species
        //added yet, this method should return null
        //String[] speciesArray = new String[getCapacity()];
        for (int i = 0; i < pakuriArray.length; i++) {
            if (pakuriArray[0] == null) {
                System.out.println("No Pakuri in Pakudex yet!");
                break;
            }
            if (pakuriArray[0] != null && i < 1) {
                System.out.println("Pakuri in Pakudex:"  );
            }
            if (pakuriArray[i] != null) {
                System.out.println(i + 1 + ". " + pakuriArray[i]);
            }
            if (pakuriArray[0] != null && pakuriArray[i] == null) { // Not sure if this is the right signature, come back
                break;
            }
        }
        return pakuriArray;
    }

    public int[] getStats(String species) {
        //Returns an int array containing the attack, defense, and speed
        // statistics of species at indices 0, 1, and 2
        //respectively; if species is not in the Pakudex, returns null
        for (int i = 0; i < pakuriArray.length; i++) {

            if (pakuriArray[i] == null) {
                System.out.println("Error: No such Pakuri!");
                break;
            }
            if (pakuriArray[i].equals(species)) {
                int[] pakuriStats = new int [3];
                pakuriStats[0] = pakuri.getAttack();
                pakuriStats[1] = pakuri.getDefense();
                pakuriStats[2] = pakuri.getSpeed();
                System.out.println("Attack: " + pakuriStats[0]);
                System.out.println("Defense: " + pakuriStats[1]);
                System.out.println("Speed: " + pakuriStats[2]);
                break;
            }

            if (!pakuriArray[i].equals(species) && i != pakuriArray.length - 1) {
                continue;
            }

            if (!pakuriArray[pakuriArray.length - 1].equals(species)) {
                System.out.println("Error: No such Pakuri!");
                break;
            }

        }
        return pakuriStats;
    }

    public void sortPakuri() {
        //Sorts the Pakuri objects in this Pakudex according
        // to Java standard lexicographical ordering of species name
        Arrays.sort(pakuriArray);
        System.out.println("Pakuri have been sorted!");
    }

    public boolean addPakuri(String species) {
        //Adds species to the Pakudex; if successful, return true, and false otherwise, #3
        boolean success = false;
        for (int i = 0; i < pakuriArray.length; i++) {

            if (pakuriArray[pakuriArray.length - 1] != null) {
                System.out.println("Error: Pakudex is full!");
                break;
            }
            if (pakuriArray[i] == null) {
                pakuriArray[i] = species;
                pakuri = new Pakuri(species);
                System.out.println("Pakuri species " + species + " successfully added!");
                success = true;
                break;
            }

            if (pakuriArray[i].equals(species)) {
                System.out.println("Error: Pakudex already contains this species!");
                break;
            }

        }
        return success;
    }

    public boolean evolveSpecies(String species) {
        //Attempts to evolve species within the Pakudex;
        // if successful, return true, and false otherwise
        boolean evolve = false;
        for (int i = 0; i < pakuriArray.length; i++) {

            if (pakuriArray[i] == null) {
                System.out.println("Error: No such Pakuri!");
                break;
            }
            if (pakuriArray[i].equals(species)) {
                pakuri =  new Pakuri(species);
                pakuri.evolve();
                System.out.println(species + " has evolved!");
                evolve = true;
                break;
            }

            if (!pakuriArray[i].equals(species) && i != pakuriArray.length - 1) {
                continue;
            }

            if (!pakuriArray[pakuriArray.length - 1].equals(species)) {
                System.out.println("Error: No such Pakuri!");
                break;
            }

        }
        return evolve;
    }

}

