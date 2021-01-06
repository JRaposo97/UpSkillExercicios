/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pedra.papel.tesoura;

import static com.mycompany.pedra.papel.tesoura.Main.scan;

/**
 *
 * @author upskills
 */
public class Game {

    private int maxValue;

    public Game(int maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * @return the maxValue
     */
    public int getMaxValue() {
        return maxValue;
    }

    /**
     * @param maxValue the maxValue to set
     */
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public void startGame() {

        System.out.println("Jogo a melhor de " + getMaxValue());

        int array[] = {0, 0};

        while (array[0] != getMaxValue() && array[1] != getMaxValue()) {

            int player1Choice = input(0);

            int player2Choice = input(1);

            switch (Sinal.score(player1Choice, player2Choice)) {
                case 0:
                    System.out.println("Empate! Ninguem ganhou pontos!");
                    break;
                case 1:
                    System.out.println("Player 1 Ganhou esta Ronda! ");
                    addScore(array, 0);
                    break;
                case -1:
                    System.out.println("Player 2 Ganhou esta Ronda! ");
                    addScore(array, 1);
                    break;
            }
        }
        checkScores(array);

    }

    private void checkScores(int[] array) {
        if (array[0] == getMaxValue()) {
            System.out.println("Player 1 Ganhou! Parabens!");
        } else {
            System.out.println("Player 2 Ganhou! Parabens!");
        }
    }

    private void addScore(int[] array, int i) {
        array[i]++;
    }

    private int input(int i) {
        System.out.println("Jogador" + i + " (Enter 1-Pedra, 2-Papel, 3-Tesoura): ");
        return scan.nextInt();
    }

}
