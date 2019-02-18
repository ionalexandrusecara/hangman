public class CommandOptions {

	private int maxGuesses;
	private int maxHints;
	
	private String wordsDictionary;

	CommandOptions(String[] args) {
		if(args == null){
			throw new NullPointerException();
		}
		maxGuesses = 10;
		maxHints = 3;
		wordsDictionary = "";
		
		for(int i = 0; i < args.length; ++i) {
			if (args[i].equals("--guesses")) {
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
				i++;
			}
			else if (args[i].equals("--hints")) {
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
				i++;
			} else if(args[i].equals("--file")){
				try{
					wordsDictionary = args[i+1];
				} catch (IndexOutOfBoundsException e){
					System.out.println("Did not specify the file! Will not allow custom input!");
					throw new IndexOutOfBoundsException();
				}
				if(wordsDictionary == null){
					wordsDictionary = "";
				}
				i++;
			}
		}
	}

	public int getMaxGuesses() {
		return maxGuesses;
	}

	public void setMaxGuesses(int maxGuesses) {
		this.maxGuesses = maxGuesses;
	}

	public String getWordsDictionary() {
		return wordsDictionary;
	}

	public int getMaxHints() {
		return maxHints;
	}

	public void setMaxHints(int maxHints) {
		this.maxHints = maxHints;
	}

	public void setWordsDictionary(String wordsDictionary) {
		this.wordsDictionary = wordsDictionary;
	}
}
