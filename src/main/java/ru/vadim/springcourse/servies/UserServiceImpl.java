package ru.vadim.springcourse.servies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vadim.springcourse.dao.UserDao;
import ru.vadim.springcourse.model.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void save(User user) {
       userDao.save(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional
    @Override
    public boolean delete(Long userId) {
        return userDao.delete(userId);
    }

    @Override
    public List<User> allUsers() {
       return userDao.allUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
}
