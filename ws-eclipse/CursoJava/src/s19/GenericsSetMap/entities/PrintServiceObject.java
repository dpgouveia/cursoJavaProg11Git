package s19.GenericsSetMap.entities;

import java.util.ArrayList;

public class PrintServiceObject {

	// atributos
	ArrayList<Object> listaNumeros;

	// construtores
	public PrintServiceObject() {
		super();
		listaNumeros = new ArrayList<Object>();
		
		if (listaNumeros == null) {
			throw new IllegalStateException("Lista de numeros inexistente no objeto");
		}
	}

	// metodos
	public void addValue(Object value) {
		listaNumeros.add(value);
	}

	public Object first() {
		
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
			for (Object numero : listaNumeros) {
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
