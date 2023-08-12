package com.spring.acountservice.web.controllers;


import com.spring.acountservice.domain.Contato;
import com.spring.acountservice.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContatoController {

    @Autowired
    private ContatoService service;


    @GetMapping("/contatos")
    public ResponseEntity<List<Contato>> findAll() {
        List<Contato> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/contato/{id}")
    public void findById(@PathVariable Long id) throws Exception {
        try {
            service.findById(id);
        }
        catch (Exception e) {
            throw new Exception("Id não encontrado!");
        }
    }


    @PostMapping("/contato/insert")
    public ResponseEntity<Contato> insert(@RequestBody Contato contato) throws Exception {
        try {
            service.insert(contato);
            return ResponseEntity.ok().body(contato);
        }
        catch (Exception e) {
            throw new Exception("Algum campo não foi preenchido corretamente");
        }

    }

    @DeleteMapping("/contato/delete/{id}")
    public ResponseEntity<String> deleteByid(@PathVariable Long id) throws Exception {
        try {
            service.deleteById(id);
            return ResponseEntity.ok("Contato deletado com sucesso!");
        } catch (Exception e) {
            throw new Exception("Id não encontrado!");
        }
    }

    @PutMapping(value = "/contato/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Contato contato) throws Exception {
        try {
            service.findById(id);
            service.update(id, contato);
            return ResponseEntity.ok().body("Contato atualizado com sucesso = { " + contato + " }");
        } catch (Exception e) {
            throw new Exception("Id não encontrado!");
        }
    }

}
