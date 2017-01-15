/**
 * @author David_Doblas_Jiménez
 *
 */
public class Customer {

	/**
	 * The attributes
	 */	
	private String cip;
	private String name;
	private City city;

	
	
	/**
	 * Instantiates a new customer.
	 * 
	 * @param name the customer's name
	 * @param cip the customer's id
	 * @param city the name of the city
	 */
	public Customer(String name, String cip, City city) {
		this.name = name;
		this.cip = cip;
		this.city=city;
	}
	
	/**
	 * @return name of the customer
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return cip the id of the customer
	 */
	public String getCip() {
		return cip;
	}
	
	/**
	 * @param cip the id to set
	 */
	public void setCip(String cip) {
		this.cip = cip;
	}
	
	/**
	 * @return city a city object
	 */
	public City getCity() {
		return city;
	}
	
	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [name=" + name +
		       ", id=" + cip + 
		       ", city=" + this.getCity().getName() +  "]";
	}
}
