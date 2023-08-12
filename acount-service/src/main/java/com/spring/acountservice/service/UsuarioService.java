package com.spring.acountservice.service;

import com.spring.acountservice.dao.GenericDao;
import com.spring.acountservice.domain.Usuario;
import com.spring.acountservice.persistence.repository.IUsuarioRepository;
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
public class UsuarioService implements GenericDao<Usuario, Long> {

    @Autowired
    private IUsuarioRepository repository;

    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Usuario> findBySize(Pageable pageable) {
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
    public Usuario insert(Usuario usuario) throws Exception {
        try {
            return repository.save(usuario);
        }
        catch (Exception e) {
            throw new Exception("Erro ao executar a operação");
        }
        }

    @Override
    public Usuario update(@NotNull Long id, Usuario usuario) throws Exception {
        try {
            Optional<Usuario> optionalUsuario = Optional.ofNullable(repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado!")));
            var usuarioAtualizado = optionalUsuario.get();

            usuarioAtualizado.setNome(usuario.getNome());
            usuarioAtualizado.setContato(usuario.getContato());

            return repository.save(usuarioAtualizado);
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
