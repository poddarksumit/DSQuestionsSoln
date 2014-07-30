package design.observer.nonjava;

public interface Observer<T> {

	void update(T newObject);
}
