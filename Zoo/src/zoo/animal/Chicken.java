package zoo.animal;

public class Chicken extends Bird{

	protected final String type = "chicken";
	
	public Chicken() {
		super();
		this.wingspan = 0;
	}

	public <T> Chicken(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}
	
	public <T> Chicken(T birthdate, float weight, float wingspan) throws Exception {
		super(birthdate, weight, wingspan);
	}

	@Override
	public String toString() {
		return this.id + " " + this.type;
	}
	
	public void eating() {
		System.out.println("This " + this.type + "is eating");
	}
}
