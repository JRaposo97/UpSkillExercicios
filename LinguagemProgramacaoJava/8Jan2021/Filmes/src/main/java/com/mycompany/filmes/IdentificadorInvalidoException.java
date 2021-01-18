/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filmes;

/**
 *
 * @author joaor
 */
public class IdentificadorInvalidoException extends Exception {

    /**
     * Creates a new instance of <code>IdentificadorInvalidoException</code>
     * without detail message.
     */
    public IdentificadorInvalidoException() {
    }

    /**
     * Constructs an instance of <code>IdentificadorInvalidoException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public IdentificadorInvalidoException(String msg) {
        super(msg);
    }
}
