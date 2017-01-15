/**
 * 
 * @author DPOO
 *
 */
public class Person {

	// Attributes
	private String name;
	private Integer age;

	/**
	 * Constructor
	 * @param name name of the person
	 * @param age age of the person
	 */
	public Person (String name,Integer age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * 
	 * @return
	 */
	public String getName () {
		return name;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getAge () {
		return age;
	}

}
