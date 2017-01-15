import java.util.Date;

/**
 * 
 * @author DPOO
 * @modified David Doblas Jiménez
 *
 */
public class Score {

	// Attributes
	private Date when;
	private Player player;
	private Match match;


	/**
	 * CONSTRUCTOR
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
	 * @return the date of a score
	 */
	public Date getWhen() {
		return when;
	}

	/**
	 * 
	 * @return the player who made certain score
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * 
	 * @return the match
	 */
	public Match getMatch() {
		return match;
	}
}
