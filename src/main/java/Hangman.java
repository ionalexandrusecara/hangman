import java.util.Scanner;

public class Hangman {

	static void doStuff(Scanner sc, CommandOptions opts, GameState g) {

		boolean correct;

		if (opts.wordsDictionary == "") {

			System.out.println("  1. Counties");
			System.out.println("  2. Countries");
			System.out.println("  3. Cities");

			System.out.print("Pick a category:");

			g = new GameState(Words.randomWord(sc.nextInt()), opts.maxGuesses, opts.maxHints);
		} else {
			g = new GameState(Words.randomWord(opts.wordsDictionary), opts.maxGuesses, opts.maxHints);
		}

		while (!g.won() && !g.lost()) {
			g.showWord(g.word);

			System.out.println("Guesses remaining: " + g.wrong);

			correct = g.guessLetter();

			if (correct) System.out.println("Good guess!");
			if (!correct) System.out.println("Wrong guess!");
		}

		if (g.won()) {
			System.out.println("Well done!");
			System.out.println("You took " + g.g + " guesses");
		} else {
			System.out.println("You lost! The word was " + g.word);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GameState g = null;
		CommandOptions opts;

		opts = new CommandOptions(args);

		doStuff(sc, opts, g);

	}
}
