package my.grocery.store.data.mapper;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository ("usersDB")
public class DBSimulator {

    private List<DBUser> dbUserList = new ArrayList<>();

    @PostConstruct
    private void createUsers(){
        for (int i = 1; i <= 20; i++) {
            Random random = new Random();
            DBUser dbUser = new DBUser(
            i + random.nextInt(100_000),
            "testName_N_" + i,
            random.nextInt(10_000) + "pass"
            );
            dbUserList.add(dbUser);
        }
        System.out.println(dbUserList);
    }

    public List<DBUser> getUsers(){
        return dbUserList;
    }

    public void remove(DBUser dbUser){
        dbUserList.remove(dbUser);
    }

    public void update(DBUser dbUser){
        DBUser userFromOurDB = null;
        for (DBUser user: dbUserList) {
            if (dbUser.getId().equals(user.getId())){
                userFromOurDB = user;
            }
        }
    }

    public void add (DBUser dbUser){
        if (dbUserList.contains(dbUser)){
            System.out.println("We are very sorry, but this user already exists!");
        } else {
            dbUserList.add(dbUser);
        }
    }
}
