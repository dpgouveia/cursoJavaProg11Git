package s11.DateFormat.Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

public class Program {

	public static void main(String args[]) throws ParseException {
		Scanner input = new Scanner(System.in);

//		aula99_exemplo01(input);

		aula100_exemplo01(input);

		input.close();
	}

	public static void aula100_exemplo01(Scanner input) throws ParseException {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n----------------------------");
		System.out.println("AULA 100 - EXEMPLO 01");
		System.out.println("----------------------------\n");

		System.out.println();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date myDate = new Date();
		System.out.println(sdf.format(myDate));

		// realizando contas com horas utilizando a classe Calendar
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(myDate);
		calendario.add(Calendar.HOUR_OF_DAY, 4);
		myDate = calendario.getTime();
		System.out.println();
		System.out.println(sdf.format(myDate));

		// obtendo uma unidade de tempo a partir da classe calendar
		System.out.println();
		System.out.println("Minutos: " + calendario.get(Calendar.MINUTE));
		System.out.println("Mês: " + (calendario.get(Calendar.MONTH) + 1));

	}

	public static void aula99_exemplo01(Scanner input) throws ParseException {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n----------------------------");
		System.out.println("AULA 98 - EXEMPLO 01");
		System.out.println("----------------------------\n");

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));

		Date x1 = new Date();
		Date x2 = new Date(System.currentTimeMillis());
		Date x3 = new Date(0L);
		Date x4 = new Date(1000L * 60 * 60 * 5);

		Date y1 = sdf1.parse("08/02/2020");
		Date y2 = sdf2.parse("08/02/2020 16:02:51");
		Date y3 = Date.from(Instant.parse("2018-06-25T15:42:07Z"));

		System.out.println();
		System.out.println("TimeZone: BRT");
		System.out.println("------------------------");
		System.out.println("x1: " + sdf2.format(x1));
		System.out.println("x2: " + sdf2.format(x2));
		System.out.println("x3: " + sdf2.format(x3));
		System.out.println("x4: " + sdf2.format(x4));
		System.out.println(y1);
		System.out.println(y2);
		System.out.println("y1: " + sdf1.format(y1));
		System.out.println("y2: " + sdf2.format(y2));
		System.out.println("y3: " + sdf2.format(y3));

		System.out.println();
		System.out.println("TimeZone: GMT -- UTC");
		System.out.println("------------------------");
		System.out.println("x1: " + sdf3.format(x1));
		System.out.println("x2: " + sdf3.format(x2));
		System.out.println("x3: " + sdf3.format(x3));
		System.out.println("x4: " + sdf3.format(x4));
		System.out.println(y1);
		System.out.println(y2);
		System.out.println("y1: " + sdf3.format(y1));
		System.out.println("y2: " + sdf3.format(y2));
		System.out.println("y3: " + sdf3.format(y3));

		System.out.println();
		System.out.println("Imprimindo o Date diretamente");
		System.out.println("------------------------");
		System.out.println("x1: " + x1);
		System.out.println("x2: " + x2);
		System.out.println("x3: " + x3);
		System.out.println("x4: " + x4);
		System.out.println(y1);
		System.out.println(y2);
		System.out.println("y1: " + y1);
		System.out.println("y2: " + y2);
		System.out.println("y3: " + y3);

	}

}
