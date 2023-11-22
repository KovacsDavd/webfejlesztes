package hu.unideb.dao.impl;

import hu.unideb.dao.CarDao;
import hu.unideb.entity.Car;

import javax.ejb.Stateless;

@Stateless
public class CarDaoImpl extends CoreDaoImpl<Car> implements CarDao {
    @Override
    protected Class<Car> getManagedClass() {
        return Car.class;
    }
}
