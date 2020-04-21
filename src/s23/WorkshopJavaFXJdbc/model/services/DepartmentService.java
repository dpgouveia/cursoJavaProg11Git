package s23.WorkshopJavaFXJdbc.model.services;

import java.util.List;

import s23.WorkshopJavaFXJdbc.model.dao.DaoFactory;
import s23.WorkshopJavaFXJdbc.model.dao.DepartmentDao;
import s23.WorkshopJavaFXJdbc.model.entities.Department;

public class DepartmentService {
	
	// atributos
	private DepartmentDao dao = DaoFactory.createDepartmentDao();
	
	// métodos
	public List<Department> findAll() {
		
		System.out.println();
		System.out.println("==== findAll() --> dao.findAll()");
		return dao.findAll();
	}

}
