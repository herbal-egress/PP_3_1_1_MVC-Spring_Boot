package mvc.spring.boot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import mvc.spring.boot.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(readOnly = true)
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    // чтение всех юзеров из БД.
    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    // получаю юзера по id
    @Override
    public User userById(int id) {
        TypedQuery<User> tQuery = entityManager.createQuery("SELECT u FROM User u where u.id = :id", User.class);
        tQuery.setParameter("id", id);
        return tQuery.getResultList().stream().findAny().orElse(null); // если результат пустой - вернуть null
    }

    // создание нового юзера:
    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    // обновление данных юзера
    @Override
    @Transactional
    public void update(int id, User updatedUser) {
        User userTeBeUpdated = entityManager.find(User.class, id);
        userTeBeUpdated.setName(updatedUser.getName());
        userTeBeUpdated.setAge(updatedUser.getAge());
        userTeBeUpdated.setEmail(updatedUser.getEmail());
        entityManager.merge(userTeBeUpdated);
    }

    // удаление юзера по id
    @Override
    @Transactional
    public void delete(int id) {
        User userTeBeDeleted = entityManager.find(User.class, id);
        entityManager.remove(userTeBeDeleted);
    }
}