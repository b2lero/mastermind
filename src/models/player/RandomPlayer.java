package models.player;

import java.util.Random;

import models.Color;
import models.PlayerEventsListener;

public class RandomPlayer implements Player {

    private PlayerEventsListener listener;

    private int combiLength;

    public RandomPlayer(PlayerEventsListener listener, int combiLength) {
        this.listener = listener;
        this.combiLength = combiLength;
    }

    @Override
    public void startTurn() {
        Random r = new Random();
        Color[] colors = Color.values();
        Color[] randomCombi = new Color[combiLength];
        for(int i=0;i<combiLength;i++) {
            randomCombi[i] = colors[r.nextInt(colors.length)];
        }
        listener.onCombinationChoosen(randomCombi);
    }
}
