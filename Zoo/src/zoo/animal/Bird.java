package zoo.animal;

/**
 * The Bird class that extends Animal
 * 
 * @author winniedehpoe
 * 
 * @author lindllgrn
 * @since 2023.04.07
 * @version 1.0 beta
 * 
 * GitHub URL: https://github.com/lindllgrn/JavaIndividualProjects/tree/main/Zoo
 */

public abstract class Bird extends Animal{
	
	/**
	 * the wingspan of the Bird
	 */
	protected float wingspan;
	
	/**
	 * the type of Animal
	 */
	protected final String type = "bird";
	
	/**
	 * sets the Bird to default values
	 */
	public Bird() {
		super();
		this.wingspan = 0;
	}

	/**
	 * gets the birthdate and weight of the bird
	 * 
	 * @param <T> for many data types
	 * @param birthdate for the birthdate of the Bird
	 * @param weight the weight of the Bird
	 * @throws Exception for the method
	 */
	public <T> Bird(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}
	
	/**
	 * gets the birthdate, weight and wingspan of the bird
	 * 
	 * @param <T> for multiple data types
	 * @param birthdate the birthdate of the bird
	 * @param weight the weight of the bird
	 * @param wingspan the wingspan of the bird
	 * @throws Exception for the methods 
	 */
	public <T> Bird(T birthdate, float weight, float wingspan) throws Exception {
		super(birthdate, weight);
		this.setWingspan(wingspan);
	}

	/**
	 * gets the wingspan
	 * 
	 * @return the wingspan
	 */
	public float getWingspan() {
		return this.wingspan;
	}

	/**
	 * sets the wingspan
	 * 
	 * @param wingspan the wingspan of the Bird
	 * @throws Exception if wingspan is 0 or less
	 */
	public void setWingspan(float wingspan) throws Exception{
		
		if(wingspan > 0) {
			this.wingspan = wingspan;
		}else{
			throw new Exception ("invalid wingspan: " + wingspan);
		}
	}
	
	/**
	 *overrides the type in the Super class to the type in this class
	 */
	@Override
	public String toString() {
	
		return this.id + " " + this.type;
	}
}
