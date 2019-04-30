package se.kth.iv1500.POS.dbHandler;
/**
* This class is responsible for instantiating all External systems.
*/
public class ExternalSystemGenerator {
	/**
	 * Get the value of the printer
	 * @return the value of the printer
	 */
	public Printer getPrinter() {
		return new Printer();
	}
}
