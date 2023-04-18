package zoo.animal;

/**
 * The Sparrow class, extends the Bird class and implements the Flying interface
 * 
 * @author winniedehpoe
 * 
 * @author lindllgrn
 * @since 2023.04.07
 * @version 1.0 beta
 * 
 * GitHub URL: https://github.com/lindllgrn/JavaIndividualProjects/tree/main/Zoo
 */

public class Sparrow extends Bird implements Flying {

	/**
	 *  the type of the animal
	 */
	protected final String type = "sparrow";
	
	/**
	 * creates Sparrow with default values
	 */
	public Sparrow() {
		super();
	}

	/**
	 * gets the birthdate and weight of Sparrow
	 * 
	 * @param <T> for many types of data
	 * @param birthdate for the Sparrow birthdate
	 * @param weight for the Sparrow weight
	 * @throws Exception for the method inside
	 */
	public <T> Sparrow(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}
	
	/**
	 * gets the birthdate, weight and wingspan of Sparrow
	 * 
	 * @param <T> for many data types
	 * @param birthdate of the Sparrow
	 * @param weight for the Sparrow
	 * @param wingspan in cm for the Sparrow
	 * @throws Exception for the method inside
	 */
	public <T> Sparrow(T birthdate, float weight, float wingspan) throws Exception {
		super(birthdate, weight, wingspan);
	}

	/**
	 * overrides the animal type in the parent class to the type in this class
	 */
	@Override
	public String toString() {
	
		return this.id + " " + this.type;
	}

	/**
	 *overrides the animal type in the parent class to the type in this class and
	 *uses a method from the Flying interface
	 *
	 */
	@Override
	public void fly() {
		System.out.println("This " + this.type + " can glide.");
	}

	/**
	 * overrides the animal type in the parent class to the type in this class and
	 * uses a method from the Flying interface
	 */
	@Override
	public void soar() {
		System.out.println("This " + this.type + " can soar.");		
	}
	
	/**
	 * uses the animal type in this class
	 */
	public void eating() {
		System.out.println("This " + this.type + " is eating.");
	}
	
}