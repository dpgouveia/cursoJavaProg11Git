package s20.ProgFuncionalLambda.application;

import java.util.Comparator;

import s20.ProgFuncionalLambda.entities.Product2;

public class MyComparator implements Comparator<Product2> {

	@Override
	public int compare(Product2 o1, Product2 o2) {
		return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
	}

}
