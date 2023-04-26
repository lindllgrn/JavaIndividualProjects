package zoo.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import zoo.animal.*;



/**
 * The Zoo_Keeper_App
 * 
 * @author winniedehpoe
 * 
 * @author lindllgrn
 * @since 2023.04.07
 * @version 1.0 beta
 * GitHub URL: https://github.com/lindllgrn/JavaIndividualProjects/tree/main/Zoo
 */

public class Zoo_Keeper_App {

	/**
	 * Helps for getting user input
	 */
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Get the name of the zoo
	 */
	private String name;

	/**
	 * ArrayList to store animals
	 */
	private List<Animal> animals;

	/**
	 * the header
	 */
	private void displayHeader() {
		String s ="███╗░░░███╗██╗░░░██╗     ███████╗░█████╗░░█████╗░\r\n"
				+ "████╗░████║╚██╗░██╔╝     ╚════██║██╔══██╗██╔══██╗\r\n"
				+ "██╔████╔██║░╚████╔╝░     ░░███╔═╝██║░░██║██║░░██║\r\n"
				+ "██║╚██╔╝██║░░╚██╔╝░░     ██╔══╝░░██║░░██║██║░░██║\r\n"
				+ "██║░╚═╝░██║░░░██║░░░     ███████╗╚█████╔╝╚█████╔╝\r\n"
				+ "╚═╝░░░░░╚═╝░░░╚═╝░░░     ╚══════╝░╚════╝░░╚════╝░ ฅʕ•ᴥ•ฅʔ ";

		System.out.println(s);
	}

	/**
	 * the line under the header
	 */
	private void displayLine() {
		String s = "\r\n"
				+ "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\r\n"
				+ "██████╗██████╗██████╗██████╗██████╗██████╗██████╗██████╗\r\n"
				+ "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░";
		System.out.println(s);
	}

	/**
	 * creates a double line for separation
	 */
	private final static String DOUBLE_LINE = "=========================================";

	/**
	 * creates a single line for separation
	 */
	private final static String SINGLE_LINE = "-----------------------------------------"; 

	/**
	 * creates the Zoo_Keeper_App to defaults
	 */
	public Zoo_Keeper_App() {
		this.name = "Unknown";
		this.animals = new ArrayList<Animal>();
	}

	/**
	 * gets the name of the Zoo
	 * 
	 * @return the name
	 */
	public String getName() {

		return this.name;
	}

	/**
	 * sets the name of the Zoo
	 * 
	 * @param name sets the name
	 */
	public void setName(String name) {

		this.name = name;
	}

	/**
	 * @param name sets the name 
	 * @throws Exception for invalid name
	 */
	public Zoo_Keeper_App(String name)throws Exception {

		this();
		this.setName(name);
	}

	/**
	 * asks the user for the name of the zoo
	 * 
	 * @throws Exception for invalid name
	 */
	public void zooName() throws Exception {
		String userInput = " ";

		System.out.println();

		userInput = Input.getLine("What would you like your zoo to be called?: ");
		this.setName(userInput);

		System.out.println();
	}

	/**
	 * adds a Guppy to the ArrayList
	 */
	public void addGuppy() {

		this.animals.add(new Guppy());
	}

	/**
	 * adds a FlyingFish to the ArrayList
	 */
	public void addFlyingFish() {

		this.animals.add(new FlyingFish());
	}

	/**
	 * adds a Chicken to the ArrayList
	 */
	public void addChicken() {

		this.animals.add(new Chicken());
	}

	/**
	 * adds a Sparrow to the ArrayList
	 */
	public void addSparrow() {

		this.animals.add(new Sparrow());
	}

	/**
	 * creates the menu for what type of bird the user wants
	 * and depending on the bird, the certain type will be
	 * stored into the ArrayList along with the information
	 * the user puts in for each of the questions
	 * 
	 * @throws Exception for invalid numeric input
	 */
	public void birdChoices() throws Exception {

		boolean birdChoices = true;
		int userInput = 0;

		System.out.println();
		System.out.println(DOUBLE_LINE);

		while(birdChoices) {

			System.out.println("What type of Bird would you like to add?:");
			System.out.println("0 = Chicken");
			System.out.println("1 = Sparrow");
			System.out.println("2 = Main Menu");
			System.out.println("3 = Fish Choices");
			System.out.println("4 = End Game");

			userInput = Input.getIntRange("Menu Choice: ", 0, 4);

			switch (userInput) {
			case 0:
				this.addChicken();
				Chicken c = (Chicken) this.animals.get(this.animals.size() - 1);
				this.setGender(c, c, c, c);
				this.setBirthdate(c, c, c, c);
				this.setWeight(c, c, c, c);
				this.setWingspan(c, c);
				System.out.println();
				break;
			case 1:
				this.addSparrow();
				Sparrow d = (Sparrow) this.animals.get(this.animals.size() - 1);
				this.setGender(d, d, d, d);
				this.setBirthdate(d, d, d, d);
				this.setWeight(d, d, d, d);
				this.setWingspan(d, d);
				System.out.println();
				break;
			case 2:
				this.createZoo();
				break;
			case 3:
				this.fishChoices();
				break;
			case 4: 
				System.exit(0);;
			default:
				System.out.println("Invalid menu choice = " + userInput);
			}
		}
	}

	/**
	 * the user inputs the gender of the animal
	 * 
	 * @param <T> for multiple types of data
	 * @param a gets methods from the Animal class for Animal a
	 * @param b gets methods from the Animal class for Animal b
	 * @param c gets methods from the Animal class for Animal c
	 * @param d gets methods from the Animal class for Animal d
	 * @throws Exception for invalid input
	 */
	public <T> void setGender(Animal a, Animal b, Animal c, Animal d)throws Exception {

		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.println(DOUBLE_LINE);
		System.out.println("Please enter the type of gender of the animal you picked: ");

		String s = sc.nextLine();

		a.setGender(s);
		b.setGender(s);
		c.setGender(s);
		d.setGender(s);
	}

	/**
	 * the user inputs the birthdate of the animal
	 * 
	 * @param a gets methods from the Animal class for Animal a
	 * @param b gets methods from the Animal class for Animal b
	 * @param c gets methods from the Animal class for Animal c
	 * @param d gets methods from the Animal class for Animal d
	 * @throws Exception for invalid input
	 */
	public void setBirthdate(Animal a, Animal b, Animal c, Animal d) throws Exception{

		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.println(DOUBLE_LINE);
		System.out.println("Please enter the birthdate (MM-dd-yyyy): ");

		String input = sc.nextLine();

		a.setBirthdate(input);
		b.setBirthdate(input);
		c.setBirthdate(input);
		d.setBirthdate(input);
	}

	/**
	 * the user inputs the type of water the fish lives in
	 * 
	 * @param <T> for multiple types of data
	 * @param a gets methods from Fish class for Animal a
	 * @param b gets methods from Fish class for Animal b
	 * @throws Exception for invalid input
	 */
	public <T> void setWater(Fish a, Fish b) throws Exception{

		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.println(DOUBLE_LINE);
		System.out.println("Please enter the type of water they live in (fresh or salt): ");

		String s = sc.nextLine();

		a.setWater(s);
		b.setWater(s);
	}

	/**
	 * the user inputs the weight of the animal
	 * 
	 * @param a gets methods from Animal class for Animal a
	 * @param b gets methods from Animal class for Animal b
	 * @param c gets methods from Animal class for Animal c
	 * @param d gets methods from Animal class for Animal d
	 * @throws Exception for invalid input
	 */
	public void setWeight(Animal a, Animal b, Animal c, Animal d) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.println(DOUBLE_LINE);
		System.out.println("Please enter the weight in lbs: ");

		float userInput = sc.nextFloat();

		a.setWeight(userInput);
		b.setWeight(userInput);
		c.setWeight(userInput);
		d.setWeight(userInput);
	}

	/**
	 * asks the user what fish they want to add to their zoo, depending
	 * on what the user picks, it will add that certain animal into 
	 * the ArrayList and sets the information the user gives into the 
	 * ArrayList
	 * 
	 * @throws Exception for invalid numeric input
	 */
	public void fishChoices() throws Exception {
		boolean fishChoices = true;
		int userInput = 0;

		System.out.println();
		System.out.println(DOUBLE_LINE);

		while(fishChoices) {

			System.out.println("What type of Fish would you like to add?:");
			System.out.println("0 = Guppy");
			System.out.println("1 = Flying Fish");
			System.out.println("2 = Main Menu");
			System.out.println("3 = Bird Choices");
			System.out.println("4 = End Game");

			userInput = Input.getIntRange("Menu Choice: ", 0, 4);

			switch (userInput) {
			case 0:
				this.addGuppy();
				Guppy a = (Guppy) this.animals.get(this.animals.size() - 1);
				this.setGender(a, a, a, a);
				this.setBirthdate(a, a, a, a);
				this.setWeight(a, a, a, a);
				this.setWater(a, a);
				System.out.println();
				break;
			case 1:
				this.addFlyingFish();
				FlyingFish b = (FlyingFish) this.animals.get(this.animals.size() - 1);
				this.setGender(b, b, b, b);
				this.setBirthdate(b, b, b, b);
				this.setWeight(b, b, b, b);
				this.setWater(b, b);
				System.out.println();
				break;
			case 2:
				this.createZoo();
				break;
			case 3:
				this.birdChoices();
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Invalid menu choice = " + userInput);
			}
		}
	}

	/** 
	 * asks the user if they want to add a fish or a bird
	 * 
	 * @throws Exception for invalid numeric input
	 */
	public void updateZoo() throws Exception {

		boolean updateZoo = true;
		int userInput = 0;

		System.out.println();
		System.out.println(DOUBLE_LINE);

		while (updateZoo) {

			System.out.println("Would you like to add a type of Fish or Bird?:");
			System.out.println("0 = Fish");
			System.out.println("1 = Bird");
			System.out.println("2 = Main Menu");

			userInput = Input.getIntRange("Menu Choice: ", 0, 2);

			switch (userInput) {
			case 0:
				this.fishChoices();
				break;
			case 1:
				this.birdChoices();
				break;
			case 2:
				this.createZoo();
				break;
			default:
				System.out.println("Invalid menu choice = " + userInput);
			}
		}
	}

	/**
	 * the user enters the wingspan in cm for a bird and passes into the ArrayList
	 * 
	 * @param c for using methods inside the Bird class
	 * @param d for using methods inside the Bird class
	 * @throws Exception for invalid input
	 */
	public void setWingspan(Bird c, Bird d) throws Exception{

		System.out.println();
		System.out.println(DOUBLE_LINE);
		System.out.println("Please enter the wingspan in cm: ");

		float userInput = sc.nextFloat();

		c.setWingspan(userInput);
		d.setWingspan(userInput);
	}

	/**
	 * Main menu, the user can pick to add animals or end game or display
	 * animals if they have added any
	 * 
	 * @throws Exception for invalid numeric input
	 */
	public void createZoo() throws Exception {

		boolean createZoo = true;

		int userInput = 0;

		while (createZoo) {

			System.out.println();
			System.out.println(DOUBLE_LINE);

			System.out.println("Main Menu");

			System.out.println("0 = End Game");
			System.out.println("1 = Enter " + this.getName() + " Zoo Animals");
			System.out.println("2 = Display Animals");

			userInput = Input.getIntRange("Menu Choice: ", 0, 3);

			switch (userInput) {
			case 0:
				System.exit(0);
			case 1:
				this.updateZoo();
				break;
			case 2:
				this.displayAnimals();
				break;
			default:
				System.out.println("Invalid menu choice = " + userInput);
			}
		}
	}

	/**
	 * displays the animals that are stored in the ArrayList, and if the
	 * ArrayList contains the certain Animal, then they will display their
	 * specific interfaces
	 */
	public void displayAnimals() {
		System.out.println();

		for (int i = 0; i < this.animals.size(); i++) {

			System.out.println();
			System.out.println((i + 1) + ") Birthdate  Gender Weight ID Type ");
			System.out.println("  ========== ====== ====== == ============= ");

			String birthdate = animals.get(i).getBirthdateStr();
			Gender gender = animals.get(i).getGender();
			float weight = animals.get(i).getWeight();
			String string = animals.get(i).toString();

			System.out.printf("  %10s %6s %3.2f %15s\n", birthdate, gender, weight, string);
			System.out.println(SINGLE_LINE);
			System.out.println("What this animal does or is doing:");
			System.out.println(SINGLE_LINE);


			if(this.animals.get(i).toString().contains("guppy")) {
				Guppy guppy = new Guppy();
				guppy.propel();
				guppy.drift();
				guppy.eating();
			}else if(this.animals.get(i).toString().contains("flying fish")) {
				FlyingFish flyingfish = new FlyingFish();
				flyingfish.fly();
				flyingfish.drift();
				flyingfish.propel();
				flyingfish.soar();
				flyingfish.eating();
			}else if(this.animals.get(i).toString().contains("sparrow")) {
				Sparrow sparrow = new Sparrow();
				sparrow.fly();
				sparrow.soar();
				sparrow.eating();
			}else {
				Chicken chicken = new Chicken();
				chicken.eating();
			}			
		}
	}

	/**
	 * displays the name of the zoo 
	 */
	public void zooStarted() {
		System.out.println(SINGLE_LINE);
		System.out.println(this.getName() +" Zoo Started!");
		System.out.println(SINGLE_LINE);
	}

	/**
	 * Main, runs the methods inside
	 * 
	 * @param args No command line input args are used for this application
	 * @throws Exception numerous methods could throw errors back to main
	 */
	public static void main(String[] args) throws Exception{


		try {
			Zoo_Keeper_App app = new Zoo_Keeper_App();

			app.displayHeader();
			app.displayLine();

			app.zooName();
			app.zooStarted();
			app.createZoo();

		} catch (Exception e) {
			System.out.println("The following error has occurred: ");
			System.out.println(e.getMessage());
		}
	}
}
