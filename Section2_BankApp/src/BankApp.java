public class BankApp {
	
	public static void main(String[] args) {
		
		Account debbieAccount = new Account(100.10, "Debbie", "Johnson");
		
		System.out.println(debbieAccount.number);
		System.out.println(debbieAccount.balance);
		
		Account lindsayAccount = new Account(40000.10, "Lindsay", "Green");
		
		System.out.println(lindsayAccount.number);
		System.out.println(lindsayAccount.balance);
			
		}
}

