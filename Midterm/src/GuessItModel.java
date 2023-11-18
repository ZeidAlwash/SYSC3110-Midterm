public class GuessItModel {
    private String secretWord;
    private String currentWord;
    private final int MaxNumGuesses = 5;

    private int numGuesses;

    // Constructor for GuessItModel class
    public GuessItModel(String secretWord) {
        this.secretWord = secretWord;
        this.currentWord = "";
        numGuesses = 0;

    }

    // Getter for secretWord
    public String getSecretWord() {
        return secretWord;
    }


    // Setter for secretWord
    public void setSecretWord(String input) {
        secretWord = input;
    }

    // Getter for currentWord
    public String getCurrentWord() {
        return currentWord;
    }

    // Setter for currentWord
    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }

    // Getter for numGuesses
    public int getNumGuesses() {
        return numGuesses;
    }

    // Setter for numGuesses
    public void setNumGuesses(int numGuesses) {
        this.numGuesses = numGuesses;
    }


}
