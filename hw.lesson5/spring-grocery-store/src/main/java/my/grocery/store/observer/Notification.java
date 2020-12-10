package my.grocery.store.observer;

import my.grocery.store.domain.Product;

public interface Notification {
    void addObserver (Observer observer);
    void notifyAllObservers (Product product);
    void removeObserver (Observer observer);
}
