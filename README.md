# 🧠 Mastermind Game - Java Implementation  
## Author: Anna Rakes 
### 📜 Description  
This project is a **Java implementation of the classic code-breaking game Mastermind**, created for Computer Science II at Elon University using **IntelliJ IDEA**. The game challenges the player to guess a secret combination of colored pegs within 10 turns. After each guess, the game provides feedback using "h" (hit: correct color and position) and "p" (partial: correct color, wrong position). The goal is to crack the code before running out of attempts.

### 🚀 Features  
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
README.md           # Project documentation
