package my.grocery.store.data.mapper;

import my.grocery.store.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service ("dataMapperService")
public class DataMapperService implements DataMapper{

    private DBSimulator dbSimulator;

    private Map<String, DBUser> identityMap = new HashMap<>();

    @Autowired
    public void setDbSimulator (DBSimulator dbSimulator){
        this.dbSimulator = dbSimulator;
    }

    @Override
    public DBUser getUser(User user) {
        if (identityMap.containsKey(user.getId())){  // firstly, we are searching in cache
            return identityMap.get(user.getId());
        }
        List<DBUser> dbUserList = dbSimulator.getUsers();
        for (DBUser u : dbUserList) {
            if (user.getId().equals(u.getId())){
                return u;
            }
        }
        System.out.println("Sorry, but DB doesn't contain user with such id!");
        return null;
    }

    @Override
    public DBUser addUser(User user) {
        DBUser dbUser = map(user);
        dbSimulator.add(dbUser);
        identityMap.put(dbUser.getId().toString(), dbUser); // put to cache
        return dbUser;
    }

    private DBUser map (User user){
        return new DBUser(user.getId(), user.getUsername(), user.getPassword());
    }

    @Override
    public DBUser updateUser(User user) {
        DBUser dbUser = map(user);
        dbSimulator.update(dbUser);
        return dbUser;
    }

    @Override
    public void removeUser(User user) {
        DBUser dbUser = map(user);
        dbSimulator.remove(dbUser);
        identityMap.remove(dbUser.getId());
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        List<DBUser> dbUserList = dbSimulator.getUsers();
        for (DBUser u : dbUserList) {
            User user = new User.UserBuilder(
                    u.getUsername(),
                    u.getPassword())
                    .build();
            user.setId(u.getId());
            userList.add(user);
        }
        return userList;
    }

    @Override
    public User findUserByName(String username) {
        for (DBUser u : identityMap.values()) {
            if(u.getUsername().equals(username)){
                return createUserFromDBUser(u);
            }
        }
        List<DBUser> dbUserList = dbSimulator.getUsers();
        User user;
        for (DBUser u : dbUserList) {
            if (u.getUsername().equals(username)){
                user = createUserFromDBUser(u);
                return user;
            }
        }
        System.out.println("Sorry, there is no user with such name!");
        return null;
    }

    private User createUserFromDBUser (DBUser dbUser){
        User user;
        user = new User.UserBuilder(
                dbUser.getUsername(),
                dbUser.getPassword())
                .build();
        user.setId(dbUser.getId());
        return user;
    }

}
