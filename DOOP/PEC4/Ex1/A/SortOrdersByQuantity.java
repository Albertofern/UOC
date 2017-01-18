import java.util.Comparator;

/**
 * Comparator class of Order objects.
 *
 * @author David Doblas Jiménez
 */

public class SortOrdersByQuantity implements Comparator<Order> {
	
	/**
	 * This method compares two objects based on the quantity
	 * @param o1, o2 orders to be compared
	 * @return Returns a <0, 0 or >0 if the first argument is <, =, or > than the second
	 */
	public int compare(Order o1, Order o2) {
		return Integer.compare(o1.getQuantity(),o2.getQuantity());
	}
		
}