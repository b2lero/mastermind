package models;

import models.player.Player;

public class MasterMind implements PlayerEventsListener{

    private Combination secret;
    private GameEventsListener listener; //null

    private final int combiLength;
    private final int maxAttempts;

    private int attempts;
    private Player player;


    public MasterMind(int combiLength,int maxAttempts) {
        this.combiLength = combiLength;
        this.maxAttempts = maxAttempts;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setListener(GameEventsListener listener) {
        this.listener = listener;
    }

    public void startNewGame() {
        attempts = 0;
        this.secret = Combination.generateRandomCombination(combiLength);
        listener.onGameStart(combiLength);
        nextTurn();
    }

    public void onCombinationChoosen(Color[] c) {
        attempts++;

        Combination playerCombi = new Combination(c);

        int killed = secret.killedComparingWith(playerCombi);
        int damaged = secret.damagedComparingWith(playerCombi);

        listener.onCombinationResult(c,killed,damaged);

        if(playerCombi.equals(secret)) {
            listener.onGameWon();
        }
        else {
            nextTurn();
        }
    }

    private void nextTurn() {
        if(attempts < maxAttempts) {
            listener.onCombinationRequest();
            player.startTurn();
        }
        else {
            listener.onGameOver(secret.getColors());
        }
    }

    @Override
    public void onManualCombinationRequest() {
        listener.onManualCombinationRequest();
}
}
