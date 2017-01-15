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
		System.out.println("Cities info -------");
		System.out.println(city1);
		System.out.println(city2);
		Customer c1= new Customer("Mary Poppins","id1",city1);
		Customer c2= new Customer("John Wayne","id2",city2);
		Customer c3= new Customer("Ian Malkovick","id3",city1);
		System.out.println("Customers info -------");
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);		
		Message m1=new Message(c3,c1,"Still waiting. No news");
		Message m2=new Message(c2,c1,"No good news. Fax not received");
		Message m3=new Message(c2,c1,"Still waiting. Suspended trip");
		Message m4=new Message(c1,c2,"Text equal to summary");		
		System.out.println("All about messages -------");
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		System.out.println(m4);		
	}
}
