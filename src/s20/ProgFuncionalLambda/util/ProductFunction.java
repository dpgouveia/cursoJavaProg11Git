package s20.ProgFuncionalLambda.util;

import java.util.function.Function;

import s20.ProgFuncionalLambda.entities.Product;

public class ProductFunction implements Function<Product, Product> {

	@Override
	public Product apply(Product source) {
		return new Product(source.getName().toUpperCase(), source.getPrice());
	}

}
