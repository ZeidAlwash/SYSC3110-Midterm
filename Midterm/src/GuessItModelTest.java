import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class GuessItModelTest {
    private GuessItModel model;

    @Test
    public void testWrongGuess() {
        // Initialize the model with the word "Hello"
        model = new GuessItModel("Hello");

        // Attempt to set a wrong guess
        model.setSecretWord("Hellllllo");

        // Check if the values are not equal
        assertFalse(model.getSecretWord().equals(model.getCurrentWord()));
    }

    @Test
    public void testCorrectGuess() {
        // Initialize the model with the word "Hello"
        model = new GuessItModel("hello");

        // Test if the model detects correct guess
        model.setSecretWord("hello");
        model.setCurrentWord("hello");
        model.setNumGuesses(3);

        // Check if the values are equal
        assertTrue(model.getSecretWord().equals(model.getCurrentWord()));
    }

}