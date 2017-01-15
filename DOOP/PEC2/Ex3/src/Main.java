/**
 * @author DPOO
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		City city1 = new City("BCN");
		City city2 = new City("NY");		
		Customer c1= new Customer("Mary Poppins","id1",city1);
		Customer c2= new Customer("John Wayne","id2",city2);
		Customer c3= new Customer("Ian Malkovick","id3",city1);		
		Message m1=new Message(c1,c2);
		Message m2=new Message(c2,c1);
		Message m3=new Message(c3,c1,12,"Still waiting. No news about the journey");
		Message m4=new Message(c2,c1,12,"No good news. The fax was not received on time");
		Message m5=new Message(c2,c1,12,"Still waiting. Suspended trip to Xina");
		Message m6=new Message(c1,c2,3,"Text equal to summary");
		Message m7=new Message(c1,c2,8,"Text equal to summary");
		m4.setRead(true);
		m1.setRead(true);
		System.out.println("All about messages -------");
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		System.out.println(m4);
		System.out.println(m5);
		System.out.println(m6);
		System.out.println(m5.equals(m4));
		System.out.println(m1.equals(m6));
		System.out.println(m6.equals(m7));
	}

}
