package hu.unideb.dao.impl;

import hu.unideb.dao.OwnerDao;
import hu.unideb.entity.Owner;

import javax.ejb.Stateless;

@Stateless
public class OwnerDaoImpl extends CoreDaoImpl<Owner> implements OwnerDao {
    @Override
    protected Class<Owner> getManagedClass() {
        return Owner.class;
    }
}
