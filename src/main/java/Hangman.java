import Exception.NotEnoughHintsException;
import Exception.QuestionMarkFoundException;

import java.io.IOException;
import java.util.Scanner;

public class Hangman {

    /**
     * displayCli processes the Commmand Line Interface displayed to the user
     * Calls methods displayMenu(), setupGameState(), gameInProgress() and checkStatus() that represent each stage of the game
     *
     * @param scanner
     * @param commandOptions
     * @throws IOException
     */
    public static void displayCli(Scanner scanner, CommandOptions commandOptions) throws IOException {

        GameState gameState;

        if (commandOptions.getWordsDictionary().equals("")) {
            displayMenu();
            gameState = setupGameState(scanner, commandOptions);
        } else {
            gameState = new GameState(Dictionary.getRandomCustomName(commandOptions.getWordsDictionary()), commandOptions.getMaxGuesses(), commandOptions.getMaxHints());
        }

        gameInProgress(gameState, scanner);

        checkStatus(gameState);

    }

    /**
     * First stage of the game - display menu to user
     */
    public static void displayMenu() {
        System.out.println("  1. Counties");
        System.out.println("  2. Countries");
        System.out.println("  3. Cities");

        System.out.print("Pick a category:");
    }

    /**
     * Second stage of the game.
     * Get a random target name and initialise the GameState object with the appropriate guesses, hints and optionally file values.
     * @param scanner
     * @param commandOptions
     * @return
     */
    public static GameState setupGameState(Scanner scanner, CommandOptions commandOptions) {
        int randomCategoryChoice;
        GameState gameState;

        if (scanner.hasNextInt()) {
            gameState = new GameState(Dictionary.getRandomName(scanner.nextInt()), commandOptions.getMaxGuesses(), commandOptions.getMaxHints());
        } else {
            randomCategoryChoice = (int) (Math.random() * 3 + 1);
            System.out.println("Category chosen randomly: " + randomCategoryChoice);
            gameState = new GameState(Dictionary.getRandomName(randomCategoryChoice), commandOptions.getMaxGuesses(), commandOptions.getMaxHints());
        }

        return gameState;
    }

    /**
     * Loops continuously until the game is won or lost by the user.
     * Game is won when the user fully guessed the target word.
     * Game is lost if user did not guess fully the target word and ran out of guesses.
     * The method displays appropriate messages for correct and wrong guesses.
     * @param gameState
     * @param scanner
     */
    public static void gameInProgress(GameState gameState, Scanner scanner) {
        boolean isGuessCorrect;
        String userGuess;

        while (!gameState.isGameWon() && !gameState.isGameLost()) {
            gameState.showWord(gameState.getTargetName());

            System.out.println("Guesses remaining: " + gameState.getNumberOfGuessesRemaining());

            System.out.print("Guess a letter or word (? for a giveHint): ");

            userGuess = scanner.next();
            isGuessCorrect = gameState.makeGuess(userGuess);

            if (isGuessCorrect) System.out.println("Good guess!");
            if (!isGuessCorrect) System.out.println("Wrong guess!");
        }
    }

    /**
     * Displays the final result of the game - won or lost, together with some additional information (number of guesses or target name)
     * @param gameState
     */
    public static void checkStatus(GameState gameState) {
        if (gameState.isGameWon()) {
            System.out.println("Well done!");
            System.out.println("You took " + gameState.getNumberOfGuessesRemaining() + " guesses");
        } else {
            System.out.println("You lost the game! The word was " + gameState.getTargetName());
        }
    }

    /**
     * This is the main method. The program starts here.
     * @param args
     * @throws IOException
     * @throws NotEnoughHintsException
     * @throws QuestionMarkFoundException
     */
    public static void main(String[] args) throws IOException, NotEnoughHintsException, QuestionMarkFoundException {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        CommandOptions commandOptions = new CommandOptions(args);

        displayCli(scanner, commandOptions);
    }
}
