/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

/**
 *
 * @author joaor
 */
public abstract class FormaVisitor<T> {

    public abstract T visit(Rectangulo d);

    public abstract T visit(Triangulo f);

    public abstract T visit(Circulo f);
}
