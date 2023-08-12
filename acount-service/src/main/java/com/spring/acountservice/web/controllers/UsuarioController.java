package com.spring.acountservice.web.controllers;


import com.spring.acountservice.domain.Usuario;
import com.spring.acountservice.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;


    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/usuario/{id}")
    public void findById(@PathVariable Long id) throws Exception {
        try {
            service.findById(id);
        }
        catch (Exception e) {
            throw new Exception("Id não encontrado!");
        }
    }


    @PostMapping("/usuario/insert")
    public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario) throws Exception {
        try {
            service.insert(usuario);
            return ResponseEntity.ok().body(usuario);
        }
        catch (Exception e) {
            throw new Exception("Algum campo não foi preenchido corretamente");
        }

    }

    @DeleteMapping("/usuario/delete/{id}")
    public ResponseEntity<String> deleteByid(@PathVariable Long id) throws Exception {
        try {
            service.deleteById(id);
            return ResponseEntity.ok("Usuario deletado com sucesso!");
        } catch (Exception e) {
            throw new Exception("Id não encontrado!");
        }
    }

    @PutMapping(value = "/usuario/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Usuario usuario) throws Exception {
        try {
            service.findById(id);
            service.update(id, usuario);
            return ResponseEntity.ok().body("Usuario atualizado com sucesso = { " + usuario + " }");
        } catch (Exception e) {
            throw new Exception("Id não encontrado!");
        }
    }

}
