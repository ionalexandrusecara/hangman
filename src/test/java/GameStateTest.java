import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

import Exception.NotEnoughHintsException;
import Exception.QuestionMarkFoundException;

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
        assertEquals(gameState.getLettersNotGuessed(), letters);
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
    }

    @Test
    public void gameStateInitialisationTestTwo() {
        GameState gameState = new GameState("ASD XYZ", 5, 3);

        ArrayList<Character> letters = new ArrayList<>();
        letters.add('a');
        letters.add('s');
        letters.add('d');
        letters.add('x');
        letters.add('y');
        letters.add('z');

        assertEquals(gameState.getTargetName(), "ASD XYZ");
        assertEquals(gameState.getNumberOfGuessesRemaining(), 5);
        assertEquals(gameState.getNumberOfHints(), 3);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertEquals(gameState.getLettersNotGuessed(), letters);
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
        letters.add('2');

        assertEquals(gameState.getTargetName(), "££78AS 28");
        assertEquals(gameState.getNumberOfGuessesRemaining(), 5);
        assertEquals(gameState.getNumberOfHints(), 3);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertEquals(gameState.getLettersNotGuessed(), letters);
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
        assertEquals(gameState.getLettersNotGuessed(), letters);
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
        assertEquals(gameState.getLettersNotGuessed(), letters);
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
        assertEquals(gameState.getLettersNotGuessed(), letters);
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
        assertEquals(gameState.getLettersNotGuessed(), letters);
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
        assertEquals(gameState.getLettersNotGuessed(), letters);
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
        assertEquals(gameState.getLettersNotGuessed(), letters);
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
        assertEquals(gameState.getLettersNotGuessed(), letters);
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
        assertEquals(gameState.getLettersNotGuessed(), letters);
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
    }

    @Test
    public void correctFirstLetterGuessLetterTest() {
        GameState gameState = new GameState("London", 7, 2);
        String userGuess = "l";

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        ArrayList<Character> correctLetters = new ArrayList<>();
        correctLetters.add('l');

        boolean isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
        assertTrue(isGuessCorrect);
    }

    @Test
    public void correctLetterGuessLetterTest() {
        GameState gameState = new GameState("Edinburgh", 7, 2);
        String userGuess = "b";

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('e');
        notGuessedLetters.add('d');
        notGuessedLetters.add('i');
        notGuessedLetters.add('n');
        notGuessedLetters.add('u');
        notGuessedLetters.add('r');
        notGuessedLetters.add('g');
        notGuessedLetters.add('h');

        ArrayList<Character> correctLetters = new ArrayList<>();
        correctLetters.add('b');

        boolean isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
        assertTrue(isGuessCorrect);
    }

    @Test
    public void correctCapitalLetterGuessLetterTest() {
        GameState gameState = new GameState("London", 7, 2);
        String userGuess = "L";

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        ArrayList<Character> correctLetters = new ArrayList<>();
        correctLetters.add('l');

        boolean isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
        assertTrue(isGuessCorrect);
    }

    @Test
    public void correctLastLetterGuessLetterTest() {
        GameState gameState = new GameState("Edinburgh", 7, 2);
        String userGuess = "h";

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('e');
        notGuessedLetters.add('d');
        notGuessedLetters.add('i');
        notGuessedLetters.add('n');
        notGuessedLetters.add('b');
        notGuessedLetters.add('u');
        notGuessedLetters.add('r');
        notGuessedLetters.add('g');

        ArrayList<Character> correctLetters = new ArrayList<>();
        correctLetters.add('h');

        boolean isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
        assertTrue(isGuessCorrect);
    }

    @Test
    public void correctMultipleLetterGuessLetterTest() {
        GameState gameState = new GameState("London", 7, 2);
        String userGuess = "o";

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('l');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        ArrayList<Character> correctLetters = new ArrayList<>();
        correctLetters.add('o');

        boolean isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
        assertTrue(isGuessCorrect);
    }

    @Test
    public void correctNumberGuessLetterTest() {
        GameState gameState = new GameState("London13", 7, 2);
        String userGuess = "1";

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('l');
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');
        notGuessedLetters.add('3');

        ArrayList<Character> correctLetters = new ArrayList<>();
        correctLetters.add('1');

        boolean isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
        assertTrue(isGuessCorrect);
    }

    @Test
    public void wrongGuessLetterGuessLetterTest() {
        GameState gameState = new GameState("London", 7, 2);
        String userGuess = "a";

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('l');
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        boolean isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertFalse(isGuessCorrect);
    }

    @Test
    public void wrongGuessLetterGuessLetterTest2() {
        GameState gameState = new GameState("London13", 7, 2);
        String userGuess = "2";

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('l');
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');
        notGuessedLetters.add('1');
        notGuessedLetters.add('3');

        boolean isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertFalse(isGuessCorrect);
    }

    @Test
    public void hintGuessLetterGuessLetterTest2() {
        GameState gameState = new GameState("London", 7, 2);
        String userGuess = "?";

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('l');
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        boolean isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
        assertEquals(gameState.getNumberOfHints(), 1);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertFalse(isGuessCorrect);
    }

    @Test
    public void twoCorrectGuessesLetterGuessLetterTest() {
        GameState gameState = new GameState("London", 7, 2);
        String userGuess = "l";

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        ArrayList<Character> correctLetters = new ArrayList<>();
        correctLetters.add('l');

        boolean isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
        assertTrue(isGuessCorrect);

        userGuess = "o";

        notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        correctLetters.add('o');

        isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
        assertTrue(isGuessCorrect);
    }

    @Test
    public void OneCorrectOneWrongGuessesLetterGuessLetterTest() {
        GameState gameState = new GameState("London", 7, 2);
        String userGuess = "l";

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        ArrayList<Character> correctLetters = new ArrayList<>();
        correctLetters.add('l');

        boolean isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
        assertTrue(isGuessCorrect);

        userGuess = "a";

        notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
        assertFalse(isGuessCorrect);
    }

    @Test
    public void OneWrongOneCorrectGuessesLetterGuessLetterTest() {
        GameState gameState = new GameState("London", 7, 2);
        String userGuess = "a";

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('l');
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        boolean isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertFalse(isGuessCorrect);

        userGuess = "l";

        notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        ArrayList<Character> correctLetters = new ArrayList<>();
        correctLetters.add('l');

        isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
        assertTrue(isGuessCorrect);
    }

    @Test
    public void twoWrongGuessesLetterGuessLetterTest() {
        GameState gameState = new GameState("London", 7, 2);
        String userGuess = "b";

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('l');
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        boolean isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertFalse(isGuessCorrect);

        userGuess = "a";

        isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 5);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 2);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertFalse(isGuessCorrect);
    }

    @Test
    public void correctWordLetterGuessLetterTest() {
        GameState gameState = new GameState("London", 7, 2);
        String userGuess = "london";

        boolean isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertTrue(gameState.getLettersNotGuessed().isEmpty());
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertTrue(isGuessCorrect);
    }

    @Test
    public void correctCapitalWordLetterGuessLetterTest() {
        GameState gameState = new GameState("London", 7, 2);
        String userGuess = "LONDON";

        boolean isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertTrue(gameState.getLettersNotGuessed().isEmpty());
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertTrue(isGuessCorrect);
    }

    @Test
    public void wrongWordGuessLetterTest() {
        GameState gameState = new GameState("London", 7, 2);
        String userGuess = "Londn";

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('l');
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        boolean isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertFalse(isGuessCorrect);
    }

    @Test
    public void wrongWordGuessLetterTest2() {
        GameState gameState = new GameState("Edinburgh", 7, 2);
        String userGuess = "Edi";

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('e');
        notGuessedLetters.add('d');
        notGuessedLetters.add('i');
        notGuessedLetters.add('n');
        notGuessedLetters.add('b');
        notGuessedLetters.add('u');
        notGuessedLetters.add('r');
        notGuessedLetters.add('g');
        notGuessedLetters.add('h');

        boolean isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertFalse(isGuessCorrect);
    }

    @Test
    public void emptyGuessGuessLetterTest2() {
        GameState gameState = new GameState("Edinburgh", 7, 2);
        String userGuess = "";

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('e');
        notGuessedLetters.add('d');
        notGuessedLetters.add('i');
        notGuessedLetters.add('n');
        notGuessedLetters.add('b');
        notGuessedLetters.add('u');
        notGuessedLetters.add('r');
        notGuessedLetters.add('g');
        notGuessedLetters.add('h');

        boolean isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertFalse(isGuessCorrect);
    }

    @Test
    public void whiteSpaceCorrectGuessGuessLetterTest2() {
        GameState gameState = new GameState("St Andrews", 7, 2);
        String userGuess = " ";

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('s');
        notGuessedLetters.add('t');
        notGuessedLetters.add('a');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');
        notGuessedLetters.add('r');
        notGuessedLetters.add('e');
        notGuessedLetters.add('w');

        boolean isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertFalse(isGuessCorrect);
    }

    @Test
    public void whiteSpaceWrongGuessGuessLetterTest2() {
        GameState gameState = new GameState("StAndrews", 7, 2);
        String userGuess = " ";

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('s');
        notGuessedLetters.add('t');
        notGuessedLetters.add('a');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');
        notGuessedLetters.add('r');
        notGuessedLetters.add('e');
        notGuessedLetters.add('w');

        boolean isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertFalse(isGuessCorrect);
    }

    @Test
    public void nullGuessGuessLetterTest2() {
        GameState gameState = new GameState("London", 7, 2);
        String userGuess = null;

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('l');
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        boolean isGuessCorrect = gameState.makeGuess(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertFalse(isGuessCorrect);
    }

    @Test
    public void wonTest() {
        GameState gameState = new GameState("London", 7, 2);
        gameState.getLettersNotGuessed().clear();

        assertEquals(gameState.getLettersNotGuessed().size(), 0);
        assertTrue(gameState.isGameWon());
    }

    @Test
    public void wonTest2() {
        GameState gameState = new GameState("London", 7, 2);

        gameState.makeGuess("L");
        assertFalse(gameState.isGameWon());

        gameState.makeGuess("o");
        assertFalse(gameState.isGameWon());

        gameState.makeGuess("n");
        assertFalse(gameState.isGameWon());

        gameState.makeGuess("d");

        assertEquals(gameState.getLettersNotGuessed().size(), 0);
        assertTrue(gameState.isGameWon());
    }

    @Test
    public void wonLowerCaseLettersTest() {
        GameState gameState = new GameState("London", 7, 2);

        gameState.makeGuess("l");
        assertFalse(gameState.isGameWon());

        gameState.makeGuess("o");
        assertFalse(gameState.isGameWon());

        gameState.makeGuess("n");
        assertFalse(gameState.isGameWon());

        gameState.makeGuess("d");

        assertEquals(gameState.getLettersNotGuessed().size(), 0);
        assertTrue(gameState.isGameWon());
    }

    @Test
    public void wonCapitalLettersTest() {
        GameState gameState = new GameState("London", 7, 2);

        gameState.makeGuess("L");
        assertFalse(gameState.isGameWon());

        gameState.makeGuess("O");
        assertFalse(gameState.isGameWon());

        gameState.makeGuess("N");
        assertFalse(gameState.isGameWon());

        gameState.makeGuess("D");


        assertEquals(gameState.getLettersNotGuessed().size(), 0);
        assertTrue(gameState.isGameWon());
    }

    @Test
    public void wonWithWrongGuessLettersTest() {
        GameState gameState = new GameState("London", 7, 2);

        gameState.makeGuess("L");
        assertFalse(gameState.isGameWon());

        gameState.makeGuess("O");
        assertFalse(gameState.isGameWon());

        gameState.makeGuess("X");
        assertFalse(gameState.isGameWon());

        gameState.makeGuess("N");
        assertFalse(gameState.isGameWon());

        gameState.makeGuess("D");

        assertEquals(gameState.getLettersNotGuessed().size(), 0);
        assertTrue(gameState.isGameWon());
    }

    @Test
    public void notWonTest() {
        GameState gameState = new GameState("London", 7, 2);

        gameState.makeGuess("L");
        assertFalse(gameState.isGameWon());

        gameState.makeGuess("O");
        assertFalse(gameState.isGameWon());

        gameState.makeGuess("X");
        assertFalse(gameState.isGameWon());

        gameState.makeGuess("N");
        assertFalse(gameState.isGameWon());

        assertEquals(gameState.getLettersNotGuessed().size(), 1);
        assertFalse(gameState.isGameWon());
    }

    @Test
    public void notWonTest2() {
        GameState gameState = new GameState("London", 7, 2);

        gameState.makeGuess("L");
        assertFalse(gameState.isGameWon());

        assertEquals(gameState.getLettersNotGuessed().size(), 3);
        assertFalse(gameState.isGameWon());
    }

    @Test
    public void lostTest() {
        GameState gameState = new GameState("London", 7, 2);
        gameState.setNumberOfGuessesRemaining(0);

        assertTrue(gameState.isGameLost());
    }

    @Test
    public void lostTest2() {
        GameState gameState = new GameState("London", 1, 2);
        gameState.makeGuess("a");

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('l');
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        assertEquals(gameState.getNumberOfGuessesRemaining(), 0);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.isGameLost());
    }

    @Test
    public void lostTest3() {
        GameState gameState = new GameState("London", 1, 2);
        gameState.makeGuess("a");
        gameState.makeGuess("b");

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('l');
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        assertEquals(gameState.getNumberOfGuessesRemaining(), 0);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.isGameLost());
    }

    @Test
    public void lostTest4() {
        GameState gameState = new GameState("London", 1, 2);
        gameState.makeGuess("l");
        gameState.makeGuess("b");

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        assertEquals(gameState.getNumberOfGuessesRemaining(), 0);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.isGameLost());
    }

    @Test
    public void notLostTest() {
        GameState gameState = new GameState("L", 1, 2);
        gameState.makeGuess("l");

        assertEquals(gameState.getNumberOfGuessesRemaining(), 1);
        assertTrue(gameState.getLettersNotGuessed().isEmpty());
        assertFalse(gameState.isGameLost());
    }

    @Test
    public void notLostTest2() {
        GameState gameState = new GameState("London", 1, 2);
        gameState.makeGuess("l");

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        assertEquals(gameState.getNumberOfGuessesRemaining(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertFalse(gameState.isGameLost());
    }

    @Test
    public void notLostTest3() {
        GameState gameState = new GameState("London", 1, 2);
        gameState.makeGuess("l");

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');
        assertEquals(gameState.getNumberOfGuessesRemaining(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertFalse(gameState.isGameLost());

        gameState.makeGuess("o");
        notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');
        assertEquals(gameState.getNumberOfGuessesRemaining(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertFalse(gameState.isGameLost());

        gameState.makeGuess("n");
        notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('d');
        assertEquals(gameState.getNumberOfGuessesRemaining(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertFalse(gameState.isGameLost());

        gameState.makeGuess("d");
        assertEquals(gameState.getNumberOfGuessesRemaining(), 1);
        assertTrue(gameState.getLettersNotGuessed().isEmpty());
        assertFalse(gameState.isGameLost());
    }

    @Test
    public void hintTest() throws NotEnoughHintsException {
        GameState gameState = new GameState("London", 7, 2);
        gameState.giveHint();

        assertEquals(gameState.getNumberOfHints(), 1);
    }

    @Test(expected = NotEnoughHintsException.class)
    public void outOfHintsHintTest() throws NotEnoughHintsException {
        GameState gameState = new GameState("London", 7, 0);
        gameState.giveHint();

        assertEquals(gameState.getNumberOfHints(), 0);
    }

    @Test
    public void storeUniqueCharactersTest() {
        GameState gameState = new GameState("London", 7, 0);
        gameState.getLettersNotGuessed().clear();

        gameState.storeUniqueCharacters("London");

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('l');
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
    }

    @Test
    public void sameCharacterStoreUniqueCharactersTest() {
        GameState gameState = new GameState("", 7, 0);
        gameState.getLettersNotGuessed().clear();

        gameState.storeUniqueCharacters("LLLLLllllLLLL");

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('l');

        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
    }

    @Test
    public void emptyStoreUniqueCharactersTest() {
        GameState gameState = new GameState("", 7, 0);
        gameState.getLettersNotGuessed().clear();

        gameState.storeUniqueCharacters("");

        assertTrue(gameState.getLettersNotGuessed().isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void nullStoreUniqueCharactersTest() {
        GameState gameState = new GameState("", 7, 0);
        gameState.getLettersNotGuessed().clear();

        gameState.storeUniqueCharacters(null);

        assertTrue(gameState.getLettersNotGuessed().isEmpty());
    }

    @Test
    public void guessLetterTest() {
        GameState gameState = new GameState("London", 7, 2);
        char userGuess = 'l';

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        ArrayList<Character> correctLetters = new ArrayList<>();
        correctLetters.add('l');

        boolean isGuessCorrect = gameState.guessLetter(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
        assertTrue(isGuessCorrect);
    }

    @Test
    public void twoLettersGuessLetterTest() {
        GameState gameState = new GameState("London", 7, 2);
        char userGuess = 'l';

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        ArrayList<Character> correctLetters = new ArrayList<>();
        correctLetters.add('l');
        correctLetters.add('o');

        boolean isGuessCorrect = gameState.guessLetter(userGuess);
        userGuess = 'o';
        isGuessCorrect = gameState.guessLetter(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
        assertTrue(isGuessCorrect);
    }

    @Test
    public void wrongLetterGuessLetterTest() {
        GameState gameState = new GameState("London", 7, 2);
        char userGuess = 'a';

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('l');
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        boolean isGuessCorrect = gameState.guessLetter(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertFalse(isGuessCorrect);
    }

    @Test
    public void oneWrongOneCorrectGuessLetterTest() {
        GameState gameState = new GameState("London", 7, 2);
        char userGuess = 'a';

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('l');
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        boolean isGuessCorrect = gameState.guessLetter(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertFalse(isGuessCorrect);

        ArrayList<Character> correctLetters = new ArrayList<>();
        correctLetters.add('o');

        notGuessedLetters.clear();
        notGuessedLetters.add('l');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        userGuess = 'o';
        isGuessCorrect = gameState.guessLetter(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
        assertTrue(isGuessCorrect);
    }

    @Test
    public void oneCorrectOneWrongGuessLetterTest() {
        GameState gameState = new GameState("London", 7, 2);
        char userGuess = 'o';

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('l');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        ArrayList<Character> correctLetters = new ArrayList<>();
        correctLetters.add('o');

        boolean isGuessCorrect = gameState.guessLetter(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
        assertTrue(isGuessCorrect);

        userGuess = 'a';
        isGuessCorrect = gameState.guessLetter(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertEquals(gameState.getLettersGuessedCorrect(), correctLetters);
        assertFalse(isGuessCorrect);
    }

    @Test
    public void giveHintGuessLetterTest() {
        GameState gameState = new GameState("London", 7, 2);
        char userGuess = '?';

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('l');
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        boolean isGuessCorrect = gameState.guessLetter(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
        assertEquals(gameState.getNumberOfHints(), 1);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertFalse(isGuessCorrect);
    }

    @Test
    public void notEnoughHintsGuessLetterTest() {
        GameState gameState = new GameState("London", 7, 0);
        char userGuess = '?';

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('l');
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        boolean isGuessCorrect = gameState.guessLetter(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
        assertEquals(gameState.getNumberOfHints(), 0);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertFalse(isGuessCorrect);
    }

    @Test
    public void guessWordTest() {
        GameState gameState = new GameState("London", 7, 2);
        String userGuess = "London";

        boolean isGuessCorrect = gameState.guessWord(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertTrue(gameState.getLettersNotGuessed().isEmpty());
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertTrue(isGuessCorrect);
    }

    @Test
    public void ignoreCaseGuessWordTest() {
        GameState gameState = new GameState("London", 7, 2);
        String userGuess = "lONDON";

        boolean isGuessCorrect = gameState.guessWord(userGuess);

        assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertTrue(gameState.getLettersNotGuessed().isEmpty());
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertTrue(isGuessCorrect);
    }

    @Test
    public void emptyWrongGuessWordTest() {
        GameState gameState = new GameState("London", 7, 2);
        String userGuess = "";

        boolean isGuessCorrect = gameState.guessWord(userGuess);

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('l');
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertFalse(isGuessCorrect);
    }

    @Test
    public void wrongGuessWordTest() {
        GameState gameState = new GameState("London", 7, 2);
        String userGuess = "Londo";

        boolean isGuessCorrect = gameState.guessWord(userGuess);

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('l');
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        assertEquals(gameState.getNumberOfGuessesRemaining(), 6);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 1);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertFalse(isGuessCorrect);
    }

    @Test(expected = NullPointerException.class)
    public void nullGuessWordTest() {
        GameState gameState = new GameState("London", 7, 2);
        String userGuess = null;

        boolean isGuessCorrect = gameState.guessWord(userGuess);

        ArrayList<Character> notGuessedLetters = new ArrayList<>();
        notGuessedLetters.add('l');
        notGuessedLetters.add('o');
        notGuessedLetters.add('n');
        notGuessedLetters.add('d');

        assertEquals(gameState.getNumberOfGuessesRemaining(), 7);
        assertEquals(gameState.getNumberOfHints(), 2);
        assertEquals(gameState.getNumberOfGuessesMade(), 0);
        assertEquals(gameState.getLettersNotGuessed(), notGuessedLetters);
        assertTrue(gameState.getLettersGuessedCorrect().isEmpty());
        assertFalse(isGuessCorrect);
    }

    @Test
    public void detectQuestionMarksTest() throws QuestionMarkFoundException{
        GameState gameState = new GameState("Lon?don", 7, 2);
        gameState.detectQuestionMarks(gameState.getTargetName());

        assertEquals(gameState.getTargetName(), "London");
    }

    @Test
    public void noQuestionMarkDetectQuestionMarksTest() throws QuestionMarkFoundException{
        GameState gameState = new GameState("London", 7, 2);
        gameState.detectQuestionMarks(gameState.getTargetName());

        assertEquals(gameState.getTargetName(), "London");
    }

    @Test
    public void onlyQuestionMarkDetectQuestionMarksTest() throws QuestionMarkFoundException{
        GameState gameState = new GameState("?", 7, 2);
        gameState.detectQuestionMarks(gameState.getTargetName());

        assertEquals(gameState.getTargetName(), "");
    }

    @Test(expected = NullPointerException.class)
    public void nullQuestionMarkDetectQuestionMarksTest() throws QuestionMarkFoundException{
        GameState gameState = new GameState(null, 7, 2);
        gameState.detectQuestionMarks(gameState.getTargetName());

        assertEquals(gameState.getTargetName(), "");
    }
}
