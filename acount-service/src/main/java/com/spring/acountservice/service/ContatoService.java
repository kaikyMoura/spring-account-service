package com.spring.acountservice.service;

import com.spring.acountservice.dao.GenericDao;
import com.spring.acountservice.domain.Contato;
import com.spring.acountservice.persistence.repository.IContatoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContatoService implements GenericDao<Contato, Long> {

    @Autowired
    private IContatoRepository repository;

    @Override
    public List<Contato> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Contato> findBySize(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void findById(Long id) throws Exception {
        try {
            if (id != null) {
                repository.findById(id);
            }
        }
        catch (Exception e) {
            throw new Exception("Id não encontrado!");
        }
    }

    @Override
    public Contato insert(Contato contato) throws Exception {
        try {
            return repository.save(contato);
        }
        catch (Exception e) {
            throw new Exception("Erro ao executar a operação");
        }
        }

    @Override
    public Contato update(@NotNull Long id, Contato contato) throws Exception {
        try {
            Optional<Contato> optionalContato = Optional.ofNullable(repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Contato não encontrado!")));
            var contatoAtualizado = optionalContato.get();

           contatoAtualizado.setEmail(contato.getEmail());
           contatoAtualizado.setNumber(contato.getNumber());

            return repository.save(contatoAtualizado);
        }
        catch (Exception e) {
            throw new Exception("Erro ao executar à operação");
         }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        try {
            repository.deleteById(id);
        }
        catch (Exception e) {
            throw new Exception("Id não encontrado!");
        }
        }
}
