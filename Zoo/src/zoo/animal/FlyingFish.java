package zoo.animal;

/**
 * The Flying Fish class that extends the Fish class and implements both Flying and Swimming interfaces
 * 
 * @author winniedehpoe
 * 
 * @author lindllgrn
 * @since 2023.04.07
 * @version 1.0 beta
 * 
 * GitHub URL: https://github.com/lindllgrn/JavaIndividualProjects/tree/main/Zoo
 */

public class FlyingFish extends Fish implements Flying, Swimming{

	/**
	 * the type of fish
	 */
	protected final String type = "flying fish";
	
	/**
	 * sets the FlyingFish to default values
	 */
	public FlyingFish() {
		super();
	}

	/**
	 * gets the birthdate and weight of the FlyingFish
	 * 
	 * @param <T>for many data types
	 * @param birthdate the birthdate of the FlyingFish
	 * @param weight the weight of the FlyingFish
	 * @throws Exception for the method
	 */
	public <T> FlyingFish(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}
	
	/**
	 * gets the birthdate, weight and water type of the FlyingFish
	 * 
	 * @param <T> for many datatypes
	 * @param birthdate the birthdate of the FlyingFish
	 * @param weight the weight of the FlyingFish
	 * @param water the water type of the FlyingFish
	 * @throws Exception for the methods
	 */
	public <T> FlyingFish(T birthdate, float weight, T water) throws Exception {
		super(birthdate, weight);
		this.setWater(water);
	}

	/**
	 *overrides the animal type in the Super class to the type in this class
	 */
	@Override
	public String toString() {
	
		return this.id + " " + this.type;
	}
	
	/**
	 * overrides the animal type in the Super class to the type in this class and
	 * is a method from the Flying interface
	 */
	@Override
	public void fly() {
		System.out.println("This " + this.type + " can fly.");
	}

	/**
	 * overrides the animal type in the Super class to the type in this class and
	 * is a method from the Flying interface
	 *
	 */
	@Override
	public void soar() {
		System.out.println("This " + this.type + " can soar.");		
	}
	
	/**	 
	 * overrides the animal type in the Super class to the type in this class and
	 * is a method from the Swimming interface
	 *
	 */
	@Override
	public void drift() {
		System.out.println("This " + this.type + " can drift.");
	}

	/**	 
	 * overrides the animal type in the Super class to the type in this class and
	 * is a method from the Swimming interface
	 *
	 */
	@Override
	public void propel() {
		System.out.println("This " + this.type + " can propel.");		
	}
	
	/**
	 *the method for eating
	 */
	public void eating() {
		System.out.println("This " + this.type + " is eating");
	}
	
}
