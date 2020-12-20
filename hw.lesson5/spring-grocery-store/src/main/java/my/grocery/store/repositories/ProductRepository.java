package my.grocery.store.repositories;

import my.grocery.store.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findOneByTitle(String title);
}
