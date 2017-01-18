
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Enumeration;
import java.util.ArrayList;

/**
 * This class represents an Closet
 *
 * @author POO teaching staff
 * @version 1.0
 * @since Autumn 2016
 */

public class Closet extends Furniture{

   // The new line separator:
   private final String NL = System.getProperty("line.separator");

   /**
    * This atribute stores the Furniture width
    */
   private double width;
   /**
    * This atribute stores the Furniture height
    */
   private double height;
   /**
    * This atribute stores the Furniture depth
    */
   private double depth;

   /**
    * This atribute stores the list of frontparts
    */
   private ArrayList<FrontPart> frontparts;

   /**
    * Constructor method
    *
    * @param id
    *            the Furniture id
    * @param material
    *            the Furniture material object
    * @param w
    *            the Closet width
    * @param h
    *            the Closet height
    * @param d
    *            the Closet depth
    */
   public Closet(String id, Material material, Color color, double w, double h, double d) {
      super(id,material,color);
	    this.width = w;
      this.height = h;
      this.depth = d;
      this.frontparts = new ArrayList<FrontPart>();
   }

   /**
    * Getter method of atribute width
    * @return atribute width
    */
   public double getWidth() {
      return this.width;
   }

   /**
    * Getter method of atribute height
    * @return atribute height
    */
   public double getHeight() {
      return this.height;
   }

   /**
    * Getter method of atribute depth
    * @return atribute depth
    */
   public double getDepth() {
      return this.depth;
   }

   /**
    * Add a FrontPart to this object
    * @param f FrontPart object
    */
   public void add(FrontPart f) {
     this.frontparts.add(f);
   }

   /**
    * This method generates and returns the information of
    * every element in the front parts list of the closet, in
    * the order they were introduced.
    */
   public String listOfFrontParts() {
      StringBuilder sb = new StringBuilder();
      for (Iterator<FrontPart> it = this.frontparts.iterator(); it.hasNext();) {
         FrontPart f = (FrontPart) it.next();
         sb.append(f.toString() + NL);
      }
      return sb.toString();
   }

   /**
    * This method calculates and returns the price of the
    * Furniture.
    *
    * The price of the Furniture is calculated as:
    *   (sum of its areas) x (price per cm2 of the material) x (price factor of the color)
    *
    * @return price of the Furniture
    */
   public double price() {
      double area = this.height*this.depth*2 + this.width*this.height;
      return (area * this.getMaterial().getPricePerCm2() * this.getColor().getPriceFactor()) + this.frontPartsPrice();
   }

   /**
    * This method generates and returns an String with
    * the information of the Furniture object.
    *
    * Note that this method has to access to the Material
    * and Color atributes of the class to get some information,
    * and that this method also gets price from front parts, if any,
    * to add to final price.
    */
   public String toString() {
      DecimalFormat myFormat1 = new DecimalFormat("#0.000");
      DecimalFormat myFormat2 = new DecimalFormat("#,##0.00");
      StringBuilder sb = new StringBuilder();
      sb.append(super.toString());
      sb.append("Furniture description: " + NL);
      sb.append("  Closet made on " + this.getMaterial().getName() + " with color " + this.getColor().getName()+ NL);
      sb.append("  Material price: " + myFormat1.format(this.getMaterial().getPricePerCm2()) + " euros per cm2" + NL);
      sb.append("  Width: " + myFormat2.format(this.width) + " cm" + NL);
      sb.append("  Height: " + myFormat2.format(this.height) + " cm" + NL);
      sb.append("  Depth: " + myFormat2.format(this.depth) + " cm" + NL);
      sb.append("  Color price factor: " + myFormat1.format(this.getColor().getPriceFactor()) + " euros" + NL);
      String doors = this.listOfFrontParts();
      if (!doors.equals("")) {
        sb.append(" Body price: " + myFormat2.format(this.price() - this.frontPartsPrice()) + " euros" + NL);
        sb.append(" Front parts: " + NL);
        sb.append(doors);
      }
      sb.append("Furniture price: " + myFormat2.format(this.price()) + " euros" + NL);
	    return sb.toString();
   }

   /**
    * Get the price from the FrontParts of this Closet
    */
   private double frontPartsPrice() {
     double fPrice = 0.0;
     for (Iterator<FrontPart> it = this.frontparts.iterator(); it.hasNext();) {
        FrontPart f = (FrontPart) it.next();
        fPrice += f.price();
     }
     return fPrice;
   }
}
