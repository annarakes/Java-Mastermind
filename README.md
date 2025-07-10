# 🧠 Mastermind Game - Java Implementation  
## Author: Anna Rakes 
### 📜 Description  
This project is a **Java implementation of the classic code-breaking game Mastermind**, created for Computer Science II at Elon University using **IntelliJ IDEA**. The game challenges the player to guess a secret combination of colored pegs within 10 turns. After each guess, the game provides feedback using "h" (hit: correct color and position) and "p" (partial: correct color, wrong position). The goal is to crack the code before running out of attempts.

### Features  
**🎯 Secret Code Generation**  
- Randomly generates a sequence of four pegs using six possible colors.

**🔁 Guess and Feedback System**  
- Accepts player guesses (e.g., `rgby`) and provides visual and textual feedback.

**📋 Game History**  
- Stores and displays previous guesses and their feedback.

**🧪 Feedback Matching Logic**  
- Implements correct "hit" and "partial" matching without double-counting pegs.

**🎨 Color-Coded Output**  
- ANSI color codes visually represent each peg color in the terminal.

**🧠 Cheat Mode**  
- Optional cheat mode reveals the secret code for debugging or practice.

### 📂 Project Structure
```bash
Main.java           # Entry point – launches the game
Peg.java            # Represents a single colored peg
PegList.java        # Represents a combination of pegs (guess or code)
Feedback.java       # Compares a guess to the secret and returns feedback
History.java        # Stores a history of all guesses and their feedback
GamePlay.java       # Controls game flow, input/output, and logic
```

### 🎮 How to Play

1. Run the program in IntelliJ or from terminal using:
```bash
java Main
```
3. Decide whether to enable cheat mode.
4. Enter guesses using four-letter combinations:

- r = Red

- y = Yellow

- g = Green

- a = Gray

- p = Purple

- b = Blue
Example: rrbb for Red, Red, Blue, Blue.

4. Receive feedback after each guess:

- "h" = correct color and position

- "p" = correct color, wrong position

5. Type "history" at any point to view your past guesses.

6. You win by getting hhhh within 10 guesses!

**🛠️ Built With**
**Java (JDK 17+)**

**IntelliJ IDEA**
