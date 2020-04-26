package s19.GenericsSetMap.entities;

import java.util.ArrayList;
import java.util.Comparator;

public class CalculationService {

	// metodos
//	public static <T extends Comparable<? super T>> T max(ArrayList<T> listaRegistros) {
	public static <T extends Comparable<T>> T max(ArrayList<T> listaRegistros) {

		if (listaRegistros.isEmpty()) {
			throw new IllegalStateException(
					"Erro: Impossivel encontrar o maior registro da lista, pois a lista esta vazia!");
		}

//		Meu jeito (ordena a lista pelo maior e recupera a primeira posicao
//		listaRegistros.sort(Comparator.naturalOrder());
//		return listaRegistros.get(0);

		T max = listaRegistros.get(0);
		for (T registro : listaRegistros) {
			max = registro.compareTo(max) < 0 ? registro : max;
		}
		return max;

	}
}
