/**
 * CommandOptions class
 * Parses the user's command line input - args[]
 * Retreives the values of guesses, hints and words dictionary file accordingly.
 * If invalid, the default values are 10 guesses, 3 hints and an empty dictionary file
 */
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
     *
     * @param args
     */
    CommandOptions(String[] args) {
        if (args == null) {
            throw new NullPointerException();
        }

        maxGuesses = 10;
        maxHints = 3;
        wordsDictionary = "";

        for (int i = 0; i < args.length; ++i) {
            switch (args[i]) {
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
                default:
                    i++;
                    break;
            }
        }
    }

    /**
     * parseGuesses is called when args contains the --guesses string
     * The method assigns the number of guesses passed as a parameter by the user
     * If input is not valid, it assigns the default value - 10 guesses
     *
     * @param args
     * @param i
     */
    public void parseGuesses(String[] args, int i) {
        try {
            maxGuesses = Integer.parseInt(args[i + 1]);
        } catch (NumberFormatException e) {
            System.out.println("Number of guesses has to be an integer!");
            maxGuesses = 10;
            throw new NumberFormatException();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Did not specify the number of guesses! Setting guesses default value!");
            maxGuesses = 10;
            throw new IndexOutOfBoundsException();
        } catch (NullPointerException e) {
            maxGuesses = 10;
            throw new NullPointerException();
        }

        if (maxGuesses <= 0) {
            System.out.println("Invalid input - zero or negative number detected! Setting guesses default value!");
            maxGuesses = 10;
        }
    }

    /**
     * parseHints is called when args contains the --hints string
     * The method assigns the number of hints passed as a parameter by the user
     * If input is not valid, it assigns the default value - 3 hints
     *
     * @param args
     * @param i
     */
    public void parseHints(String[] args, int i) {
        try {
            maxHints = Integer.parseInt(args[i + 1]);
        } catch (NumberFormatException e) {
            System.out.println("Number of hints has to be an integer!");
            maxHints = 3;
            throw new NumberFormatException();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Did not specify the number of hints! Setting hints default value!");
            maxHints = 3;
            throw new IndexOutOfBoundsException();
        } catch (NullPointerException e) {
            maxHints = 3;
            throw new NullPointerException();
        }

        if (maxHints <= 0) {
            System.out.println("Invalid input - zero or negative number detected! Setting hints default value!");
            maxHints = 3;
        }
    }

    /**
     * parseFile is called when args contains the --file string
     * The method assigns the name of the file where the custom names can be found
     * If input is not valid, it assigns the default value - "" empty string which is handled properly later in the program
     *
     * @param args
     * @param i
     */
    public void parseFile(String[] args, int i) {
        try {
            wordsDictionary = args[i + 1];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Did not specify the file! Will not allow custom input!");
            wordsDictionary = "";
            throw new IndexOutOfBoundsException();
        } catch (NullPointerException e) {
            wordsDictionary = "";
            throw new NullPointerException();
        }

        if (wordsDictionary == null) {
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
