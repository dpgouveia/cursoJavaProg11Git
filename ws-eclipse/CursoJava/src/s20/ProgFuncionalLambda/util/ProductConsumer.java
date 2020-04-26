package s20.ProgFuncionalLambda.util;

import java.util.function.Consumer;

import s20.ProgFuncionalLambda.entities.Product;

public class ProductConsumer implements Consumer<Product> {

	@Override
	public void accept(Product t) {
		t.setPrice(t.getPrice() * 1.1);
	}

}
