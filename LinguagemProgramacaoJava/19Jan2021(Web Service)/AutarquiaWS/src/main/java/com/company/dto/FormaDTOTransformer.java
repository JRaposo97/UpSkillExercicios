/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dto;

import com.company.model.Circulo;
import com.company.model.FormaVisitor;
import com.company.model.Rectangulo;
import com.company.model.Triangulo;

/**
 *
 * @author joaor
 */
public class FormaDTOTransformer extends FormaVisitor {

    @Override
    public CirculoDTO visit(Circulo d) {
        return new CirculoDTO(d);
    }

    @Override
    public RetanguloDTO visit(Rectangulo r) {
        return new RetanguloDTO(r);
    }
    
    @Override
    public TrianguloDTO visit(Triangulo t) {
        return new TrianguloDTO(t);
    }
}
