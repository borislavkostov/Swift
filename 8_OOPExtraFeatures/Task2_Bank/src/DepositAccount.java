
public class DepositAccount extends Account{
	public DepositAccount(String iBAN, Owner owner, double balance, double montlyInterestRate) {
		super(iBAN,owner,balance, montlyInterestRate);
	}
	public void withdraw(double withdrawSum){
		this.setBalance(this.getBalance()-withdrawSum);
	}
}
