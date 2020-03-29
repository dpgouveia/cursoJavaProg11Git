package s19.GenericsSetMap.entities;

import java.util.ArrayList;

public class PrintServiceInteger {

	// atributos
	ArrayList<Integer> listaNumeros;

	// construtores
	public PrintServiceInteger() {
		super();
		listaNumeros = new ArrayList<Integer>();
		
		if (listaNumeros == null) {
			throw new IllegalStateException("Lista de numeros inexistente no objeto");
		}
	}

	// metodos
	public void addValue(Integer value) {
		listaNumeros.add(value);
	}

	public Integer first() {
		
		if (listaNumeros.isEmpty()) {
			throw new IllegalStateException("A lista de numero esta VAZIA!");
		}

		return listaNumeros.get(0);
	}

	public void print() {

		if (listaNumeros.isEmpty()) {
			System.out.println("[ ]");
		} else {
			System.out.print("[");
			for (Integer numero : listaNumeros) {
				if (!numero.equals(listaNumeros.get(listaNumeros.size() - 1))) {
					System.out.print(numero + ", ");
				} else {
					System.out.print(numero);
				}
			}
			System.out.println("]");
		}
	}

}
