package project2.service;

import java.util.List;

public interface ModelService<T> {
	
	List<T> getAll();
	
	T getById(int id);
	
	void saveOrUpdate(T t);
	
	default Integer save(T t) {
		throw new ServiceMethodNotImplementedException();
	}
	
	default void update(T t) {
		throw new ServiceMethodNotImplementedException();
	}
	
	default void delete(T t) {
		throw new ServiceMethodNotImplementedException();
	}

}