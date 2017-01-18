
/**
 * This class represents a front part of a furniture
 *
 * @author POO teaching staff
 * @version 1.0
 * @since Autumn 2016
 */

public abstract class FrontPart {

   /**
    * The new line separator
    */
   private String NL = System.getProperty("line.separator");

   /**
    * This atribute stores the product identification code
    */
   private String id;

   /**
    * This atribute stores the product material object
    */
   private Material material;
   private Color color;

   /**
    * Constructor method
    *
    * @param id
    *            the FrontPart id
    * @param material
    *            the FrontPart material object
    * @param color
    *            the FrontPart color object
    */
   public FrontPart(String id, Material material, Color color) {
     this.id = id;
     this.material = material;
     this.color = color;
   }

   /**
    * Getter method of atribute id
    * @return atribute id
    */
   public String getId() {
      return this.id;
   }

   /**
    * Getter method of atribute material
    * @return atribute material
    */
   public Material getMaterial() {
      return this.material;
   }

   /**
    * Getter method of atribute color
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
    * This method generates and returns an String with
    * the product identification code.
    */
   public String toString() {
      return "  FrontPart id: " + this.id + NL;
   }

}
