package zoo.animal;

public class Sparrow extends Bird implements Flying {

	protected final String type = "sparrow";
	
	public Sparrow() {
		super();
	}

	public <T> Sparrow(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}
	
	public <T> Sparrow(T birthdate, float weight, float wingspan) throws Exception {
		super(birthdate, weight, wingspan);
	}

	@Override
	public String toString() {
	
		return this.id + " " + this.type;
	}

	@Override
	public void fly() {
		System.out.println("This " + this.type + "is gliding.");
	}

	@Override
	public void soar() {
		System.out.println("This " + this.type + "is soaring.");		
	}
	
	public void eating() {
		System.out.println("This " + this.type + "is eating");
	}
	
}