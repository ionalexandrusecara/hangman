import java.util.ArrayList;
import java.util.Scanner;

public class GameState {
	private String targetName;
	private int numberOfGuessesMade;
	private int numberOfGuessesRemaining;
	private int numberOfHints;

	private ArrayList<Character> lettersGuessedCorrect;
	private ArrayList<Character> lettersGuessedWrong;

	private Scanner scanner = new Scanner(System.in).useDelimiter("\n");
	
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

	public ArrayList<Character> getLettersGuessedWrong() {
		return lettersGuessedWrong;
	}

	public void setLettersGuessedWrong(ArrayList<Character> lettersGuessedWrong) {
		this.lettersGuessedWrong = lettersGuessedWrong;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
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

		if(userGuess == null){
			numberOfGuessesMade++;
			if(numberOfGuessesRemaining > 0) {
				numberOfGuessesRemaining--;
			}
			return false;
		}

		if(userGuess.length() == 0){
			numberOfGuessesMade++;
			if(numberOfGuessesRemaining > 0) {
				numberOfGuessesRemaining--;
			}
			return false;
		}
		
		if (userGuess.length() > 1) {
			if (userGuess.equalsIgnoreCase(targetName)) {
				lettersGuessedWrong.clear();
				return true;
			} else {
				numberOfGuessesMade++;
				if(numberOfGuessesRemaining > 0) {
					numberOfGuessesRemaining--;
				}
				return false;
			}
		}
		
		letter = userGuess.toLowerCase().charAt(0);
		
		if (letter == '?') {
			hint();
			return false;
		}

		for(i = 0; i < lettersGuessedWrong.size(); ++i) {
			if (lettersGuessedWrong.get(i).equals(letter)) {
				lettersGuessedWrong.remove(i);
				lettersGuessedCorrect.add(letter);
				return true;
			}
		}

		numberOfGuessesMade++;
		if(numberOfGuessesRemaining > 0) {
			numberOfGuessesRemaining--;
		}
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
		} else {
			numberOfHints --;
			System.out.print("Try: ");
			System.out.println(lettersGuessedWrong.get((int)(Math.random()* lettersGuessedWrong.size())));
		}
	}
}
