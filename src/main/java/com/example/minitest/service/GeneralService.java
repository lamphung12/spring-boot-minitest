package com.example.minitest.service;

import java.util.List;
import java.util.Optional;

public interface GeneralService <T>{
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);





}
