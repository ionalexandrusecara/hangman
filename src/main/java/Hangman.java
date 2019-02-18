import java.io.IOException;
import java.util.Scanner;

public class Hangman {

	static void displayCLI(Scanner scanner, CommandOptions commandOptions, GameState gameState) throws IOException {

		boolean isGuessCorrect;
		String userGuess;

		if(commandOptions.getWordsDictionary() == "") {
			System.out.println("  1. Counties");
			System.out.println("  2. Countries");
			System.out.println("  3. Cities");

			System.out.print("Pick a category:");

			gameState = new GameState(Dictionary.getRandomName(scanner.nextInt()), commandOptions.getMaxGuesses(), commandOptions.getMaxHints());
		} else {
			gameState = new GameState(Dictionary.getRandomCustomName(commandOptions.getWordsDictionary()), commandOptions.getMaxGuesses(), commandOptions.getMaxHints());
		}

		while (!gameState.won() && !gameState.lost()) {
			gameState.showWord(gameState.targetName);

			System.out.println("Guesses remaining: " + gameState.numberOfGuessesRemaining);

			System.out.print("Guess a letter or word (? for a hint): ");

			userGuess = scanner.next();
			isGuessCorrect = gameState.guessLetter(userGuess);

			if (isGuessCorrect) System.out.println("Good guess!");
			if (!isGuessCorrect) System.out.println("Wrong guess!");
		}

		if (gameState.won()) {
			System.out.println("Well done!");
			System.out.println("You took " + gameState.numberOfGuessesRemaining + " guesses");
		} else {
			System.out.println("You lost! The word was " + gameState.targetName);
		}
	}

	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(System.in, "UTF-8");

		GameState gameState = null;
		CommandOptions commandOptions = new CommandOptions(args);

		displayCLI(scanner, commandOptions, gameState);
	}
}
