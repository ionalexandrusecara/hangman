public class CommandOptions {

	public int maxGuesses;
	public int maxHints;
	
	String wordsDictionary;

	CommandOptions(String[] args) {
		maxGuesses = 10;
		maxHints = 2;
		
		wordsDictionary = "";
		
		for(int i = 0; i < args.length; ++i) {
			if (args[i].equals("--guesses")) {
				maxGuesses = Integer.parseInt(args[i+1]);
				i++;
			}
			else if (args[i].equals("--hints")) {
				maxHints = Integer.parseInt(args[i+1]);
				i++;
			}
			else wordsDictionary = args[i];
		}
	}
}
