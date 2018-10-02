package models;

public interface GameEventsListener {
    void onGameWon();
    void onGameOver(Color[] secretCombi);
    void onCombinationResult(Color[] c, int killed, int damaged);
    void onManualCombinationRequest();
    void onGameStart(int combiLength);
    void onCombinationRequest();
}
