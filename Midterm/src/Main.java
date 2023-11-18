
public class Main {
    // Main class is responsible for creating the model and view objects and running the game
    public static void main(String[] args) {
        GuessItModel model = new GuessItModel("Hello");
        GuessItView view = new GuessItView(model);
        GuessItController controller = new GuessItController(model, view);

    }
}