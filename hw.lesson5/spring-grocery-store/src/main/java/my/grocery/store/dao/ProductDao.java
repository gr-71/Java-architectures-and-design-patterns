package my.grocery.store.dao;

import my.grocery.store.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Long> {
}