package zoo.animal;

/**
 * Creates Guppy class, extends the Fish class, implements the Swimming interface
 * 
 * @author winniedehpoe
 * 
 * @author lindllgrn
 * @since 2023.04.07
 * @version 1.0 beta
 * 
 * GitHub URL: https://github.com/lindllgrn/JavaIndividualProjects/tree/main/Zoo
 */

public class Guppy extends Fish implements Swimming {

	/**
	 * the type of fish
	 */
	protected final String type = "guppy";
	
	/**
	 * sets Guppy to default values
	 */
	public Guppy() {
		super();
	}

	/**
	 * gets the weight and the birthdate for Guppy
	 * 
	 * @param <T> for many data types
	 * @param birthdate the birthdate of the Guppy
	 * @param weight the weight of the Guppy
	 * @throws Exception for the code inside
	 */
	public <T> Guppy(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}
	
	/**
	 * gets the birthdate, weight, and water type of Guppy
	 * 
	 * @param <T> for multiple data types
	 * @param birthdate the Guppy's birthdate
	 * @param weight the weight of the Guppy
	 * @param water the water type of the Guppy
	 * @throws Exception for the method 
	 */
	public <T> Guppy(T birthdate, float weight, T water) throws Exception {
		super(birthdate, weight);
		this.setWater(water);
	}

	/**
	 * overrides the final type of animal in the parent class to the type inside this class
	 */
	@Override
	public String toString() {
	
		return this.id + " " + this.type;
	}
	
	/**
	 * overrides the final type of animal in the parent class to the type inside this class and
	 */
	@Override
	public void drift() {
		System.out.println("This " + this.type + " can drift.");
	}

	/**
	 * overrides the final type of animal in the parent class to the type inside this class and
	 * uses a method from the Swimming interface
	 */
	@Override
	public void propel() {
		System.out.println("This " + this.type + " can propel.");		
	}
	
	/**
	 *uses the animal type in this class
	 */
	public void eating() {
		System.out.println("This " + this.type + " is eating.");
	}	
}
