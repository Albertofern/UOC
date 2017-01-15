
import java.util.Date;

/**
 *
 * @author DPOO
 *
 */
public class Match {

	// Attributes
	private Date date;
	private Score scores[];
	private int nscore;
	private Team teams[];

	/**
	 * CONSTRUCTOR
	 *
	 * @param a first team
	 * @param b second team
	 */
	public Match(Team a, Team b,Date d) {
		// Initialize the teams for a match
		teams = new Team[2];
		teams[0] = a;
		teams[1] = b;
		this.date = d;
		// Assuming that there will be only 6 points
		this.scores = new Score[6];

	}

	/**
	 * add a new Score for the match
	 *
	 * @param s new score
	 */
	public void addScore(Score s) {
		scores[nscore] = s;
		nscore++;
	}

	/**
	 *
	 * @return
	 */
	public Team getWinner() {
		if (this.getScore(teams[0]) > this.getScore(teams[1])){
			return teams[0];
		}
		else {
			return teams[1];
		}
	}

	/**
	 *
	 * @return
	 */
	public String getScores() {
		return "Team " + teams[0].getName() + 
				" score: "+this.getScore(teams[0]) + 
				" Team " + teams[1].getName() + 
				" score: "+this.getScore(teams[1]);
	}

	/**
	 *
	 * @param t
	 */
	public Integer getScore(Team t) {
		// Initialize variable to get the result
		int result = 0;
		// Loop through all the players
		for (Player player : t.getPlayers()){
			// Check if the player exists
			if (player != null){
				// Loop through the score of each player
				for (Score score : player.getScores()){
					// Check if the player has scored
					if (score != null){
						// Check when was made the annotation
						if (score.getWhen().equals(date)){
							result++;
						}
					}
				}
			}
		}
		return result;
	}

}
