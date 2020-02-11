package s13Enumeracoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import myUtils.MyUtils;
import s13Entidades.Contrato;
import s13Entidades.Departamento;
import s13Entidades.Funcionario;
import s13Entidades.Pedido;
import s13Entidades.Enum.StatusPedido;

public class Program {

	public static void main(String args[]) throws ParseException {

		Scanner input = new Scanner(System.in);

//		aula112_exemplo01(input);

//		aula112_exemplo02(input);

		aula115_exercicio01(input);

		input.close();

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
