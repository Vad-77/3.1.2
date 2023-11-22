package ru.vadim.springcourse.dao;


import ru.vadim.springcourse.model.User;

import java.util.List;

public interface UserDao {
    List<User> allUsers();
    void save(User user);
    void update(User user);
    boolean delete(Long userId);
    User getUserById(Long id);
}
