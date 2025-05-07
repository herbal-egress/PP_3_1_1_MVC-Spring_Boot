package mvc.spring.boot.services;

import mvc.spring.boot.model.User;

import java.util.List;

public interface UserService {

    public List<User> allUsers();

    public User userById(int id);

    public void save(User user);

    public void update(int id, User updatedUser);

    public void delete(int id);
}
