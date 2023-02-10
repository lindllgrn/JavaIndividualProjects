// Class used to create Account objects
public class Account {

	// this is a class level field - share across all accounts
	private static int lastNumber = 0;

	// instance level fields - unique per account
	// a field can also be called attribute or property
	private int number;
	private String firstName;
	private String lastName;
	private double balance;

	// default constructor that will return a unique account object 
	public Account() {
		System.out.println("Default constructor");

		this.number = ++Account.lastNumber;
		this.balance = 0;
		this.firstName = "Unknown";
		this.lastName = "Unknown";
	} // end of default

	// overload constructor that allows setting the object's fields
	public Account(String firstName, String lastName, double balance) {
		this(); // call the default constructor

		// can not run this before calling default constructor
		System.out.println("Overload constructor");

		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	} // end of overload constructor

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public static void setLastNumber(int lastNumber) {
		Account.lastNumber = lastNumber;
	}

	
	
} // end of Account class
