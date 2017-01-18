import java.util.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
/**
 * This class represents an order
 *
 * @author POO teaching staff
 * @version 1.0
 * @since Autumn 2016
 */

public class Order{

   /**
    * The new line separator
    */
   private String NL = System.getProperty("line.separator");

   /**
    * This atribute stores the order reference code
    */
   private String ref;

   /**
    * This atribute stores the order date
    */
   private Date date;

   /**
    * This atribute stores the number of Furniture units to make
    */
   private int quantity;

   /**
    * This atribute stores the type of Furniture to make
    */
   private Furniture furniture;

   /**
    * Constructor method
    *
    * @param ref
    *            the Order's reference code
    * @param date
    *            the Order's date
    * @param quantity
    *            the number of units of Furniture to make
    * @param Furniture
    *            the type of Furniture to make
    */
   public Order(String ref, Date date, int quantity, Furniture furniture) {
      this.ref = ref;
      this.date = date;
      this.quantity = quantity;
      this.furniture = furniture;
   }

   /**
    * Getter method of atribute ref
    * @return atribute ref
    */
   public String getRef() {
      return this.ref;
   }

   /**
    * Getter method of atribute date
    * @return atribute date
    */
   public Date getDate() {
      return this.date;
   }

   /**
    * Getter method of atribute quantity
    * @return atribute quantity
    */
   public int getQuantity() {
      return this.quantity;
   }

   /**
    * Getter method of atribute Furniture
    * @return atribute Furniture
    */
   public Furniture getFurniture() {
      return this.furniture;
   }

   /**
    * This method calculates and returns the total amount
    * of the order.
    *
    * The total amount is calculated as:
    *   (quantity) x (price of the Furniture)
    *
    * @return total amount of the order
    */
   public double totalAmount() {
      return (this.quantity * this.furniture.price());
   }

   /**
    * This method generates and returns an String with
    * the information of the Order object.
    *
    * Note that this method has to access to the Furniture
    * atribute of the class to get some information.
    *
    */
   public String toString() {
      DecimalFormat myFormat = new DecimalFormat("#,##0.00");
      StringBuilder sb = new StringBuilder();
      sb.append("Order ref: " + this.ref + NL);
      sb.append("Order date: " + DateFormat.getDateInstance().format(this.date) + NL);
      sb.append("Order information:" + NL);
      sb.append("Furniture:" + NL);
      sb.append(this.furniture.toString());
      sb.append("Quantity: " + this.quantity + " units" + NL);
      sb.append("Total amount: " + myFormat.format(this.totalAmount()) + " euros" + NL);
	return sb.toString();
   }

   /**
    * Redefinition of the equals method, to define whether two
    * Order objects are equals.
    *
    * The method has to verify that the paramater object is an
    * instance of class Order.
    *
    * So, two Order objects will be considered equals if, and
    * only if, their reference codes are equals (regardless
    * the values of the rest of atributes).
    */
   public boolean equals (Object obj) {
      if (obj instanceof Order) {
        Order tmpOrder = (Order) obj;
        return this.ref.equals(tmpOrder.getRef());
      }
      else
         return false;
   }

}
