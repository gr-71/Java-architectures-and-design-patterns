package my.grocery.store.proxy.access.service;

import my.grocery.store.domain.Authority;
import my.grocery.store.domain.User;

public class LimitedAccessProxy implements Info {

    private AdminInfo adminInfo;
    private User user;

    public LimitedAccessProxy() {
        adminInfo = AdminInfo.getAdminInfoInstance();
    }

    @Override
    public String getAdminInfo() {
        if(user.getAuthorities().contains(Authority.Role.ADMIN)){
            return adminInfo.getAdminInfo();
        }
        return "Attention! You haven't got access to this data!";
    }
}
