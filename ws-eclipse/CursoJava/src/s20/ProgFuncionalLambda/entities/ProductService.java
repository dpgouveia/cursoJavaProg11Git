package s20.ProgFuncionalLambda.entities;

import java.util.List;
import java.util.function.Predicate;

public class ProductService {

	public static double somaFiltrada(List<Product> list) {
		double soma = 0;

		for (Product p : list) {
			if(p != null && p.getName().toUpperCase().charAt(0) == 'T') {
				soma += p.getPrice();
			}
		}
		
		return soma;
	}
	
	public static double somaFiltradaPredicate(List<Product> list, Predicate<Product> predicate) {
		double soma = 0;

		for (Product p : list) {
			if(predicate.test(p)) {
				soma += p.getPrice();
			}
		}
		
		return soma;
	}

}
