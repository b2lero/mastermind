package view;

import java.util.Scanner;

import models.Color;

public class Console {

    private Scanner sc = new Scanner(System.in);

    public void showMessageLn(String msg) {
        System.out.println(msg);
    }

    public void showMessage(String msg) {
        System.out.print(msg);
    }

    public void showMenu() {
        showMessageLn("--- MASTERMIND ---");
        showMessageLn("1. Partida");
        showMessageLn("2. Demo");
        showMessageLn("------------------");
    }

    public void showCombination(Color[] c) {
        showMessage(formatCombi(c));
    }

    public String getString() {
        return sc.nextLine();
    }

    public int getInt() {
        int n = sc.nextInt();
        sc.nextLine();
        return n;
    }

    private String formatCombi(Color[] colors) {
        StringBuilder s = new StringBuilder();
        for(Color c : colors) {
            s.append(c.toString());
        }
        return s.toString();
    }

    public void showMessageLn() {
        showMessageLn("");
    }
}
