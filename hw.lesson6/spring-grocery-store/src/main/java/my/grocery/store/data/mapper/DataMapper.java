package my.grocery.store.data.mapper;

import my.grocery.store.domain.User;

import java.util.List;

public interface DataMapper {

    DBUser getUser (User user);

    DBUser addUser (User user);

    DBUser updateUser (User user);

    void removeUser (User user);

    List<User> findAll();

    User findUserByName (String username);
}
