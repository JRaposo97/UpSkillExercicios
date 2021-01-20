/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.controller;

import com.company.dto.ErroDTO;
import com.company.dto.ListaPessoaDTO;
import com.company.dto.ListaTerrenoDTOSemID;
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
    
      @RequestMapping(value = "/terrenos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTerrenos() {
        try {
            ListaTerrenoDTOSemID listaTerrenoDTOSemID = TerrenosService.getTerrenos();
            if (listaTerrenoDTOSemID.getTerrenos().size() > 0) {
                return new ResponseEntity<>(listaTerrenoDTOSemID, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/terrenos/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getPessoa(@PathVariable("id") int id) {
        try {
            TerrenoDTO terrenoDTO = TerrenosService.getTerreno(id);
            if (terrenoDTO != null) {
                return new ResponseEntity<>(terrenoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/terrenos",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addPessoa(@RequestBody TerrenoDTO terrenoDTO) {
        try {
            TerrenosService.addTerreno(terrenoDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/terrenos/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
             produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updatePessoa(@PathVariable("id") int id, @RequestBody TerrenoDTO terrenoDTO
    ) {
        try {
            TerrenosService.updateTerreno(id, terrenoDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/terrenos/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removePessoa(@PathVariable("id") int id) {
        try {
            TerrenosService.removeTerreno(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    
}
