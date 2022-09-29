package eticaret.dataAcces.abstracts;

import java.util.List;

import eticaret.entities.concretes.User;

public interface IUserDao  {
    void add(User user);
    void update(User user);
    void delete(User user);
    User get(int id);
    List<User> getUsers();
    
}