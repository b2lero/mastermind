package controller;

import models.Color;
import models.GameEventsListener;
import models.MasterMind;
import models.player.Player;
import view.ColorTranslator;
import view.Console;

public class ConsoleController implements GameEventsListener {

    private Console console = new Console();
    private ColorTranslator colorTranslator = new ColorTranslator();
    private MasterMind masterMind;

    private Player random;
    private Player human;

    public ConsoleController(MasterMind masterMind, Player random,
                             Player human) {
        this.masterMind = masterMind;
        this.random = random;
        this.human = human;
    }

    public void run() {
        while(true) {
            console.showMenu();
            int option = console.getInt();
            if (option == 1) {
                startPlay();
            } else if (option == 2) {
                startDemoPlay();
            }
            console.showMessageLn();
        }
    }

    private void startDemoPlay() {
        masterMind.setPlayer(random);
        masterMind.startNewGame();
    }

    private void startPlay() {
        masterMind.setPlayer(human);
        masterMind.startNewGame();
    }

    @Override
    public void onGameWon() {
        console.showMessageLn("You win!");
    }

    @Override
    public void onGameOver(Color[] secretCombi) {
        console.showMessageLn("You lost!");
        console.showCombination(secretCombi);
    }

    @Override
    public void onCombinationResult(Color[] c, int killed, int damaged) {
        console.showCombination(c);
        console.showMessageLn(String.format(" (%d muertos y %d heridos)",killed,damaged));
    }

    @Override
    public void onManualCombinationRequest() {
        String userInput = console.getString();
        char[] userInputChars = splitToIndividualChars(userInput);
        Color[] colors = colorTranslator.mapFrom(userInputChars);
        masterMind.onCombinationChoosen(colors);
    }

    @Override
    public void onGameStart(int combiLength) {
        String hiddenCode = generateHiddenCode(combiLength);
        console.showMessageLn("Secreto: "+hiddenCode);
    }

    private String generateHiddenCode(int combiLength) {
        String s = "";
        for(int i=0;i<combiLength;i++){
            s += "*";
        }
        return s;
    }

    @Override
    public void onCombinationRequest() {
        console.showMessageLn("Intento: [cuatro letras de entre A-amarillo, R-Rojo, V-verde, Z-azul," +
                "B-blanco, N-negro]");
    }

    private char[] splitToIndividualChars(String s) {
        String[] splitted = s.split("");
        char[] chars = new char[s.length()];
        for (int i = 0; i < splitted.length; i++) {
            String sp = splitted[i];
            chars[i] = sp.charAt(0);
        }
        return chars;
    }
}
