
/**
 * This class defines the exception causes expected
 * 
 * @author POO teaching staff
 * @version 1.0
 * @since Autumm 2016
 */

public class FactoryException extends Exception {

   /** Defined errors */

   public static final String INCORRECT_MATERIAL = "Incorrect Material: negative value of Price/cm2. It has not been added. ";

   public static final String REPEATED_COLOR = "Repeated Color. It has not been added.";

   public static final String ORDER_NOT_FOUND = "Order not found. Impossible to remove.";

   /**
    * Constructor method
    */
   public FactoryException (String errorMessage) {
      super (errorMessage);
   } 

}
