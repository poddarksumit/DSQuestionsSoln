package design.observer.nonjava;

public interface Subject<T> {

	void addObserver(Observer obj);

	void removeObserver(Observer obj);

	void setChanged();

	void notifyObjservers(T object);
}
