/**
 * This class represents a generic furniture
 *
 * @author POO teaching staff
 * @version 1.0
 * @since Fall 2016
 * @modified David Doblas Jiménez
 */

public abstract class Furniture{

   /**
    * The new line separator
    */
   private String NL = System.getProperty("line.separator");

   /**
    * This attribute stores the product identification code
    */
   private String id;

   /**
    * This attribute stores the product material object
    */
   private Material material;
   private Color color;

   /**
    * CONSTRUCTOR
    *
    * @param id
    *            the Furniture id
    * @param material
    *            the Furniture material object
    * @param color
    *            the Furniture color object
    */
   public Furniture(String id, Material material, Color color) {
		 this.id = id;
     this.material = material;
     this.color = color;
   }

   /**
    * Getter method of attribute id
    * @return attribute id
    */
   public String getId() {
     return this.id;
   }

   /**
    * Getter method of attribute material
    * @return attribute material
    */
   public Material getMaterial() {
     return this.material;
   }

   /**
    * Getter method of attribute color
    * @return attribute color
    */
   public Color getColor() {
     return this.color;
   }

   /**
    * Abstract method price (developed in every subclass)
    */
   abstract double price();

   /**
    * This method generates and returns an String with
    * the product identification code.
    */
   public String toString() {
     return "Furniture id: " + this.id + NL;
   }
}
