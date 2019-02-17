public class CommandOptions {

	public int maxGuesses;
	public int maxHints;
	
	String wordsDictionary;

	CommandOptions(String[] args) {
		maxGuesses = 10;
		maxHints = 3;
		wordsDictionary = "";
		
		for(int i = 0; i < args.length; ++i) {
			if (args[i].equals("--guesses")) {
				try{
					maxGuesses = Integer.parseInt(args[i+1]);
				} catch (NumberFormatException e){
					System.out.println("Number of guesses has to be an integer!");
					maxGuesses = 10;
					throw new NumberFormatException();
				} catch (IndexOutOfBoundsException e){
					System.out.println("Did not specify the number of guesses! Setting guesses default value!");
					maxGuesses = 10;
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
					maxHints = 3;
					throw new NumberFormatException();
				} catch (IndexOutOfBoundsException e){
					System.out.println("Did not specify the number of hints! Setting hints default value!");
					maxHints = 3;
					throw new IndexOutOfBoundsException();
				}
				if(maxHints <= 0){
					System.out.println("Invalid input - zero or negative number detected! Setting hints default value!");
					maxHints = 3;
				}
				i++;
			} else if(args[i].equals("--file")){
				wordsDictionary = args[i+1];
				i++;
			}
		}
	}
}
