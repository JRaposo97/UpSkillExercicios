/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service;

import com.company.dto.ListaFreguesiaDTO;
import com.company.dto.Mapper;
import com.company.exception.ConversaoException;
import com.company.model.Autarquia;
import com.company.model.Freguesia;
import com.company.repo.Dados;
import java.util.ArrayList;

/**
 *
 * @author joaor
 */
public class FreguesiasService {

    public static ListaFreguesiaDTO getFreguesias() {
        ListaFreguesiaDTO listaFreguesiaDTO = null;
        Autarquia autarquia = Dados.carregarDados();
        ArrayList<Freguesia> freguesias = autarquia.getFreguesias();
        listaFreguesiaDTO = Mapper.listPessoa2PessoaDTO(pessoas);
        return listaPessoaDTO;
    }

    public static PessoaDTO getPessoa(long nif) {
        Autarquia autarquia = Dados.carregarDados();
        Pessoa pessoa = autarquia.getPessoa(nif);
        if (pessoa == null) {
            return null;
        }
        PessoaDTO pessoaDTO = Mapper.pessoa2PessoaDTO(pessoa);
        if (pessoaDTO != null) {
            return pessoaDTO;
        } else {
            throw new ConversaoException("PessoaDTO");
        }
    }

    public static void addPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = Mapper.pessoaDTO2Pessoa(pessoaDTO);
        if (pessoa != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.addPessoa(pessoa);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("PessoaDTO");
        }
    }

    public static void updatePessoa(long nif, PessoaDTO pessoaDTO) {
        Pessoa pessoa = Mapper.pessoaDTO2Pessoa(pessoaDTO);
        if (pessoa != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.updatePessoa(nif, pessoa);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("PessoaDTO");
        }
    }

    public static void removePessoa(long nif) {
        Autarquia autarquia = Dados.carregarDados();
        autarquia.removePessoa(nif);
        Dados.guardarDados(autarquia);
    }
}
