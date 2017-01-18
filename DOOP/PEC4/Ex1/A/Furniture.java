
/**
 * This class represents a generic furniture
 *
 * @author POO teaching staff
 * @version 1.0
 * @since Autumn 2016
 * @modified David Doblas Jiménez
 */

public abstract class Furniture implements Comparable<Furniture> {

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
    * Constructor method
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
    * @return atribute id
    */
   public String getId() {
      return this.id;
   }

   /**
    * Getter method of attribute material
    * @return atribute material
    */
   public Material getMaterial() {
      return this.material;
   }

   /**
    * Getter method of attribute color
    * @return atribute color
    */
   public Color getColor() {
     return this.color;
   }

   /**
    * Abstract method price (developed in every subclass)
    */
   abstract double price();

   /**
    * This method generates and returns a String with the product identification code.
    */
   public String toString() {
      return "Furniture id: " + this.id + NL;
   }
   
   /**
    * This method will compare furniture objects based on their id
    */
   @Override  
   public int compareTo(Furniture f) {
      return ((this.id).compareTo(f.id));
   }
}
