import java.util.ArrayList;
import java.util.List;

public class Team {

	private String name;
	private List<Player> players;

	public Team() {

		this.name = "unknown";
		this.players = new ArrayList<Player>();

	}

	public Team(String name)throws Exception {
		this();
		this.setName(name);
	}

	public String getName() {

		return this.name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public void addPlayer(String name, int jersey) throws Exception {

		Player duplicate = this.getPlayer(jersey);
		if (duplicate == null) {
			this.players.add(new Player(name, jersey));
		} else {
			String duplicateName = duplicate.getName();
			throw new Exception("Jersey #" + jersey + " already assigned to " + duplicateName + "!");
		}
	}

	public Player getPlayer(int jersey) throws Exception{

		int index = this.players.indexOf(new Player (jersey));
		if (index == -1) {
			return null;
		} else {
			return this.players.get(index);
		}
	}

	public int getTeamPoints() {

		int teamPoints = 0;
		
		for (int i = 0; i < players.size(); i++) {
			teamPoints += this.players.get(i).getPoints();
		}
		return teamPoints;
	}

	public int getTeamFouls() {

		int teamFouls = 0;
		
		for (int i = 0; i < players.size(); i++) {
			teamFouls += this.players.get(i).getFouls();
		}
		return teamFouls;
	}

	public void displayTeamStats() {

		System.out.println("Team " + this.name + " Fouls = " + this.getTeamFouls() + " Points = " + this.getTeamPoints());
	}

	public void displayDetailStats() {

		//where the header should be 
		System.out.println("Jersey" + " Name" + "    Fouls " + "1pt 2pt 3pt   Total");
		System.out.println("====== =============    ===== === === ===   ====");
		
		for (int i = 0; i < players.size(); i++) {

			String name = players.get(i).getName();
			int jersey = players.get(i).getJersey();
			int fouls = players.get(i).getFouls();
			int fg1 = players.get(i).getFieldGoals_1pt();
			int fg2 = players.get(i).getFieldGoals_2pt();
			int fg3 = players.get(i).getFieldGoals_3pt();

			//make printf
			System.out.printf(" %2i %13s   %2i %2i %2i %2i\n", jersey, name, fouls, fg1, fg2, fg3);
		}
	}

}
