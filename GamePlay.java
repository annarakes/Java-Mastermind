// Anna Rakes
// May 12th, 2025
// GamePlay.java
// Creates/stores the secret code and controls the game (printing instructions, prompting input from player,
// looping through turns, printing feedback, etc.).
import java.util.ArrayList;
import java.util.Scanner;

public class GamePlay {

    // Field
    private PegList secretCode;

    // Code provided by Professor Dutton to print colors for pegs.
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GRAY = "\u001B[37m";

    // Method that runs the game. Prints the intro, generates the secret code, asks the player if they want to use the
    // cheat mode, counts the turns, makes a guess or see their history.
    // Returns void.
    public void play(){
        printIntro();
        secretCode = generateSecret();
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enable cheat mode? (y/n)");
        String cheatMode = scnr.nextLine();
        if (cheatMode.equals("y")){
            System.out.println("The secret code is: " + colorReturn(cheatMode()));
            System.out.println("");
        }

        int count = 1;
        History history = new History();
        boolean won = false;
        while (count < 11 && !won){
            System.out.print("Make your guess (or type \"history\"): ");
            String letterGuess = scnr.nextLine();
            if (letterGuess.equals("history")){
                selectHistory(history);
            } else {
                won = makeGuess(history, letterGuess, count);
                count += 1;
            }
        }
        if (!won){
            System.out.println("You ran out of guesses");
            System.out.println("The answer was: " + colorReturn(cheatMode()));
        }
    }


    // Method that takes no input and prints out the game introduction.
    // Void return.
    public void printIntro(){
        System.out.println("Welcome to Mastermind! Become a code breaker!");
        System.out.println("Your computer opponent has created a secret code");
        System.out.println("You have 10 guesses to break it! Create your guess");
        System.out.println("by choosing any combination of the 4 colors listed");
        System.out.println("(repeats are allowed)");
        System.out.println("");
        System.out.println("Colors: r (red), y (yellow), g (green), a (gray), p (purple), or b (blue)");
        System.out.println("Ex: To guess red,red,blue,blue enter \"rrbb\"");
    }

    // Method that takes in no input and generates the secret code (A PegList of 4 Pegs).
    // Returns the PegList.
    public PegList generateSecret() {
        secretCode = new PegList();
        for (int i = 0; i < 4; i++) {
            int randResult = (int) (Math.random() * 6);
            Peg num = new Peg(randResult);
            secretCode.addPeg(num);
        }
        return secretCode;
    }

    // Method called if player chooses to see the secret code. Takes in no input and transforms secret code to
    // an ArrayList for printing.
    // Returns ArrayList<Integer> of secret code.
    public ArrayList<Integer> cheatMode(){
        ArrayList<Integer> cheatList = new ArrayList<>();
        for (int i = 0 ; i < 4 ; i++){
            cheatList.add(secretCode.getColorList().get(i).getColor());
        }
        return cheatList;
    }

    // Method that takes in the game history, the guess, and the count of number of turns.
    // Checks guess against secret code by using the Feedback object and determines if the player
    // won or if they will continue playing.
    // Returns boolean if they won or not.
    public boolean makeGuess(History history, String letterGuess, int count){
        ArrayList <Integer> numbers = lettersToNums(letterGuess);
        PegList pegGuess = numsToPegList(numbers);
        Feedback feedback = new Feedback();
        boolean won = false;
        String result = "Code: " + colorReturn(numbers) + " Feedback: " + feedback.getMatches(pegGuess, secretCode);
        if (feedback.getMatches(pegGuess, secretCode).equals("hhhh")){
            System.out.println("You won in " + count + " guesses!");
            won = true;
        } else {
            history.addTurn(result);
            System.out.println(result);
        }
        return won;
    }

    // Method that takes in history of turns and prints guide for history and all their previous turns.
    // Void return.
    public void selectHistory(History history){
        System.out.println("\"h\" means hit -> a peg was the correct color in the correct position.");
        System.out.println("\"p\" means partial -> a peg was the correct color in the wrong position.");
        System.out.println("No feedback means the peg was the wrong color (it was not in the secret code");
        for (String turn: history.getHistory()){
            System.out.println(turn);
        }
    }


    // Method that takes in possible numbers from the guess and pairs it with its corresponding color.
    // Returns a string of code to print the colors.
    public String colorReturn(ArrayList<Integer> numbers){
        String row = "";
        for (Integer num:numbers){
            if (num==0) {
                row += ANSI_RED + "\u25A0" + ANSI_RESET;
            } else if (num == 1) {
                row += ANSI_YELLOW + "\u25A0" + ANSI_RESET;
            } else if (num == 2) {
                row += ANSI_GREEN + "\u25A0" + ANSI_RESET;
            } else if (num == 3) {
                row += ANSI_GRAY + "\u25A0" + ANSI_RESET;
            } else if (num == 4) {
                row += ANSI_PURPLE + "\u25A0" + ANSI_RESET;
            } else {
                row += ANSI_BLUE + "\u25A0" + ANSI_RESET;
            }
        }
       return row;
    }

    // Method that takes in a guess from the player of letters and translates their colors into numbers.
    // Returns an ArrayList of Integers that represents their guess in numbers instead of letters.
    public ArrayList<Integer> lettersToNums(String letterGuess){
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i<4; i++){
            if (letterGuess.charAt(i) == 'r'){
                numbers.add(0);
            } else if (letterGuess.charAt(i) == 'y') {
                numbers.add(1);
            } else if (letterGuess.charAt(i) == 'g') {
                numbers.add(2);
            } else if (letterGuess.charAt(i) == 'a') {
                numbers.add(3);
            } else if (letterGuess.charAt(i) == 'p') {
                numbers.add(4);
            } else if (letterGuess.charAt(i) == 'b'){
                numbers.add(5);
            }
        }
        return numbers;
    }

    // Method that takes in a guess in the form of an ArrayList of Integers and turns each one into a peg. Each peg
    // is then added to a PegList.
    // Returns the PegList. This is their official guess.
    public PegList numsToPegList(ArrayList<Integer> numbers){
        PegList pegGuess = new PegList();
        for (Integer num:numbers){
            Peg newPeg = new Peg(num);
            pegGuess.addPeg(newPeg);
        }
        return pegGuess;
    }

}
