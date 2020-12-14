package my.grocery.store.observer;

import my.grocery.store.domain.Category;
import my.grocery.store.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class InterestedUser implements Observer{

    private String name;

    private List<Category> categoryOfInterest = new ArrayList<Category>();

    public InterestedUser(String name) {
        this.name = name;
    }

    @Override
    public void update(Product product) {
        for (Category c : categoryOfInterest){
            if (product.getCategory().equals(c)){
                System.out.println
                        ("Notification for user " + name +
                                " : our store has received a new product of the following category(ies) "
                                + product.getCategory());
                System.out.println("============================================================================================================");
            }
        }
    }

    public void addCategoryOfInterest(Category category){
        categoryOfInterest.add(category);
    }
}
