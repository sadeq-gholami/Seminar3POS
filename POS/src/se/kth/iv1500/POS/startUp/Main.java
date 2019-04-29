/**
 * 
 */
package se.kth.iv1500.POS.startUp;
import se.kth.iv1500.POS.controller.Controller;
import se.kth.iv1500.POS.dbHandler.*;
import se.kth.iv1500.POS.view.*;
import se.kth.iv1500.POS.model.*;
/**
 * @author Sadeq
 *
 */
public class Main {

	/**
	 * @param args
	 * change the comment in main 
	 */
	public static void main(String[] args) {
		ExternalSystemGenerator extSys = new ExternalSystemGenerator();
		CashRegister cashRegister = new CashRegister();
		Controller contr = new Controller(extSys, cashRegister);
        View view = new View(contr);
        view.runFakeSale();
	}

}
