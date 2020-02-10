package s13Enumeracoes;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import s13Entidades.Pedido;
import s13Entidades.Enum.StatusPedido;

public class Program {

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

//		aula112_exemplo01(input);
		
		aula112_exemplo02(input);

		input.close();

	}
	
	public static void aula112_exemplo02(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n--------------------------------");
		System.out.println("AULA 112 - EXEMPLO 02");
		System.out.println("--------------------------------\n");

		Pedido novoPedido = new Pedido(1080, new Date(), StatusPedido.AGUARDANDO_PAGAMENTO);
		System.out.println(novoPedido);
		
		StatusPedido sp1 = StatusPedido.ENTREGUE;
		StatusPedido sp2 = StatusPedido.valueOf("ENTREGUE");
		System.out.println(sp1);
		System.out.println(sp2);

	}

	public static void aula112_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n--------------------------------");
		System.out.println("AULA 112 - EXEMPLO 01");
		System.out.println("--------------------------------\n");

		Pedido novoPedido = new Pedido(1080, new Date(), StatusPedido.AGUARDANDO_PAGAMENTO);
		System.out.println(novoPedido);

	}

}
