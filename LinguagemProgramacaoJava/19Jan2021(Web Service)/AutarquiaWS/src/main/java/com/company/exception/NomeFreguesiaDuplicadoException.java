/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.exception;

/**
 *
 * @author joaor
 */
public class NomeFreguesiaDuplicadoException extends RuntimeException {
     public NomeFreguesiaDuplicadoException(String s) {
        super(s);
    }
}
