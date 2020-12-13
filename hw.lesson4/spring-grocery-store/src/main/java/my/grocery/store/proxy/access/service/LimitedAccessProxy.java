package my.grocery.store.proxy.access.service;

import my.grocery.store.domain.Authority;
import my.grocery.store.domain.User;

public class LimitedAccessProxy {

    private AdminInfo adminInfo;

    public LimitedAccessProxy() {
        adminInfo = AdminInfo.getAdminInfoInstance();
    }

    public String getAdminInfo(User user) {
        if(user.getAuthorities().contains(Authority.Role.ADMIN)){
            return adminInfo.getAdminInfo();
        }
        return "Attention! You haven't got access to this data!";
    }
}
