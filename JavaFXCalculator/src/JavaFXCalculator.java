import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

/**
 * The JavaFX Calculator
 *  
 * @author winniedehpoe
 * @since 2023.04.07
 * @version 1.0 beta
 *
 * GitHub URL: https://github.com/lindllgrn/JavaIndividualProjects/tree/main/JavaFX_Calculator
 */
public class JavaFXCalculator extends Application {
	/**
	 * The text display for the numbers entered
	 */
	private TextField mDisplay;		// display memory text field
	/**
	 * The text display for the Memory at the bottom of the calculator
	 */
	private TextField tfDisplay;    // display textfield
	/**
	 * Used to create the buttons on the calculator
	 */
	private Button[] btns;          // 24 buttons
	/**
	 * Creates the labels on the buttons
	 */
	private String[] btnLabels = {  // Labels of 16 buttons
			"7", "8", "9", "+",
			"4", "5", "6", "-",
			"1", "2", "3", "x",
			".", "0", "=", "/",
			"C", "\u2190", "^", "\u221A", 
			"MC", "MR", "M+", "M-"
	};
	// For computation
	/**
	 * For the result of the numbers put into the calculator
	 */
	private double result = 0.0;      // Result of computation
	/**
	 * Gets the input number as a string
	 */
	private String inStr = "0";  // Input number as String
	// Previous operator: ' '(nothing), '+', '-', '*', '/', '='
	/**
	 * Gets the operator for the math operation being used
	 */
	private char lastOperator = ' ';
	/**
	 * Used for storing a number that the user wants to keep for later math equations
	 */
	private double memory = 0.0;

	// Event handler for all the 16 Buttons
	/**
	 * This creates the button labels and uses a switch for buttons being used.
	 * Depending on the button pressed, the switch will use the compute() method
	 * which handles for any of the math operations being used and will also
	 * update the text field at the top of the calculator
	 */
	EventHandler handler = evt -> {
		String currentBtnLabel = ((Button)evt.getSource()).getText();
		switch (currentBtnLabel) {
		// Number buttons
		case "0": case "1": case "2": case "3": case "4":
		case "5": case "6": case "7": case "8": case "9":
		case ".":
			if (inStr.equals("0")) {
				inStr = currentBtnLabel;  // no leading zero
			} else {
				inStr += currentBtnLabel; // append input digit
			}
			tfDisplay.setText(inStr);
			// Clear buffer if last operator is '='
			if (lastOperator == '=') {
				result = 0;
				lastOperator = ' ';
			}
			break;

			// Operator buttons: '+', '-', 'x', '/' and '='
		case "+":
			compute();
			lastOperator = '+';
			break;
		case "-":
			compute();
			lastOperator = '-';
			break;
		case "x":
			compute();
			lastOperator = '*';
			break;
		case "/":
			compute();
			lastOperator = '/';
			break;
		case "=":
			compute();
			lastOperator = '=';
			break;

			// Clear button
		case "C":
			result = 0.0;
			inStr = "0";
			lastOperator = ' ';
			tfDisplay.setText("0");
			break;

			// adds a number to memory
		case "M+":
			if (this.lastOperator != '=') {
				Double.parseDouble(this.inStr);
				this.memory += Double.parseDouble(this.inStr);
			}else {
				this.memory += this.result;
				this.mDisplay.setText("Memory = " + this.memory);
			}
			break;

			//takes away a number from memory
		case "M-":	
			if (this.lastOperator != '=') {
				Double.parseDouble(this.inStr);
				//subtract value from this.memory
				this.memory -= Double.parseDouble(this.inStr);
			}else {
				this.memory -= this.result;
				mDisplay.setText("Memory = " + this.memory);
			}
			break;

			//clears the number from memory
		case "MC":
			this.memory = 0.0;
			this.mDisplay.setText("Memory = " + this.memory);

			//recalls the number in memory
		case "MR":
			this.inStr = String.valueOf(this.memory);
			this.tfDisplay.setText(this.memory + "");
			break;

			//the power math operator
		case "^":
			compute();
			lastOperator = '^';
			break;     

			//gets the square root of a number
		case "\u221A": //unicode for square root
			if (this.lastOperator != '=') {
				this.result = Double.parseDouble(this.inStr);
			}
			this.result = Math.sqrt(this.result);
			this.inStr = (this.result + " ");
			tfDisplay.setText(this.inStr);
			lastOperator = '=';
			break;

			//can backspace the number typed if a mistake was made
		case "\u2190": //unicode for backspace
			if (this.inStr.length() == 1) {
				this.inStr = "0";
			} else {
				this.inStr = this.inStr.substring(0, inStr.length() - 1);
			}
			this.tfDisplay.setText(this.inStr);
			break;     
		}
	};

	// User pushes '+', '-', '*', '/', '=', or '^' button.
	// Perform computation on the previous result and the current input number,
	// based on the previous operator.
	/**
	 * This method performs the math operations of the one that the
	 * user chooses
	 */
	private void compute() {
		double inNum = Double.parseDouble(inStr); //changed from int to handle for MR 
		inStr = "0";
		if (lastOperator == ' ') {
			result = inNum;
		} else if (lastOperator == '+') {
			result += inNum;
		} else if (lastOperator == '-') {
			result -= inNum;
		} else if (lastOperator == '*') {
			result *= inNum;
		} else if (lastOperator == '/') {
			result /= inNum;
		} else if (lastOperator == '=') {
			// Keep the result for the next operation
		} else if (lastOperator == '^') {
			result = Math.pow(result, inNum);
		}
		tfDisplay.setText(result + "");
	}

	// Setup the UI
	/**
	 *This creates the calculator itself. It creates the text fields 
	 *and displays one at the top and bottom. It creates rows and 
	 *columns in a GridPane for the buttons to be placed in at equal width. 
	 *The buttons are then placed with their labels using a for loop and inside
	 *their is a switch giving the buttons their colors.
	 */
	@Override
	public void start(Stage primaryStage) {
		// Setup the Display and Memory TextField
		mDisplay = new TextField("Memory = 0.0");
		mDisplay.setEditable(false);
		mDisplay.setAlignment(Pos.BOTTOM_LEFT);
		tfDisplay = new TextField("0");
		tfDisplay.setEditable(false);
		tfDisplay.setAlignment(Pos.CENTER_RIGHT);

		// Setup a GridPane for 4x4 Buttons
		int numCols = 4;
		int numRows = 6;
		GridPane paneButton = new GridPane();
		paneButton.setPadding(new Insets(15, 0, 15, 0));  // top, right, bottom, left
		paneButton.setVgap(5);  // Vertical gap between nodes
		paneButton.setHgap(5);  // Horizontal gap between nodes
		// Setup 4 columns of equal width, fill parent
		ColumnConstraints[] columns = new ColumnConstraints[numCols];
		for (int i = 0; i < numCols; ++i) {
			columns[i] = new ColumnConstraints();
			columns[i].setHgrow(Priority.ALWAYS) ;  // Allow column to grow
			columns[i].setFillWidth(true);  // Ask nodes to fill space for column
			paneButton.getColumnConstraints().add(columns[i]);
		}

		// Setup 24 Buttons and add to GridPane; and event handler
		btns = new Button[24];
		for (int i = 0; i < btns.length; ++i) {
			btns[i] = new Button(btnLabels[i]);
			btns[i].setOnAction(handler);  // Register event handler
			btns[i].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);  // full-width
			paneButton.add(btns[i], i % numCols, i / numCols);  // control, col, row

			switch (btnLabels[i]) {
			case "M+": case "M-": case "MR": case "MC" :
				btns[i].setStyle("-fx-color: salmon");
				break;
			case "\u2190": case "^": case "+": case "-": case "x": case "/": case "\u221A":
				btns[i].setStyle("-fx-color: pink");
				break;
			case "C":
				btns[i].setStyle("-fx-color: coral");
				break;
			case "0": case "1": case "2": case "3": case "4":
			case "5": case "6": case "7": case "8": case "9":
			case ".": case "=":
				btns[i].setStyle("-fx-color: lightblue");

			}
		}

		// Setup up the scene graph rooted at a BorderPane (of 5 zones)
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(15, 15, 15, 15));  // top, right, bottom, left
		root.setTop(tfDisplay);     // Top zone contains the TextField
		root.setBottom(mDisplay);	// bottom zone text field
		root.setCenter(paneButton); // Center zone contains the GridPane of Buttons

		// Set up scene and stage
		primaryStage.setScene(new Scene(root, 400, 400));
		primaryStage.setTitle("JavaFX Calculator");
		primaryStage.show();
	}

	/**
	 * @param args launches the calculator 
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
