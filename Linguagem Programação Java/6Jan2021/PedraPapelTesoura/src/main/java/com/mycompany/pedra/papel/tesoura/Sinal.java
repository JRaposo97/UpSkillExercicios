/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pedra.papel.tesoura;

import java.util.List;

/**
 *
 * @author joaor
 */
public enum Sinal {
    ROCK(1), PAPER(2), SCISSORS(3);

    private final int value;

    private Sinal(int value) {
        this.value = value;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    public static int score(int player1Choice, int player2Choice) {
        int score = player1Choice - player2Choice;
        if (score == 2) {
            score = -1;
        } else if (score == -2) {
            score = 1;
        }
        return score;
    }

}
