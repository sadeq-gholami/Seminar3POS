package view;
import Controller.*;
public class View {
	 private Controller contr;
	    
	    public View(Controller contr) {
	        this.contr = contr;
	    }
	    
	    public void runFakeSale() {
	        contr.startNewSale();
	        System.out.println("New sale was started.");
	    }
}
