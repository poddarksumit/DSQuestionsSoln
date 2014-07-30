package design.observer.nonjava;

public class AajTakObserver implements Observer<String> {

	@Override
	public void update(String newObject) {
		System.out.println("Aaj tak breaking news : " + newObject);
	}

}
