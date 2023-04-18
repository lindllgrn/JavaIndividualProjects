package zoo.animal;

/**
 * The Chicken class that extends the Bird class
 * 
 * @author winniedehpoe
 * 
 * @author lindllgrn
 * @since 2023.04.07
 * @version 1.0 beta
 * 
 * GitHub URL: https://github.com/lindllgrn/JavaIndividualProjects/tree/main/Zoo
 */

public class Chicken extends Bird{

	/**
	 * the type of bird
	 */
	protected final String type = "chicken";
	
	/**
	 * sets the Chicken to default values
	 */
	public Chicken() {
		super();
		this.wingspan = 0;
	}

	/**
	 * 
	 * gets the birthdate and weight of the Chicken
	 * 
	 * @param <T> for many data types
	 * @param birthdate birthdate of the chicken
	 * @param weight weight of the chicken
	 * @throws Exception for the method
	 */
	public <T> Chicken(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}
	
	/**
	 * gets the birthdate, weight and wingspan of the Chicken
	 * 
	 * @param <T>for many data types
	 * @param birthdate birthdate of the Chicken
	 * @param weight weight of the Chicken
	 * @param wingspan wingspan of the Chicken's wings
	 * @throws Exception for the method
	 */
	public <T> Chicken(T birthdate, float weight, float wingspan) throws Exception {
		super(birthdate, weight, wingspan);
	}

	/**
	 *overrides the animal type of the Super class to the type in this class
	 */
	@Override
	public String toString() {
		return this.id + " " + this.type;
	}
	
	/**
	 *a method for eating
	 */
	public void eating() {
		System.out.println("This " + this.type + " is eating.");
	}
}
