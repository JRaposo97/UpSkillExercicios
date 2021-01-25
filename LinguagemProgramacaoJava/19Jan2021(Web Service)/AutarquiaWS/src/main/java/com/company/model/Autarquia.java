/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

import com.company.exception.ElementoNaoExistenteException;
import com.company.exception.NifDuplicadoException;
import com.company.exception.NomeFreguesiaDuplicadoException;
import com.company.exception.NumeroFuncionarioDuplicadoException;
import java.io.Serializable;
import java.util.ArrayList;

public class Autarquia implements Serializable {

    private String nome;
    private ArrayList<Pessoa> pessoas;
    private ArrayList<Freguesia> freguesias;

    public Autarquia(String nome) {
        this.nome = nome;
        this.pessoas = new ArrayList<Pessoa>();
        this.freguesias = new ArrayList<Freguesia>();
    }

    //PESSOA
    public ArrayList<Pessoa> getAllPessoas() {
        Pessoa pessoa;
        ArrayList<Pessoa> lista = new ArrayList<>();
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (!(pessoa instanceof Funcionario)) {
                Pessoa copiaPessoa = new Pessoa(pessoa);
                lista.add(copiaPessoa);
            } else {
                Funcionario funcionarioFuncionario = new Funcionario((Funcionario) pessoa);
                lista.add(funcionarioFuncionario);
            }
        }
        return lista;
    }

    public ArrayList<Pessoa> getPessoas() {
        Pessoa pessoa;
        ArrayList<Pessoa> lista = new ArrayList<>();
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (!(pessoa instanceof Funcionario)) {
                Pessoa copia = new Pessoa(pessoa);
                lista.add(copia);
            }
        }
        return lista;
    }

    public void addPessoa(Pessoa pessoa) throws NifDuplicadoException {
        Pessoa p = getPessoaByNif(pessoa.getNif());
        if (p == null) {
            this.pessoas.add(pessoa);
        } else {
            throw new NifDuplicadoException(p.getNif() + ": NIF j´a existe");
        }
    }

    public Pessoa getPessoa(long nif) {
        return getPessoaByNif(nif);
    }

    public void removePessoa(long nif) throws ElementoNaoExistenteException {
        Pessoa pessoa = null;
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa.getNif() == nif) {
                if (!(pessoa instanceof Funcionario)) {
                    this.pessoas.remove(i);
                    return;
                } else {
                    throw new ElementoNaoExistenteException(nif + ": Não é uma pessoa, ´e um funcionário");
                }
            }
        }
        throw new ElementoNaoExistenteException(nif + ": Não existe essa pessoa");
    }

    public void updatePessoa(long nif, Pessoa p) throws ElementoNaoExistenteException {
        Pessoa pessoa = null;
        boolean updated = false;
        for (int i = 0; i < this.pessoas.size() && !updated; i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa.getNif() == nif) {
                this.pessoas.set(i, p);
                updated = true;
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(nif + ": N~ao existe essa pessoa");
        }
    }

    private Pessoa getPessoaByNif(long nif) {
        Pessoa pessoa = null;
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa.getNif() == nif) {
                Pessoa copia = new Pessoa(pessoa);
                return copia;
            }
        }
        return null;
    }

    // FUNCIONARIO
    public ArrayList<Funcionario> getFuncionarios() {
        Pessoa pessoa;
        ArrayList<Funcionario> lista = new ArrayList<>();
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa instanceof Funcionario) {
                Funcionario copia = new Funcionario((Funcionario) pessoa);
                lista.add(copia);
            }
        }
        return lista;
    }

    public void addFuncionario(Funcionario funcionario) throws NumeroFuncionarioDuplicadoException,
            NifDuplicadoException {
        Pessoa p = getPessoaByNif(funcionario.getNif());
        if (p == null) {
            Funcionario f = getFuncionarioByNr(funcionario.getNumeroFuncionario());
            if (f == null) {
                addPessoa(funcionario);
            } else {
                throw new NumeroFuncionarioDuplicadoException(f.getNumeroFuncionario() + ": Numero de Funcionario ja existe ");
            }
        } else {
            throw new NifDuplicadoException(p.getNif() + ": NIF j´a existe");
        }
    }

    public Funcionario getFuncionario(int nr) {
        Funcionario funcionario = getFuncionarioByNr(nr);
        if (funcionario != null) {
            Funcionario copia = new Funcionario(funcionario);
            return copia;
        }
        return null;
    }

    public void removeFuncionario(int nr) throws ElementoNaoExistenteException {
        Pessoa pessoa = null;
        Funcionario funcionario = null;
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa instanceof Funcionario) {
                if (pessoa instanceof Funcionario) {
                    funcionario = (Funcionario) pessoa;
                    if (funcionario.getNumeroFuncionario() == nr) {
                        this.pessoas.remove(i);
                        return;
                    }
                }
            }
        }
        throw new ElementoNaoExistenteException(nr + ": N~ao existe esse funcion´ario");
    }

    public void updateFuncionario(int nr, Funcionario f) throws ElementoNaoExistenteException {
        boolean updated = false;
        Pessoa pessoa = null;
        Funcionario funcionario = null;
        for (int i = 0; i < this.pessoas.size() && !updated; i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa instanceof Funcionario) {
                funcionario = (Funcionario) pessoa;
                if (funcionario.getNumeroFuncionario() == nr) {
                    this.pessoas.set(i, f);
                    updated = true;
                }
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(nr + ": N~ao existe esse funcionario");
        }
    }

    private Funcionario getFuncionarioByNr(int nr) {
        Pessoa pessoa = null;
        Funcionario funcionario = null;
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa instanceof Funcionario) {
                funcionario = (Funcionario) pessoa;
                if (funcionario.getNumeroFuncionario() == nr) {
                    return funcionario;
                }
            }
        }
        return null;
    }

    //Freguesias
    public ArrayList<Freguesia> getFreguesias() {
        return new ArrayList<Freguesia>(freguesias);
    }

    public void addTerreno(String nomeFreguesia, Terreno terreno) {
        Freguesia f = getFreguesiaByNome(nomeFreguesia);

        Terreno t = f.getTerreno(terreno.getId());
        if (t == null) {
            f.getTerrenos().add(terreno);
        }
    }

    public void updateTerreno(String nomeFreguesia, Terreno terreno, int idTerreno) {
        Freguesia f = getFreguesiaByNome(nomeFreguesia);
        Terreno terr = null;
        boolean updated = false;
        for (int i = 0; i < f.getTerrenos().size() && !updated; i++) {
            terr = f.getTerrenos().get(i);
            if (terr.getId() == idTerreno) {
                f.getTerrenos().set(i, terreno);
                updated = true;
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(nomeFreguesia + ": Não Existe esse Terreno");
        }
    }

    public ArrayList<Terreno> getTerrenosByFreguesia(String nomeFreguesia) {
        Freguesia f = getFreguesiaByNome(nomeFreguesia);

        return f.getTerrenos();
    }

    public void addFreguesia(Freguesia freguesia) throws NomeFreguesiaDuplicadoException {
        Freguesia f = getFreguesiaByNome(freguesia.getNomeFreguesia());
        if (f == null) {
            this.freguesias.add(freguesia);
        } else {
            throw new NomeFreguesiaDuplicadoException(f.getNomeFreguesia() + ": Nome de Freguesia ja existe");
        }
    }

    public Freguesia getFreguesiaByNome(String nomeFreguesia) {
        Freguesia freg = null;
        for (int i = 0; i < this.freguesias.size(); i++) {
            freg = this.freguesias.get(i);
            if (freg.getNomeFreguesia().equalsIgnoreCase(nomeFreguesia)) {
                return freg;
            }
        }
        return null;
    }

    public void removeFreguesia(String nomeFreguesia) throws ElementoNaoExistenteException {
        Freguesia freg = null;
        for (int i = 0; i < this.freguesias.size(); i++) {
            freg = this.freguesias.get(i);
            if (freg.getNomeFreguesia().equalsIgnoreCase(nomeFreguesia)) {
                this.freguesias.remove(i);
                return;
            }
        }
        throw new ElementoNaoExistenteException(nomeFreguesia + ": Não existe essa Freguesia");
    }

    public void updateFreguesias(String nomeFreguesia, Freguesia f) throws ElementoNaoExistenteException {
        Freguesia freg = null;
        boolean updated = false;
        for (int i = 0; i < this.freguesias.size() && !updated; i++) {
            freg = this.freguesias.get(i);
            if (freg.getNomeFreguesia().equalsIgnoreCase(nomeFreguesia)) {
                this.freguesias.set(i, f);
                updated = true;
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(nomeFreguesia + ": Não Existe essa Freguesia");
        }
    }

    public ArrayList<Terreno> getAllTerrenos() {
        ArrayList<Terreno> listaTodosTerrenos = new ArrayList<>();
        for (Freguesia f : getFreguesias()) {
            listaTodosTerrenos.addAll(f.getTerrenos());
        }
        return listaTodosTerrenos;
    }

    public Terreno getTerreno(int id, String nomeFreguesia) {
        Freguesia f = getFreguesiaByNome(nomeFreguesia);
        return f.getTerreno(id);
    }

    public void removeTerreno(int idTerreno, String nomeFreguesia) throws ElementoNaoExistenteException {
        Freguesia f = getFreguesiaByNome(nomeFreguesia);
        Terreno terr = null;
        f.removeTerreno(idTerreno);
        throw new ElementoNaoExistenteException(nomeFreguesia + ": Não existe esse Terreno");
    }

    public ArrayList<Pessoa> getProprietarios(String nomeFreguesia, int idTerreno) throws Exception {
        Freguesia f = getFreguesiaByNome(nomeFreguesia);

        return f.getProprietarios(idTerreno);
    }

    public boolean removeProprietarioTerreno(int id, String nomeFreguesia, Pessoa p) throws Exception {
        Freguesia f = getFreguesiaByNome(nomeFreguesia);
        if (f == null) {
            throw new ElementoNaoExistenteException("Freguesia não existe");
        } else {
            return f.removeProprietarioTerreno(id, p);
        }
    }
}
