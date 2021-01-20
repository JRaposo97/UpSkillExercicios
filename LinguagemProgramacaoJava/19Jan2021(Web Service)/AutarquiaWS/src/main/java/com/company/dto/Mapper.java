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
import com.company.model.Data;
import com.company.model.Freguesia;
import com.company.model.Funcionario;
import com.company.model.Pessoa;
import com.company.model.Terreno;
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

    public static PessoaDTO pessoa2PessoaDTO(Pessoa pessoa) throws NullPointerException {
        PessoaDTO pessoaDTO = new PessoaDTO(pessoa.getNif(), pessoa.getNome(), data2dataDTO(pessoa.getNascimento()));

        return pessoaDTO;
    }

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

    public static ListaTerrenoDTO listterreno2terrenoDTO(ArrayList<Terreno> terrenos) {
       ArrayList<TerrenoDTO> terrenosDTO = new ArrayList<>();
        for (Terreno terreno : terrenos) {
            try {
                TerrenoDTO terrenoDTO = terreno2TerrenoDTO(terreno);
                terrenosDTO.add(terrenoDTO);
            } catch (NullPointerException e) {
//does nothing. Actually, nothing is added to arraylist
            }
        }
        ListaTerrenoDTO listaTerrenoDTO = new ListaTerrenoDTO();
        listaTerrenoDTO.setTerrenos(terrenosDTO);
        return listaTerrenoDTO;
    }

    public static TerrenoDTO terreno2TerrenoDTO(Terreno terreno) {
        TerrenoDTO terrenoDTO = new TerrenoDTO();
        terrenoDTO.setId(terreno.getId());
        terrenoDTO.setNome(terreno.getNome());
        terrenoDTO.setForma(terreno.getShape().accept(v));
        return terrenoDTO;
    }

    public static Terreno terrenoDTO2Terreno(TerrenoDTO terrenoDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
