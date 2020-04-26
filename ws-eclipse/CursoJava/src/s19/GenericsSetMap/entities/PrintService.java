package s19.GenericsSetMap.entities;

import java.util.ArrayList;

public class PrintService<T> {

	// atributos
	ArrayList<T> listaRegistros;

	// construtores
	public PrintService() {
		super();
		listaRegistros = new ArrayList<T>();
		
		if (listaRegistros == null) {
			throw new IllegalStateException("Erro ao criar lista de registros no objeto");
		}
	}

	// metodos
	public void addValue(T value) {
		listaRegistros.add(value);
	}

	public T first() {
		
		if (listaRegistros.isEmpty()) {
			throw new IllegalStateException("A lista de registros esta VAZIA!");
		}

		return listaRegistros.get(0);
	}

	public void print() {

		if (listaRegistros.isEmpty()) {
			System.out.println("[ ]");
		} else {
			System.out.print("[");
			for (T registro : listaRegistros) {
				if (!registro.equals(listaRegistros.get(listaRegistros.size() - 1))) {
					System.out.print(registro + ", ");
				} else {
					System.out.print(registro);
				}
			}
			System.out.println("]");
		}
	}

}
