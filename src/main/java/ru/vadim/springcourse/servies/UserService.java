package ru.vadim.springcourse.servies;

import ru.vadim.springcourse.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void update(User user);
    boolean delete(Long userId);
    List<User> allUsers();
    User getUserById(Long id);

}
