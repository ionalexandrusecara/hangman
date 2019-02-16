import java.util.Scanner;

public class Hangman {

	static void doStuff(Scanner scanner, CommandOptions commandOptions, GameState gameState) {

		boolean correct;

		if (commandOptions.wordsDictionary == "") {

			System.out.println("  1. Counties");
			System.out.println("  2. Countries");
			System.out.println("  3. Cities");

			System.out.print("Pick a category:");

			gameState = new GameState(Words.randomWord(scanner.nextInt()), commandOptions.maxGuesses, commandOptions.maxHints);
		} else {
			gameState = new GameState(Words.randomWord(commandOptions.wordsDictionary), commandOptions.maxGuesses, commandOptions.maxHints);
		}

		while (!gameState.won() && !gameState.lost()) {
			gameState.showWord(gameState.word);

			System.out.println("Guesses remaining: " + gameState.wrong);

			correct = gameState.guessLetter();

			if (correct) System.out.println("Good guess!");
			if (!correct) System.out.println("Wrong guess!");
		}

		if (gameState.won()) {
			System.out.println("Well done!");
			System.out.println("You took " + gameState.g + " guesses");
		} else {
			System.out.println("You lost! The word was " + gameState.word);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		GameState gameState = null;
		CommandOptions commandOptions;

		commandOptions = new CommandOptions(args);

		doStuff(scanner, commandOptions, gameState);

	}
}
