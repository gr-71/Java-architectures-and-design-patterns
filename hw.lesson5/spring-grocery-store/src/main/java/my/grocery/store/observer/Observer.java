package my.grocery.store.observer;

import my.grocery.store.domain.Product;

public interface Observer {
    void update (Product product);
}
