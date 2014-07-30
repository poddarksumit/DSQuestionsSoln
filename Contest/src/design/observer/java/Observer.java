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
public class Observer implements java.util.Observer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof ObservableClass) {
			System.out.println(arg);
		}

	}
}
