package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

//@Repository
@Component
@Transactional()
public class UserDaoImp implements UserDao {


    //@PersistenceContext(unitName = "em")
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void dell(Long deleteId) {
        //entityManager.createQuery("delete from User where id = :deleteId").setParameter("deleteId", deleteId).executeUpdate();
        entityManager.remove(this.getForId(deleteId));

    }

    @Override
    public void edit(Long editId, User user) {
        if (editId == 0) {
            this.add(user);
        } else {
            entityManager.createQuery("update User" +
                    " set firstName = :firstName," +
                        " lastName = :lastName," +
                        " email = :email where id = :editId")
                    .setParameter("firstName", user.getFirstName())
                    .setParameter("lastName", user.getLastName())
                    .setParameter("email", user.getEmail())
                    .setParameter("editId", editId).executeUpdate();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers(byte count) {

        if (count == 0) {
            return entityManager.createQuery("select u from User u", User.class).getResultList();
        } else {
            return entityManager.createQuery("select u from User u", User.class).setMaxResults(count).getResultList();
        }
    }

    @Override
    public User getForId(Long userId) {
        return entityManager.find(User.class, userId);
    }

    @Override
    public void add5User(){
        add(new User("name1", "last1", "1@dd.w"));
        add(new User("name2", "last2", "2@dd.w"));
        add(new User("name3", "last3", "3@dd.w"));
        add(new User("name4", "last4", "4@dd.w"));
        add(new User("name5", "last5", "5@dd.w"));
    }

}
