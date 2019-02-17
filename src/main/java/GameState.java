import java.util.ArrayList;
import java.util.Scanner;

// The game state
public class GameState {
	public String targetName;
	public int numberOfGuessesMade;
	public int numberOfGuessesRemaining;
	public int numberOfHints;
	
	ArrayList<Character> lettersGuessedCorrect;
	ArrayList<Character> lettersGuessedWrong;
	
	public Scanner scanner = new Scanner(System.in).useDelimiter("\n");
	
	public GameState(String targetName, int numberOfGuessesRemaining, int numberOfHints) {
		this.targetName = targetName;
		lettersGuessedWrong = new ArrayList<Character>();
		lettersGuessedCorrect = new ArrayList<Character>();
		
		for(int i = 0; i < targetName.length(); ++i) {
			if (!lettersGuessedWrong.contains(Character.toLowerCase(targetName.charAt(i))))
				lettersGuessedWrong.add(Character.toLowerCase(targetName.charAt(i)));
		}
		//System.out.println(missing);
		
		this.numberOfGuessesMade = 0; // guesses made
		this.numberOfGuessesRemaining = numberOfGuessesRemaining; // guesses remaining
		this.numberOfHints = numberOfHints;
	}
	
	void showWord(String word) {
		for (int i = 0; i < word.length(); ++i) {
			if (lettersGuessedCorrect.contains(word.charAt(i))) {
				System.out.print(word.charAt(i));
			} else {
				System.out.print("-");
			}
		}
		System.out.println("");
		// System.out.println(missing);
	}
	
	boolean guessLetter() {
		int i;
		char letter;
		
		System.out.print("Guess a letter or word (? for a hint): ");
		
		String str = scanner.next().toLowerCase();
		
		if (str.length() > 1) {
			if (str==targetName) {
				lettersGuessedWrong.clear();
				return true;
			} else return false;
		}
		
		letter = str.charAt(0);
		
		if (letter == '?') {
			hint();
			return false;
		}
		
		for(i = 0; i < lettersGuessedWrong.size(); ++i) { // Loop over the not got
			if (lettersGuessedWrong.get(i) == letter) {
				lettersGuessedWrong.remove(i);
				lettersGuessedCorrect.add(letter);
				numberOfHints++;
				return true;
			}
		}

		numberOfGuessesMade++; // One more guess
		numberOfGuessesRemaining--;
		return false;
	}
	
	boolean won() {
		if (lettersGuessedWrong.size() == 0) return true; else return false;
	}

	boolean lost() {
		if (lettersGuessedWrong.size() > 0 && numberOfGuessesRemaining == 0) return true; else return false;
	}

	void hint() {
		if (numberOfHints == 0) {
			System.out.println("No more hints allowed");
		}
		
		System.out.print("Try: ");
		System.out.println(lettersGuessedWrong.get((int)(Math.random()* lettersGuessedWrong.size())));
	}
}
