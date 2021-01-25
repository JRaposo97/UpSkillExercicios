/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service;

import com.company.dto.CirculoDTO;
import com.company.dto.ListaProprietarioDTO;
import com.company.dto.ListaTerrenoDTO;
import com.company.dto.Mapper;
import com.company.dto.RetanguloDTO;
import com.company.dto.TrianguloDTO;
import com.company.exception.AlturaNegativeOrNullException;
import com.company.exception.BaseNegativeOrNull;
import com.company.exception.ConversaoException;
import com.company.exception.CumpRectanguloNegativeOrNullException;
import com.company.model.Autarquia;
import com.company.model.Circulo;
import com.company.model.Pessoa;
import com.company.model.Rectangulo;
import com.company.model.Terreno;
import com.company.model.Triangulo;
import com.company.repo.Dados;
import java.util.ArrayList;

/**
 *
 * @author joaor
 */
public class TerrenosService {

    public static Object getTerreno(int id, String nomeFreguesia) {
        Autarquia autarquia = Dados.carregarDados();
        Terreno terreno = autarquia.getTerreno(id, nomeFreguesia);
        if (terreno == null) {
            return null;
        }
        if (terreno instanceof Triangulo) {
            return Mapper.triangulo2TrianguloDTO((Triangulo) terreno);
        } else if (terreno instanceof Rectangulo) {
            return Mapper.retangulo2RetanguloDTO((Rectangulo) terreno);
        } else if (terreno instanceof Circulo) {
            return Mapper.circular2CircularDTO((Circulo) terreno);
        } else {
            throw new ConversaoException("TerrenoCircularDTO");
        }
    }

    public static ListaTerrenoDTO getAllTerrenos() {
        ListaTerrenoDTO listaTerrenoDTO = null;
        Autarquia autarquia = Dados.carregarDados();
        ArrayList<Terreno> terrenos = autarquia.getAllTerrenos();
        listaTerrenoDTO = Mapper.listTerreno2TerrenoDTO(terrenos);
        return listaTerrenoDTO;
    }

    public static ListaTerrenoDTO getTerrenosByFreguesiaID(String nomeFreguesia) {
        ListaTerrenoDTO listaTerrenoDTO = null;
        Autarquia autarquia = Dados.carregarDados();
        ArrayList<Terreno> terrenos = autarquia.getTerrenosByFreguesia(nomeFreguesia);
        listaTerrenoDTO = Mapper.listTerreno2TerrenoDTO(terrenos);
        return listaTerrenoDTO;
    }

    public static void removeTerreno(int id, String nomeFreguesia) {
        Autarquia autarquia = Dados.carregarDados();
        autarquia.removeTerreno(id, nomeFreguesia);
        Dados.guardarDados(autarquia);
    }

    public static void updateTerrenoCircular(String nome, int numID, CirculoDTO terrenoCircDTO) {
        Terreno terreno = Mapper.circularDTO2Circular(terrenoCircDTO);
        if (terreno != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.updateTerreno(nome, terreno, numID);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("TerrenoCircularDTO");
        }
    }

    public static void updateTerrenoRectangular(String nome, int numID, RetanguloDTO terrenoRectDTO) throws NullPointerException, AlturaNegativeOrNullException, CumpRectanguloNegativeOrNullException {
        Terreno terreno = Mapper.retanguloDTO2Retangulo(terrenoRectDTO);
        if (terreno != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.updateTerreno(nome, terreno, numID);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("TerrenoRectangularDTO");
        }
    }

    public static void updateTerrenoTriangular(String nome, int numID, TrianguloDTO terrenoTriDTO) throws NullPointerException, BaseNegativeOrNull, AlturaNegativeOrNullException {
        Terreno terreno = Mapper.trianguloDTO2Triangulo(terrenoTriDTO);
        if (terreno != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.updateTerreno(nome, terreno, numID);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("TerrenoTriangularDTO");
        }
    }

    public static void addTerrenoCircular(String nome, CirculoDTO terrenoCircDTO) {
        Terreno terreno = Mapper.circularDTO2Circular(terrenoCircDTO);
        if (terreno != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.addTerreno(nome, terreno);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("TerrenoCircularDTO");
        }
    }

    public static void addTerrenoRectangular(String nome, RetanguloDTO terrenoRectDTO) throws NullPointerException, AlturaNegativeOrNullException, CumpRectanguloNegativeOrNullException {
        Terreno terreno = Mapper.retanguloDTO2Retangulo(terrenoRectDTO);
        if (terreno != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.addTerreno(nome, terreno);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("TerrenoRectangularDTO");
        }
    }

    public static void addTerrenoTriangular(String nome, TrianguloDTO terrenoTriDTO) throws NullPointerException, BaseNegativeOrNull, AlturaNegativeOrNullException {
        Terreno terreno = Mapper.trianguloDTO2Triangulo(terrenoTriDTO);
        if (terreno != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.addTerreno(nome, terreno);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("TerrenoTriangularDTO");
        }
    }

    public static ListaProprietarioDTO getAllProprietarios(String nomeFreguesia, int idTerreno) throws Exception {
        ListaProprietarioDTO listaProprietariosDTO = null;
        Autarquia autarquia = Dados.carregarDados();
        ArrayList<Pessoa> proprietarios = autarquia.getProprietarios(nomeFreguesia, idTerreno);
        listaProprietariosDTO = Mapper.listProprietarios2ProprietarioDTO(proprietarios);
        return listaProprietariosDTO;
    }

    public static void removeProprietario(int id, String nomeFreguesia,Pessoa p) {
        Autarquia autarquia = Dados.carregarDados();
        autarquia.removeProprietario(id, nomeFreguesia,p);
        Dados.guardarDados(autarquia);
    }
}
