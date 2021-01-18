/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exposicao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author upskills
 */
public class QuadroTest {

    public QuadroTest() {
    }

    @Test
    public void testEquals() {
        //Arrange
        Quadro instance1 = new Quadro("Desi1", "migueli", 100);
        Quadro instance2 = new Quadro("Desi1", "migueli", 100);
        //Result
        assertTrue(instance1.equals(instance2));
    }

    @Test
    public void testCompareTo() {
    }

}
