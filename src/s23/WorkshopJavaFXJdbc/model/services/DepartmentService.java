package s23.WorkshopJavaFXJdbc.model.services;

import java.util.ArrayList;
import java.util.List;

import s23.WorkshopJavaFXJdbc.model.entities.Department;

public class DepartmentService {
	
	public List<Department> findAll() {
		
		System.out.println();
		System.out.println("==== findAll()");
		
		List<Department> list = new ArrayList<Department>();
		list.add(new Department(1, "Books"));
		list.add(new Department(2, "Computers"));
		list.add(new Department(3, "Eletronics"));
		return list;
	}

}
