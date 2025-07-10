// Anna Rakes
// May 12th, 2025
// History.java
// Stores an ArrayList of Strings. Each string in the list represents each guess in the game and its respective feedback.
import java.util.ArrayList;

public class History {

    // Field
    private ArrayList<String> history;

    // Default constructor that initializes the variable "history" to an empty ArrayList.
    public History(){
        history = new ArrayList<>();
    }

    // Method that takes in a String input parameter representing a single turn. For example, the input String would
    // read "Code: ---- Feedback: hhp". The String is then added to the list of turns in "history".
    // Void return.
    public void addTurn(String turn){
        history.add(turn);
    }

    // Getter that takes in no input parameters and returns the variable "history" (an ArrayList of Strings).
    public ArrayList<String> getHistory(){
        return history;
    }

}
