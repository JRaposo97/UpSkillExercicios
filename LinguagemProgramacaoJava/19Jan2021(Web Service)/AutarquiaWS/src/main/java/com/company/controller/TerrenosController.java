/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.controller;

import com.company.dto.CirculoDTO;
import com.company.dto.ErroDTO;
import com.company.dto.ListaTerrenoDTO;
import com.company.dto.RetanguloDTO;
import com.company.dto.TrianguloDTO;
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

    @RequestMapping(value = "/freguesias/{nomeFreguesia}/terrenos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTerrenos(@PathVariable("nomeFreguesia") String nomeFreguesia) {
        try {
            ListaTerrenoDTO listaTerrenoDTO = TerrenosService.getTerrenosByFreguesiaID(nomeFreguesia);
            if (listaTerrenoDTO.getTerrenos().size() > 0) {
                return new ResponseEntity<>(listaTerrenoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    
    @RequestMapping(value = "/terrenos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getAllTerrenos() {
        try {
            ListaTerrenoDTO listaTerrenoDTO = TerrenosService.getAllTerrenos();
            if (listaTerrenoDTO.getTerrenos().size() > 0) {
                return new ResponseEntity<>(listaTerrenoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/freguesias/{nomeFreguesia}/terrenos/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTerreno(@PathVariable("id") int id, @PathVariable("nomeFreguesia") String nomeFreguesia) {
        try {
            Object terrenoDTO = TerrenosService.getTerreno(id, nomeFreguesia);
            if (terrenoDTO != null) {
                return new ResponseEntity<>(terrenoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    
     @RequestMapping(value = "/freguesias/{nomeFreguesia}/terrenos/rectangular",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addTerrenoRetangular(@RequestBody RetanguloDTO terrenoRectangularDTO,
                                            @PathVariable("nomeFreguesia") String nomeFreguesia) {
        try {
            TerrenosService.addTerrenoRectangular(nomeFreguesia, terrenoRectangularDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    
    @RequestMapping(value = "/freguesias/{nomeFreguesia}/terrenos/circular",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addTerrenoCircular(@PathVariable("nomeFreguesia") String nomeFreguesia, @RequestBody CirculoDTO terrenoCircularDTO) {
        try {
            TerrenosService.addTerrenoCircular(nomeFreguesia, terrenoCircularDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    
     @RequestMapping(value = "/freguesias/{nomeFreguesia}/terrenos/triangular",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addTerrenoTriangular(@PathVariable("nomeFreguesia") String nomeFreguesia, @RequestBody TrianguloDTO terrenoTriangularDTO) {
        try {
            TerrenosService.addTerrenoTriangular(nomeFreguesia, terrenoTriangularDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }



    @RequestMapping(value = "/freguesias/{nomeFreguesia}/terrenos/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removePessoa(@PathVariable("id") int id, @PathVariable("nomeFreguesia") String nomeFreguesia) {
        try {
            TerrenosService.removeTerreno(id, nomeFreguesia);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    
    

}
