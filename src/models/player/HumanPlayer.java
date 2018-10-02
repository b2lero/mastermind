package models.player;

import models.PlayerEventsListener;

public class HumanPlayer implements Player {

    private PlayerEventsListener listener;

    public HumanPlayer(PlayerEventsListener listener) {
        this.listener = listener;
    }

    @Override
    public void startTurn() {
        listener.onManualCombinationRequest();
    }
}
