import java.util.ArrayList;
import java.util.List;

public class Team {
	
	private String name;
	private List<Player> players;

	public Team() {

		this.name = "unknown";
		this.players = new ArrayList<Player>();
		
	}
	
	public void addPlayer(String name, int jersey) throws Exception {
		
		Player duplicate = this.getPlayer(jersey);
		if (duplicate == null) {
			this.players.add(new Player(name, jersey));
		}else {
			String duplicateName = duplicate.getName();
			throw new Exception("Jersey #" + jersey + " already assigned to " + duplicateName + "!");
		}
	}
	
	public Player getPlayer(int jersey) {
		
		int index = this.players.indexOf(jersey);
		if (index == -1) {
			return null;
		} else {
			return this.players.get(index);
		}
	}

	public void displayDetailStats() {
		
		for (int i = 0; i < players.size(); i++) {
			
			int jersey = players.get(i).getJersey();
			String name = players.get(i).getName();
					
			System.out.println("#" + jersey + " " + name);
		}
	}
	
}
