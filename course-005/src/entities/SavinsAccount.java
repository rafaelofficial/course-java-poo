package entities;

public final class SavinsAccount extends Account {

	private Double interestRate;

	public SavinsAccount() {
		super();
	}

	public SavinsAccount(Integer number, String holder, Double balance, Double interestRate) {
		super(number, holder, balance);
		this.interestRate = interestRate;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public void updateBalance() {
		balance += balance * interestRate;
	}
	
	@Override
	public final void withdraw(double amount) {
		balance -= amount;
	}

}