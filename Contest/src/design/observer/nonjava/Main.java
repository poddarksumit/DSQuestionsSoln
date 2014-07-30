package design.observer.nonjava;

public class Main {
	public static void main(String[] args) {
		WeatherSubject subject = new WeatherSubject();
		subject.addObserver(new AajTakObserver());
		Observer<String> india = new IndiaTodayObserver();
		subject.addObserver(india);
		subject.setValue("Heavy Rain Tonight");
		subject.setValue("Heavy Sunny Today");
		subject.setValue("Valcono To errpt tonight");
		subject.removeObserver(india);
		subject.setValue("Heavy Fog Today");
		subject.setValue("Heavy Wind Today");
	}
}
