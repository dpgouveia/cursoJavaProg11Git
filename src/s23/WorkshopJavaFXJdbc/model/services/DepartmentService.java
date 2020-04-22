package s23.WorkshopJavaFXJdbc.model.services;

import java.util.List;

import s22.javafx.exceptions.MainException;
import s23.WorkshopJavaFXJdbc.model.dao.DaoFactory;
import s23.WorkshopJavaFXJdbc.model.dao.DepartmentDao;
import s23.WorkshopJavaFXJdbc.model.entities.Department;

public class DepartmentService {

	// atributos
	private DepartmentDao dao = DaoFactory.createDepartmentDao();

	// métodos
	public List<Department> findAll() {
		System.out.println();
		System.out.println(getClass() + " ==== findAll()");
		
		return dao.findAll();
	}

	public void saveOrUpdate(Department dept) {

		System.out.println();
		System.out.println(getClass() + " ==== dao.saveOrUpdate()");

		if (dept == null) {
			throw new MainException("Department object IS NULL!");
		}

		if (dept.getId() == null) {
			dao.insert(dept);
		} else if (dao.findById(dept.getId()) == null) {
			throw new MainException("The specified department ID does not exist on Departemnt table for update operation");
		} else {
			dao.update(dept);
		}

	}

	public void remove(Department dept) {
		System.out.println();
		System.out.println(getClass() + " ==== remove()");
		
		if(dept == null) {
			throw new MainException("Department object IS NULL!");
		}
		
		if(dept.getId() == null) {
			throw new MainException("Department ID IS NULL!");
		}
		
		if(dao.findById(dept.getId()) == null) {
			throw new MainException("The specified department ID does not exist on Departemnt table for remove operation");
		}
		
		dao.deleteById(dept.getId());		
	}
	
	
}
