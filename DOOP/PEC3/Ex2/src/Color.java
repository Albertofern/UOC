import java.text.DecimalFormat;

/**
 * This class represents a color
 *
 * @author POO teaching staff
 * @version 1.0
 * @since Fall 2016
 * @modified David Doblas Jiménez
 */

public class Color{

   /**
    * The new line separator
    */
   private final String NL = System.getProperty("line.separator");

   /**
    * This attribute stores the material name
    */
   private String name;

   /**
    * This attribute stores the price factor of this color
    */
   private Double priceFactor;

   /**
    * CONSTRUCTOR
    *
    * @param name
    *                 the Color name
    * @param priceFactor
    *                 the Color price per cm2
    */
   public Color(String name, Double priceFactor) {
      this.name = name;
      this.priceFactor = priceFactor;
   }

   /**
    * Getter method of attribute name
    * @return attribute name
    */
   public String getName() {
      return this.name;
   }

   /**
    * Getter method of attribute priceFactor
    * @return attribute priceFactor
    */
   public double getPriceFactor() {
      return this.priceFactor;
   }

   /**
    * This method generates and returns an String with the information of the Color object.
    */
   public String toString() {
	   DecimalFormat myFormat = new DecimalFormat("#0.000");
	   StringBuilder sb = new StringBuilder();
	   sb.append("Name: " + this.name + "\t");
	   sb.append("Price factor: " + myFormat.format(this.getPriceFactor()));
	   return sb.toString();
   }
}
