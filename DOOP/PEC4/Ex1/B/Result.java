
/**
 * This class represents a result
 *
 * @author David Doblas Jiménez
 * @version 1.0
 * @since Autumn 2016
 */
public class Result extends Student implements IExam{
	
	// The new line separator:
	private final String NL = System.getProperty("line.separator");
	
   /**
    * Constructor
    *
    * @param n the student name
    * @param r the student roll number
    * @param m1 mark of subject 1
    * @param m2 mark of subject 2
    */
	public Result(String n, int r, int m1, int m2){
		/**
		 * get the attributes from the parent class
		 */
		super(n, r, m1, m2);
	}

	/**
	 * Returns info about a student 
	 */
	public void display() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Name of Student: " + this.getName() + NL);
	    sb.append("Roll No. of Student: " + this.getRollNo() + NL);
	    sb.append("Marks of Subject 1: " + this.getMark1() + NL);
	    sb.append("Marks of Subject 2: " + this.getMark2());
	    System.out.println(sb.toString());
	}
	
	
	public void percent_cal() {
		StringBuilder sb = new StringBuilder();
	  sb.append("Percentage: " + (((float)this.getMark1() + this.getMark2()) * 100/200) + "%");
	  System.out.println(sb.toString());
	}
}
