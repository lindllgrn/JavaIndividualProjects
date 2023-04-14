/**
 * A Player on a basketball Team plus the player's stats
 * 
 * @author lindllgrn
 * @since 2023.03.28
 * @version 1.0 beta
 * 
 * GitHub URL: https://github.com/lindllgrn/JavaIndividualProjects/tree/main/Section3_BB_Scoreboard
 */
public class Player {
	
	/** 
	 * The Player's name
	 */
	private String name;
	
	/**
	 * The Player's jersey number
	 */
	private int jersey;
	
	/** 
	 * The Player's number of fouls
	 */
	private int fouls;
	
	/**
	 * The Player's number of 1pt field goals
	 */
	private int fieldGoals_1pt;
	
	/**
	 * The Player's number of 2pt field goals
	 */
	private int fieldGoals_2pt;
	
	/** 
	 * The Player's number of 3pt field goals
	 */
	private int fieldGoals_3pt;
	
	/**
	 * Set the Player's properties to default values
	 */
	public Player() {
		
		this.name = "unknown";
		this.jersey = 0;
		this.fouls = 0;
		this.fieldGoals_1pt = 0;
		this.fieldGoals_2pt = 0;
		this.fieldGoals_3pt = 0;
	}
	
	/**
	 * Allow creating a Player by only setting the jersey number
	 * @param jersey setting the Player's jersey number
	 * @throws Exception for invalid input
	 */
	public Player(int jersey) throws Exception{
		
		this();
		this.setJersey(jersey);
	}
	
	/**
	 * Allow creating a Player plus setting their name and jersey number
	 * @param name sets the Player's name
	 * @param jersey sets the Player's jersey
	 * @throws Exception for invalid input
	 */
	public Player(String name, int jersey) throws Exception{
		
		this();
		this.setName(name);
		this.setJersey(jersey);
	}
	
	/**
	 * Set the Player's jersey number if it's a number between 1 and 99
	 * @param jersey sets the Player's jersey
	 * @throws Exception for invalid input
	 */
	public void setJersey(int jersey) throws Exception{
		
		if (jersey >= 1 && jersey <= 99)
			this.jersey = jersey;
		else 
			throw new Exception("Invalid jersey number #" + jersey + "!");
	}
			
	/**
	 * Get the Player's name
	 * @return the Player's name
	 */
	public String getName() {
		
		return this.name;
	}
	
	/**
	 * Set the Player's name
	 * @param name gives this.name the value of String name
	 */
	public void setName(String name) {
		
		this.name = name;
	}
	
	/**
	 * Get the Player's jersey number
	 * @return jersey number
	 */
	public int getJersey() {
		
		return this.jersey;
	}
	
	/**
	 * Get the Player's number of fouls
	 * @return number of fouls
	 */
	public int getFouls() {
		
		return this.fouls;
	}
	
	/**
	 * Get the Player's number of 1pt field goals made
	 * @return number of 1pt field goals
	 */
	public int getFieldGoals_1pt() {
		
		return this.fieldGoals_1pt;
	}
	
	/**
	 * Get the Player's number of 2pt field goals made
	 * @return number of 2pt field goals
	 */
	public int getFieldGoals_2pt() {
		
		return this.fieldGoals_2pt;
	}

	/**
	 * Get the Player's number of 3pt field goals made
	 * @return number of 3pt field goals
	 */
	public int getFieldGoals_3pt() {
		
		return this.fieldGoals_3pt;
	}
	
	/**
	 * Increment the Player's fouls by 1
	 */
	public void foul() {
		
		this.fouls++;
	}
	
	/**
	 * Increment the appropriate field goal type using a switch
	 * @param shotType type of field goal
	 * @throws Exception for invalid choice
	 */
	public void shot(int shotType) throws Exception {

		switch (shotType) {
		case 1:
			fieldGoals_1pt++;
		case 2:
			fieldGoals_2pt++;
		case 3:
			fieldGoals_3pt++;
		default: throw new Exception ("Invalid choice!");
		}
	}
	
	/**
	 * Get the Player's total points by calculating it by field goal types
	 * @return total points
	 */
	public int getPoints() {
		
		return this.fieldGoals_1pt + (this.fieldGoals_2pt * 2) + (this.fieldGoals_3pt * 3);
		
	}
	
	/**
	 * Display the Player's jersey number, name, number of fouls and number of points
	 */
	public void displayStats() {
		
		System.out.println("Jersey # = " + getJersey() + " Name = " + getName() + " Fouls = " + getFouls() + " Points = " + getPoints());
	}
	
	/**
	 * Instead of verifying two players are identical by equal identities.
	 * Verifies two players are the same by only their jersey number
	 */
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

