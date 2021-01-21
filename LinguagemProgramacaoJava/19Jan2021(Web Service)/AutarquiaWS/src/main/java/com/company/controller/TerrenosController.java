/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.controller;

import com.company.dto.ErroDTO;
import com.company.dto.ListaPessoaDTO;
import com.company.dto.ListaTerrenoDTO;
import com.company.dto.PessoaDTO;
import com.company.dto.TerrenoDTO;
import com.company.service.PessoasService;
import com.company.service.TerrenosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author joaor
 */
@RestController
@RequestMapping("/api")
public class TerrenosController {
    
    @RequestMapping(value = "freguesias/{nomeFreguesia}/terrenos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTerrenos(@PathVariable("nomeFreguesia") String nomeFreguesia) {
        try {
            ListaTerrenoDTO listaTerrenoDTO = TerrenosService.getTerrenos(nomeFreguesia);
            if (listaTerrenoDTO.getTerrenos().size() > 0) {
                return new ResponseEntity<>(listaTerrenoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    
    @RequestMapping(value = "freguesias/{nomeFreguesia}/terrenos/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTerreno(@PathVariable("id") int id, @PathVariable("nomeFreguesia") String nomeFreguesia) {
        try {
            TerrenoDTO terrenoDTO = TerrenosService.getTerreno(id, nomeFreguesia);
            if (terrenoDTO != null) {
                return new ResponseEntity<>(terrenoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    
    @RequestMapping(value = "freguesias/{nomeFreguesia}/terrenos",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addTerreno(@PathVariable("nomeFreguesia") String nomeFreguesia,@RequestBody TerrenoDTO terrenoDTO) {
        try {
            TerrenosService.addTerreno(terrenoDTO, nomeFreguesia);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    
    @RequestMapping(value = "freguesias/{nomeFreguesia}/terrenos/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateTerreno(@PathVariable("id") int id,@PathVariable("nomeFreguesia") String nomeFreguesia, @RequestBody TerrenoDTO terrenoDTO
    ) {
        try {
            TerrenosService.updateTerreno(id, terrenoDTO, nomeFreguesia);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    
    @RequestMapping(value = "freguesias/{nomeFreguesia}/terrenos/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removePessoa(@PathVariable("id") int id,@PathVariable("nomeFreguesia") String nomeFreguesia) {
        try {
            TerrenosService.removeTerreno(id, nomeFreguesia);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    
}
