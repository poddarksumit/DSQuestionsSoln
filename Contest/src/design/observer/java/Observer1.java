/**
 * 
 */
package design.observer.java;

import java.util.Observable;
import java.util.Observer;

/**
 * This class is used to
 * 
 * @author Sumit 13-Jul-2013
 * 
 */
public class Observer1 implements Observer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof ObservableClass) {
			System.out.println("Observer1");
		}

	}

}
