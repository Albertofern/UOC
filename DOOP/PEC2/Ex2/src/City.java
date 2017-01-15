/**
 * @author David_Doblas_Jiménez
 *
 */
public class City {

	/** The city. */
	private String name;


	/**
	 * Instantiates a new city.
	 *
	 * @param name the name of the city 
	 */
	public City(String name) {
		this.name=name;
	}

	/**
	 * 
	 * @return name of the city
	 */
	public String getName() {
		return this.name;
	}	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "City [name=" + name + "]";
	}
}
