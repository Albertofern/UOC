
/**
 * This class represents a student
 *
 * @author David Doblas Jiménez
 * @version 1.0
 * @since Autumn 2016
 */
public class Student {
	
	// The new line separator:
	private final String NL = System.getProperty("line.separator");
	
	private String name;
	private int roll_no;
	private int mark1;
	private int mark2;

   /**
    * Constructor
    *
    * @param n the student name
    * @param r the student roll number
    * @param m1 mark of subject 1
    * @param m2 mark of subject 2
    */
	public Student (String n, int r, int m1, int m2) {
		this.name = n;
		this.roll_no = r;
		this.mark1 = m1;
		this.mark2 = m2;
	}

	/**
	 * GETTERS/SETTERS
	 */
	public String getName () {
		return this.name;
	}
	
	
	public int getRollNo () {
		return this.roll_no;
	}
	
	public int getMark1 () {
		return this.mark1;
	}
	
	public int getMark2 () {
		return this.mark2;
	}
	

	public void setRollNo(int roll_no) {
		this.roll_no = roll_no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMark1(int mark1) {
		this.mark1 = mark1;
	}

	public void setMark2(int mark2) {
		this.mark2 = mark2;
	}
}
