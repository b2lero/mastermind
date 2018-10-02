package models;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Combination {

    private Color[] colors;

    Combination(Color[] colors) {
        this.colors = colors;
    }

    int damagedComparingWith(Combination other) {
        Map<Color,Integer> appearancesMap = new HashMap<>();
        for (Color color : colors) {
            int last = 0;
            if (appearancesMap.containsKey(color))
                last = appearancesMap.get(color);
            appearancesMap.put(color, last + 1);
        }

        Color[] otherColors = other.colors;

        int damaged = 0;

        for (int i = 0; i < otherColors.length; i++) {
            Color color = otherColors[i];
            if (appearancesMap.containsKey(color) && !colors[i].equals(color)) {
                int appearances = appearancesMap.get(color);
                if (appearances > 0) {
                    appearances--;
                    damaged++;
                }
                appearancesMap.put(color, appearances);
            }
        }

        return damaged;
    }

    int killedComparingWith(Combination other) {
        int killed = 0;
        Color[] otherColors = other.colors;
        for(int i = 0;i<otherColors.length;i++) {
            Color color = otherColors[i];
            if(color.equals(colors[i])) {
                killed++;
            }
        }
        return killed;
    }

    static Combination generateRandomCombination(int combiLength) {
        Random r = new Random();
        Color[] colors = Color.values();
        Color[] randomCombi = new Color[combiLength];
        for(int i=0;i<randomCombi.length;i++) {
            randomCombi[i] = colors[r.nextInt(colors.length)];
        }
        return new Combination(randomCombi);
    }

    Color[] getColors() {
        return colors;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Combination) {
            Combination other = (Combination) obj;
            return Arrays.equals(this.colors,other.colors);
        }
        return false;
    }
}
