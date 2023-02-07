// Class used to create Account objects
public class Account {
	
	// this is a class level field - share across all accounts
	public static int lastNumber = 0;
	
	// instance level fields - unique per account
	// a field can also be called attribute or property
	public int number;
	public String firstName;
	public String lastName;
	public double balance;
	
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
	
} // end of Account class
