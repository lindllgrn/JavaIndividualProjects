package zoo.animal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class Animal {

	private static int counter = 0;
	
	protected static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.US);

	protected final int id;
	
	protected final String type = "Animal";
	
	/**
	 * https://www.baeldung.com/java-creating-localdate-with-values
	 * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
	 */	
	private LocalDate birthdate;
	
	private float weight;
	 
	protected Gender gender;
	
	public Animal() {
		this.id = ++Animal.counter;
		this.birthdate = null;
		this.weight = 0;
	}
	
	public <T> Animal(T birthdate, float weight) throws Exception {
		this();
		this.setBirthdate(birthdate);
		this.setWeight(weight);
	}

	public int getId() {
		return this.id;
	}
	
	public LocalDate getBirthdate() {
		return this.birthdate;
	}
	
	public Gender getGender() {
		return this.gender;
	}
	
	public String getBirthdateStr() {
		if (this.birthdate == null)
			return "unknown";
		else
			return Animal.FORMAT.format(this.birthdate);
	}
	
	public String getType() {
		return this.getType();
	}
	
	public float getWeight() {
		return this.weight;
	}
	
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
	
	public void setWeight(float weight) throws Exception {
		
		if (weight > 0)
			this.weight = weight;
		else
			throw new Exception("Invalid weight: " + weight);
	}
	
	@Override
	public String toString() {
	
		return this.id + " " + this.type;
	}
	
	public abstract void eating();
	
}