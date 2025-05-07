package mvc.spring.boot.services;

import mvc.spring.boot.dao.UserDAO;
import mvc.spring.boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional(readOnly = true)
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Transactional(readOnly = true)
    public User userById(int id) {
        return userDAO.userById(id);
    }

    public void save(User user) {
        userDAO.save(user);
    }

    public void update(int id, User updatedUser) {
        userDAO.update(id, updatedUser);
    }

    public void delete(int id) {
        userDAO.delete(id);
    }
}