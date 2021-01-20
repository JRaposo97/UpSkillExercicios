/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service;

import com.company.dto.ListaTerrenoDTO;
import com.company.dto.ListaTerrenoDTOSemID;
import com.company.dto.Mapper;
import com.company.dto.TerrenoDTO;
import com.company.exception.ConversaoException;
import com.company.model.Autarquia;
import com.company.model.Terreno;
import com.company.repo.Dados;
import java.util.ArrayList;

/**
 *
 * @author joaor
 */
public class TerrenosService {

    public static TerrenoDTO getTerreno(int id, String nomeFreguesia) {
        Autarquia autarquia = Dados.carregarDados();
        Terreno terreno = autarquia.getFreguesia(nomeFreguesia).getTerreno(id);
        if (terreno == null) {
            return null;
        }
        TerrenoDTO terrenoDTO = Mapper.terreno2TerrenoDTO(terreno);
        if (terrenoDTO != null) {
            return terrenoDTO;
        } else {
            throw new ConversaoException("TerrenoDTO");
        }
    }

    public static void addTerreno(TerrenoDTO terrenoDTO, String nomeFreguesia) {
        Terreno terreno = Mapper.terrenoDTO2Terreno(terrenoDTO);
        if (terreno != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.getFreguesia(nomeFreguesia).addTerreno(terreno);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("PessoaDTO");
        }
    }

    public static ListaTerrenoDTO getTerrenos(String nomeFreguesia) {
        ListaTerrenoDTO listaTerrenoDTO = null;
        Autarquia autarquia = Dados.carregarDados();
        ArrayList<Terreno> terrenos = autarquia.getAllTerrenos(autarquia.getFreguesia(nomeFreguesia).getTerrenos());
        listaTerrenoDTO = Mapper.listterreno2terrenoDTO(terrenos);
        return listaTerrenoDTO;
    }

    public static void removeTerreno(int id, String nomeFreguesia) {
        Autarquia autarquia = Dados.carregarDados();
        autarquia.getFreguesia(nomeFreguesia).removeTerreno(id);
        Dados.guardarDados(autarquia);
    }

    public static void updateTerreno(int id, TerrenoDTO terrenoDTO, String nomeFreguesia) {
        Terreno terreno = Mapper.terrenoDTO2Terreno(terrenoDTO);
        if (terreno != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.getFreguesia(nomeFreguesia).addTerreno(terreno);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("TerrenoDTO");
        }
    }


}
