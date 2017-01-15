
import java.util.Date;

/**
 *
 * @author DPOO
 * @modified David Doblas Jiménez
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
		// Initialize teams for a match
		teams = new Team[2];
		teams[0] = a;
		teams[1] = b;
		date = d;
		nscore = 0;
		// Assuming that there will be only 10 points per match
		this.scores = new Score[10];

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
	 * @return the winner of the match
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
	 * @return the scores of each team
	 */
	public String getScores() {
		return "Team " + teams[0].getName() + 
		       " score: "+this.getScore(teams[0]) + 
		       " Team " + teams[1].getName() + 
		       " score: "+this.getScore(teams[1]);
	}

	/**
	 * get the score of a player in a certain match
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
