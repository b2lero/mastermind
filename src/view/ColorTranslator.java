package view;

import models.Color;

public class ColorTranslator {

    public Color mapFrom(char c) {
        Color[] colors = Color.values();
        int i = 0;
        while(i < colors.length && colors[i].getCode() != c) {
            i++;
        }
        if(i >= colors.length) {
            return null;
        }
        return colors[i];
    }

    public char mapFrom(Color c) {
        return c.getCode();
    }

    public Color[] mapFrom(char[] cs) {
        Color[] mappedColors = new Color[cs.length];
        for (int i = 0; i < cs.length; i++) {
            mappedColors[i] = mapFrom(cs[i]);
        }
        return mappedColors;
    }

}
