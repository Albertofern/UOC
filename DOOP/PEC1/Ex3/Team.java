
/**
 *
 * @author DPOO
 *
 */
public class Team {

	// Attributes
	private String name;
	private String city;
	private int since;
	private Player players[];
	private int nplayers;
	private Match matches[];
	private int nmatches;

	/**
	 * Constructor
	 *
	 * @param p player who scores
	 * @param m match in play
	 */
	public Team(String name, String city) {
		this.name = name;
		this.city = city;
		// Each team has 4 players
		players = new Player [4];
	}

	/**
	 *
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 *
	 * @return
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
