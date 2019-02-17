import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class GameStateTest {

	@Test
	public void gameStateInitialisation() {
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
	public void gameStateInitialisationTwo() {
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
	public void gameStateInitialisationThree() {
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
	public void oneLetterTargetGameStateInitialisation() {
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
	public void oneLetterTargetGameStateInitialisationTwo() {
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
	public void emptyTargetGameStateInitialisationTwo() {
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
	public void nullTargetGameStateInitialisationTwo() {
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
	public void zeroGuessesGameStateInitialisationTwo() {
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
	public void negativeGuessesGameStateInitialisationTwo() {
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
	public void zeroHintsGameStateInitialisationTwo() {
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
	public void negativeHintsGameStateInitialisationTwo() {
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

}
