
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;

/**
 * Test class of Exercise 2
 *
 * @author POO teaching staff
 * @version 1.0
 * @since Autumn 2016
 */
public class Main2 {

    // The new line separator:
    private static final String NL = System.getProperty("line.separator");

    // Declaring a Factory object:
    Factory myF;

    /**
     * main method.
     *
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {

        // Making the instance of Factory:
        Factory myF = new Factory();

        // ***************************************************
        //   STEP 1 ((Creating and listing Materials)
        // ***************************************************
        // Creating some Material objects and adding them into
        // its corresponding list:
        Material mWood = new Material("Wood", 0.0125);
        myF.add(mWood);
        Material mMelamine = new Material("Melamine", 0.0100);
        myF.add(mMelamine);
        Material mGlass = new Material("Glass", 0.0150);
        myF.add(mGlass);

        // Creating some Color objects and adding them into
        // its corresponding list:
        Color cBlack = new Color("Black", 1.000);
        myF.add(cBlack);
        Color cRed = new Color("Red", 1.100);
        myF.add(cRed);
        Color cWenge = new Color("Wenge", 1.000);
        myF.add(cWenge);
        Color cWhite = new Color("White", 1.200);
        myF.add(cWhite);

        // Printing material's information:
        System.out.println("********************************");
        System.out.println("       OUTPUT OF STEP 1");
        System.out.println("********************************");
        System.out.println("List of materials (in the order they were introduced)");
        System.out.println("-----------------------------------------------------");
        System.out.println(myF.listOfMaterials());
        System.out.println("List of colors (in the order they were introduced)");
        System.out.println("-----------------------------------------------------");
        System.out.println(myF.listOfColors());

        // ***************************************************
        //   STEP 2 (Creating and listing Furniture)
        // ***************************************************
        // Creating some Furniture objects and adding them into
        // its corresponding list:
        Closet fCloset1 = new Closet("C01", mWood, cBlack, 300, 200, 60);
        Door fpDoor1 = new Door("D01", mWood, cBlack, 150, 200);
        fCloset1.add(fpDoor1);
        Door fpDoor2 = new Door("D02", mWood, cBlack, 150, 200);
        fCloset1.add(fpDoor2);
        myF.add(fCloset1);
        Closet fCloset2 = new Closet("C02", mWood, cWenge, 300, 200, 60);
        Door fpDoor3 = new Door("D03", mWood, cWenge, 150, 200);
        fCloset2.add(fpDoor3);
        Door fpDoor4 = new Door("D04", mWood, cWenge, 150, 200);
        fCloset2.add(fpDoor4);
        myF.add(fCloset2);
        Closet fCloset3 = new Closet("C03", mMelamine, cWhite, 300, 200, 60);
        Door fpDoor5 = new Door("D05", mGlass, cBlack, 150, 200);
        fCloset3.add(fpDoor5);
        Door fpDoor6 = new Door("D06", mGlass, cBlack, 150, 200);
        fCloset3.add(fpDoor6);
        myF.add(fCloset3);
        Closet fCloset4 = new Closet("C04", mMelamine, cRed, 300, 200, 60);
        Door fpDoor7 = new Door("D07", mGlass, cRed, 100, 200);
        fCloset4.add(fpDoor7);
        Door fpDoor8 = new Door("D08", mGlass, cRed, 100, 200);
        fCloset4.add(fpDoor8);
        Door fpDoor9 = new Door("D09", mGlass, cRed, 100, 200);
        fCloset4.add(fpDoor9);
        myF.add(fCloset4);
        Bed fBed = new Bed("B01", mWood, cWenge, 150, 200);
        myF.add(fBed);
        Bed pBed2 = new Bed("B02", mWood, cWhite, 135, 200);
        myF.add(pBed2);

        // Printing furniture information:
        System.out.println("********************************");
        System.out.println("       OUTPUT OF STEP 2");
        System.out.println("********************************");
        System.out.println("List of furniture (in the order they were introduced)");
        System.out.println("-----------------------------------------------------");
        System.out.println(myF.listOfFurniture());

        // Printing product's information:
         System.out.println("List of products (ordered by id)");
        System.out.println("--------------------------------");
        System.out.println(myF.sortedListOfFurniture());

        // ***************************************************
        //   STEP 3 (Creating and listing Orders)
        // ***************************************************
        SimpleDateFormat d = new SimpleDateFormat("dd-MM-yy");

        // Creating some Order objects and adding them into
        // its corresponding list:
        myF.add(new Order("O001", d.parse("15-10-2016"), 5, fCloset1));
        myF.add(new Order("O002", d.parse("15-10-2016"), 10, fCloset2));
        myF.add(new Order("O003", d.parse("16-10-2016"), 3, fCloset3));
        myF.add(new Order("O004", d.parse("16-10-2016"), 2, fCloset4));
        myF.add(new Order("O005", d.parse("17-10-2016"), 10, fBed));
        myF.add(new Order("O006", d.parse("17-10-2016"), 5, pBed2));

        // Printing order's information:
        System.out.println("********************************");
        System.out.println("       OUTPUT OF STEP 3");
        System.out.println("********************************");
        System.out.println("List of orders (in the order they were introduced)");
        System.out.println("--------------------------------------------------");
        System.out.println(myF.listOfOrders());
        System.out.println("List of orders (sorted by date)");
        System.out.println("-------------------------------");
        System.out.println(myF.listOrdersSortedByDate());
        System.out.println("List of orders (sorted by quantity)");
        System.out.println("-------------------------------");
        System.out.println(myF.listOrdersSortedByQuantity());

        // ***************************************************
        //   STEP 4 (List of furniture within a price range)
        // ***************************************************
        System.out.println("********************************");
        System.out.println("       OUTPUT OF STEP 4");
        System.out.println("********************************");
        // Printing product's information (in a range of prices):
        System.out.println("List of furniture within a price range (in order of introduction)");
        System.out.println("-----------------------------------------------------------------");
        double min = 1500.0;  // minimum price
        double max = 1900.0; // maximum price
        DecimalFormat myFormat = new DecimalFormat("#,##0.00");
        System.out.println("Minimum price: " + myFormat.format(min) + " euros");
        System.out.println("Maximum price: " + myFormat.format(max) + " euros" + NL);
        System.out.println(myF.listFurnitureInPriceRange(min, max));

        // ***************************************************
        //   STEP 5 (Removing Orders)
        // ***************************************************
        System.out.println("********************************");
        System.out.println("       OUTPUT OF STEP 5");
        System.out.println("********************************");

        // -- Successful case --
        // Explanation of the context: He has to imagine that,
        // in some way, the application provides the Order
        // object to be removed from the list orders, if
        // possible; that means (according to the definition of
        // method equals in class Order), in the case that an
        // Order object with the same reference code exists in
        // the list orders.
        // To show that, we create a "target" Order object with
        // the same reference code of the second Order object
        // created previously at STEP 3 and included into the
        // lis Orders, but with "null" values for the rest of
        // its atributes.
        String myRef = new String("O002");
        Order myOrder = new Order(myRef, null, 0, null);
        System.out.println("Trying to remove Order with reference code: " + myRef);
        if (myF.removeOrder(myOrder)) {
            System.out.println("Order object has been removed");
        } else {
            System.out.println("ERROR: Order object not found");
        }
        // Listing the remaining Order objects at list orders
        System.out.println("List of remaining orders (in order of introduction)");
        System.out.println("---------------------------------------------------");
        System.out.println(myF.listOfOrders());

        // -- ERROR case --
        // Trying to remove an Order object that does not exist
        // in the list orders.
        // Reference code of the Order to be removed:
        String myRef2 = new String("O022");
        Order myOrder2 = new Order(myRef2, null, 0, null);
        System.out.println("Trying to remove Order with reference code: " + myRef2);
        if (myF.removeOrder(myOrder2)) {
            System.out.println("Order object has been removed");
        } else {
            System.out.println("ERROR: Order object not found");
        }

    }

}
