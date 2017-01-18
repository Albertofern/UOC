
import java.text.DecimalFormat;

/**
 * This class represents a material
 *
 * @author POO teaching staff
 * @version 1.0
 * @since Autumn 2016
 */

public class Material{

   /**
    * The new line separator
    */
   private final String NL = System.getProperty("line.separator");

   /**
    * This atribute stores the material name
    */
   private String name;

   /**
    * This atribute stores the price per cm2 of this material
    */
   private Double pricePerCm2;

   /**
    * Constructor method
    *
    * @param name
    *                 the Material's name
    * @param pricePerCm2
    *                 the Material's price per cm2
    */
   public Material(String name, Double pricePerCm2) {
      this.name = name;
      this.pricePerCm2 = pricePerCm2;
   }

   /**
    * Getter method of atribute name
    * @return atribute name
    */
   public String getName() {
      return this.name;
   }

   /**
    * Getter method of atribute pricePerCm2
    * @return atribute pricePerCm2
    */
   public double getPricePerCm2() {
      return this.pricePerCm2;
   }

   /**
    * This method generates and returns an String with
    * the information of the Material object.
    */
   public String toString() {
      DecimalFormat myFormat = new DecimalFormat("#0.000");
      StringBuilder sb = new StringBuilder();
      sb.append("Name: " + this.name + "\t");
      sb.append("Price per cm2: " + myFormat.format(this.pricePerCm2) + " euros" + NL);
      return sb.toString();
   }

}
