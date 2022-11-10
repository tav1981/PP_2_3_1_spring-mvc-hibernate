package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void dell(Long deleteId);
    void edit(Long editId, User user);
    List<User> listUsers(byte count);
    User getForId(Long userId);
    public void add5User();
}
