package hu.unideb.dao;

import hu.unideb.entity.CoreEntity;

import java.util.List;

public interface CoreDao<T extends CoreEntity> {

    List<T> getAll();

    void add(T entity);

    void remove(Long id);

    T findById(Long id);

    void update(T entity);
}
