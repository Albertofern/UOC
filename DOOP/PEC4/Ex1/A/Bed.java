
import java.text.DecimalFormat;

/**
 * This class represents a bed
 *
 * @author POO teaching staff
 * @version 1.0
 * @since Autumn 2016
 */

public class Bed extends Furniture{

   // The new line separator:
   private final String NL = System.getProperty("line.separator");

   /**
    * This atribute stores the bed X dimension
    */
   private double x;

   /**
    * This atribute stores the bed Y dimension
    */
   private double y;

   /**
    * Constructor method
    *
    * @param id
    *            the Furniture id
    * @param material
    *            the Furniture material object
    * @param color
    *            the Furniture color object
    * @param x
    *            the bed x dimension
    * @param y
    *            the bed y dimension
    */
   public Bed(String id, Material material, Color color, double x, double y) {
      super(id,material,color);
      this.x = x;
      this.y = y;
   }

   /**
    * Getter method of atribute x
    * @return atribute x
    */
   public double getX() {
      return this.x;
   }

   /**
    * Getter method of atribute y
    * @return atribute y
    */
   public double getY() {
      return this.y;
   }

   /**
    * This method calculates and returns the price of the
    * Bed.
    *
    * The price of the Bed is calculated as:
    *   (its Area) x (price per cm2 of the material) x (price factor of the color)
    *
    * @return price of the cylinder
    */
   public double price() {
      double area = this.x * this.y;
      return (area * this.getMaterial().getPricePerCm2() * this.getColor().getPriceFactor());
   }

   /**
    * This method generates and returns an String with
    * the information of the Bed object.
    *
    * Note that this method has to access to the Material
    * and Color atributes of the class to get some information.
    */
   public String toString() {
      DecimalFormat myFormat1 = new DecimalFormat("#0.000");
      DecimalFormat myFormat2 = new DecimalFormat("#,##0.00");
      StringBuilder sb = new StringBuilder();
      sb.append(super.toString());
      sb.append("Furniture description: " + NL);
      sb.append("  Bed made on " + this.getMaterial().getName() + " with color " + this.getColor().getName()+ NL);
      sb.append("  Material price: " + myFormat1.format(this.getMaterial().getPricePerCm2()) + " euros per cm2" + NL);
      sb.append("  X: " + myFormat2.format(this.x) + " cm" + NL);
      sb.append("  Y: " + myFormat2.format(this.y) + " cm" + NL);
      sb.append("  Color price factor: " + myFormat1.format(this.getColor().getPriceFactor()) + " euros" + NL);
      sb.append("Furniture price: " + myFormat2.format(this.price()) + " euros" + NL);
	    return sb.toString();
   }
}
