package application;

import java.util.Locale;
import java.util.Scanner;

import entities.exception.DomainException;
import model.entities.Account;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			Account acc = new Account(number, holder, balance, withdrawLimit);
			balance = sc.nextDouble();
			System.out.print("New balance: " + String.format("%.2f%n", acc.withdraw(balance)));
		}
		catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		sc.close();
	}

}
