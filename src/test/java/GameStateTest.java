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

		assertEquals(gameState.getTargetName(), "London");
		assertEquals(gameState.getNumberOfGuessesRemaining(), 10);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), letters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
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

		assertEquals(gameState.getTargetName(), "ASD XYZ");
		assertEquals(gameState.getNumberOfGuessesRemaining(), 5);
		assertEquals(gameState.getNumberOfHints(), 3);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), letters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
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

		assertEquals(gameState.getTargetName(), "££78AS 28");
		assertEquals(gameState.getNumberOfGuessesRemaining(), 5);
		assertEquals(gameState.getNumberOfHints(), 3);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), letters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
	}

	@Test
	public void oneLetterTargetGameStateInitialisationTest() {
		GameState gameState = new GameState("a", 5, 3);

		ArrayList<Character> letters = new ArrayList<>();
		letters.add('a');

		assertEquals(gameState.getTargetName(), "a");
		assertEquals(gameState.getNumberOfGuessesRemaining(), 5);
		assertEquals(gameState.getNumberOfHints(), 3);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), letters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
	}

	@Test
	public void oneLetterTargetGameStateInitialisationTestTwo() {
		GameState gameState = new GameState("aaaaa", 5, 3);

		ArrayList<Character> letters = new ArrayList<>();
		letters.add('a');

		assertEquals(gameState.getTargetName(), "aaaaa");
		assertEquals(gameState.getNumberOfGuessesRemaining(), 5);
		assertEquals(gameState.getNumberOfHints(), 3);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), letters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
	}

	@Test
	public void emptyTargetGameStateInitialisationTest() {
		GameState gameState = new GameState("", 5, 3);

		ArrayList<Character> letters = new ArrayList<>();

		assertEquals(gameState.getTargetName(), "");
		assertEquals(gameState.getNumberOfGuessesRemaining(), 5);
		assertEquals(gameState.getNumberOfHints(), 3);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), letters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
	}

	@Test(expected = NullPointerException.class)
	public void nullTargetGameStateInitialisationTest() {
		GameState gameState = new GameState(null, 5, 3);

		ArrayList<Character> letters = new ArrayList<>();

		assertEquals(gameState.getTargetName(), "");
		assertEquals(gameState.getNumberOfGuessesRemaining(), 5);
		assertEquals(gameState.getNumberOfHints(), 3);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), letters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
	}

	@Test
	public void zeroGuessesGameStateInitialisationTest() {
		GameState gameState = new GameState("London", 0, 3);

		ArrayList<Character> letters = new ArrayList<>();
		letters.add('l');
		letters.add('o');
		letters.add('n');
		letters.add('d');

		assertEquals(gameState.getTargetName(), "London");
		assertEquals(gameState.getNumberOfGuessesRemaining(), 10);
		assertEquals(gameState.getNumberOfHints(), 3);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), letters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
	}

	@Test
	public void negativeGuessesGameStateInitialisationTest() {
		GameState gameState = new GameState("London", -1, 3);

		ArrayList<Character> letters = new ArrayList<>();
		letters.add('l');
		letters.add('o');
		letters.add('n');
		letters.add('d');

		assertEquals(gameState.getTargetName(), "London");
		assertEquals(gameState.getNumberOfGuessesRemaining(), 10);
		assertEquals(gameState.getNumberOfHints(), 3);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), letters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
	}

	@Test
	public void zeroHintsGameStateInitialisationTest() {
		GameState gameState = new GameState("London", 7, 0);

		ArrayList<Character> letters = new ArrayList<>();
		letters.add('l');
		letters.add('o');
		letters.add('n');
		letters.add('d');

		assertEquals(gameState.getTargetName(), "London");
		assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
		assertEquals(gameState.getNumberOfHints(), 0);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), letters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
	}

	@Test
	public void negativeHintsGameStateInitialisationTest() {
		GameState gameState = new GameState("London", 7, -4);

		ArrayList<Character> letters = new ArrayList<>();
		letters.add('l');
		letters.add('o');
		letters.add('n');
		letters.add('d');

		assertEquals(gameState.getTargetName(), "London");
		assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
		assertEquals(gameState.getNumberOfHints(), 3);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), letters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
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

		boolean isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
		assertTrue(isGuessCorrect);
	}

	@Test
	public void correctLetterGuessLetterTest() {
		GameState gameState = new GameState("Edinburgh", 7, 2);
		String userGuess = "b";

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('e');
		wrongLetters.add('d');
		wrongLetters.add('i');
		wrongLetters.add('n');
		wrongLetters.add('u');
		wrongLetters.add('r');
		wrongLetters.add('g');
		wrongLetters.add('h');

		ArrayList<Character> correctLetters = new ArrayList<>();
		correctLetters.add('b');

		boolean isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
		assertTrue(isGuessCorrect);
	}

	@Test
	public void correctCapitalLetterGuessLetterTest() {
		GameState gameState = new GameState("London", 7, 2);
		String userGuess = "L";

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('o');
		wrongLetters.add('n');
		wrongLetters.add('d');

		ArrayList<Character> correctLetters = new ArrayList<>();
		correctLetters.add('l');

		boolean isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
		assertTrue(isGuessCorrect);
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

		boolean isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
		assertTrue(isGuessCorrect);
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

		boolean isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
		assertTrue(isGuessCorrect);
	}

	@Test
	public void correctNumberGuessLetterTest() {
		GameState gameState = new GameState("London13", 7, 2);
		String userGuess = "1";

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('l');
		wrongLetters.add('o');
		wrongLetters.add('n');
		wrongLetters.add('d');
		wrongLetters.add('3');

		ArrayList<Character> correctLetters = new ArrayList<>();
		correctLetters.add('1');

		boolean isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
		assertTrue(isGuessCorrect);
	}

	@Test
	public void wrongGuessLetterGuessLetterTest() {
		GameState gameState = new GameState("London", 7, 2);
		String userGuess = "a";

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('l');
		wrongLetters.add('o');
		wrongLetters.add('n');
		wrongLetters.add('d');

		boolean isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 1);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
		assertFalse(isGuessCorrect);
	}

	@Test
	public void wrongGuessLetterGuessLetterTest2() {
		GameState gameState = new GameState("London13", 7, 2);
		String userGuess = "2";

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('l');
		wrongLetters.add('o');
		wrongLetters.add('n');
		wrongLetters.add('d');
		wrongLetters.add('1');
		wrongLetters.add('3');

		boolean isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 1);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
		assertFalse(isGuessCorrect);
	}

	@Test
	public void hintGuessLetterGuessLetterTest2() {
		GameState gameState = new GameState("London", 7, 2);
		String userGuess = "?";

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('l');
		wrongLetters.add('o');
		wrongLetters.add('n');
		wrongLetters.add('d');

		boolean isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
		assertEquals(gameState.getNumberOfHints(), 1);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
		assertFalse(isGuessCorrect);
	}

	@Test
	public void twoCorrectGuessesLetterGuessLetterTest() {
		GameState gameState = new GameState("London", 7, 2);
		String userGuess = "l";

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('o');
		wrongLetters.add('n');
		wrongLetters.add('d');

		ArrayList<Character> correctLetters = new ArrayList<>();
		correctLetters.add('l');

		boolean isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
		assertTrue(isGuessCorrect);

		userGuess = "o";

		wrongLetters = new ArrayList<>();
		wrongLetters.add('n');
		wrongLetters.add('d');

		correctLetters.add('o');

		isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
		assertTrue(isGuessCorrect);
	}

	@Test
	public void OneCorrectOneWrongGuessesLetterGuessLetterTest() {
		GameState gameState = new GameState("London", 7, 2);
		String userGuess = "l";

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('o');
		wrongLetters.add('n');
		wrongLetters.add('d');

		ArrayList<Character> correctLetters = new ArrayList<>();
		correctLetters.add('l');

		boolean isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
		assertTrue(isGuessCorrect);

		userGuess = "a";

		wrongLetters = new ArrayList<>();
		wrongLetters.add('o');
		wrongLetters.add('n');
		wrongLetters.add('d');

		isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 1);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
		assertFalse(isGuessCorrect);
	}

	@Test
	public void OneWrongOneCorrectGuessesLetterGuessLetterTest() {
		GameState gameState = new GameState("London", 7, 2);
		String userGuess = "a";

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('l');
		wrongLetters.add('o');
		wrongLetters.add('n');
		wrongLetters.add('d');

		boolean isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 1);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
		assertFalse(isGuessCorrect);

		userGuess = "l";

		wrongLetters = new ArrayList<>();
		wrongLetters.add('o');
		wrongLetters.add('n');
		wrongLetters.add('d');

		ArrayList<Character> correctLetters = new ArrayList<>();
		correctLetters.add('l');

		isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 1);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
		assertTrue(isGuessCorrect);
	}

	@Test
	public void twoWrongGuessesLetterGuessLetterTest() {
		GameState gameState = new GameState("London", 7, 2);
		String userGuess = "b";

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('l');
		wrongLetters.add('o');
		wrongLetters.add('n');
		wrongLetters.add('d');

		boolean isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 1);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
		assertFalse(isGuessCorrect);

		userGuess = "a";

		isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 5);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 2);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
		assertFalse(isGuessCorrect);
	}

	@Test
	public void correctWordLetterGuessLetterTest() {
		GameState gameState = new GameState("London", 7, 2);
		String userGuess = "london";

		boolean isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertTrue(gameState.getLettersGuessedWrong().isEmpty());
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
		assertTrue(isGuessCorrect);
	}

	@Test
	public void correctCapitalWordLetterGuessLetterTest() {
		GameState gameState = new GameState("London", 7, 2);
		String userGuess = "LONDON";

		boolean isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertTrue(gameState.getLettersGuessedWrong().isEmpty());
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
		assertTrue(isGuessCorrect);
	}

	@Test
	public void wrongWordGuessLetterTest() {
		GameState gameState = new GameState("London", 7, 2);
		String userGuess = "Londn";

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('l');
		wrongLetters.add('o');
		wrongLetters.add('n');
		wrongLetters.add('d');

		boolean isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 1);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
		assertFalse(isGuessCorrect);
	}

	@Test
	public void wrongWordGuessLetterTest2() {
		GameState gameState = new GameState("Edinburgh", 7, 2);
		String userGuess = "Edi";

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('e');
		wrongLetters.add('d');
		wrongLetters.add('i');
		wrongLetters.add('n');
		wrongLetters.add('b');
		wrongLetters.add('u');
		wrongLetters.add('r');
		wrongLetters.add('g');
		wrongLetters.add('h');

		boolean isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 1);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
		assertFalse(isGuessCorrect);
	}

	@Test
	public void emptyGuessGuessLetterTest2() {
		GameState gameState = new GameState("Edinburgh", 7, 2);
		String userGuess = "";

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('e');
		wrongLetters.add('d');
		wrongLetters.add('i');
		wrongLetters.add('n');
		wrongLetters.add('b');
		wrongLetters.add('u');
		wrongLetters.add('r');
		wrongLetters.add('g');
		wrongLetters.add('h');

		boolean isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 1);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
		assertFalse(isGuessCorrect);
	}

	@Test
	public void whiteSpaceCorrectGuessGuessLetterTest2() {
		GameState gameState = new GameState("St Andrews", 7, 2);
		String userGuess = " ";

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('s');
		wrongLetters.add('t');
		wrongLetters.add('a');
		wrongLetters.add('n');
		wrongLetters.add('d');
		wrongLetters.add('r');
		wrongLetters.add('e');
		wrongLetters.add('w');

		ArrayList<Character> correctLetters = new ArrayList<>();
		correctLetters.add(' ');

		boolean isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
		assertTrue(isGuessCorrect);
	}

	@Test
	public void whiteSpaceWrongGuessGuessLetterTest2() {
		GameState gameState = new GameState("StAndrews", 7, 2);
		String userGuess = " ";

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('s');
		wrongLetters.add('t');
		wrongLetters.add('a');
		wrongLetters.add('n');
		wrongLetters.add('d');
		wrongLetters.add('r');
		wrongLetters.add('e');
		wrongLetters.add('w');

		boolean isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 1);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
		assertFalse(isGuessCorrect);
	}

	@Test
	public void nullGuessGuessLetterTest2() {
		GameState gameState = new GameState("London", 7, 2);
		String userGuess = null;

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('l');
		wrongLetters.add('o');
		wrongLetters.add('n');
		wrongLetters.add('d');

		boolean isGuessCorrect = gameState.guessLetter(userGuess);

		assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
		assertEquals(gameState.getNumberOfHints(), 2);
		assertEquals(gameState.getNumberOfGuessesMade(), 1);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
		assertFalse(isGuessCorrect);
	}

	@Test
	public void wonTest() {
		GameState gameState = new GameState("London", 7, 2);
		gameState.getLettersGuessedWrong().clear();

		assertEquals(gameState.getLettersGuessedWrong().size(), 0);
		assertTrue(gameState.won());
	}

	@Test
	public void wonTest2() {
		GameState gameState = new GameState("London", 7, 2);

		gameState.guessLetter("L");
		assertFalse(gameState.won());

		gameState.guessLetter("o");
		assertFalse(gameState.won());

		gameState.guessLetter("n");
		assertFalse(gameState.won());

		gameState.guessLetter("d");

		assertEquals(gameState.getLettersGuessedWrong().size(), 0);
		assertTrue(gameState.won());
	}

	@Test
	public void wonLowerCaseLettersTest() {
		GameState gameState = new GameState("London", 7, 2);

		gameState.guessLetter("l");
		assertFalse(gameState.won());

		gameState.guessLetter("o");
		assertFalse(gameState.won());

		gameState.guessLetter("n");
		assertFalse(gameState.won());

		gameState.guessLetter("d");

		assertEquals(gameState.getLettersGuessedWrong().size(), 0);
		assertTrue(gameState.won());
	}

	@Test
	public void wonCapitalLettersTest() {
		GameState gameState = new GameState("London", 7, 2);

		gameState.guessLetter("L");
		assertFalse(gameState.won());

		gameState.guessLetter("O");
		assertFalse(gameState.won());

		gameState.guessLetter("N");
		assertFalse(gameState.won());

		gameState.guessLetter("D");


		assertEquals(gameState.getLettersGuessedWrong().size(), 0);
		assertTrue(gameState.won());
	}

	@Test
	public void wonWithWrongGuessLettersTest() {
		GameState gameState = new GameState("London", 7, 2);

		gameState.guessLetter("L");
		assertFalse(gameState.won());

		gameState.guessLetter("O");
		assertFalse(gameState.won());

		gameState.guessLetter("X");
		assertFalse(gameState.won());

		gameState.guessLetter("N");
		assertFalse(gameState.won());

		gameState.guessLetter("D");

		assertEquals(gameState.getLettersGuessedWrong().size(), 0);
		assertTrue(gameState.won());
	}

	@Test
	public void notWonTest() {
		GameState gameState = new GameState("London", 7, 2);

		gameState.guessLetter("L");
		assertFalse(gameState.won());

		gameState.guessLetter("O");
		assertFalse(gameState.won());

		gameState.guessLetter("X");
		assertFalse(gameState.won());

		gameState.guessLetter("N");
		assertFalse(gameState.won());

		assertEquals(gameState.getLettersGuessedWrong().size(), 1);
		assertFalse(gameState.won());
	}

	@Test
	public void notWonTest2() {
		GameState gameState = new GameState("London", 7, 2);

		gameState.guessLetter("L");
		assertFalse(gameState.won());

		assertEquals(gameState.getLettersGuessedWrong().size(), 3);
		assertFalse(gameState.won());
	}

	@Test
	public void lostTest() {
		GameState gameState = new GameState("London", 7, 2);
		gameState.setNumberOfGuessesRemaining(0);

		assertTrue(gameState.lost());
	}

	@Test
	public void lostTest2() {
		GameState gameState = new GameState("London", 1, 2);
		gameState.guessLetter("a");

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('l');
		wrongLetters.add('o');
		wrongLetters.add('n');
		wrongLetters.add('d');

		assertEquals(gameState.getNumberOfGuessesRemaining(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertTrue(gameState.lost());
	}

	@Test
	public void lostTest3() {
		GameState gameState = new GameState("London", 1, 2);
		gameState.guessLetter("a");
		gameState.guessLetter("b");

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('l');
		wrongLetters.add('o');
		wrongLetters.add('n');
		wrongLetters.add('d');

		assertEquals(gameState.getNumberOfGuessesRemaining(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertTrue(gameState.lost());
	}

	@Test
	public void lostTest4() {
		GameState gameState = new GameState("London", 1, 2);
		gameState.guessLetter("l");
		gameState.guessLetter("b");

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('o');
		wrongLetters.add('n');
		wrongLetters.add('d');

		assertEquals(gameState.getNumberOfGuessesRemaining(), 0);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertTrue(gameState.lost());
	}

	@Test
	public void notLostTest() {
		GameState gameState = new GameState("L", 1, 2);
		gameState.guessLetter("l");

		assertEquals(gameState.getNumberOfGuessesRemaining(), 1);
		assertTrue(gameState.getLettersGuessedWrong().isEmpty());
		assertFalse(gameState.lost());
	}

	@Test
	public void notLostTest2() {
		GameState gameState = new GameState("London", 1, 2);
		gameState.guessLetter("l");

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('o');
		wrongLetters.add('n');
		wrongLetters.add('d');

		assertEquals(gameState.getNumberOfGuessesRemaining(), 1);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertFalse(gameState.lost());
	}

	@Test
	public void notLostTest3() {
		GameState gameState = new GameState("London", 1, 2);
		gameState.guessLetter("l");

		ArrayList<Character> wrongLetters = new ArrayList<>();
		wrongLetters.add('o');
		wrongLetters.add('n');
		wrongLetters.add('d');
		assertEquals(gameState.getNumberOfGuessesRemaining(), 1);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertFalse(gameState.lost());

		gameState.guessLetter("o");
		wrongLetters = new ArrayList<>();
		wrongLetters.add('n');
		wrongLetters.add('d');
		assertEquals(gameState.getNumberOfGuessesRemaining(), 1);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertFalse(gameState.lost());

		gameState.guessLetter("n");
		wrongLetters = new ArrayList<>();
		wrongLetters.add('d');
		assertEquals(gameState.getNumberOfGuessesRemaining(), 1);
		assertEquals(gameState.getLettersGuessedWrong(), wrongLetters);
		assertFalse(gameState.lost());

		gameState.guessLetter("d");
		assertEquals(gameState.getNumberOfGuessesRemaining(), 1);
		assertTrue(gameState.getLettersGuessedWrong().isEmpty());
		assertFalse(gameState.lost());
	}

	@Test
	public void hintTest() {
		GameState gameState = new GameState("London", 7, 2);
		gameState.hint();

		assertEquals(gameState.getNumberOfHints(), 1);
	}

	@Test
	public void outOfHintsHintTest() {
		GameState gameState = new GameState("London", 7, 0);
		gameState.hint();

		assertEquals(gameState.getNumberOfHints(), 0);
	}

}
