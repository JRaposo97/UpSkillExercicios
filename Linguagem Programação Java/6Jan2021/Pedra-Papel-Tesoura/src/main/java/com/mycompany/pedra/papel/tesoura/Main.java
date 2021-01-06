/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pedra.papel.tesoura;

import java.util.Scanner;

/**
 *
 * @author joaor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int player1Score = 0;
        int player2Score = 0;
        int counter = 0;

        System.out.println("Jogo a melhor de 3");
        while (counter == 0) {
            System.out.println(" Jogador 1 (Enter 1-Pedra, 2-Papel, 3-Tesoura): ");
            int player1Choice = scan.nextInt();

            System.out.println(" Jogador 2 (Enter 1-Pedra, 2-Papel, 3-Tesoura): ");
            int player2Choice = scan.nextInt();

            if (player1Choice == player2Choice) {
                System.out.println("É um empate, não serão adicionados pontos");
            } else if (player1Choice == 1) {
                if (player2Choice == 2) {
                    System.out.println("Player 2 ganhou esta ronda");
                    player2Score++;
                } else if (player2Choice == 3) {
                    System.out.println("Player 1 ganhou esta ronda");
                    player1Score++;
                }
            } else if (player1Choice == 2) {
                if (player2Choice == 1) {
                    System.out.println("Player 1 ganhou esta ronda!");
                    player1Score++;

                } else if (player2Choice == 3) {
                    System.out.println("Player 2 ganhou esta ronda!");
                    player2Score++;
                }
            } else if (player1Choice == 3) {
                if (player2Choice == 1) {
                    System.out.println("Player 2 Ganhou esta ronda!");
                    player2Score++;
                } else if (player2Choice == 2) {
                    System.out.println("Player 1 Ganhou esta ronda!");
                    player1Score++;
                }
            }
            if (player1Score == 3) {
                System.out.println("Player 1 Ganhou! Parabens!");
                counter++;
            }
            if (player2Score == 3) {
                System.out.println("Player 2 Ganhou! Parabens!");
                counter++;
            }
        }
    }

}
