import static org.junit.Assert.*;

import org.junit.Test;

public class CommandOptionsTest {

	@Test
	public void optionsTest() {
		String[] args = { "--guesses", "2", "--hints", "4", "words.txt" };
		CommandOptions opts = new CommandOptions(args);
		assertEquals(opts.maxguesses, 2);
		assertEquals(opts.maxhints, 4);
		assertEquals(opts.wordsource, "words.txt");
	}

}
