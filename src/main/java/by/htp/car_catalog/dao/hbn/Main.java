package by.htp.car_catalog.dao.hbn;

import java.util.List;

import by.htp.car_catalog.domain.Car;

public class Main {

    public static void main(String[] args) {

	CarDaoHibernateImpl dao = new CarDaoHibernateImpl();
	List<Car> cars = dao.readByBrandAndModel("Audi", "A3 Sportback");
	System.out.println(cars);
    }

}
