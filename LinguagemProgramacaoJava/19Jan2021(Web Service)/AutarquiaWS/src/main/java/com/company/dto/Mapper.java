/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dto;

/**
 *
 * @author joaor
 */
import com.company.exception.AlturaNegativeOrNullException;
import com.company.exception.BaseNegativeOrNull;
import com.company.exception.CumpRectanguloNegativeOrNullException;
import com.company.model.Circulo;
import com.company.model.Data;
import com.company.model.Freguesia;
import com.company.model.Funcionario;
import com.company.model.Pessoa;
import com.company.model.Rectangulo;
import com.company.model.Terreno;
import com.company.model.Triangulo;
import java.util.ArrayList;

public class Mapper {

    public static DataDTO data2dataDTO(Data data) throws NullPointerException {
        DataDTO dataDTO = new DataDTO(data.getDia(), data.getMes(), data.getAno());

        return dataDTO;
    }

    public static Data dataDTO2data(DataDTO dataDTO) throws NullPointerException {
        Data data = null;
        data = new Data(dataDTO.getDia(), dataDTO.getMes(), dataDTO.getAno());
        return data;
    }

    public static CirculoDTO circular2CircularDTO(Circulo circulo) throws NullPointerException {
        CirculoDTO circuloDTO = new CirculoDTO(circulo);
        return circuloDTO;
    }

    public static Circulo circularDTO2Circular(CirculoDTO circuloDTO) throws NullPointerException {
        Circulo circulo = null;
        circulo = new Circulo(circuloDTO.getNome(), circuloDTO.getRaio());
        return circulo;
    }

    //RetanguloDTO
    public static RetanguloDTO retangulo2RetanguloDTO(Rectangulo rectangulo) throws NullPointerException {
        RetanguloDTO retanguloDTO = new RetanguloDTO(rectangulo);
        return retanguloDTO;
    }

    public static Rectangulo retanguloDTO2Retangulo(RetanguloDTO retanguloDTO) throws NullPointerException, AlturaNegativeOrNullException, CumpRectanguloNegativeOrNullException {
        Rectangulo rectangulo = null;
        rectangulo = new Rectangulo(retanguloDTO.getNome(), retanguloDTO.getaltura(), retanguloDTO.getCumprimento());
        return rectangulo;
    }

    //TriangularDTO
    public static TrianguloDTO triangulo2TrianguloDTO(Triangulo t) throws NullPointerException {
        TrianguloDTO triDTO = new TrianguloDTO(t);
        return triDTO;
    }

    public static Triangulo trianguloDTO2Triangulo(TrianguloDTO triDTO) throws NullPointerException, BaseNegativeOrNull, AlturaNegativeOrNullException {
        Triangulo triangulo = null;
        triangulo = new Triangulo(triDTO.getNome(), triDTO.getBase(), triDTO.getAltura());
        return triangulo;
    }

    public static PessoaDTO pessoa2PessoaDTO(Pessoa pessoa) throws NullPointerException {
        PessoaDTO pessoaDTO = new PessoaDTO(pessoa.getNif(), pessoa.getNome(), data2dataDTO(pessoa.getNascimento()));
        return pessoaDTO;
    }

    //Pessoa
    public static Pessoa pessoaDTO2Pessoa(PessoaDTO pessoaDTO) throws NullPointerException {
        Pessoa pessoa = null;
        Data data = dataDTO2data(pessoaDTO.getNascimento());
        pessoa = new Pessoa(pessoaDTO.getNif(), pessoaDTO.getNome(), data);
        return pessoa;
    }

    public static ListaPessoaDTO listPessoa2PessoaDTO(ArrayList<Pessoa> pessoas) throws NullPointerException {
        ArrayList<PessoaDTO> pessoasDTO = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            try {
                PessoaDTO pessoaDTO = pessoa2PessoaDTO(pessoa);
                pessoasDTO.add(pessoaDTO);
            } catch (NullPointerException e) {
//does nothing. Actually, nothing is added to arraylist
            }
        }
        ListaPessoaDTO listaPessoaDTO = new ListaPessoaDTO();
        listaPessoaDTO.setPessoas(pessoasDTO);
        return listaPessoaDTO;
    }

    public static FuncionarioDTO funcionario2FuncionarioDTO(Funcionario funcionario) throws
            NullPointerException {
        FuncionarioDTO funcionarioDTO
                = new FuncionarioDTO(funcionario.getNif(),
                        funcionario.getNome(),
                        data2dataDTO(funcionario.getNascimento()),
                        funcionario.getNumeroFuncionario(),
                        funcionario.getCargo());

        return funcionarioDTO;
    }

    public static Funcionario funcionarioDTO2Funcionario(FuncionarioDTO funcionarioDTO) throws
            NullPointerException {
        Funcionario funcionario = null;
        Data data = dataDTO2data(funcionarioDTO.getNascimento());
        funcionario = new Funcionario(funcionarioDTO.getNif(), funcionarioDTO.getNome(), data, funcionarioDTO.
                getNumeroFuncionario(), funcionarioDTO.getCargo());
        return funcionario;
    }

    public static ListaFuncionarioDTO listFuncionario2FuncionarioDTO(ArrayList<Funcionario> funcionarios)
            throws NullPointerException {
        ArrayList<FuncionarioDTO> funcionariosDTO = new ArrayList<>();
        for (Funcionario funcionario : funcionarios) {
            try {
                FuncionarioDTO funcionarioDTO = funcionario2FuncionarioDTO(funcionario);
                funcionariosDTO.add(funcionarioDTO);
            } catch (NullPointerException e) {
//does nothing. Actually, nothing is added to arraylist
            }
        }
        ListaFuncionarioDTO listaFuncionarioDTO = new ListaFuncionarioDTO();
        listaFuncionarioDTO.setFuncionarios(funcionariosDTO);
        return listaFuncionarioDTO;
    }

    ////////////////// Freguesias
    public static FreguesiaDTO freguesia2FreguesiaDTO(Freguesia freguesia) throws NullPointerException {
        FreguesiaDTO freguesiaDTO = new FreguesiaDTO();
        freguesiaDTO.setNomeFreguesia(freguesia.getNomeFreguesia());
        return freguesiaDTO;
    }

    public static Freguesia freguesiaDTO2Freguesia(FreguesiaDTO freguesiaDTO) throws NullPointerException {
        Freguesia freguesia = null;
        freguesia = new Freguesia(freguesiaDTO.getNomeFreguesia());
        return freguesia;
    }

    public static ListaFreguesiaDTO listfreguesia2freguesiaDTO(ArrayList<Freguesia> freguesias) throws NullPointerException {
        ArrayList<FreguesiaDTO> freguesiasDTO = new ArrayList<>();
        for (Freguesia freguesia : freguesias) {
            try {
                FreguesiaDTO freguesiaDTO = freguesia2FreguesiaDTO(freguesia);
                freguesiasDTO.add(freguesiaDTO);
            } catch (NullPointerException e) {
//does nothing. Actually, nothing is added to arraylist
            }
        }
        ListaFreguesiaDTO listaFreguesiaDTO = new ListaFreguesiaDTO();
        listaFreguesiaDTO.setFreguesias(freguesiasDTO);
        return listaFreguesiaDTO;
    }

    public static ListaTerrenoDTO listTerreno2TerrenoDTO(ArrayList<Terreno> terrenos) throws NullPointerException {
        ArrayList<Object> terrenosDTO = new ArrayList<>();
        for (Terreno terreno : terrenos) {
            try {
                if (terreno instanceof Triangulo) {
                    TrianguloDTO terrenoDTO = triangulo2TrianguloDTO((Triangulo) terreno);
                    terrenosDTO.add(terrenoDTO);
                } else if (terreno instanceof Circulo) {
                    CirculoDTO terrenoDTO = circular2CircularDTO((Circulo) terreno);
                    terrenosDTO.add(terrenoDTO);
                } else if (terreno instanceof Rectangulo) {
                    RetanguloDTO terrenoDTO = retangulo2RetanguloDTO((Rectangulo) terreno);
                    terrenosDTO.add(terrenoDTO);
                }
            } catch (NullPointerException e) {
                //nada é adicionado
            }
        }
        ListaTerrenoDTO listaTerrenoDTO = new ListaTerrenoDTO();
        listaTerrenoDTO.setTerrenos(terrenosDTO);
        return listaTerrenoDTO;
    }

    public static ListaProprietarioDTO listProprietarios2ProprietarioDTO(ArrayList<Pessoa> proprietarios) throws NullPointerException {
        ArrayList<PessoaDTO> pessoasDTO = new ArrayList<>();
        for (Pessoa proprietario : proprietarios) {
            try {
                PessoaDTO pessoaDTO = pessoa2PessoaDTO(proprietario);
                pessoasDTO.add(pessoaDTO);
            } catch (NullPointerException e) {
//does nothing. Actually, nothing is added to arraylist
            }
        }
        ListaProprietarioDTO listaProprietarioDTO = new ListaProprietarioDTO();
        listaProprietarioDTO.setProprietarios(proprietarios);
        return listaProprietarioDTO;
    }

}
