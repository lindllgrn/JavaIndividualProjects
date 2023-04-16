package zoo.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import zoo.animal.*;

public class Zoo_Keeper_App {

	private Water water;

	private float weight;

	private Gender gender;

	private String name;

	private float wingspan;

	private static Scanner sc;

	private final static DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.US);

	private LocalDate birthdate;

	private List<Animal> animals;

	private void displayHeader() {
		System.out.println("\r\n"
				+ "███╗░░░███╗██╗░░░██╗     ███████╗░█████╗░░█████╗░\r\n"
				+ "████╗░████║╚██╗░██╔╝     ╚════██║██╔══██╗██╔══██╗\r\n"
				+ "██╔████╔██║░╚████╔╝░     ░░███╔═╝██║░░██║██║░░██║\r\n"
				+ "██║╚██╔╝██║░░╚██╔╝░░     ██╔══╝░░██║░░██║██║░░██║\r\n"
				+ "██║░╚═╝░██║░░░██║░░░     ███████╗╚█████╔╝╚█████╔╝\r\n"
				+ "╚═╝░░░░░╚═╝░░░╚═╝░░░     ╚══════╝░╚════╝░░╚════╝░ ฅʕ•ᴥ•ฅʔ ");
	}

	private void displayLine() {
		System.out.println("\r\n"
				+ "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\r\n"
				+ "██████╗██████╗██████╗██████╗██████╗██████╗██████╗██████╗\r\n"
				+ "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
	}

	
	private final static String DOUBLE_LINE = "=========================================";

	private final static String SINGLE_LINE = "-----------------------------------------"; 

	public Zoo_Keeper_App() {
		this.name = "Unknown";
		this.animals = new ArrayList<Animal>();
	}

	public String getName() {

		return this.name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public Zoo_Keeper_App(String name)throws Exception {

		this();
		this.setName(name);
	}

	public void zooName() throws Exception {
		String userInput = " ";

		System.out.println();

		userInput = Input.getLine("What would you like your zoo to be called?: ");
		this.setName(userInput);

		System.out.println();
	}

	public void addGuppy() {

		this.animals.add(new Guppy());
	}
	
	public void addFlyingFish() {

		this.animals.add(new FlyingFish());
	}
	
	public void addChicken() {

		this.animals.add(new Chicken());
	}
	
	public void addSparrow() {

		this.animals.add(new Sparrow());
	}

	public void birdChoices() throws Exception {

		boolean birdChoices = true;
		int userInput = 0;

		System.out.println();
		System.out.println(DOUBLE_LINE);

		while(birdChoices) {

			System.out.println("What type of Bird would you like to add?:");
			System.out.println("0 = Chicken");
			System.out.println("1 = Sparrow");
			System.out.println("e = Main Menu");

			userInput = Input.getIntRange("Menu Choice: ", 0, 2);

			switch (userInput) {
			case 0:
				this.setGender("male");
				this.addChicken();
				this.setBirthdate(birthdate);
				this.setWeight(weight);
				this.setWingspan(wingspan);
				System.out.println();
				break;
			case 1:
				this.setGender("male");
				this.addSparrow();
				this.setBirthdate(birthdate);
				this.setWeight(weight);
				this.setWingspan(wingspan);
				System.out.println();
				break;
			case 2:
				this.createZoo();
				break;

			default:
				System.out.println("Invalid menu choice = " + userInput);
			}
		}
	}

	public <T> void setGender(T gender)throws Exception {

		System.out.println();
		System.out.println(DOUBLE_LINE);
		System.out.println("Please enter the type of gender of the animal you picked: ");

		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		if (gender instanceof String) {

			s = (String) gender;

			s = s.toLowerCase();

			switch(s) {
			case "f":
			case "female":
				this.gender = Gender.FEMALE;
				break;
			case "m":
			case "male":
				this.gender = Gender.MALE;
				break;
			default:
				this.gender = Gender.UNKNOWN;
			}
		}else if (gender instanceof Gender) {
			Gender g = (Gender) gender;
			this.gender = g;
		}else if (gender == null) {
			throw new IllegalArgumentException("Invalid gender: null");
		}else {
			throw new Exception("invalid gender: " + gender);
		}
	}

	public void setBirthdate(LocalDate birthdate) throws Exception{
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter the birthdate (MM-dd-yyyy): ");

		String input = sc.nextLine();

		LocalDate birthdate1 = LocalDate.parse(input, FORMAT);

		if (!input.matches("\\d{2}-\\d{2}-\\d{4}")) {
			throw new Exception("Invalid date format. Please enter date in MM-dd-yyyy format.");
		}

		this.birthdate = birthdate1;
	}

	public <T> void setWater(T water) throws Exception{

		System.out.println();
		System.out.println(DOUBLE_LINE);
		System.out.println("Please enter the type of water they live in (fresh or salt): ");

		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		if (water instanceof String) {

			s = (String) water;

			s = s.toLowerCase();

			switch(s) {
			case "f":
			case "fresh":
				this.water = Water.FRESH;
				break;
			case "s":
			case "salt":
				this.water = Water.SALT;
				break;
			default:
				this.water = Water.UNKNOWN;
			}
		}else if (water instanceof Water) {
			Water w = (Water) water;
			this.water = w;
		}else if(water == null) {
			throw new IllegalArgumentException("Invalid water: null");
		}else {
			throw new Exception("invalid water: " + water);
		}
	}

	public void setWeight(float weight) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.println(DOUBLE_LINE);
		System.out.println("Please enter the weight in lbs: ");

		float userInput = sc.nextFloat();

		if (userInput > 0)
			this.weight = userInput;
		else
			throw new Exception("Invalid weight: " + userInput);
	}

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

			userInput = Input.getIntRange("Menu Choice: ", 0, 2);

			switch (userInput) {
			case 0:
				this.setGender("male");
				this.addGuppy();
				this.setBirthdate(birthdate);
				this.setWeight(weight);
				this.setWater("fresh");
				System.out.println();
				break;
			case 1:
				this.setGender("male");
				this.addFlyingFish();
				this.setBirthdate(birthdate);
				this.setWeight(weight);
				this.setWater("fresh");
				System.out.println();
				break;
			case 2:
				this.createZoo();
				break;

			default:
				System.out.println("Invalid menu choice = " + userInput);
			}
		}
	}

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

	public void setWingspan(float wingspan) throws Exception{

		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.println(DOUBLE_LINE);
		System.out.println("Please enter the wingspan in cm: ");

		float userInput = sc.nextFloat();

		if(userInput > 0) {
			this.wingspan = userInput;
		}else{
			throw new Exception ("invalid wingspan: " + userInput);
		}
	}

	public void createZoo() throws Exception {

		boolean createZoo = true;
		int userInput = 0;

		System.out.println(SINGLE_LINE);
		System.out.println(this.getName() +" Zoo Started!");
		System.out.println(SINGLE_LINE);


		while (createZoo) {

			System.out.println();
			System.out.println(DOUBLE_LINE);

			System.out.println("Main Menu");

			System.out.println("0 = End Game");
			System.out.println("1 = Enter " + this.getName() + " Zoo Animals");

			userInput = Input.getIntRange("Menu Choice: ", 0, 2);

			switch (userInput) {
			case 0:
				createZoo = false;
				System.out.println();
				break;
			case 1:
				this.updateZoo();
				break;

			default:
				System.out.println("Invalid menu choice = " + userInput);
			}
		}
	}

	public static void main(String[] args) throws Exception{


		try {
			Zoo_Keeper_App app = new Zoo_Keeper_App();

			app.displayHeader();
			app.displayLine();

			app.zooName();
			app.createZoo();

		} catch (Exception e) {
			System.out.println("The following error has occurred: ");
			System.out.println(e.getMessage());
		}
	}
}
