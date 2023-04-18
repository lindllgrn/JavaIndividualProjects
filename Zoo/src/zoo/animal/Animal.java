package zoo.animal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * The animal class that creates the Animals
 * 
 * @author winniedehpoe
 * 
 * @author lindllgrn
 * @since 2023.04.07
 * @version 1.0 beta
 * 
 * GitHub URL: https://github.com/lindllgrn/JavaIndividualProjects/tree/main/Zoo
 */

public abstract class Animal {

	/**
	 * creates id numbers
	 */
	private static int counter = 0;
	
	/**
	 * creates the format of the dates being use
	 */
	protected static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.US);

	/**
	 * creates id numbers
	 */
	protected final int id;
	
	/**
	 * the type of animal 
	 */
	protected final String type = "Animal";
	
	/**
	 * https://www.baeldung.com/java-creating-localdate-with-values
	 * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
	 * 
	 * makes sure the birthdate is according to the FORMAT
	 */
	private LocalDate birthdate;
	
	/**
	 * the weight of the animal
	 */
	private float weight;
	 
	/**
	 * the gender of the animal
	 */
	protected Gender gender;
	
	/**
	 * creates an animal with default values
	 */
	public Animal() {
		this.id = ++Animal.counter;
		this.birthdate = null;
		this.weight = 0;
	}
	
	/**
	 * gets the birthdate and weight of the animal
	 * 
	 * @param <T> for multiple data types
	 * @param birthdate the birthdate of the Animal
	 * @param weight the weight of the Animal
	 * @throws Exception for the methods inside
	 */
	public <T> Animal(T birthdate, float weight) throws Exception {
		this();
		this.setBirthdate(birthdate);
		this.setWeight(weight);
	}

	/**
	 * gets the Id of the animal
	 * 
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * gets the birthdate
	 * 
	 * @return the birthdate
	 */
	public LocalDate getBirthdate() {
		return this.birthdate;
	}
	
	/**
	 * gets the gender
	 * 
	 * @return the gender
	 */
	public Gender getGender() {
		return this.gender;
	}
	
	/**
	 * gets the birthdate string in the FORMAT
	 * 
	 * @return the birthdate in FORMAT
	 */
	public String getBirthdateStr() {
		if (this.birthdate == null)
			return "unknown";
		else
			return Animal.FORMAT.format(this.birthdate);
	}
	
	/**
	 * gets the type of animal
	 * 
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * gets the weight
	 * 
	 * @return the weight
	 */
	public float getWeight() {
		return this.weight;
	}
	
	/**
	 * gets the gender of the animal, gets the user's input by using a switch
	 * and the gender enums
	 * 
	 * @param <T> for many data types
	 * @param gender the gender of the animal
	 * @throws Exception for an invalid Gender
	 */
	public <T> void setGender(T gender)throws Exception {
		
		if (gender instanceof String) {
			
		String s = (String) gender;
		
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
		}else {
			throw new Exception("invalid gender: " + gender);
		}
	}
	
	/**
	 * sets the birthdate of the Animal, makes sure the string is in the FORMAT
	 * of the date
	 * 
	 * @param <T> for many data types
	 * @param birthdate birthdate of the Animal
	 * @throws Exception for an invalid birthdate
	 */
	public <T> void setBirthdate(T birthdate) throws Exception {


		if (birthdate instanceof String) {
			
			String date = (String) birthdate;
		    this.birthdate = LocalDate.parse(date, Animal.FORMAT);
		    
		} else if (birthdate instanceof LocalDate){
			
			this.birthdate = (LocalDate) birthdate;
			
		} else {
			
			throw new Exception("Invalid date MM-dd-yyyy: " + birthdate);
			
		}
			
	}
	
	/**
	 * sets the weight of the Animal, makes sure that the weight
	 * is greater than 0
	 * 
	 * @param weight the weight of the Animal
	 * @throws Exception to throw an Exception if invalid weight
	 */
	public void setWeight(float weight) throws Exception {
		
		if (weight > 0)
			this.weight = weight;
		else
			throw new Exception("Invalid weight: " + weight);
	}
	
	/**
	 *overrides the type of Animal in the Super class to the type in this class
	 */
	@Override
	public String toString() {
	
		return this.id + " " + this.type;
	}
	
	/**
	 * a method for eating
	 */
	public abstract void eating();
	
}