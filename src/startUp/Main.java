/**
 * 
 */
package startUp;
import controller.*;
import dbHandler.*;
import view.*;
import model.*;
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
		RegistryCreator regCreator = new RegistryCreator();
		ExternalSystemGenerator extSys = new ExternalSystemGenerator();
		CashRegister cashRegister = new CashRegister();
		Controller contr = new Controller(regCreator, extSys, cashRegister);
        View view = new View(contr);
        view.runFakeSale();
	}
}
