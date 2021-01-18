package org.dei.excecaoUnchecked;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class TestePessoa {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        try {
            Pessoa p = new Pessoa();

            System.out.println("Nome:");
            String nome = ler.nextLine();
            p.setNome(nome);

            System.out.println("Nº de ID Civil:");
            int idCivil = ler.nextInt();
            ler.nextLine();
            p.setIDCivil(idCivil);
        } catch (ArgumentoForaDosLimitesException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

}
