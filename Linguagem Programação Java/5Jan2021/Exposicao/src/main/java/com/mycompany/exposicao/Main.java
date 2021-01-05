/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exposicao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author upskills
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Quadro q1 = new Quadro("Designa1", "Autor1", 1995);
        Quadro q2 = new Quadro("Designa2", "Autor2", 1997);
        Quadro q3 = new Quadro("Designa3", "Autor3", 2005);
        Quadro q4 = new Quadro("Designa4", "Autor4", 1950);
        ArrayList<Quadro> quadros = new ArrayList<>();

        quadros.add(q1);
        quadros.add(q2);
        quadros.add(q3);
        quadros.add(q4);
        System.out.println("################ Listar Quadros ###################");
        listar(quadros);
        
        Exposicao expo1 = new Exposicao("Expo1", 2010, quadros);
        Exposicao expo2 = new Exposicao("Expo2", 2014, quadros);
        Exposicao expo3 = new Exposicao("Expo3", 2020);
        ArrayList<Exposicao> expos = new ArrayList<>();
        
        expos.add(expo1);
        expos.add(expo2);
        expos.add(expo3);
        
        System.out.println("################ Listar Exposiçoes ###################");
        listar(expos);
        
        
        System.out.println("################ Listar Exposicoes pos alterar quadro 2 ###################");
        q2.setAnoCriacao(2019);
        listar(expos);
        
       
        
        System.out.println("################ Listar Exposicoes ordem decrescente de Ano Realizacao ###################");
        Collections.sort(expos);
        Collections.reverse(expos);
        listar(expos);
        
        
        System.out.println("################ Exposicao 1 Verificar Remove de Quadro 4###################");
        expo1.removeQuadro(q4);
        System.out.println(expo1);

    }

    private static void listar(List lista) {
        for (Object obj : lista) {
            if (obj != null) {
                System.out.println(obj);
            }
        }
    }
    
   
}
