
public class Player {

	private String name;
	
	private int jersey;
	
	private int fouls;
	
	private int fieldGoals_1pt;
	
	private int fieldGoals_2pt;
	
	private int fieldGoals_3pt;
	
	public Player() {
		this.name = "unknown";
		this.jersey = 0;
		this.fouls = 0;
		this.fieldGoals_1pt = 0;
		this.fieldGoals_2pt = 0;
		this.fieldGoals_3pt = 0;
	}
	
	public Player(int jersey) throws Exception{
		this();
		this.setJersey(jersey);
	}
	
	public void setJersey(int jersey) throws Exception{
		if (jersey >= 1 && jersey <= 99)
			this.jersey = jersey;
		else 
			throw new Exception("Invalid jersey number #" + jersey + "!");
	}
	
	public Player(String name, int jersey) throws Exception{
		this();
		this.setName(name);
		this.setJersey(jersey);
	}
			
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getJersey() {
		return this.jersey;
	}
	
	public int getFouls() {
		return this.fouls;
	}
	
	public int getFieldGoals_1pt() {
		return this.fieldGoals_1pt;
	}
	
	public int getFieldGoals_2pt() {
		return this.fieldGoals_2pt;
	}

	public int getFieldGoals_3pt() {
		return this.fieldGoals_3pt;
	}
	
	public void foul() {
		this.fouls++;
	}
	
	public void shot(int shotType) throws Exception {
		//increment the appropriate field goal type, using a switch
		//that also handles invalid data
		switch (shotType) {
		case 0:
			break;
		case 1:
			fieldGoals_1pt++;
		case 2:
			fieldGoals_2pt++;
		case 3:
			fieldGoals_3pt++;
		default: System.out.println("Invalid choice");
		}
	}
	
	public int getPoints() {
		//get the players total points by calculating it by field goal types
		return this.fieldGoals_1pt + (this.fieldGoals_2pt * 2) + (this.fieldGoals_3pt * 3);
		
	}
	
	public void displayStats() {
		//display the player's jersey number, name, 
		//# of fouls, and # of pints via getPoints method
		System.out.println(getJersey() + " " + getName() + " " + getFouls() + " " + getPoints());
	}
	public boolean equals(Object object) {
		if(!(object instanceof Player))
			return false;
		
		Player other = (Player)object;
		
		if (this.jersey == other.getJersey())
			return true;
		else
			return false;
	}
	
	
}

