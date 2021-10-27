package application;

import java.util.Locale;
import java.util.Scanner;

import util.CorrencyConverter;

public class CurrencyConverterMain {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("What is the dollar price? ");
		double dollarPrice = sc.nextDouble();

		System.out.println("How many dollars will be bought? ");
		double amount = sc.nextDouble();

		double result = CorrencyConverter.dolarToReal(amount, dollarPrice);
		System.out.printf("Amount to be paid in reais = %.2f%n", result);

		sc.close();

	}

}
