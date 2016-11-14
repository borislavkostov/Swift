
public class LoanAccount extends Account {
	public LoanAccount(String iBAN, Owner owner, double balance, double montlyInterestRate) {
		super(iBAN,owner,balance, montlyInterestRate);
	}
	public double increase(int months){
		if(this.getOwner() instanceof IndividualCustomer ){
			return this.getMontlyInterestRate()*this.getBalance()* (months-3);
		}
		return 0;
	}
}
