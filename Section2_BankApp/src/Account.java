
public class Account {
	
	//all accounts share this field
	private static int nextAccount;

	//each account object values
	public int number;
	public double balance;
	public String firstName;
	public String lastName;
	
	//default constructor
	public Account() {
		this.number = ++Account.nextAccount;
	}
	
	//overload constructor
	public Account(double balance, String firstName, String lastName) {
		this(); //call the default constructor
		this.balance = balance;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
}
