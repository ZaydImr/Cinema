package com.cinema.services;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T  ,UUID extends Serializable> {
    //private static final int PAGE_SIZE = 5;
    protected abstract JpaRepository<T, UUID> getRepository();

    /*public Page<T> getList(Integer pageNumber) {
        PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "id");
        return getRepository().findAll(pageRequest);
    }*/
    public List<T> getAll() {
        return getRepository().findAll();
    }
    public T addEntity(T entity) {
        return getRepository().save(entity);
    }

    public T getElementById(UUID id) {
        Optional<T> entityOpt = getRepository().findById(id);
        T entity = entityOpt.get();
        return entity;
    }

    public void deleteEntity(UUID id) {
        getRepository().deleteById(id);
    }

    public T updateEntity(T entity) {
        getRepository().save(entity);
        return entity;
    }
}
