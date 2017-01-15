
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DPOO
 * @modified David Doblas Jiménez
 */
public class Main {

	public static void main(String[] args) throws ParseException {

		//Creation of teams
		Team t1 = new Team("team 1", "Barcelona");
		Team t2 = new Team("team 2", "Barcelona");

		//Creation of players
		Player p1_1= new Player("Joan Pere",new Integer("23"),t1,new Integer("18"));
		Player p2_1= new Player("Joan Manel",new Integer("21"),t1,new Integer("19"));
		Player p3_1= new Player("Joan Flix",new Integer("22"),t1,new Integer("20"));
		Player p4_1= new Player("Joan Petit",new Integer("23"),t1,new Integer("2"));

		Player p1_2= new Player("Manel Pere",new Integer("19"),t2,new Integer("18"));
		Player p2_2= new Player("Manel Manel",new Integer("18"),t2,new Integer("19"));
		Player p3_2= new Player("Manel Flix",new Integer("17"),t2,new Integer("20"));
		//The following object has a typo (t1 instead of t2)
		//Player p4_2= new Player("Manel Petit",new Integer("23"),t1,new Integer("2"));
		//Corrected
		Player p4_2= new Player("Manel Petit",new Integer("23"),t2,new Integer("2"));

		// Add players to the teams
		t1.addPlayer(p1_1);
		t1.addPlayer(p2_1);
		t1.addPlayer(p3_1);
		t1.addPlayer(p4_1);

		//Is this action allowed or not?
		//t1.addPlayer(p1_2);

		//ANSWER: According to our definition in the team class, no.
		//Each team has a maximum of 4 players

		t2.addPlayer(p1_2);
		t2.addPlayer(p2_2);
		t2.addPlayer(p3_2);
		t2.addPlayer(p4_2);

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		//Creation of match 1
		String dateInString = "11-08-2016";
		Date date = sdf.parse(dateInString);
		Match m1 =new Match(t1,t2,date);
		Score s1= new Score(p1_1,m1,date);
		Score s2= new Score(p1_1,m1,date);
		Score s3= new Score(p1_2,m1,date);

		//Creation of match 2
		String dateInString2 = "14-08-2016";
		Date date2 = sdf.parse(dateInString2);
		Match m2 =new Match(t2,t1,date2);
		Score s4= new Score(p3_2,m2,date2);
		Score s5= new Score(p1_1,m2,date2);
		Score s6= new Score(p1_2,m2,date2);

		//relation Player => Score
		p1_1.addScore(s1);
		p1_1.addScore(s2);
		p1_2.addScore(s3);
		p3_2.addScore(s4);
		p1_1.addScore(s5);
		p1_2.addScore(s6);

		//relation Match => Score
		m1.addScore(s1);
		m1.addScore(s2);
		m1.addScore(s3);
		m2.addScore(s4);
		m2.addScore(s5);
		m2.addScore(s6);

		//Results
		System.out.println("result match 1 team 1: " + m1.getScore(t1));
		System.out.println("result match 1 team 2: " + m1.getScore(t2));
		System.out.println("winner match 1: " + m1.getWinner().getName());
		System.out.println("result match: " + m1.getScores());
		System.out.println("result match: " + m2.getScores());
		System.out.println("winner match 2: " + m2.getWinner().getName());
	}
}
