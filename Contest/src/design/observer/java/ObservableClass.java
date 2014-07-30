/**
 * 
 */
package design.observer.java;

import java.util.Observable;

/**
 * This class is used to
 * 
 * @author Sumit 13-Jul-2013
 * 
 */
public class ObservableClass extends Observable {

	public void observe(Object args) {
		setChanged();
		notifyObservers(args);
	}
}
