package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void dell(Long deleteId) {
        entityManager.remove(this.getForId(deleteId));

    }

    @Override
    public void edit(Long id, User user) {

            User userToBe = this.getForId(id);
            userToBe.setFirstName(user.getFirstName());
            userToBe.setLastName(user.getLastName());
            userToBe.setEmail(user.getEmail());

            entityManager.merge(userToBe);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
            return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getForId(Long userId) {
        return entityManager.find(User.class, userId);
    }

}
