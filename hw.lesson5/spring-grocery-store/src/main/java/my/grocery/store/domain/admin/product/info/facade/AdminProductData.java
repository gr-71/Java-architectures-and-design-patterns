package my.grocery.store.domain.admin.product.info.facade;

import my.grocery.store.domain.admin.product.info.data.DoubleData;
import my.grocery.store.domain.admin.product.info.data.StringData;

public class AdminProductData {

    private DoubleData doubleData;
    private StringData stringData;

    public AdminProductData() {
        this.doubleData = new DoubleData();
        this.stringData = new StringData();
    }

    public void displayCompleteProductData(){
        System.out.println(doubleData.getPriceNetto());
        System.out.println(stringData.getTitle());
    }
}