package s19.GenericsSetMap.entities;

import java.util.ArrayList;

public class PrintServiceString {

	// atributos
	ArrayList<String> listaNumeros;

	// construtores
	public PrintServiceString() {
		super();
		listaNumeros = new ArrayList<String>();
		
		if (listaNumeros == null) {
			throw new IllegalStateException("Lista de numeros inexistente no objeto");
		}
	}

	// metodos
	public void addValue(String value) {
		listaNumeros.add(value);
	}

	public String first() {
		
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
			for (String numero : listaNumeros) {
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
