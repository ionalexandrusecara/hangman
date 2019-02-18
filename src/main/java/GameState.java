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
		if(targetName == null){
			this.targetName = "";
			throw new NullPointerException();
		}
		this.targetName = targetName;
		lettersGuessedWrong = new ArrayList<Character>();
		lettersGuessedCorrect = new ArrayList<Character>();
		
		for(int i = 0; i < targetName.length(); i++) {
			if (!lettersGuessedWrong.contains(Character.toLowerCase(targetName.charAt(i))))
				lettersGuessedWrong.add(Character.toLowerCase(targetName.charAt(i)));
		}

		if(numberOfGuessesRemaining <= 0){
			this.numberOfGuessesRemaining = 10;
		} else {
			this.numberOfGuessesRemaining = numberOfGuessesRemaining;
		}

		if(numberOfHints < 0){
			this.numberOfHints = 3;
		} else {
			this.numberOfHints = numberOfHints;
		}

		this.numberOfGuessesMade = 0;
	}
	
	void showWord(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (lettersGuessedCorrect.contains(word.toLowerCase().charAt(i))) {
				System.out.print(word.charAt(i));
			} else {
				System.out.print("-");
			}
		}
		System.out.println("");
	}
	
	boolean guessLetter(String userGuess) {
		int i;
		char letter;
		
		System.out.print("Guess a letter or word (? for a hint): ");
		
		if (userGuess.length() > 1) {
			if (userGuess==targetName) {
				lettersGuessedWrong.clear();
				return true;
			} else return false;
		}
		
		letter = userGuess.charAt(0);
		System.out.println("letter: " + letter);
		
		if (letter == '?') {
			hint();
			return false;
		}

		for(i = 0; i < lettersGuessedWrong.size(); ++i) {
			if (lettersGuessedWrong.get(i) == letter) {
				lettersGuessedWrong.remove(i);
				lettersGuessedCorrect.add(letter);
				numberOfHints++;
				numberOfGuessesMade++;
				numberOfGuessesRemaining--;
				return true;
			}
		}

		numberOfGuessesMade++;
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
