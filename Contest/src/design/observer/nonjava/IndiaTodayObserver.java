package design.observer.nonjava;

public class IndiaTodayObserver implements Observer<String> {

	@Override
	public void update(String newObject) {
		System.out.println("India today breaking news : " + newObject);
	}
}
