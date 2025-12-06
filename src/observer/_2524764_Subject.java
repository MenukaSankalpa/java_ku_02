package observer;

public interface _2524764_Subject {
    void registerObserver(_2524764_Observer observer);
    void removeObserver(_2524764_Observer observer);
    void notifyObservers(String message);
}
