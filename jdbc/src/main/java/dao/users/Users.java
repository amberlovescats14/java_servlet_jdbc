package dao.users;

import models.User;

import java.util.ArrayList;

public interface Users {
    ArrayList<User> getAll();
    User getById(long id);
    Long createUser(User user);
    int updateUserById(User user);
    int deleteById(long id);

}
