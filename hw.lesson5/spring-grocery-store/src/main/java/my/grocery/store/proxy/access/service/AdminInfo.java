package my.grocery.store.proxy.access.service;

import my.grocery.store.domain.admin.product.info.facade.AdminProductData;

public class AdminInfo {

    AdminProductData data = new AdminProductData();

    private static AdminInfo adminInfoInstance;

    private AdminInfo() {
    }

    public static synchronized AdminInfo getAdminInfoInstance() {
        if (adminInfoInstance == null) {
            synchronized (AdminInfo.class){
                if (adminInfoInstance == null){
                    adminInfoInstance = new AdminInfo();
                }
            }
        }
        return adminInfoInstance;
    }

    String getAdminInfo() {
        data.displayCompleteProductData();
        return "Attention! All this data is assigned for ADMIN only!";
    }
}
