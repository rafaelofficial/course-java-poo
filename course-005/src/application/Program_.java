package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavinsAccount;

public class Program_ {

	public static void main(String[] args) {
		
		Account acc1 = new Account(1001, "Alex", 1000.0);
		acc1.withdraw(200.0);
		System.out.println("Account : " + acc1.getBalance());
		
		Account acc2 = new SavinsAccount(1002, "Maria", 1000.0, 0.01);
		acc2.withdraw(200);
		System.out.println("Savins Account : " + acc2.getBalance());
		
		Account acc3 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);
		acc3.withdraw(200.0);
		System.out.println("Business Account : " + acc3.getBalance());

	}

}
