package com.cinema.dao;

import java.util.List;

public interface IGenericRepository<T,V> {
    List<T> GetAll();
    void AddEntity(T obj);
    void UpdateEntity(T obj);
    T GetOneById(int id);
    void DeleteEntity(int id);

}
