// Anna Rakes
// May 12th, 2025
// PegList.java
// Stores an ArrayList of 4 Peg objects, which represents any "guess" or "code" in the game.
import java.util.ArrayList;

public class PegList {

    // Field
    private ArrayList<Peg> colorList;

    // Default constructor that initializes an empty ArrayList of Pegs, called "colorList".
    public PegList(){
        colorList = new ArrayList<>();
    }

    // Getter that has no input parameters and returns "colorList".
    public ArrayList<Peg> getColorList() {
        return colorList;
    }

    // Method that has no input parameters. Its purpose is to print out the number ("color") of each peg in colorList.
    // Used for debugging purposes. Void return.
    public void printColorList(){
        for (Peg peg : colorList){
            System.out.print(peg.getColor());
        }
        System.out.println();
    }

    // Method that takes in a Peg object and adds the Peg object to the existing "colorList".
    // Void return.
    public void addPeg(Peg peg){
        colorList.add(peg);
    }

}
