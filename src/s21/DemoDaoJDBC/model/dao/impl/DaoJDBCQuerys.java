package s21.DemoDaoJDBC.model.dao.impl;

import s21.DemoDaoJDBC.application.ProgramException;

public enum DaoJDBCQuerys {

	// Valores numeros representam as querys
	// DepartmentDaoJDBC
	
	// SellerDaoJDBC
	SELLER_FINDBYID_CHECK,
	SELLER_FINDBYID;
	

	// Retornando a string referente a query selecionada
	String returnQuery() {
		
		switch(this) {
		
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
					"select                     " + 
					"	s.*                     " + 
					"	,d.Name as 'DepName'    " + 
					"from                       " + 
					"	seller s                " + 
					"inner join department d    " + 
					"	on s.Id = d.Id          " + 
					"where                      " + 
					"	s.Id = ?                ";
		
		default:
			throw new ProgramException(getClass() + ": valor enumerado especificado não possui uma querys válida associada no programa!");
			
		}
			
	}
	
}
