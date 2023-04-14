package zoo.animal;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

	private String name;

	
	public Zoo() {
		this.name = "Unknown";
		//List<Animal> animals = new ArrayList<Animal>();
	}
		
	public String getName() {
		
		return this.name;
	}
	
	public void setName(String name) {

		this.name = name;
	}
	
	public Zoo(String name)throws Exception {
		
		this();
		this.setName(name);
	}
	
}
