package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService{

    private UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) { this.userDao = userDao; }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void dell(Long deleteId) {
        userDao.dell(deleteId);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public User getForId(Long userId) {
        return userDao.getForId(userId);
    }

    @Override
    public void edit(Long id, User user) {
        userDao.edit(id, user);
    }
}
