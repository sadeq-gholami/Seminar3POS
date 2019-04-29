package se.kth.iv1500.POS.dbHandler;
/**
 * 
 * @author Sadeq
 *creates all registries and returns them via getter methods
 */
public class RegistryCreator {
	/**
	 * Creates an instance of Registry Creator 
	 */
	public RegistryCreator() {
		
	}
	
	public ItemRegistry getItemRegistry() {
		return new ItemRegistry();
	}

}
