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
public class DiaInvalidoException extends IllegalArgumentException {

    /**
     * Creates a new instance of <code>DiaInvalidoException</code> without
     * detail message.
     */
    public DiaInvalidoException() {
    }

    /**
     * Constructs an instance of <code>DiaInvalidoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DiaInvalidoException(String msg) {
        super(msg);
    }
}
