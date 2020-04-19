package s21.DemoDaoJDBC.model.dao.impl;

import s21.DemoDaoJDBC.application.ProgramException;

public enum DaoJDBCQuerys {

	// Valores numeros representam as querys
	// DepartmentDaoJDBC
	DEPARTMENT_INSERT,
	DEPARTMENT_UPDATE,
	DEPARTMENT_DELETE,
	DEPARTMENT_FINDBYID,
	DEPARTMENT_FINDALL,
	
	// SellerDaoJDBC
	SELLER_INSERT,
	SELLER_UPDATE,
	SELLER_DELETE,
	SELLER_FINDBYID,
	SELLER_FINDBYDEPARTMENT,
	SELLER_FINDALL;
	

	// Retornando a string referente a query selecionada
	String returnQuery() {
		
		switch(this) {
		
		case DEPARTMENT_INSERT:
			return 
					"insert                         " +
					"	into department (Name)      " +
					"values                         " +
					"	(?)                         ";
			
		case DEPARTMENT_UPDATE:
			return 
					"update department d   " +
					"	set d.Name = ?     " +
					"where d.Id = ?        ";
		
		case DEPARTMENT_FINDBYID:
			return
					"select                               " +
					"	d.Id as 'SellerDepartmentId',     " +
					"	d.Name as 'DepartmentName'        " +
					"from                                 " +
					"	department d                      " + 
					"where                                " +
					"	d.Id = ?                          ";
			
		case DEPARTMENT_FINDALL:
			return
					"select                               " +
					"	d.Id as 'SellerDepartmentId',     " +
					"	d.Name as 'DepartmentName'        " +
					"from                                 " +
					"	department d                      ";
		
		case SELLER_INSERT:
			return 
					"insert                                                                 " +
					"	into seller (Name, Email, BirthDate, BaseSalary, DepartmentId)      " +
					"values                                                                 " +
					"	(?, ?, ?, ?, ?)                                                     ";     
		
		case SELLER_UPDATE:
			return 
					"update seller s                                                                            " +
					"	set s.Name = ?, s.Email = ?, s.BirthDate = ?, s.BaseSalary = ?, s.DepartmentId = ?      " +
					"where s.Id = ?                                                                             "; 
			
		case SELLER_DELETE:
			return 
					"delete from seller s " +
					"where s.Id = ?       ";
					
		case SELLER_FINDBYID:
			return 
					"select                                     " +
					"	s.Id  as 'SellerID',                    " +
					"	s.Name  as 'SellerName',                " +
					"	s.Email as 'SellerEmail',               " +
					"	s.BirthDate as 'SellerBirthDate',       " +
					"	s.BaseSalary as 'SellerBaseSalary',     " +
					"	s.DepartmentId as 'SellerDepartmentId', " +
					"	d.Name as 'DepartmentName'              " +
					"from                                       " +
					"	seller s,                               " +
					"	department d                            " +
					"where                                      " +
					" 	s.DepartmentId = d.Id                   " +
					"	and s.Id = ?                            ";
		
		case SELLER_FINDBYDEPARTMENT:
			return 
					"select                                     " +
					"	s.Id  as 'SellerID',                    " +
					"	s.Name  as 'SellerName',                " +
					"	s.Email as 'SellerEmail',               " +
					"	s.BirthDate as 'SellerBirthDate',       " +
					"	s.BaseSalary as 'SellerBaseSalary',     " +
					"	s.DepartmentId as 'SellerDepartmentId', " +
					"	d.Name as 'DepartmentName'              " +
					"from                                       " +
					"	seller s,                               " +
					"	department d                            " +
					" where                                     " +
					" 	s.DepartmentId = d.Id                   " +
					" 	and d.Id = ?                            " +
					"order by                                   " +
					"	s.Name                                  ";
		
		case SELLER_FINDALL:
			return 
					"select                                     " +
					"	s.Id  as 'SellerID',                    " +
					"	s.Name  as 'SellerName',                " +
					"	s.Email as 'SellerEmail',               " +
					"	s.BirthDate as 'SellerBirthDate',       " +
					"	s.BaseSalary as 'SellerBaseSalary',     " +
					"	s.DepartmentId as 'SellerDepartmentId', " +
					"	d.Name as 'DepartmentName'              " +
					"from                                       " +
					"	seller s,                               " +
					"	department d                            " +
					" where                                     " +
					" 	s.DepartmentId = d.Id                   " +
					"order by                                   " +
					"	s.Name                                  ";
			
		default:
			throw new ProgramException(getClass() + ": valor enumerado especificado não possui uma querys válida associada no programa!");
			
		}
			
	}
	
}
