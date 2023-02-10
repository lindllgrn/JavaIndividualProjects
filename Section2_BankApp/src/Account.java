/**
 * Class used to create Account objects
 * @author winniedehpoe
 *
 */
public class Account {

	/**
	 * this is used to generate the next account number 
	 * this is a class level field - share across all accounts
	 */
	private static int lastNumber = 0;

	// instance level fields - unique per account
	// a field can also be called attribute or property
	
	/**
	 * the account number that is unique across all accounts
	 */
	private int number;
	
	/**
	 * the account owner's first name
	 */
	
	private String firstName;
	
	/**
	 * the account owner's last name
	 */
	
	private String lastName;
	
	/**
	 * the current account balance
	 */
	
	private double balance;

	/**
	 * default constructor that will return a unique account object
	 * default constructor automatically assigns the next account number
	 * and initiate default values
	 */
	
	public Account() {
		System.out.println("Default constructor");

		this.number = ++Account.lastNumber;
		this.balance = 0;
		this.firstName = "Unknown";
		this.lastName = "Unknown";
	} // end of default

	/**
	 * the overload constructor calls the default constructor 
	 * and allows overwriting the default values
	 * 
	 * overload constructor that allows setting the object's fields
	 * @param firstName The account owner's first name
	 * @param lastName The account owner's last name
	 * @param balance The initial balance
	 */
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
		if (firstName == "")
			System.out.println("first name can not be blank");
		else 
			this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName == "")
			System.out.println("last name can not be blank");
		else 
			this.lastName = lastName;
		this.lastName = lastName;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount > 0)
			this.balance += amount;
		else 
			System.out.println("invalid amount, deposit cancelled: " + amount);
		this.balance += amount;
	}

	public void withdrawal(double amount) {
		if (amount > this.balance)
			System.out.println("invalid amount, withdrawal can not exceed balance: " + this.balance);
		else if (amount > 0)
			this.balance += amount;
		else 
			System.out.println("invalid amount, withdrawal cancelled: " + amount);
		this.balance += amount;
	}
	
	/**
	 * allows getting the last account number used 
	 * @return the last account number used 
	 */
	
	public static int getLastNumber() {
		return lastNumber;
	}



	
	
} // end of Account class
