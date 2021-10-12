package entities;

public class Employee {

	public String name;
	public double glossSalary;
	public double tax;

	public double netSalary() {
		return glossSalary - tax;
	}

	public void increaseSalary(double percentage) {
		this.glossSalary += glossSalary * percentage / 100.0;
	}

	public String toString() {
		return name + ", $ " + String.format("%.2f", netSalary());
	}
}
