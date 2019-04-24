/**
 * 
 */
package startUp;
import Controller.*;
import view.*;
/**
 * @author Sadeq
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller contr = new Controller();
        View view = new View(contr);
        view.runFakeSale();
	}

}
