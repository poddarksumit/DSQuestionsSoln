package design.observer.nonjava;

import java.util.ArrayList;

public class WeatherSubject implements Subject<String> {

	private static ArrayList<Observer<String>> observers = new ArrayList<Observer<String>>();
	private boolean isStatusChanged = false;
	private String value = "";

	@Override
	public void addObserver(Observer obj) {
		observers.add(obj);

	}

	/**
	 * @return the observers
	 */
	public static ArrayList<Observer<String>> getObservers() {
		return observers;
	}

	/**
	 * @param observers
	 *            the observers to set
	 */
	public static void setObservers(ArrayList<Observer<String>> observers) {
		WeatherSubject.observers = observers;
	}

	/**
	 * @return the isStatusChanged
	 */
	public boolean isStatusChanged() {
		return isStatusChanged;
	}

	/**
	 * @param isStatusChanged
	 *            the isStatusChanged to set
	 */
	public void setStatusChanged(boolean isStatusChanged) {
		this.isStatusChanged = isStatusChanged;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
		setChanged();
		notifyObjservers(this.value);
	}

	@Override
	public void removeObserver(Observer obj) {
		observers.remove(obj);

	}

	@Override
	public void setChanged() {
		isStatusChanged = true;

	}

	@Override
	public void notifyObjservers(String object) {

		if (isStatusChanged) {
			for (Observer<String> obj : observers) {
				obj.update(value);
			}
			isStatusChanged = false;
		}

	}

}
