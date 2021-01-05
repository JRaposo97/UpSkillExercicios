/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exposicao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author upskills
 */
public class ExposicaoTest {

    public ExposicaoTest() {
    }

    @Test
    public void testEquals() {
        //Arrange
        Quadro instance1 = new Quadro("Desi1", "migueli", 100);
        Quadro instance2 = new Quadro("Desi1", "migueli", 100);

        ArrayList<Quadro> quadros = new ArrayList<>();
        quadros.add(instance1);
        quadros.add(instance2);
        Exposicao expo = new Exposicao("ExpoTest", 2000, quadros);
        Exposicao expo1 = new Exposicao("ExpoTest", 2000, quadros);
        //Act
        //Result
        assertTrue(expo.equals(expo1));
    }

    @Test
    public void testAddQuadro() {
        //Arrange
        Exposicao expo = new Exposicao("ExpoTest", 2000);
        Quadro instance1 = new Quadro("Desi1", "migueli", 100);
        //Result
        assertTrue(expo.addQuadro(instance1));
    }

    @Test
    public void testRemoveQuadro() {
        //Arrange
        Exposicao expo = new Exposicao("ExpoTest", 2000);
        Quadro instance1 = new Quadro("Desi1", "migueli", 100);
        expo.addQuadro(instance1);
        //Result
        assertTrue(expo.removeQuadro(instance1));
        
    }

    @Test
    public void testCompareTo() {
    }

}
