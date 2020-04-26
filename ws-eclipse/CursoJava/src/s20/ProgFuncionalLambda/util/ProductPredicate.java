package s20.ProgFuncionalLambda.util;

import java.util.function.Predicate;

import s20.ProgFuncionalLambda.entities.Product;
import s20.ProgFuncionalLambda.exception.ProgramException;

public class ProductPredicate implements Predicate<Product> {

	private Double threshold;

	public ProductPredicate(Double threshold) {
		super();
		this.threshold = threshold;
	}

	public ProductPredicate() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean test(Product t) {

		if (threshold == null) {
			throw new ProgramException("ProductPredicate: Threshold não foi definido com um valor inicial");
		}

		return t.getPrice() > threshold;
	}

}
