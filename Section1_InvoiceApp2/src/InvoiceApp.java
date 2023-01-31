import java.util.Scanner;

/********************************************************************************************
 Description: First assignment for Section1 modifying the Invoice App
 Programmer: Lindsay Green
 Date Written: 2023.01.27
 GitHub: https://github.com/lindllgrn/JavaIndividualProjects/tree/main/section1-invoiceapp
 ********************************************************************************************/

public class InvoiceApp {
    public static void main(String[] args) {
    	 // initialize variables for use in calculating averages
        int invoiceCount = 0;
        int lineItems = 0;
        
        double invoiceTotal = 0.0;
        double discountTotal = 0.0;
        double subtotal = 0.0;
        double discountPercent = 0.0;
        double discountAmount = 0.0;
        double discountInvoiceTotal = 0.0;
        
        String choice = "y";
		
		// create a Scanner object named sc
        Scanner sc = new Scanner(System.in);
        
        // welcome the user to the program
		System.out.println(); //print blank line
		System.out.println("==========================================");
        System.out.println("Welcome to the Invoice Total Calculator V5");
		System.out.println("==========================================");

        // perform invoice calculations until choice is "n" or "N"
        while (!choice.equalsIgnoreCase("n")) {
        	
        	// get the invoice line items from the user
        	System.out.println();
            System.out.print("Enter the number of invoice line items: ");
            lineItems = sc.nextInt();
            
            System.out.println();
    		System.out.println("==========================================");
            System.out.println();

            //user enters the invoice amounts
        	for (int i = 1; i <= lineItems; i++) {   
                System.out.print("Enter the #" + i + " line item amount:   ");
                subtotal += sc.nextDouble();
                
    			System.out.println();
        	}
        	
    		System.out.println("==========================================");
  	
        	// calculate the discount amount and total
            if (subtotal >= 500) {
                discountPercent = 0.25;
            } else if (subtotal >= 200) {
                discountPercent = 0.2;
            } else if (subtotal >= 100) {
                discountPercent = 0.1;
            } else {
                discountPercent = 0.0;
            }
            discountAmount = subtotal * discountPercent;
            discountInvoiceTotal = subtotal - discountAmount;
            
            // accumulate the invoice count and invoice total
            invoiceTotal = invoiceTotal + discountInvoiceTotal;
            discountTotal = discountTotal + discountAmount;
            invoiceCount = invoiceCount + 1;  
            
			System.out.println();
            
			//displays the user's proper numbers according to the input data
            System.out.printf("%20s: %,10.2f\n", "Discount percent", discountPercent);
            System.out.printf("%20s: %,10.2f\n", "Discount amount", discountAmount);
            System.out.printf("%20s: %,10.2f\n", "Invoice total", discountInvoiceTotal);
            
            System.out.println();
			System.out.println("==========================================");
			
			choice = sc.nextLine(); //clear the return char still in the input buffer
			
			System.out.println();
			
			//displays the user's proper numbers according to the input data
	        System.out.printf("%20s: %,10d\n", "Numer of invoices", invoiceCount);
	        System.out.printf("%20s: %,10.2f\n", "Average invoice", invoiceTotal / invoiceCount);
	        System.out.printf("%20s: %,10.2f\n", "Average discount", discountTotal / invoiceCount);

			System.out.println();
			System.out.println("==========================================");
			System.out.println();

			//asks the user if they would like to continue
            System.out.print("Continue? (y/n): ");
            
            choice = sc.nextLine();
            
            System.out.println();
        }
        
        //sends a goodbye message to the user when they are finished using the program
		System.out.println("==========================================");
		System.out.println();
		System.out.println("Goodbye");
		System.out.println();
		System.out.println("==========================================");
		
		sc.close();
    } //end of main
} //end of invoiceapp class