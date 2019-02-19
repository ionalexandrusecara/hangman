import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import Exception.NotEnoughHintsException;
import Exception.QuestionMarkFoundException;

/**
 * GameState class
 * Stores the state of the game, analyses the user's guesses and checks the status (win or loss)
 */
public class GameState {
    private String targetName;
    private int numberOfGuessesMade;
    private int numberOfGuessesRemaining;
    private int numberOfHints;

    private ArrayList<Character> lettersGuessedCorrect;
    private ArrayList<Character> lettersNotGuessed;

    private Scanner scanner;

    /**
     * Constructor of the GameState class
     * Stores unique character values in the lettersNotGuessed ArrayList
     * Assigns the value of numberOfGuessesRemaining.
     * If the param value is 0 or smaller, then numberOfGuessesRemaining takes the default value = 10
     * Assigns the value of numberOfHints.
     * If the param value is 0 or smaller, then numberOfHints takes the default value = 3
     * numberOfGuessesMade is initialised to 0, since the game did not start yet
     *
     * @param targetName
     * @param numberOfGuessesRemaining
     * @param numberOfHints
     */
    public GameState(String targetName, int numberOfGuessesRemaining, int numberOfHints) {
        if (targetName == null) {
            this.targetName = "";
            throw new NullPointerException();
        }

        try {
            scanner = new Scanner(new InputStreamReader(System.in, "UTF-8")).useDelimiter("\n");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException();
        }

        try {
            targetName = detectQuestionMarks(targetName);
        } catch (QuestionMarkFoundException e) {
            targetName = targetName.replaceAll("\\?", "");
            System.out.println(e.getMessage());
        }

        this.targetName = targetName;
        lettersNotGuessed = new ArrayList<Character>();
        lettersGuessedCorrect = new ArrayList<Character>();

        storeUniqueCharacters(targetName);

        if (numberOfGuessesRemaining <= 0) {
            this.numberOfGuessesRemaining = 10;
        } else {
            this.numberOfGuessesRemaining = numberOfGuessesRemaining;
        }

        if (numberOfHints < 0) {
            this.numberOfHints = 3;
        } else {
            this.numberOfHints = numberOfHints;
        }

        this.numberOfGuessesMade = 0;
    }

    /**
     * Method removes question marks from inside the target name
     * Since '?' stands as a key in the game, the user cannot input this in the target name
     *
     * @param name
     * @return
     */
    public String detectQuestionMarks(String name) throws QuestionMarkFoundException {
        if (name == null) {
            throw new NullPointerException();
        }
        if (name.indexOf('?') != -1) {
            throw new QuestionMarkFoundException("Question marks are not allowed inside the target name - ? is a key for playing the game!");
        }
        return name;
    }

    /**
     * Stores the unique characters of the targetName in the lettersNotGuessed ArrayList
     *
     * @param name
     */
    public void storeUniqueCharacters(String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < name.length(); i++) {
            if (!lettersNotGuessed.contains(Character.toLowerCase(name.charAt(i))))
                if (name.charAt(i) != ' ') {
                    lettersNotGuessed.add(Character.toLowerCase(name.charAt(i)));
                }

        }
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public int getNumberOfGuessesMade() {
        return numberOfGuessesMade;
    }

    public void setNumberOfGuessesMade(int numberOfGuessesMade) {
        this.numberOfGuessesMade = numberOfGuessesMade;
    }

    public int getNumberOfGuessesRemaining() {
        return numberOfGuessesRemaining;
    }

    public void setNumberOfGuessesRemaining(int numberOfGuessesRemaining) {
        this.numberOfGuessesRemaining = numberOfGuessesRemaining;
    }

    public int getNumberOfHints() {
        return numberOfHints;
    }

    public void setNumberOfHints(int numberOfHints) {
        this.numberOfHints = numberOfHints;
    }

    public ArrayList<Character> getLettersGuessedCorrect() {
        return lettersGuessedCorrect;
    }

    public void setLettersGuessedCorrect(ArrayList<Character> lettersGuessedCorrect) {
        this.lettersGuessedCorrect = lettersGuessedCorrect;
    }

    public ArrayList<Character> getLettersNotGuessed() {
        return lettersNotGuessed;
    }

    public void setLettersNotGuessed(ArrayList<Character> lettersNotGuessed) {
        this.lettersNotGuessed = lettersNotGuessed;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Method that displays the already guessed letters in the correct position
     * Method hides the letters that are not guessed yet with the dash symbol -
     *
     * @param word
     */
    void showWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.toLowerCase(Locale.ENGLISH).charAt(i) == ' ') {
                System.out.print(" ");
            } else if (lettersGuessedCorrect.contains(word.toLowerCase(Locale.ENGLISH).charAt(i))) {
                System.out.print(word.charAt(i));
            } else {
                System.out.print("-");
            }
        }
        System.out.println("");
    }

    /**
     * makeGuess takes the user's input guess then checks for error-prone cases (null, empty)
     * If input is valid, the method calls checkLetter() in case the user's input is a single character
     * Otherwise, the method calls checkWord() in case the user tries to guess the whole word at once
     *
     * @param userGuess
     * @return
     */
    boolean makeGuess(String userGuess) {
        if (userGuess == null) {
            numberOfGuessesMade++;
            if (numberOfGuessesRemaining > 0) {
                numberOfGuessesRemaining--;
            }
            return false;
        }

        if (userGuess.length() == 0) {
            numberOfGuessesMade++;
            if (numberOfGuessesRemaining > 0) {
                numberOfGuessesRemaining--;
            }
            return false;
        }

        if (userGuess.length() > 1) {
            return checkWord(userGuess);
        }

        return checkLetter(userGuess.toLowerCase(Locale.ENGLISH).charAt(0));
    }

    /**
     * checkLetter checks whether the user asks for a hint and in case, calls the giveHint method
     * The method also checks whether the guess is correct and return true, otherwise it returns false
     *
     * @param letter
     * @return
     */
    public boolean checkLetter(char letter) {
        if (letter == '?') {
            try {
                giveHint();
            } catch (NotEnoughHintsException e) {
                System.out.println(e.getMessage());
            }
            return false;
        }

        for (int i = 0; i < lettersNotGuessed.size(); ++i) {
            if (lettersNotGuessed.get(i).equals(letter)) {
                lettersNotGuessed.remove(i);
                lettersGuessedCorrect.add(letter);
                return true;
            }
        }

        numberOfGuessesMade++;
        if (numberOfGuessesRemaining > 0) {
            numberOfGuessesRemaining--;
        }
        return false;
    }

    /**
     * checkLetter checks whether the user guessed the word in a single go
     *
     * @param userGuess
     * @return
     */
    public boolean checkWord(String userGuess) {
        if (userGuess == null) {
            throw new NullPointerException();
        }

        if (userGuess.equalsIgnoreCase(targetName)) {
            lettersNotGuessed.clear();
            return true;
        } else {
            numberOfGuessesMade++;
            if (numberOfGuessesRemaining > 0) {
                numberOfGuessesRemaining--;
            }
            return false;
        }
    }

    /**
     * isGameWon checks whether the game finished and the user guessed the word correctly
     *
     * @return
     */
    public boolean isGameWon() {
        if (lettersNotGuessed.size() == 0) return true;
        else return false;
    }

    /**
     * isGameLost checks whether the game finished and the user still did not guess the word
     *
     * @return
     */
    public boolean isGameLost() {
        if (lettersNotGuessed.size() > 0 && numberOfGuessesRemaining == 0) return true;
        else return false;
    }

    /**
     * giveHint method is called when the user input is a question mark
     * The method checks whether the user has hints left, and in that case provides the user with a letter to try
     */
    public void giveHint() throws NotEnoughHintsException {
        if (numberOfHints == 0) {
            throw new NotEnoughHintsException("You ran out of hints!");
        } else {
            numberOfHints--;
            System.out.print("Try: ");
            System.out.println(lettersNotGuessed.get((int) (Math.random() * lettersNotGuessed.size())));
        }
    }
}
