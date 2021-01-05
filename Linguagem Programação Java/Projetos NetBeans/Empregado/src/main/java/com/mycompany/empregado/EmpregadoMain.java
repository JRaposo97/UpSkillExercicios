/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.empregado;

import com.mycompany.utilitarios.Data;
import com.mycompany.utilitarios.Tempo;
import java.util.ArrayList;

/**
 *
 * @author joaor
 */
public class EmpregadoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Data d1 = Data.dataAtual();
        System.out.println("######## Data Criada ############");
        System.out.println(d1);

        Tempo manha = new Tempo(9, 0, 0);
        Tempo tarde = new Tempo(13, 0, 0);

        System.out.println("######## Listagem de Tempos Criados ############");
        System.out.println(manha);
        System.out.println(tarde);

        Empregado emp1 = new Empregado("Joaquim", "Calisto", d1, manha, tarde);

        Empregado emp2 = new Empregado("João", "Raposo", d1, manha, tarde);

        d1.setData(2020, 10, 10);
        manha.setTempo(10, 30, 0);
        tarde.setHoras(18);

        System.out.println("######## Listagem de Tempos / Data modificados e Empregados ############");
        System.out.println(d1);
        System.out.println(manha);
        System.out.println(tarde);
        System.out.println(emp1);
        System.out.println(emp2);
        
        emp2.setDataContrato(d1);
        emp2.setHoraEntrada(new Tempo(11,0,0));
        emp2.setHoraSaida(new Tempo(20,0,0));
        
        ArrayList<Empregado> emp = new ArrayList<Empregado>();
        emp.add(emp1);
        emp.add(emp2);
        
        
        System.out.println("######## Listagem de Empregados ############");
        for (int i = 0; i < emp.size(); i++) {
                System.out.println(emp.get(i));
        }
        
        System.out.println("######## Listagem de Nome + Horas Trabalho Semanal + Antiguidade ############");
        for (int i = 0; i < emp.size(); i++) {
                System.out.format("\nPrimeiro e Ultimo Nome: %s %s"
                        + "\nHoras de Trabalho Semanal: %d Horas"
                        + "\nAntiguidade : %d Anos",emp.get(i).getPrimeiroNome(),emp.get(i).getUltimoNome(),emp.get(i).horasTrabalho(),emp.get(i).duracaoContrato());
        }
    }

}
