package s21.DemoDaoJDBC.model.dao.impl;

import s21.DemoDaoJDBC.application.ProgramException;

public enum DaoJDBCQuerys {

	// Valores numeros representam as querys
	// DepartmentDaoJDBC
	
	// SellerDaoJDBC
	SELLER_INSERT,
	SELLER_UPDATE,
	SELLER_DELETE,
	SELLER_FINDBYID_CHECK,
	SELLER_FINDBYID,
	SELLER_FINDBYDEPARTMENT,
	SELLER_FINDALL;
	

	// Retornando a string referente a query selecionada
	String returnQuery() {
		
		switch(this) {
		
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
			
		case SELLER_FINDBYID_CHECK:
			return 
					"select                    " + 
					"	count(s.Id) as 'count' " +
					"from                      " +
					"	seller s               " +
					"where                     " +
					"	s.Id = ?               ";
			
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
