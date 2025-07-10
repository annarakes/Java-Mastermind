// Anna Rakes
// May 12th, 2025
// Peg.java
// Creates individual peg to be included in the guess of 4 pegs.

public class Peg {

    // Field
    private int color;

    // Setter, takes in an integer, which represents a color, and sets the field "color" to that number.
    // No return object
    public void setColor(int color) {
        this.color = color;
    }

    // Constructor that takes in an integer, which represents a color, and calls setColor()/
    public Peg(int color){
        setColor(color);
    }

    // Getter that has no input parameters and returns the "color" variable, an integer, which represents a color.
    public int getColor(){
        return color;
    }
}
