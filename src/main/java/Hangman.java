import java.util.Scanner;

public class Hangman {

	static void displayCLI(Scanner scanner, CommandOptions commandOptions, GameState gameState) {

		boolean isGuessCorrect;

		if(commandOptions.wordsDictionary == "") {
			System.out.println("  1. Counties");
			System.out.println("  2. Countries");
			System.out.println("  3. Cities");

			System.out.print("Pick a category:");

			gameState = new GameState(Dictionary.getRandomName(scanner.nextInt()), commandOptions.maxGuesses, commandOptions.maxHints);
		} else {
			gameState = new GameState(Dictionary.getRandomCustomName(commandOptions.wordsDictionary), commandOptions.maxGuesses, commandOptions.maxHints);
		}

		while (!gameState.won() && !gameState.lost()) {
			gameState.showWord(gameState.targetName);

			System.out.println("Guesses remaining: " + gameState.numberOfGuessesRemaining);

			isGuessCorrect = gameState.guessLetter();

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

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in, "UTF-8");

		GameState gameState = null;
		CommandOptions commandOptions = new CommandOptions(args);

		displayCLI(scanner, commandOptions, gameState);
	}
}
