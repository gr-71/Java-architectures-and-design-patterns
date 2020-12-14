package my.grocery.store.data.mapper;

import my.grocery.store.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class DataMapperTest {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DataMapperConfig.class);

        DBSimulator dbSimulator = applicationContext.getBean("usersDB", DBSimulator.class);

        DataMapperService dataMapperService = applicationContext.getBean("dataMapperService", DataMapperService.class);

        System.out.println("================= All users in DBSimulator ==================================================");
        for (DBUser u : dbSimulator.getUsers()) {
            System.out.println(u);
        }
        System.out.println("==================== All users which were mapped to User ===============================================");
        List<User> userList = dataMapperService.findAll();
        for (User u : userList) {
            System.out.println(u);
        }
        System.out.println("======================== Removing some users ..... ===========================================");
        List<User> usersAssignedToBeRemoved = new ArrayList<>();
        usersAssignedToBeRemoved.add(dataMapperService.findUserByName("testName_N_1"));
        usersAssignedToBeRemoved.add(dataMapperService.findUserByName("testName_N_7"));
        usersAssignedToBeRemoved.add(dataMapperService.findUserByName("testName_N_11"));
        usersAssignedToBeRemoved.add(dataMapperService.findUserByName("testName_N_12"));
        usersAssignedToBeRemoved.add(dataMapperService.findUserByName("testName_N_19"));
        for (User u : usersAssignedToBeRemoved) {
            dataMapperService.removeUser(u);
        }
        System.out.println("================ Our users after removing =====================================================");
        for (DBUser u : dbSimulator.getUsers()) {
            System.out.println(u);
        }
    }
}
