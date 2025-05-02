package mvc.spring.boot.dao;

import mvc.spring.boot.model.User;
import java.util.List;

public interface UserDAO {
    public List<User> allUsers();

    public User userById(int id);

    public void save(User user);

    public void update(int id, User updatedUser);

    public void delete(int id);
}