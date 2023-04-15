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

	private String name;

	private static Scanner sc;

	private final static DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.US);

	private LocalDate birthdate;

	private List<Animal> animals;
	/* 8
	 * https://fsymbols.com/bubble/
	 */
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
		String userInput = null;

		System.out.println();

		userInput = Input.getLine("What would you like your zoo to be called?: ");
		this.setName(userInput);

		System.out.println();
	}

	public void addAnimal(String name) {

		this.animals.add(null);
	}

	public void birdChoices(String name) throws Exception {

		boolean birdChoices = true;
		int userInput = 0;

		System.out.println();
		System.out.println(DOUBLE_LINE);

		while(birdChoices) {

			System.out.println("What type of Bird would you like to add?:");
			System.out.println("0 = Chicken");
			System.out.println("1 = Sparrow");

			userInput = Input.getIntRange("Menu Choice: ", 0, 2);

			switch (userInput) {
			case 0:
				this.addAnimal(name);
				this.setBirthdate(null);
				this.setWeight(userInput);
				System.out.println();
				break;
			case 1:
				this.addAnimal(name);
				this.setBirthdate(null);
				this.setWeight(userInput);
				System.out.println();
				break;

			default:
				System.out.println("Invalid menu choice = " + userInput);
			}
		}
	}

	public <T> void setBirthdate(T birthdate) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.println(DOUBLE_LINE);
		System.out.println("Please enter birthdate (MM-dd-yyyy):");

		String userInput = sc.nextLine();

		if (birthdate instanceof String) {

			userInput = (String) birthdate;
			this.birthdate = LocalDate.parse(userInput, Zoo_Keeper_App.FORMAT);

		} else if (birthdate instanceof LocalDate){

			this.birthdate = (LocalDate) birthdate;

		}else{

			throw new Exception("Invalid date MM-dd-yyyy: " + birthdate);
		}
	}

	public <T> void setWater(T water) throws Exception{
		
System.out.println();
		System.out.println(DOUBLE_LINE);
		System.out.println("Please enter the type of water they live in (fresh or salt): ");
		Scanner sc = new Scanner(System.in);

		if (water instanceof String) {

			String s = (String) water;

			sc.nextLine();

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

		if (weight > 0)
			this.weight = weight;
		else
			throw new Exception("Invalid weight: " + weight);
	}

	public void fishChoices(String name) throws Exception {
		boolean fishChoices = true;
		int userInput = 0;

		System.out.println();
		System.out.println(DOUBLE_LINE);

		while(fishChoices) {

			System.out.println("What type of Fish would you like to add?:");
			System.out.println("0 = Guppy");
			System.out.println("1 = Flying Fish");

			userInput = Input.getIntRange("Menu Choice: ", 0, 2);

			switch (userInput) {
			case 0:
				this.addAnimal(name);
				this.setBirthdate(null);
				this.setWeight(userInput);
				this.setWater(null);
				System.out.println();
				break;
			case 1:
				this.addAnimal(name);
				this.setBirthdate(null);
				this.setWeight(userInput);
				this.setWater(null);
				System.out.println();
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

			userInput = Input.getIntRange("Menu Choice: ", 0, 1);

			switch (userInput) {
			case 0:
				this.fishChoices(name);
				break;
			case 1:
				this.birdChoices(name);
				break;
			default:
				System.out.println("Invalid menu choice = " + userInput);
			}
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
			//System.out.println("3 = Display Zoo Stats");

			userInput = Input.getIntRange("Menu Choice: ", 0, 2);

			//ask about this
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

	public static void main(String[] args) throws Exception {


		try {
			Zoo_Keeper_App app = new Zoo_Keeper_App();

			app.displayHeader();
			app.displayLine();

			app.zooName();
			app.createZoo();
			//app.updateZoo();

			/*
			Animal a1 = new Animal();
			Animal a2 = new Animal("12-31-2022", (float) 10.5);

			LocalDate birthdate = LocalDate.parse("11-30-2022", FORMAT);
			Animal a3 = new Animal(birthdate, (float) 5.5);

			System.out.println(a1);
			System.out.println(a2);
			System.out.println(a3);


			System.out.println();

			System.out.println(a1.getBirthdateStr() + " " + a1.getWeight());
			System.out.println(a2.getBirthdateStr() + " " + a2.getWeight());
			System.out.println(a3.getBirthdateStr() + " " + a3.getWeight());


			Bird b1 = new Bird();
			Bird b2 = new Bird("12-31-2022", (float) 1.5);
			Bird b3 = new Bird("12-31-2022", (float) 1.5, (float) 2.0);


			System.out.println(b1);
			System.out.println(b2);
			System.out.println(b3.getWingspan());


			Sparrow s1 = new Sparrow();
			Sparrow s2 = new Sparrow("12-31-2022", (float) 1.5);
			Sparrow s3 = new Sparrow("12-31-2022", (float) 1.5, (float) 2.0);

			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3.getWingspan());


			Chicken c1 = new Chicken();
			Chicken c2 = new Chicken("12-31-2022", (float) 1.5);
			Chicken c3 = new Chicken("12-31-2022", (float) 1.5, (float) 2.0);

			System.out.println(c1);
			System.out.println(c2);
			System.out.println(c3.getWingspan());


			Fish f1 = new Fish();
			Fish f2 = new Fish("12-31-2022", (float) 1.5);
			Fish f3 = new Fish("12-31-2022", (float) 1.5, "salt");

			System.out.println(f1);
			System.out.println(f2);
			System.out.println(f3.getWater());


			Guppy g1 = new Guppy();
			Guppy g2 = new Guppy("12-31-2022", (float) 1.5);
			Guppy g3 = new Guppy("12-31-2022", (float) 1.5, "salt");

			System.out.println(g1);
			System.out.println(g2);
			System.out.println(g3.getWater());

			FlyingFish ff1 = new FlyingFish();
			FlyingFish ff2 = new FlyingFish("12-31-2022", (float) 1.5);
			FlyingFish ff3 = new FlyingFish("12-31-2022", (float) 1.5, "salt");

			System.out.println(ff1);
			System.out.println(ff2);
			System.out.println(ff3.getWater());

			//Zoo_Keeper_App.animals.add(a1);
			//Zoo_Keeper_App.animals.add(b1);
			Zoo_Keeper_App.animals.add(s1);
			Zoo_Keeper_App.animals.add(c1);
			//Zoo_Keeper_App.animals.add(f1);
			Zoo_Keeper_App.animals.add(g1);
			Zoo_Keeper_App.animals.add(ff1);

			FlyingFish myFish = (FlyingFish) Zoo_Keeper_App.animals.get(2);
			System.out.println(myFish.getWater());

			myFish.soar();
			myFish.fly();
			 */

		} catch (Exception e) {
			System.out.println("The following error has occurred: ");
			System.out.println(e.getMessage());

		}
	}

}
