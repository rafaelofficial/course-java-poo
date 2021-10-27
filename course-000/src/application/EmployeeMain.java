package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class EmployeeMain {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Employee emp = new Employee();
		System.out.println("Employee: ");
		emp.name = sc.nextLine();

		System.out.println();
		System.out.println("Gloss Salary: ");
		emp.glossSalary = sc.nextDouble();

		System.out.println();
		System.out.println("Tax: ");
		emp.tax = sc.nextDouble();

		System.out.println("Employee: " + emp);
		System.out.println("Which percentage to increase salary?");

		double percentage = sc.nextDouble();
		emp.increaseSalary(percentage);

		System.out.println("Update data: " + emp);
		emp.netSalary();

		sc.close();
	}

}
