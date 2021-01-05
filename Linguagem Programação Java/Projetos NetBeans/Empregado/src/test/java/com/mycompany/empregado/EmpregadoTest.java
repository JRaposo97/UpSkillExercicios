/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.empregado;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.utilitarios.Data;
import com.mycompany.utilitarios.Tempo;

/**
 *
 * @author joaor
 */
public class EmpregadoTest {

    public EmpregadoTest() {
    }

    @Test
    public void testDuracaoContrato() {
        //Arrange
        Empregado instance = new Empregado("Joaquim", "Calisto", new Data(2015, 12, 15), new Tempo(9, 0, 0), new Tempo(13, 0, 0));
        double expectedResult = 5;
        //Act
        double result = instance.duracaoContrato();
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void testHorasTrabalho() {
        //Arrange
        Empregado instance = new Empregado("Joaquim", "Calisto", new Data(2015, 12, 15), new Tempo(9, 0, 0), new Tempo(13, 0, 0));
        double expectedResult = 20;
        //Act
        double result = instance.horasTrabalho();
        //Assert
        assertEquals(expectedResult, result);
    }

}
