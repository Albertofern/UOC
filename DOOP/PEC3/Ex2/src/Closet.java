import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Enumeration;
import java.util.ArrayList;

/**
 * This class represents a Closet
 *
 * @author POO teaching staff
 * @version 1.0
 * @since Autumn 2016
 * @modified David Doblas Jiménez
 */

public class Closet extends Furniture{

   // The new line separator:
   private final String NL = System.getProperty("line.separator");

   /**
    * This attribute stores the Furniture width
    */
   private double width;
   /**
    * This attribute stores the Furniture height
    */
   private double height;
   /**
    * This attribute stores the Furniture depth
    */
   private double depth;

   /**
    * This attribute stores the list of frontparts
    */
   private ArrayList<FrontPart> frontparts;

   /**
    * CONSTRUCTOR
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
	   super(id, material, color);
	   this.width = w;
	   this.height = h;
	   this.depth = d;
	   this.frontparts = new ArrayList<FrontPart>();
   }

   /**
    * Getter method of attribute width
    * @return attribute width
    */
   public double getWidth() {
		 return this.width;
   }

   /**
    * Getter method of attribute height
    * @return attribute height
    */
   public double getHeight() {
     return this.height;
   }

   /**
    * Getter method of attribute depth
    * @return attribute depth
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
    * This method generates and returns the information of every element in the front parts list of the closet, in
    * the order they were introduced.
    */
   public String listOfFrontParts() {
	   StringBuilder sb = new StringBuilder();
	   for (Iterator<FrontPart> it = frontparts.iterator(); it.hasNext();) {
		   FrontPart f = (FrontPart) it.next();
	       sb.append(f.toString());
	    }
	   return sb.toString();
   }

   /**
    * This method calculates and returns the price of the Furniture as:
    *   (sum of its areas) x (price per cm2 of the material) x (price factor of the color)
    *
    * @return price of the Furniture
    */
   public double price() {
	   double area;
	   area = this.height * this.depth * 2 + this.width * this.height;
	   return ((area * this.getMaterial().getPricePerCm2() * this.getColor().getPriceFactor()) + this.frontPartsPrice());
   }

   /**
    * This method generates and returns an String with the information of the Furniture object.
    *
    * Note that this method has to access to the Material and Color attributes of the class to get some information.
    * It also gets the price to front parts, if any, to add to final price.
    */
   public String toString() {
	   DecimalFormat myFormat1 = new DecimalFormat("#0.000");
	   DecimalFormat myFormat2 = new DecimalFormat("#,##0.00");
	   StringBuilder sb = new StringBuilder();
	   sb.append(super.toString());
	   sb.append("Furniture description: " + NL);
	   sb.append("  Closet made on " + this.getMaterial().getName() + " with color " + this.getColor().getName() + NL);
	   sb.append("  Material price: " + myFormat1.format(this.getMaterial().getPricePerCm2()) + " euros per cm2" + NL);
	   sb.append("  Width: " + myFormat2.format(this.width) + " cm" + NL);
	   sb.append("  Height: " + myFormat2.format(this.height) + " cm" + NL);
	   sb.append("  Depth: " + myFormat2.format(this.depth) + " cm" + NL);
	   sb.append("  Color price factor: " + myFormat1.format(this.getColor().getPriceFactor()) + " euros" + NL);
	   sb.append("Body price: " + myFormat2.format(this.price()) + " euros" + NL);
	   sb.append("Front parts: " + NL + this.listOfFrontParts());
	   sb.append("Furniture price: " + myFormat2.format(this.price()) + NL);
	   return sb.toString();
   }

   /**
    * Get the price from the FrontParts of this Closet
    */
   private double frontPartsPrice() {
	   double total = 0.0;
	   for (Iterator<FrontPart> it = frontparts.iterator(); it.hasNext();){
		   FrontPart f = (FrontPart) it.next();
		   total += f.price();
	    }
	   return total;
   }
}
