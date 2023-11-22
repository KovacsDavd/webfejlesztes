package hu.unideb.service.impl;

import hu.unideb.entity.Car;
import hu.unideb.service.CarService;

import javax.ejb.Stateless;

@Stateless
public class CarServiceImpl extends CoreServiceImpl<Car> implements CarService {
}
