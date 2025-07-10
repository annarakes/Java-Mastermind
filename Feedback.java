// Anna Rakes
// May 12th, 2025
// Feedback.java
// Compares the guess (a PegList) with the secret code (also a PegList). Stores a string of "h" and/or "p".

public class Feedback {

    // Field
    private String response;

    // Default constructor that initializes the variable "response" to an empty string.
    public Feedback(){
        response = "";
    }

    // Method that has two PegList parameters, one acting as the guess that was made, and one as the secret code.
    // Checks if any pegs are same number and same position. If so, it adds "h" to string. Then checks if any pegs
    // are same number but different position. If so, it adds "p" to string.
    // Returns the String variable "letters".
    public String getMatches(PegList guess, PegList secret) {
        boolean[] matchedGuess = new boolean[4];
        boolean[] matchedSecret = new boolean[4];
        String letters = "";
        for (int i = 0; i < guess.getColorList().size(); i++) {
            if (guess.getColorList().get(i).getColor() == secret.getColorList().get(i).getColor()) {
                letters += "h";
                matchedGuess[i] = true;
                matchedSecret[i] = true;
            }
        }
        for (int i = 0; i < guess.getColorList().size(); i++){
            if (!matchedGuess[i]){
                for (int j = 0; j<secret.getColorList().size(); j++){
                    if (!matchedSecret[j]){
                        if (guess.getColorList().get(i).getColor() == secret.getColorList().get(j).getColor()){
                            letters += "p";
                            matchedGuess[i] = true;
                            matchedSecret[j] = true;
                        }
                    }
                }
                }
            }
        return letters;
    }
}