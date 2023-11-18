import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessItController implements ActionListener {
    private GuessItModel model;
    private GuessItView view;

    public GuessItController(GuessItModel model, GuessItView view) {
        this.model = model;
        this.view = view;
    }



    // Override for the actionPerformed method
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the string in the text field
        String input = view.getTextField().getText();

        // Check if the input is empty and if the number of guesses is less than 5 and if the input is a 5 characters long
        if (!input.isEmpty() && model.getNumGuesses() < 5 && input.length() == 5) {
            // Increment the number of guesses
            model.setNumGuesses(model.getNumGuesses() + 1);

            // Check if the input is the same as the secret word
            if (input.equals(model.getSecretWord())) {

                // Set each character of the secretWord to the top row of the grid and set the color to green
                for (int i = 0; i < 5; i++) {
                    view.getButtons()[0][i].setText(String.valueOf(model.getSecretWord().charAt(i)));
                    view.getButtons()[0][i].setBackground(java.awt.Color.GREEN);
                }

                // Show a JOptionPane dialog that the user won
                JOptionPane.showMessageDialog(view.getPanel(), "Congratulations! You've guessed the secret word!");

            } else {
                //check if the input is not the same as the secret word and if the number of guesses is less than 5
                if (!input.equals(model.getSecretWord()) && model.getNumGuesses() < 5) {
                    // For each correctly guessed letter, set the letter to the grid and set the color to green. Also set the letter to the top row of the grid and set the color to green.
                    // For each incorrectly guessed letter that's in the secretWord but not at the correct position, set the letter to the grid and set the color to yellow.
                    // For each incorrectly guessed letter that's not in the secretWord, set the letter to the grid and set the color to grey.
                    for (int i = 0; i < 5; i++) {
                        if (input.charAt(i) == model.getSecretWord().charAt(i)) {
                            view.getButtons()[0][i].setText(String.valueOf(input.charAt(i)));
                            view.getButtons()[0][i].setBackground(java.awt.Color.GREEN);
                            view.getButtons()[model.getNumGuesses()][i].setText(String.valueOf(input.charAt(i)));
                            view.getButtons()[model.getNumGuesses()][i].setBackground(java.awt.Color.GREEN);
                        } else if (model.getSecretWord().contains(String.valueOf(input.charAt(i)))) {
                            view.getButtons()[model.getNumGuesses()][i].setText(String.valueOf(input.charAt(i)));
                            view.getButtons()[model.getNumGuesses()][i].setBackground(java.awt.Color.YELLOW);
                        } else {
                            view.getButtons()[model.getNumGuesses()][i].setText(String.valueOf(input.charAt(i)));
                            view.getButtons()[model.getNumGuesses()][i].setBackground(java.awt.Color.GRAY);
                        }
                    }

                } else {
                    //show a JOptionPane dialog that the user lost
                    JOptionPane.showMessageDialog(view.getPanel(), "Sorry, you've run out of guesses. Better luck next time.");
                }
            }
        } else if (input.isEmpty() || input.length() != 5) {
            // Show a JOptionPane dialog that the user did not enter a 5 character long word
            JOptionPane.showMessageDialog(view.getPanel(), "Please enter a 5 character long word.");
        }else if (model.getNumGuesses() == 5) {
            // Show a JOptionPane dialog that the user lost
            JOptionPane.showMessageDialog(view.getPanel(), "Sorry, you've run out of guesses. Better luck next time.");

        }

    }
}
