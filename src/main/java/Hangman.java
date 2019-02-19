import java.io.IOException;
import java.util.Scanner;
import Exception.NotEnoughHintsException;

public class Hangman {

    static void displayCLI(Scanner scanner, CommandOptions commandOptions, GameState gameState) throws IOException, NotEnoughHintsException {

        boolean isGuessCorrect;
        String userGuess;

        if (commandOptions.getWordsDictionary() == "") {
            System.out.println("  1. Counties");
            System.out.println("  2. Countries");
            System.out.println("  3. Cities");

            System.out.print("Pick a category:");

            gameState = new GameState(Dictionary.getRandomName(scanner.nextInt()), commandOptions.getMaxGuesses(), commandOptions.getMaxHints());
        } else {
            gameState = new GameState(Dictionary.getRandomCustomName(commandOptions.getWordsDictionary()), commandOptions.getMaxGuesses(), commandOptions.getMaxHints());
        }

        while (!gameState.isGameWon() && !gameState.isGameLost()) {
            gameState.showWord(gameState.getTargetName());

            System.out.println("Guesses remaining: " + gameState.getNumberOfGuessesRemaining());

            System.out.print("Guess a letter or word (? for a giveHint): ");

            userGuess = scanner.next();
            isGuessCorrect = gameState.makeGuess(userGuess);

            if (isGuessCorrect) System.out.println("Good guess!");
            if (!isGuessCorrect) System.out.println("Wrong guess!");
        }

        if (gameState.isGameWon()) {
            System.out.println("Well done!");
            System.out.println("You took " + gameState.getNumberOfGuessesRemaining() + " guesses");
        } else {
            System.out.println("You isGameLost! The word was " + gameState.getTargetName());
        }
    }

    public static void main(String[] args) throws IOException, NotEnoughHintsException {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        GameState gameState = null;
        CommandOptions commandOptions = new CommandOptions(args);

        displayCLI(scanner, commandOptions, gameState);
    }
}
