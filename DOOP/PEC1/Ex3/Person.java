/**
 * 
 * @author DPOO
 * @modified David Doblas Jiménez
 *
 */
public class Person {

	// Attributes
	private String name;
	private Integer age;

	/**
	 * CONSTRUCTOR
	 *
	 * @param name name of the person
	 * @param age age of the person
	 */
	public Person (String name,Integer age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * 
	 * @return the name
	 */
	public String getName () {
		return name;
	}

	/**
	 * 
	 * @return the age
	 */
	public Integer getAge () {
		return age;
	}

}
