import javax.swing.*;
import java.awt.*;

public class GuessItView {
    private GuessItModel model;

    private JFrame frame;

    private JPanel panel;

    private JButton[][] buttons;

    private JTextField textField;


    // Constructor for GuessItView
    public GuessItView(GuessItModel model){

        // Initialize the model and the frame and the buttons
        this.model = model;
        frame = new JFrame("Guess It Game");
        panel = new JPanel(new GridLayout(7, 5));
        buttons = new JButton[7][5];

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 5; col++) {
                buttons[row][col] = new JButton();
                panel.add(buttons[row][col]);
            }
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        // Add a JTextField for user input
        textField = new JTextField(20);
        panel.add(textField);

        // Show a JOptionPane dialog for user input for the word to be guessed
        String input = JOptionPane.showInputDialog("Enter the word to be guessed:");
        model.setSecretWord(input);

        // Show a JButton submit next to the textField
        JButton submit = new JButton("Submit");
        panel.add(submit);
        submit.addActionListener(new GuessItController(model, this));

    }

    // Getter for textField
    public JTextField getTextField() {
        return textField;
    }

    // Getter for panel
    public Component getPanel() {
        return panel;
    }

    // Getter for buttons
    public JButton[][] getButtons() {
        return buttons;
    }

}
