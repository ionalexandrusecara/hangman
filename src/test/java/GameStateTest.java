import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class GameStateTest {

	@Test
	public void gameStateInitialisationTest() {
		GameState gameState = new GameState("London", 10, 2);

		ArrayList<Character> letters = new ArrayList<>();
		letters.add('l');
		letters.add('o');
		letters.add('n');
		letters.add('d');

		assertEquals(gameState.targetName, "London");
		assertEquals(gameState.numberOfGuessesRemaining, 10);
		assertEquals(gameState.numberOfHints, 2);
		assertEquals(gameState.numberOfGuessesMade, 0);
		assertEquals(gameState.lettersGuessedWrong, letters);
		assertTrue(gameState.lettersGuessedCorrect.isEmpty());
	}

	@Test
	public void gameStateInitialisationTestTwo() {
		GameState gameState = new GameState("ASD XYZ", 5, 3);

		ArrayList<Character> letters = new ArrayList<>();
		letters.add('a');
		letters.add('s');
		letters.add('d');
		letters.add(' ');
		letters.add('x');
		letters.add('y');
		letters.add('z');

		assertEquals(gameState.targetName, "ASD XYZ");
		assertEquals(gameState.numberOfGuessesRemaining, 5);
		assertEquals(gameState.numberOfHints, 3);
		assertEquals(gameState.numberOfGuessesMade, 0);
		assertEquals(gameState.lettersGuessedWrong, letters);
		assertTrue(gameState.lettersGuessedCorrect.isEmpty());
	}

	@Test
	public void gameStateInitialisationTestThree() {
		GameState gameState = new GameState("££78AS 28", 5, 3);

		ArrayList<Character> letters = new ArrayList<>();
		letters.add('£');
		letters.add('7');
		letters.add('8');
		letters.add('a');
		letters.add('s');
		letters.add(' ');
		letters.add('2');

		assertEquals(gameState.targetName, "££78AS 28");
		assertEquals(gameState.numberOfGuessesRemaining, 5);
		assertEquals(gameState.numberOfHints, 3);
		assertEquals(gameState.numberOfGuessesMade, 0);
		assertEquals(gameState.lettersGuessedWrong, letters);
		assertTrue(gameState.lettersGuessedCorrect.isEmpty());
	}

	@Test
	public void oneLetterTargetGameStateInitialisationTest() {
		GameState gameState = new GameState("a", 5, 3);

		ArrayList<Character> letters = new ArrayList<>();
		letters.add('a');

		assertEquals(gameState.targetName, "a");
		assertEquals(gameState.numberOfGuessesRemaining, 5);
		assertEquals(gameState.numberOfHints, 3);
		assertEquals(gameState.numberOfGuessesMade, 0);
		assertEquals(gameState.lettersGuessedWrong, letters);
		assertTrue(gameState.lettersGuessedCorrect.isEmpty());
	}

	@Test
	public void oneLetterTargetGameStateInitialisationTestTwo() {
		GameState gameState = new GameState("aaaaa", 5, 3);

		ArrayList<Character> letters = new ArrayList<>();
		letters.add('a');

		assertEquals(gameState.targetName, "aaaaa");
		assertEquals(gameState.numberOfGuessesRemaining, 5);
		assertEquals(gameState.numberOfHints, 3);
		assertEquals(gameState.numberOfGuessesMade, 0);
		assertEquals(gameState.lettersGuessedWrong, letters);
		assertTrue(gameState.lettersGuessedCorrect.isEmpty());
	}

	@Test
	public void emptyTargetGameStateInitialisationTest() {
		GameState gameState = new GameState("", 5, 3);

		ArrayList<Character> letters = new ArrayList<>();

		assertEquals(gameState.targetName, "");
		assertEquals(gameState.numberOfGuessesRemaining, 5);
		assertEquals(gameState.numberOfHints, 3);
		assertEquals(gameState.numberOfGuessesMade, 0);
		assertEquals(gameState.lettersGuessedWrong, letters);
		assertTrue(gameState.lettersGuessedCorrect.isEmpty());
	}

	@Test(expected = NullPointerException.class)
	public void nullTargetGameStateInitialisationTest() {
		GameState gameState = new GameState(null, 5, 3);

		ArrayList<Character> letters = new ArrayList<>();

		assertEquals(gameState.targetName, "");
		assertEquals(gameState.numberOfGuessesRemaining, 5);
		assertEquals(gameState.numberOfHints, 3);
		assertEquals(gameState.numberOfGuessesMade, 0);
		assertEquals(gameState.lettersGuessedWrong, letters);
		assertTrue(gameState.lettersGuessedCorrect.isEmpty());
	}

	@Test
	public void zeroGuessesGameStateInitialisationTest() {
		GameState gameState = new GameState("London", 0, 3);

		ArrayList<Character> letters = new ArrayList<>();
		letters.add('l');
		letters.add('o');
		letters.add('n');
		letters.add('d');

		assertEquals(gameState.targetName, "London");
		assertEquals(gameState.numberOfGuessesRemaining, 10);
		assertEquals(gameState.numberOfHints, 3);
		assertEquals(gameState.numberOfGuessesMade, 0);
		assertEquals(gameState.lettersGuessedWrong, letters);
		assertTrue(gameState.lettersGuessedCorrect.isEmpty());
	}

	@Test
	public void negativeGuessesGameStateInitialisationTest() {
		GameState gameState = new GameState("London", -1, 3);

		ArrayList<Character> letters = new ArrayList<>();
		letters.add('l');
		letters.add('o');
		letters.add('n');
		letters.add('d');

		assertEquals(gameState.targetName, "London");
		assertEquals(gameState.numberOfGuessesRemaining, 10);
		assertEquals(gameState.numberOfHints, 3);
		assertEquals(gameState.numberOfGuessesMade, 0);
		assertEquals(gameState.lettersGuessedWrong, letters);
		assertTrue(gameState.lettersGuessedCorrect.isEmpty());
	}

	@Test
	public void zeroHintsGameStateInitialisationTest() {
		GameState gameState = new GameState("London", 7, 0);

		ArrayList<Character> letters = new ArrayList<>();
		letters.add('l');
		letters.add('o');
		letters.add('n');
		letters.add('d');

		assertEquals(gameState.targetName, "London");
		assertEquals(gameState.numberOfGuessesRemaining, 7);
		assertEquals(gameState.numberOfHints, 0);
		assertEquals(gameState.numberOfGuessesMade, 0);
		assertEquals(gameState.lettersGuessedWrong, letters);
		assertTrue(gameState.lettersGuessedCorrect.isEmpty());
	}

	@Test
	public void negativeHintsGameStateInitialisationTest() {
		GameState gameState = new GameState("London", 7, -4);

		ArrayList<Character> letters = new ArrayList<>();
		letters.add('l');
		letters.add('o');
		letters.add('n');
		letters.add('d');

		assertEquals(gameState.targetName, "London");
		assertEquals(gameState.numberOfGuessesRemaining, 7);
		assertEquals(gameState.numberOfHints, 3);
		assertEquals(gameState.numberOfGuessesMade, 0);
		assertEquals(gameState.lettersGuessedWrong, letters);
		assertTrue(gameState.lettersGuessedCorrect.isEmpty());
	}

	@Test
	public void correctFirstLetterGuessLetterTest() {
		GameState gameState = new GameState("London", 7, 2);
		String userGuess = "l";

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('o');
		wrongLetters.add('n');
		wrongLetters.add('d');

		ArrayList<Character> correctLetters = new ArrayList<>();
		correctLetters.add('l');

		gameState.guessLetter(userGuess);

		assertEquals(gameState.numberOfGuessesRemaining, 6);
		assertEquals(gameState.numberOfHints, 3);
		assertEquals(gameState.numberOfGuessesMade, 1);
		assertEquals(gameState.lettersGuessedWrong, wrongLetters);
		assertEquals(gameState.lettersGuessedCorrect, correctLetters);
	}

	@Test
	public void correctLastLetterGuessLetterTest() {
		GameState gameState = new GameState("Edinburgh", 7, 2);
		String userGuess = "h";

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('e');
		wrongLetters.add('d');
		wrongLetters.add('i');
		wrongLetters.add('n');
		wrongLetters.add('b');
		wrongLetters.add('u');
		wrongLetters.add('r');
		wrongLetters.add('g');

		ArrayList<Character> correctLetters = new ArrayList<>();
		correctLetters.add('h');

		gameState.guessLetter(userGuess);

		assertEquals(gameState.numberOfGuessesRemaining, 6);
		assertEquals(gameState.numberOfHints, 3);
		assertEquals(gameState.numberOfGuessesMade, 1);
		assertEquals(gameState.lettersGuessedWrong, wrongLetters);
		assertEquals(gameState.lettersGuessedCorrect, correctLetters);
	}

	@Test
	public void correctMultipleLetterGuessLetterTest() {
		GameState gameState = new GameState("London", 7, 2);
		String userGuess = "o";

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('l');
		wrongLetters.add('n');
		wrongLetters.add('d');

		ArrayList<Character> correctLetters = new ArrayList<>();
		correctLetters.add('o');

		gameState.guessLetter(userGuess);

		assertEquals(gameState.numberOfGuessesRemaining, 6);
		assertEquals(gameState.numberOfHints, 3);
		assertEquals(gameState.numberOfGuessesMade, 1);
		assertEquals(gameState.lettersGuessedWrong, wrongLetters);
		assertEquals(gameState.lettersGuessedCorrect, correctLetters);
	}

}
