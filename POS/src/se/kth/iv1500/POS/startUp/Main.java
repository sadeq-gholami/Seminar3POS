/**
 * 
 */
package se.kth.iv1500.POS.startUp;
import se.kth.iv1500.POS.controller.Controller;
import se.kth.iv1500.POS.view.*;
/**
 * @author Sadeq
 *
 */
public class Main {

	/**
	 * @param args
	 * one more comment 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller contr = new Controller();
        View view = new View(contr);
        view.runFakeSale();
	}

}
