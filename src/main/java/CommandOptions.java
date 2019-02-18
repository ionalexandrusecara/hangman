public class CommandOptions {

	private int maxGuesses;
	private int maxHints;
	private String wordsDictionary;

	/**
	 * CommandOptions constructor
	 * Default values are 10 guesses, 3 hints and an empty dictionary
	 * The method parses the args input and stores the number of guesses, hints and the names to be guessed from the input file
	 * Throws NumberFormatException if the number of gusses or hints is not a number
	 * Throws IndexOutOfBoundsException if the input is not properly specified
	 * If number of guesses or number of hints are 0 or smaller, the program sets default values - no exception thrown
	 * Throws
	 * @param args
	 */
	CommandOptions(String[] args) {
		if(args == null){
			throw new NullPointerException();
		}

		maxGuesses = 10;
		maxHints = 3;
		wordsDictionary = "";
		
		for(int i = 0; i < args.length; ++i) {
			switch(args[i]){
				case "--guesses":
					parseGuesses(args, i);
					i++;
					break;
				case "--hints":
					parseHints(args, i);
					i++;
					break;
				case "--file":
					parseFile(args, i);
					i++;
					break;
			}
		}
	}

	public void parseGuesses(String[] args, int i){
		try{
			maxGuesses = Integer.parseInt(args[i+1]);
		} catch (NumberFormatException e){
			System.out.println("Number of guesses has to be an integer!");
			throw new NumberFormatException();
		} catch (IndexOutOfBoundsException e){
			System.out.println("Did not specify the number of guesses! Setting guesses default value!");
			throw new IndexOutOfBoundsException();
		}

		if(maxGuesses <= 0){
			System.out.println("Invalid input - zero or negative number detected! Setting guesses default value!");
			maxGuesses = 10;
		}
	}

	public void parseHints(String[] args, int i){
		try{
			maxHints = Integer.parseInt(args[i+1]);
		} catch (NumberFormatException e){
			System.out.println("Number of hints has to be an integer!");
			throw new NumberFormatException();
		} catch (IndexOutOfBoundsException e){
			System.out.println("Did not specify the number of hints! Setting hints default value!");
			throw new IndexOutOfBoundsException();
		}

		if(maxHints <= 0){
			System.out.println("Invalid input - zero or negative number detected! Setting hints default value!");
			maxHints = 3;
		}
	}

	public void parseFile(String[] args, int i){
		try{
			wordsDictionary = args[i+1];
		} catch (IndexOutOfBoundsException e){
			System.out.println("Did not specify the file! Will not allow custom input!");
			throw new IndexOutOfBoundsException();
		}

		if(wordsDictionary == null){
			wordsDictionary = "";
		}
	}

	public int getMaxGuesses() {
		return maxGuesses;
	}

	public String getWordsDictionary() {
		return wordsDictionary;
	}

	public int getMaxHints() {
		return maxHints;
	}

	public void setMaxGuesses(int maxGuesses) {
		this.maxGuesses = maxGuesses;
	}

	public void setWordsDictionary(String wordsDictionary) {
		this.wordsDictionary = wordsDictionary;
	}

	public void setMaxHints(int maxHints) {
		this.maxHints = maxHints;
	}
}
