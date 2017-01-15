
/**
 *
 * @author DPOO
 * @modified David Doblas Jiménez
 *
 */
public class Team {

	// Attributes
	private String name;
	private String city;
	private Player players[];
	private int nplayers;
	private Match matches[];
	private int nmatches;

	/**
	 * CONSTRUCTOR
	 *
	 * @param name of the team
	 * @param city of the team
	 */
	public Team(String name, String city) {
		this.name = name;
		this.city = city;
		nplayers = 0;
		nmatches = 0;
		// Each team has 4 players
		players = new Player [4];
	}

	/**
	 *
	 * @return the name of a team
	 */
	public String getName() {
		return name;
	}

	/**
	 *
	 * @return the players of a team
	 */
	public Player[] getPlayers() {
		return players;
	}

	/**
	 * Adds a new player
	 *
	 * @param p new player
	 */
	public void addPlayer(Player p) {
		players[nplayers] = p;
		nplayers++;
	}

	/**
	 * Adds a new match
	 *
	 * @param m new match
	 */
	public void addMatch(Match m) {
		matches[nmatches] = m;
		nmatches++;
	}
}
