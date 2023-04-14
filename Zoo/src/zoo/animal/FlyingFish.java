package zoo.animal;

public class FlyingFish extends Fish implements Flying, Swimming{

	protected final String type = "flying fish";
	
	public FlyingFish() {
		super();
	}

	public <T> FlyingFish(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}
	
	public <T> FlyingFish(T birthdate, float weight, T water) throws Exception {
		super(birthdate, weight);
		this.setWater(water);
	}

	@Override
	public String toString() {
	
		return this.id + " " + this.type;
	}
	
	@Override
	public void fly() {
		System.out.println("This " + this.type + "is flying.");
	}

	@Override
	public void soar() {
		System.out.println("This " + this.type + "is soaring.");		
	}
	
	@Override
	public void drift() {
		System.out.println("This " + this.type + "is drifting.");
	}

	@Override
	public void propel() {
		System.out.println("This " + this.type + "is propelling.");		
	}
	

	public void eating() {
		System.out.println("This " + this.type + "is eating");
	}
	
}
