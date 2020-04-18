package s21.DemoDaoJDBC.model.dao;

import java.util.List;

import s21.DemoDaoJDBC.model.entities.Seller;

public interface SellerDao {

	void insert(Seller obj);

	void update(Seller obj);

	void deleteById(Integer id);

	Seller findById(Integer id);

	List<Seller> findByDepartment(Integer id);
	
	List<Seller> findAll();

}
