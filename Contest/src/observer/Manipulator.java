/**
 * 
 */
package observer;

import java.util.Observable;

/**
 * This class is used to
 * 
 * @author Sumit 13-Jul-2013
 * 
 */
public class Manipulator extends Observable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ObservableClass obs = new ObservableClass();
		obs.addObserver(new Observer());
		add(4, 3, obs);
		subtract(4, 3, obs);
		multiply(4, 3, obs);
		devide(4, 3, obs);
	}

	public static int add(int a, int b, ObservableClass obs) {
		obs.observe("ADD");
		return a + b;
	}

	public static int subtract(int a, int b, ObservableClass obs) {
		obs.observe("SUBTRACT");
		return a - b;
	}

	public static int multiply(int a, int b, ObservableClass obs) {
		obs.observe("MULTIPLY");
		return a * b;
	}

	public static int devide(int a, int b, ObservableClass obs) {
		obs.observe("DEVIDE");
		return a / b;
	}
}
