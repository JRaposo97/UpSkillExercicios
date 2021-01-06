/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.listatelefonica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joaor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Contacto c1 = new Contacto("Jose", 220000000, "jose@exemplo.pt");
        Contacto c2 = new Contacto("Manuel", 933333333, "manuel@exemplo.pt");
        Contacto c3 = new Contacto("Antonio", 966666666, "antonio@exemplo.pt");
        Contacto c4 = new Contacto("Joaquim", 911111111, "joaquim@exemplo.pt");

        ListaTelefonica lista = new ListaTelefonica();

        if (lista.novoContacto(c1)) {
            System.out.println("Adicionado Com Sucesso a Lista Telefonica");
            c1.toString();
        } else {
            System.out.println("Contacto Ja Existe");
        }
        lista.novoContacto(c1);

        if (lista.addTresContactos(c2, c3, c4)) {
            System.out.println("Contactos adicionados com Sucesso");
        } else {
            System.out.println("Algum dos Contactos Ja Existe");
        }

    }

    private static void listar(List lista) {
        for (Object obj : lista) {
            if (obj != null) {
                System.out.println(obj);
            }
        }
    }

}
