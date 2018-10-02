import models.MasterMind;
import models.player.HumanPlayer;
import models.player.RandomPlayer;
import controller.ConsoleController;

public class Init {

    public static void main(String[] args) {
        MasterMind masterMind = new MasterMind(4,10);

        HumanPlayer human = new HumanPlayer(masterMind);
        RandomPlayer random = new RandomPlayer(masterMind,4);

        ConsoleController consoleController = new ConsoleController(masterMind, random, human);
        masterMind.setListener(consoleController);

        consoleController.run();
    }
}
