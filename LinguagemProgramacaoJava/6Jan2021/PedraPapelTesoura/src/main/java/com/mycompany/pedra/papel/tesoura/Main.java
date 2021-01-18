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

    static Scanner scan = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Game g1 = new Game(3);
        
        g1.startGame();
    }

}
