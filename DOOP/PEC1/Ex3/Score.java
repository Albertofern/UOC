import java.util.Date;


/**
 * 
 * @author DPOO
 *
 */
public class Score {

	// Attributes
	private Date when;
	private Player player;
	private Match match;


	/**
	 * Constructor
	 *
	 * @param p player who scores
	 * @param m match in play
	 * @param d day of the match
	 */
	public Score (Player p, Match m, Date d) {
		this.player = p;
		this.match = m;
		this.when = d;
	}

	/**
	 * 
	 */
	public Date getWhen() {
		return when;
	}

	/**
	 * 
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * 
	 */
	public Match getMatch() {
		return match;
	}

}
