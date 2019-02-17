import static org.junit.Assert.*;

import org.junit.Test;

public class CommandOptionsTest {

	@Test
	public void fileInputCommandOptionsTest() {
		String[] args = { "--guesses", "2", "--hints", "4", "words.txt" };
		CommandOptions commandOptions = new CommandOptions(args);
		assertEquals(commandOptions.maxGuesses, 2);
		assertEquals(commandOptions.maxHints, 4);
		assertEquals(commandOptions.wordsDictionary, "words.txt");
	}



}
