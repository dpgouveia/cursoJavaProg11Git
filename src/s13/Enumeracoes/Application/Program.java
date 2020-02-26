package s13.Enumeracoes.Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import common.myUtils.MyUtils;
import s13.Enumeracoes.Entidades.Client;
import s13.Enumeracoes.Entidades.Comment;
import s13.Enumeracoes.Entidades.Contrato;
import s13.Enumeracoes.Entidades.Departamento;
import s13.Enumeracoes.Entidades.Funcionario;
import s13.Enumeracoes.Entidades.Order;
import s13.Enumeracoes.Entidades.OrderItem;
import s13.Enumeracoes.Entidades.Pedido;
import s13.Enumeracoes.Entidades.Post;
import s13.Enumeracoes.Entidades.Product;
import s13.Enumeracoes.Enum.OrderStatus;
import s13.Enumeracoes.Enum.StatusPedido;

public class Program {

	public static void main(String args[]) throws ParseException {

		Scanner input = new Scanner(System.in);

//		aula112_exemplo01(input);

//		aula112_exemplo02(input);

//		aula115_exercicio01(input);

//		aula117_exercicio01(input);

		aula118_exercicio01(input);

		input.close();

	}

	public static void aula118_exercicio01(Scanner input) throws ParseException {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n--------------------------------");
		System.out.println("AULA 118 - EXERCICIO 01");
		System.out.println("--------------------------------\n");

		// Client data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String clientName = MyUtils.readString(input);
		System.out.print("Email: ");
		String clientEmail = MyUtils.readString(input);
		System.out.print("Birth Date (DD/MM/YYYY): ");
		Date clientBirthDate = sdf.parse(MyUtils.readString(input));

		// Order data
		System.out.println();
		System.out.println("Enter order data: ");
		String orderStatus = "";
		boolean orderStatusCheck = true;
		do {
			System.out.print("Order Status: ");
			orderStatus = MyUtils.readString(input);
			orderStatusCheck = orderStatus.isBlank() || orderStatus.isEmpty()
					|| !(orderStatus.toUpperCase().equals("PENDING_PAYEMENT")
							|| orderStatus.toUpperCase().equals("PROCESSING")
							|| orderStatus.toUpperCase().equals("SHIPPED")
							|| orderStatus.toUpperCase().equals("DELIVERED"));
			if (orderStatusCheck) {
				System.out.println("Invalid Order Status!!!");
			}
		} while (orderStatusCheck);
		Order order = new Order(new Date(), OrderStatus.valueOf(orderStatus),
				new Client(clientName, clientEmail, clientBirthDate));

		// Item and order item data
		Integer orderQuantity;
		do {
			System.out.println();
			System.out.printf("How many items to this order: ");
			orderQuantity = MyUtils.readInteger(input);
			if (orderQuantity <= 0) {
				System.out.println("Order quantity MUST BE GREATER THAN ZERO");
			}
		} while (orderQuantity <= 0);
		for (int i = 1; i <= orderQuantity; i++) {
			System.out.println();
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			String productName = MyUtils.readString(input);
			System.out.print("Product price: ");
			Double productPrice = MyUtils.readDouble(input);
			System.out.print("Product quantity: ");
			Integer productQuantity = MyUtils.readInteger(input);
			order.addItem(new OrderItem(new Product(productName, productPrice), productQuantity));
		}

		// report order summary
		System.out.println();
		System.out.println(order);

	}

	public static void aula117_exercicio01(Scanner input) throws ParseException {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n--------------------------------");
		System.out.println("AULA 117 - EXERCICIO 01");
		System.out.println("--------------------------------\n");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Post post1 = new Post(sdf.parse("21/06/2018 13:05:44"), "Traveling to New Zealand",
				"I'm going to visit this wonderful country!", 12);
		post1.addComent(new Comment("Have a nice trip"));
		post1.addComent(new Comment("Wow that's awesome!"));

		Post post2 = new Post(sdf.parse("27/08/2018 23:14:19"), "Good night guys", "See you tomorrow", 5);
		post2.addComent(new Comment("Good night"));
		post2.addComent(new Comment("May the force be with you"));

		System.out.println();
		System.out.println(post1);

		System.out.println();
		System.out.println(post2);

	}

	public static void aula115_exercicio01(Scanner input) throws ParseException {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n--------------------------------");
		System.out.println("AULA 115 - EXERCICIO 01");
		System.out.println("--------------------------------\n");

		System.out.printf("Entre com o nome do departamento: ");
		String departamento = MyUtils.readString(input);
		System.out.println("Entre com os dados do funcionário: ");
		System.out.print("Nome: ");
		String nome = MyUtils.readString(input);
		System.out.printf("Nível do funcionário: ");
		String nivel = MyUtils.readString(input);
		System.out.printf("Salário base: ");
		Double salarioBase = MyUtils.readDouble(input);
		Funcionario funcionario = new Funcionario(nome, nivel, salarioBase, new Departamento(departamento));

		Integer numeroContratos;
		do {
			System.out.println();
			System.out.printf("Quantos contratos este funcionário possui: ");
			numeroContratos = MyUtils.readInteger(input);
			if (numeroContratos <= 0) {
				System.out.println("O número de contratos deve ser MAIOR QUE ZERO");
			}
		} while (numeroContratos <= 0);

		for (int i = 0; i < numeroContratos; i++) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println();
			System.out.println("Entre com os dados do contrato " + (i + 1) + ": ");
			System.out.printf("Data de início do contrato (dd/MM/yyyy): ");
			Date dataInicio = sdf.parse(MyUtils.readString(input));
			System.out.print("Valor hora ($): ");
			Double valorHora = MyUtils.readDouble(input);
			System.out.printf("Horas trabalhadas: ");
			Integer horasTrabalhadas = MyUtils.readInteger(input);
			funcionario.adicionarContrato(new Contrato(dataInicio, valorHora, horasTrabalhadas));
		}

		System.out.println();
		System.out.printf("Digite o MÊS e o ANO para calcular o faturamento (MM/yyyy): ");
		SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
		Date periodoFaturamento = sdf.parse(MyUtils.readString(input));
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(periodoFaturamento);

		System.out.println();
		System.out.println(funcionario + "Faturamento para do período " + sdf.format(periodoFaturamento) + ": ["
				+ String.format("%.2f",
						funcionario.faturamento(calendario.get(Calendar.MONTH), calendario.get(Calendar.YEAR)))
				+ "]\n");

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
