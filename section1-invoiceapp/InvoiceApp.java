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
        double subotal = 0.0;
        double discountPercent = 0.0;
        double discountAmount = 0.0;
        double discountInvoiceTotal = 0.0;
        
        String choice = "y";
		
		// create a Scanner object named sc
        Scanner sc = new Scanner(System.in);
        
        // welcome the user to the program
		System.out.println(); //print blank line
		System.out.println("==========================================");
        System.out.println("Welcome to the Invoice Total Calculator V2");
		System.out.println("==========================================");
        System.out.println();  // print a blank line

        // perform invoice calculations until choice is "n" or "N"
        while (!choice.equalsIgnoreCase("n")) {
        	
        	 // get the invoice line items from the user
        	System.out.println();
    		System.out.println("==========================================");
            System.out.print("Enter the number of invoice line itmes:   ");
    		System.out.println("==========================================");
            lineItems = sc.nextInt();
        	
        	for (int i = 1; i <= lineItems; i++) {
        		System.out.println();
        		System.out.println("==========================================");
                System.out.print("Enter the #" + i + " line item amount:   ");
        		System.out.println("==========================================");
        		System.out.println();
                subtotal += sc.nextDouble();
        	}
        	
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
            // display the discount amount and total
			
            System.out.printf("%20s:,10\n", "Line items", numLineItems);
			/* better way look at assignment details
            String message = "Discount percent: " + discountPercent + "\n"
                           + "Discount amount:  " + discountAmount + "\n"
                           + "Invoice total:    " + discountInvoiceTotal + "\n";            
            System.out.println(message);
			*/
			
			choice = sc.nextLine(); //clear the return char still in the input buffer

            // see if the user wants to continue
			System.out.println();
			System.out.println("==========================================");
            System.out.print("Continue? (y/n): ");
    		System.out.println("==========================================");
            choice = sc.nextLine();
            System.out.println();
        }
        
        System.out.printf("%20s: %,10.2f\n", "Subtotal", subtotal);
		/* better way look at assignment details
        // calculate and display invoice count, average invoice, and average discount
        String message = "Number of invoices: " + invoiceCount + "\n"
                       + "Average invoice:    " + invoiceTotal / invoiceCount + "\n"
                       + "Average discount:   " + discountTotal / invoiceCount + "\n";
        System.out.println(message);
		*/
		
		sc.close();
    } //end of main
} //end of invoiceapp class