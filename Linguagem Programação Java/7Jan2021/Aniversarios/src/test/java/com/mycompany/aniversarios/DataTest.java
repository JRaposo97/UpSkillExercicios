/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aniversarios;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author upskills
 */
public class DataTest {
    
    public DataTest() {
    }

 
    @Test
    public void testSetDataValido() {
        Data data = new Data();
        data.setData(1900, 1, 1);
        Assertions.assertEquals(data, new Data(1900,1, 1));
    }
    
    @Test
    public void testSetDataDiaInvalido(){
        Data data = new Data();
        Exception exception = Assertions.assertThrows(MesInvalidoException.class, () -> data.setData(1900, 12, 40));
        Assertions.assertEquals("O dia 40 é invalido!", exception.getMessage());
    }

    @Test
    public void testSetDataMesInvalido(){
        Data data = new Data();
        Exception exception = Assertions.assertThrows(MesInvalidoException.class, () -> data.setData(1900, 19, 1));
        Assertions.assertEquals("O mês 19 é invalido!", exception.getMessage());
    }
}
