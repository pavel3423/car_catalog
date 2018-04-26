package by.htp.car_catalog.dao;

import java.util.List;

import by.htp.car_catalog.domain.Entity;

public interface BaseDao<T extends Entity> {

	void create(T entity);

	T read(int id);

	List<T> readAll();

	void update(T entity);

	void delete(int id);
}
