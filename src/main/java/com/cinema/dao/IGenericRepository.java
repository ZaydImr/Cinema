package com.cinema.dao;

import java.util.List;
import java.util.UUID;

public interface IGenericRepository<T,V> {
    List<T> GetAll();
    T AddEntity(T obj);
    T UpdateEntity(T obj);
    T GetOneById(UUID id);
    void DeleteEntity(UUID id);

}
