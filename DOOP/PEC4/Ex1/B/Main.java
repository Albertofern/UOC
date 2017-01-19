
/**
 * The main class
 * 
 * @author POO teaching staff
 * @version 1.0
 * @since Autumm 2016
 */

import java.lang.*;
import java.io.*;



class Main
{
    /**
     * main method
     * @param args arguments
     */
	public static void main(String args[])
	{
            
        //Create a result
		Result R = new Result("Ra.one",12,93,84);
		//display a result
        R.display();
        //calculate a result
		R.percent_cal();
	}
}
