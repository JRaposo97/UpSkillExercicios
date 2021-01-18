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
public class MesInvalidoException extends IllegalArgumentException {

    /**
     * Creates a new instance of <code>MesInvalidoException</code> without
     * detail message.
     */
    public MesInvalidoException() {
    }

    /**
     * Constructs an instance of <code>MesInvalidoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MesInvalidoException(String msg) {
        super(msg);
    }
}
