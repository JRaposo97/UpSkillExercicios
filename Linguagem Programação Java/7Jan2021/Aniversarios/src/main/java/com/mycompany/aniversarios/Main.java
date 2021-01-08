/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aniversarios;

import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import com.mycompany.aniversarios.Utilitario;
import java.io.FileNotFoundException;

/**
 *
 * @author upskills
 */
public class Main {

    static Scanner scan = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        lerNomeFicheiro();

    }

    private static void lerNomeFicheiro() {

        Formatter output = null;

        String filename = "";
        do {
            System.out.println("Insira o nome do ficheiro pretendido");
            filename = scan.nextLine();
            if (filename.isEmpty()) {
                System.out.println("Nome do Ficheiro não pode ser vazio!");
            }
        } while (filename.isEmpty());
        try {
            output = new Formatter(filename);
            aniversarios(output);

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private static void aniversarios(Formatter output) {

        String nome = "";
        String dataNasc = "";
        do {
            boolean flag = false;
            System.out.println("Nome (ENTER Para Terminar): ");
            nome = scan.nextLine();
            if (!nome.isEmpty()) {
                do {
                    try {
                        System.out.println("Data de Aniversario (ano/mes/dia)");
                        dataNasc = scan.next();
                        Utilitario.lerData(dataNasc);
                        flag = true;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                } while (flag == false);
                output.format("%s; %s %n", nome, dataNasc);
            }
        } while (nome.isEmpty());

        System.out.println("Aplicação Terminada!");

        output.close();

    }

}
