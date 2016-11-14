
public class Account {
	private String IBAN;
	private Owner owner;
	private double balance;
	private double montlyInterestRate;

	public Account(String iBAN, Owner owner, double balance, double montlyInterestRate) {
		IBAN = iBAN;
		this.setOwner(owner);
		this.balance = balance;
		this.montlyInterestRate = montlyInterestRate;
	}

	public void payIn(double balance) {
		this.balance += balance;
	}

	public String getIBAN() {
		return IBAN;
	}

	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getMontlyInterestRate() {
		return montlyInterestRate;
	}

	public void setMontlyInterestRate(double montlyInterestRate) {
		this.montlyInterestRate = montlyInterestRate;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
}
