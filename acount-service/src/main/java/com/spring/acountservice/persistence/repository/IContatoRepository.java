package com.spring.acountservice.persistence.repository;

import com.spring.acountservice.domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContatoRepository extends JpaRepository<Contato, Long> {
}
