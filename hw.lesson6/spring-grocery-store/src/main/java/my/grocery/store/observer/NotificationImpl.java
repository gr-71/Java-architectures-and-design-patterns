package my.grocery.store.observer;

import my.grocery.store.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class NotificationImpl implements Notification{

    private List<Observer> observerList = new ArrayList<>();

    private List<Product> productList = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void notifyAllObservers(Product product) {
        for (Observer o : observerList){
            o.update(product);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    public void addProduct (Product product){
        productList.add(product);
        notifyAllObservers(product);
    }

    public void removeProduct (Product product){
        productList.remove(product);
        notifyAllObservers(product);
    }
}
