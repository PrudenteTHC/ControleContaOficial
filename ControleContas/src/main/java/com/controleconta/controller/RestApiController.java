package com.controleconta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.controleconta.model.Conta;
import com.controleconta.service.ContaService;

@RestController
@RequestMapping("/api")
public class RestApiController {
	@Autowired
    ContaService contaService;
	
	@RequestMapping(value = "/conta/", method = RequestMethod.GET)
    public ResponseEntity<List<Conta>> listAllContas() {
        List<Conta> contas = contaService.findAllContas();
        if (contas.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Conta>>(contas, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/conta/", method = RequestMethod.POST)
    public ResponseEntity<?> createConta(@RequestBody Conta conta, UriComponentsBuilder ucBuilder) {
		contaService.saveConta(conta);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/conta/{id}").buildAndExpand(conta.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/conta/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteConta(@PathVariable("id") long id) {

        contaService.deleteContaById(id);
        return new ResponseEntity<Conta>(HttpStatus.NO_CONTENT);
    }
}
