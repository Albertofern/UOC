
/**
 *
 * @author DPOO
 * @modified David Doblas Jiménez
 *
 */
public class Player extends Person {

	// Attributes
	private Integer number;
	private Score scores[];
	private int nscores;
	private Team myTeam; // no role specified in UML

	/**
	 * CONSTRUCTOR
	 *
	 * @param name name of the player
	 * @param age age of the player
	 * @param t team of the player
	 * @param number number of the player
	 */
	public Player(String name, Integer age, Team t, Integer number) {
		// To get the name and age from the parent class
		super(name,age);
		this.myTeam = t;
		this.number = number;
		this.nscores = 0;
		// Assuming that there will be only 10 points
		this.scores = new Score[10]; 
	}

	/**
	 *
	 * @return the score of a player
	 */
	public Score[] getScores() {
		return scores;
	}

	/**
	 * add a new Score for the match
	 *
	 * @param s new score
	 */
	public void addScore(Score s) {
		this.scores[nscores] = s;
		nscores++;
	}

	/**
	 *
	 * @return the number of a player
	 */
	public Integer getNumber() {
		return number;
	}

}
