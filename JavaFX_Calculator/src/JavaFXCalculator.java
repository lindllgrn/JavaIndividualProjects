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
 *
 */
public class JavaFXCalculator extends Application {
	/**
	 * 
	 */
	private TextField mDisplay;		// display memory text field
	/**
	 * 
	 */
	private TextField tfDisplay;    // display textfield
	/**
	 * 
	 */
	private Button[] btns;          // 16 buttons
	/**
	 * 
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
	 * 
	 */
	private double result = 0.0;      // Result of computation
	/**
	 * 
	 */
	private String inStr = "0";  // Input number as String
	// Previous operator: ' '(nothing), '+', '-', '*', '/', '='
	/**
	 * 
	 */
	private char lastOperator = ' ';
	/**
	 * 
	 */
	private double memory = 0.0;

	// Event handler for all the 16 Buttons
	/**
	 * 
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
		case "M+":
			if (this.lastOperator != '=') {
				Double.parseDouble(this.inStr);
				this.memory += Double.parseDouble(this.inStr);
			}else {
				this.memory += this.result;
				this.mDisplay.setText("Memory = " + this.memory);
			}
			break;
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
		case "MC":
			this.memory = 0.0;
			this.mDisplay.setText("Memory = " + this.memory);
		case "MR":
			this.inStr = String.valueOf(this.memory);
			this.tfDisplay.setText(this.memory + "");
			break;
		case "^":
			compute();
			lastOperator = '^';
			break;      
		case "\u221A": //unicode for square root
			if (this.lastOperator != '=') {
				this.result = Double.parseDouble(this.inStr);
			}
			this.result = Math.sqrt(this.result);
			this.inStr = (this.result + " ");
			tfDisplay.setText(this.inStr);
			lastOperator = '=';
			break;
		case "\u2190": //unicode for backspace
			if (this.inStr.length() == 1) {
				this.inStr = "0";
			} else {
				//ask about this
				this.inStr = this.inStr.substring(0, inStr.length() - 1);
			}
			this.tfDisplay.setText(this.inStr);
			break;     
		}
	};

	// User pushes '+', '-', '*', '/' or '=' button.
	// Perform computation on the previous result and the current input number,
	// based on the previous operator.
	/**
	 * 
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
	 *
	 */
	@Override
	public void start(Stage primaryStage) {
		// Setup the Display TextField
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

		// Setup 16 Buttons and add to GridPane; and event handler
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
		root.setBottom(mDisplay);
		root.setCenter(paneButton); // Center zone contains the GridPane of Buttons

		// Set up scene and stage
		primaryStage.setScene(new Scene(root, 400, 400));
		primaryStage.setTitle("JavaFX Calculator");
		primaryStage.show();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
