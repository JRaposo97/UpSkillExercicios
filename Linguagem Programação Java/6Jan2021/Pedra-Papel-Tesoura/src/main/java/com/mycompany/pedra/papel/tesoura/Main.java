/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pedra.papel.tesoura;

import static com.mycompany.pedra.papel.tesoura.Sinal.*;
import java.util.Scanner;

/**
 *
 * @author joaor
 */
public class Main {

    static Scanner scan = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int player1Score = 0;
        int player2Score = 0;

        System.out.println("Jogo a melhor de 3");
        
        while (player1Score != 3 && player2Score != 3) {
            System.out.println("Jogador 1 (Enter 1-Pedra, 2-Papel, 3-Tesoura): ");
            int player1Choice = scan.nextInt();

            System.out.println("Jogador 2 (Enter 1-Pedra, 2-Papel, 3-Tesoura): ");
            int player2Choice = scan.nextInt();
            

            switch (Sinal.score(player1Choice, player2Choice)) {
                case 0:
                    System.out.println("Empate! Ninguem ganhou pontos!");
                    break;
                case 1:
                    System.out.println("Player 1 Ganhou! ");
                    player1Score++;
                    break;
                case -1:
                    System.out.println("Player 2 Ganhou! ");
                    player2Score++;
                    break;
            }
        }
        if (player1Score == 3) {
            System.out.println("Player 1 Ganhou! Parabens!");
        } else {
            System.out.println("Player 2 Ganhou! Parabens!");
        }

    }

}
