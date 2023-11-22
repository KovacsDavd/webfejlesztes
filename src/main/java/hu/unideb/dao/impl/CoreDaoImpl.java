package hu.unideb.dao.impl;

import hu.unideb.dao.CoreDao;
import hu.unideb.entity.CoreEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class CoreDaoImpl<T extends CoreEntity> implements CoreDao<T> {
    @PersistenceContext(name = "WebPersistence")
    EntityManager entityManager;

    @Override
    public List<T> getAll() {
        return entityManager.createQuery("select n from " + getManagedClass().getSimpleName() + " n", getManagedClass()).getResultList();
    }

    @Override
    public void add(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public T findById(Long id) {
        return entityManager.find(getManagedClass(), id);
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    protected abstract Class<T> getManagedClass();

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
