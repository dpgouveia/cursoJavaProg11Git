package s23.WorkshopJavaFXJdbc.model.services;

import java.util.List;

import s22.javafx.exceptions.MainException;
import s23.WorkshopJavaFXJdbc.model.dao.DaoFactory;
import s23.WorkshopJavaFXJdbc.model.dao.SellerDao;
import s23.WorkshopJavaFXJdbc.model.entities.Seller;

public class SellerService {

	// atributos
	private SellerDao dao = DaoFactory.createSellerDao();

	// métodos	
	public List<Seller> findAll() {
		System.out.println();
		System.out.println(getClass() + " ==== findAll()");

		return dao.findAll();
	}

	public void saveOrUpdate(Seller seller) {
		System.out.println();
		System.out.println(getClass() + " ==== saveOrUpdate()");

		if (seller == null) {
			throw new MainException("Seller object IS NULL!");
		}

		if (seller.getId() == null) {
			dao.insert(seller);
		} else if (dao.findById(seller.getId()) == null) {
			throw new MainException("The specified Seller ID does not exist on Seller table for update operation");
		} else {
			dao.update(seller);
		}

	}

	public void remove(Seller seller) {
		System.out.println();
		System.out.println(getClass() + " ==== remove()");

		if (seller == null) {
			throw new MainException("Seller object IS NULL!");
		}

		if (seller.getId() == null) {
			throw new MainException("Seller ID IS NULL!");
		}

		if (dao.findById(seller.getId()) == null) {
			throw new MainException("The specified Seller ID does not exist on Seller table for delete operation");
		}

		dao.deleteById(seller.getId());
	}

}
