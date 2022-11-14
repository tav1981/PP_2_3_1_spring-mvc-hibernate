package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void dell(Long deleteId);
    void edit(Long Id, User user);
    List<User> listUsers();
    User getForId(Long userId);

}
