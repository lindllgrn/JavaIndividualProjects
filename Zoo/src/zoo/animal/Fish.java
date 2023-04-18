package zoo.animal;

/**
 * The Fish class that extends the Animal class
 * 
 * @author winniedehpoe
 * 
 * @author lindllgrn
 * @since 2023.04.07
 * @version 1.0 beta
 * 
 * GitHub URL: https://github.com/lindllgrn/JavaIndividualProjects/tree/main/Zoo
 */

public abstract class Fish extends Animal{
	
	/**
	 * the type of animal
	 */
	protected final String type = "fish";
	
	/**
	 * the type of water
	 */
	protected Water water;
	
	/**
	 * sets Fish to default values
	 */
	public Fish() {
		super();
		this.water = Water.UNKNOWN;
	}

	/**
	 * gets the birthdate and weight of the Fish
	 * 
	 * @param <T> for many data types
	 * @param birthdate the birthdate of the Fish
	 * @param weight the weight of the Fish
	 * @throws Exception for the method
	 */
	public <T> Fish(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}
	
	/**
	 * gets the birthdate, weight and water type of the Fish
	 * 
	 * @param <T> for many data types
	 * @param birthdate the birthdate of the Fish
	 * @param weight the weight of the Fish
	 * @param water the water type of the Fish
	 * @throws Exception for the method
	 */
	public <T> Fish(T birthdate, float weight, T water) throws Exception {
		super(birthdate, weight);
		this.setWater(water);
	}

	/**
	 * gets the water type 
	 * 
	 * @return the water tyoe
	 */
	public Water getWater() {
		return this.water;
	}

	/**
	 * sets the water type, uses a switch for user input for what type of
	 * water the Fish lives in
	 * 
	 * @param <T> for many data types
	 * @param water for the water type
	 * @throws Exception for many things inside the method
	 */
	public <T> void setWater(T water) throws Exception{
		
		if (water instanceof String) {
			
		String s = (String) water;
		
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
	
	/**
	 *overrides the animal type in the Super class to the type in this class
	 */
	@Override
	public String toString() {
	
		return this.id + " " + this.type;
	}
}
