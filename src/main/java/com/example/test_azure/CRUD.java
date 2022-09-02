package com.example.test_azure;

import java.util.Optional;
import java.util.Set;

public interface CRUD<T, ID>{

    Set<T> findAll();
    T save (T object);
    void delete (T object);
    void deleteById(ID id);
    Optional<T> findById(ID id);

}
