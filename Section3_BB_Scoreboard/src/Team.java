/**
 * Use to keep track of a basketball Team that is made up with multiple Players along with the Team's stats
 * 
 * @author lindllgrn
 * @since 2023.03.28
 * @version 1.0 beta
 */
import java.util.ArrayList;
import java.util.List;

public class Team {

	/**
	 * The Team's name
	 */
	private String name;
	
	/**
	 * Creates an array list of the players created
	 */
	private List<Player> players;

	/**
	 * Sets a Team with default values
	 */
	public Team() {

		this.name = "unknown";
		this.players = new ArrayList<Player>();
	}

	/**
	 * Overload constructor
	 * @param name team's name
	 * @throws Exception invalid input
	 */
	public Team(String name)throws Exception {
		
		this();
		this.setName(name);
	}

	/** 
	 * Gets the Team name
	 * @return team name
	 */
	public String getName() {

		return this.name;
	}

	/**
	 * Set the Team's name
	 * @param name gives this.name the value of String name
	 */
	public void setName(String name) {

		this.name = name;
	}
	
	/**
	 * Add a Player to the Team, by using the overload constructor that allows setting their name and jersey number
	 * Verifies that the jersey number is not already used 
	 * @param name sets the name
	 * @param jersey sets the jersey
	 * @throws Exception for an already used number
	 */
	public void addPlayer(String name, int jersey) throws Exception {

		Player duplicate = this.getPlayer(jersey);
		
		if (duplicate == null) {
			this.players.add(new Player(name, jersey));
		} else {
			String duplicateName = duplicate.getName();
			throw new Exception("Jersey #" + jersey + " already assigned to " + duplicateName + "!");
		}
	}

	/**
	 * Get a Player by their jersey number
	 * @param jersey used to get the Player
	 * @return null if jersey is -1 or the Player's jersey
	 * @throws Exception already used jersey number
	 */
	public Player getPlayer(int jersey) throws Exception{

		int index = this.players.indexOf(new Player (jersey));
		
		if (index == -1) {
			return null;
		} else {
			return this.players.get(index);
		}
	}

	/**
	 * Get the total number of points for the entire Team 
	 * @return total Team points
	 */
	public int getTeamPoints() {

		int teamPoints = 0;
		
		for (int i = 0; i < players.size(); i++) {
			teamPoints += this.players.get(i).getPoints();
		}
		return teamPoints;
	}

	/**
	 * Get the total number of fouls for the entire Team
	 * @return total Team fouls
	 */
	public int getTeamFouls() {

		int teamFouls = 0;
		
		for (int i = 0; i < players.size(); i++) {
			teamFouls += this.players.get(i).getFouls();
		}
		return teamFouls;
	}

	/**
	 * Display the Team's summary stats
	 */
	public void displayTeamStats() {

		System.out.println("Team " + this.name + " Fouls = " + this.getTeamFouls() + " Points = " + this.getTeamPoints());
	}

	/**
	 * Displays each Player's detail stats for the entire Team
	 */
	public void displayDetailStats() {

		System.out.println("Jersey" + " Name" + "           Fouls " + "1pt 2pt 3pt   Total");
		System.out.println("====== =============    ===== === === ===   ====");
		
		for (int i = 0; i < players.size(); i++) {

			String name = players.get(i).getName();
			int jersey = players.get(i).getJersey();
			int fouls = players.get(i).getFouls();
			int fg1 = players.get(i).getFieldGoals_1pt();
			int fg2 = players.get(i).getFieldGoals_2pt();
			int fg3 = players.get(i).getFieldGoals_3pt();

			System.out.printf(" %2d %25s   %2d %2d %2d %2d\n", jersey, name, fouls, fg1, fg2, fg3);
		}
	}

}
