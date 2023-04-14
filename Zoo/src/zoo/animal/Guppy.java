package zoo.animal;

public class Guppy extends Fish implements Swimming {

	protected final String type = "guppy";
	
	public Guppy() {
		super();
	}

	public <T> Guppy(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}
	
	public <T> Guppy(T birthdate, float weight, T water) throws Exception {
		super(birthdate, weight);
		this.setWater(water);
	}

	@Override
	public String toString() {
	
		return this.id + " " + this.type;
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
