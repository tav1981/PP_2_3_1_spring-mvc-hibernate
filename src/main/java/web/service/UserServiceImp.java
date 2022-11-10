package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) { this.userDao = userDao; }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void dell(Long deleteId) {
        userDao.dell(deleteId);
    }

    @Transactional
    @Override
    public List<User> listUsers(byte count) {
        return userDao.listUsers(count);
    }

    @Override
    public User getForId(Long userId) {
        return userDao.getForId(userId);
    }

    @Override
    public void edit(Long editId, User user) {
        userDao.edit(editId, user);
    }
}
