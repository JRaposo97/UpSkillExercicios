/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aniversarios;


/**
 *
 * @author upskills
 */
public class Utilitario {
    
    public static void lerData(String aniversario) throws Exception{
        String[] arrOfStr = aniversario.split("/", 3);
        if (!(aniversario.length()==10) || (aniversario.charAt(4)!='/' && aniversario.charAt(7)!='/')) {
            throw new Exception("Formato Invalido!");
        }
        Data d1 = new Data(Integer.parseInt(arrOfStr[0]), Integer.parseInt(arrOfStr[1]), Integer.parseInt(arrOfStr[2]));
    }
    
}
