package my.grocery.store.observer;

import my.grocery.store.domain.Category;
import my.grocery.store.domain.Product;

public class ObserverTest {
    public static void main(String[] args) {

        NotificationImpl notificationImpl = new NotificationImpl();

        InterestedUser firstUser = new InterestedUser("firstUser");
        firstUser.addCategoryOfInterest(Category.VEGETABLES);
        firstUser.addCategoryOfInterest(Category.FRUIT);
        notificationImpl.addObserver(firstUser);

        InterestedUser secondUser = new InterestedUser("secondUser");
        secondUser.addCategoryOfInterest(Category.OTHER);
        notificationImpl.addObserver(secondUser);

        InterestedUser thirdUser = new InterestedUser("thirdUser");
        thirdUser.addCategoryOfInterest(Category.FRUIT);
        thirdUser.addCategoryOfInterest(Category.OTHER);
        notificationImpl.addObserver(thirdUser);

        notificationImpl.addProduct
                (new Product(99L, "Aubergine", 120.0, Category.VEGETABLES));

        notificationImpl.addProduct
                (new Product(137L, "Apples", 89.0, Category.FRUIT));

        notificationImpl.addProduct
                (new Product(159L, "Sweets", 250.0, Category.OTHER));

    }
}
