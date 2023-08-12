package com.spring.acountservice.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface GenericDao<T, ID extends Serializable> {

    List<T> findAll();

    Page<T> findBySize(Pageable pageable);

    void findById(Long id) throws Exception;

    T insert(T t) throws Exception;

    T update(Long id, T t) throws Exception;

    void deleteById(Long id) throws Exception;
}
