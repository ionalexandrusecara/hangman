import static org.junit.Assert.*;

import org.junit.Test;

public class CommandOptionsTest {

	@Test
	public void noInputCommandOptionsTest() {
		String[] args = {};
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(args.length, 0);
		assertEquals(commandOptions.getMaxGuesses(), 10);
		assertEquals(commandOptions.getMaxHints(), 3);
		assertEquals(commandOptions.getWordsDictionary(), "");
	}

	@Test
	public void emptyInputCommandOptionsTest() {
		String[] args = {"", "", "", ""};
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.getMaxGuesses(), 10);
		assertEquals(commandOptions.getMaxHints(), 3);
		assertEquals(commandOptions.getWordsDictionary(), "");
	}

	@Test
	public void randomInputCommandOptionsTest() {
		String[] args = {"asd", "120", "&&*&^", "2"};
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.getMaxGuesses(), 10);
		assertEquals(commandOptions.getMaxHints(), 3);
		assertEquals(commandOptions.getWordsDictionary(), "");
	}

	@Test
	public void guessesInputCommandOptionsTest() {
		String[] args = {"--guesses", "7"};
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.getMaxGuesses(), 7);
		assertEquals(commandOptions.getMaxHints(), 3);
		assertEquals(commandOptions.getWordsDictionary(), "");
	}

	@Test
	public void guessesAndRandomInputCommandOptionsTest() {
		String[] args = {"asd", "92" ,"--guesses", "7", "odo"};
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.getMaxGuesses(), 7);
		assertEquals(commandOptions.getMaxHints(), 3);
		assertEquals(commandOptions.getWordsDictionary(), "");
	}

	@Test(expected = NumberFormatException.class)
	public void nullGuessesInputCommandOptionsTest() {
		String[] args = {"asd", "92" ,"--guesses", null, "odo"};
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.getMaxGuesses(), 10);
		assertEquals(commandOptions.getMaxHints(), 3);
		assertEquals(commandOptions.getWordsDictionary(), "");
	}

	@Test
	public void zeroGuessesInputCommandOptionsTest() {
		String[] args = {"asd", "92" ,"--guesses", "0", "odo"};
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.getMaxGuesses(), 10);
		assertEquals(commandOptions.getMaxHints(), 3);
		assertEquals(commandOptions.getWordsDictionary(), "");
	}

	@Test
	public void negativeGuessesInputCommandOptionsTest() {
		String[] args = {"asd", "92" ,"--guesses", "-1", "odo"};
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.getMaxGuesses(), 10);
		assertEquals(commandOptions.getMaxHints(), 3);
		assertEquals(commandOptions.getWordsDictionary(), "");
	}

	@Test(expected = NumberFormatException.class)
	public void nonNumberGuessesInputCommandOptionsTest() {
		String[] args = {"asd", "92" ,"--guesses", "asd", "odo"};
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.getMaxGuesses(), 10);
		assertEquals(commandOptions.getMaxHints(), 3);
		assertEquals(commandOptions.getWordsDictionary(), "");
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void noGuessesInputCommandOptionsTest() {
		String[] args = {"--guesses"};
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.getMaxGuesses(), 10);
		assertEquals(commandOptions.getMaxHints(), 3);
		assertEquals(commandOptions.getWordsDictionary(), "");
	}

	@Test
	public void hintsInputCommandOptionsTest() {
		String[] args = {"--hints", "7"};
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.getMaxGuesses(), 10);
		assertEquals(commandOptions.getMaxHints(), 7);
		assertEquals(commandOptions.getWordsDictionary(), "");
	}

	@Test
	public void hintsAndRandomInputCommandOptionsTest() {
		String[] args = {"asd", "92" ,"--hints", "7", "odo"};
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.getMaxGuesses(), 10);
		assertEquals(commandOptions.getMaxHints(), 7);
		assertEquals(commandOptions.getWordsDictionary(), "");
	}

	@Test(expected = NumberFormatException.class)
	public void nullHintsInputCommandOptionsTest() {
		String[] args = {"asd", "92" ,"--hints", null, "odo"};
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.getMaxGuesses(), 10);
		assertEquals(commandOptions.getMaxHints(), 3);
		assertEquals(commandOptions.getWordsDictionary(), "");
	}

	@Test
	public void zeroHintsInputCommandOptionsTest() {
		String[] args = {"asd", "92" ,"--hints", "0", "odo"};
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.getMaxGuesses(), 10);
		assertEquals(commandOptions.getMaxHints(), 3);
		assertEquals(commandOptions.getWordsDictionary(), "");
	}

	@Test
	public void negativeHintsInputCommandOptionsTest() {
		String[] args = {"asd", "92" ,"--hints", "-1", "odo"};
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.getMaxGuesses(), 10);
		assertEquals(commandOptions.getMaxHints(), 3);
		assertEquals(commandOptions.getWordsDictionary(), "");
	}

	@Test(expected = NumberFormatException.class)
	public void nonNumberHintsInputCommandOptionsTest() {
		String[] args = {"asd", "92" ,"--hints", "asd", "odo"};
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.getMaxGuesses(), 10);
		assertEquals(commandOptions.getMaxHints(), 3);
		assertEquals(commandOptions.getWordsDictionary(), "");
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void noHintsInputCommandOptionsTest() {
		String[] args = {"--hints"};
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.getMaxGuesses(), 10);
		assertEquals(commandOptions.getMaxHints(), 3);
		assertEquals(commandOptions.getWordsDictionary(), "");
	}

	@Test
	public void fileInputCommandOptionsTest() {
		String[] args = {"--file", "asd.txt"};
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.getMaxGuesses(), 10);
		assertEquals(commandOptions.getMaxHints(), 3);
		assertEquals(commandOptions.getWordsDictionary(), "asd.txt");
	}

	@Test
	public void fileAndRandomInputCommandOptionsTest() {
		String[] args = {"asd", "92" ,"--file", "asd.txt", "odo"};
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.getMaxGuesses(), 10);
		assertEquals(commandOptions.getMaxHints(), 3);
		assertEquals(commandOptions.getWordsDictionary(), "asd.txt");
	}

	@Test
	public void nullFileInputCommandOptionsTest() {
		String[] args = {"asd", "92" ,"--file", null, "odo"};
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.getMaxGuesses(), 10);
		assertEquals(commandOptions.getMaxHints(), 3);
		assertEquals(commandOptions.getWordsDictionary(), "");
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void noFileInputCommandOptionsTest() {
		String[] args = {"--file"};
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.getMaxGuesses(), 10);
		assertEquals(commandOptions.getMaxHints(), 3);
		assertEquals(commandOptions.getWordsDictionary(), "");
	}

	@Test
	public void normalInputCommandOptionsTest() {
		String[] args = { "--guesses", "2", "--hints", "4", "--file", "words.txt" };
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.getMaxGuesses(), 2);
		assertEquals(commandOptions.getMaxHints(), 4);
		assertEquals(commandOptions.getWordsDictionary(), "words.txt");
	}

	@Test(expected = NullPointerException.class)
	public void nullInputCommandOptionsTest() {
		String[] args = null;
		CommandOptions commandOptions = new CommandOptions(args);
	}

}
