package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void dell(Long deleteId);
    List<User> listUsers();
    User getForId(Long userId);
    void edit(Long Id, User user);
}
