package eticaret.business.abstracts;

import eticaret.entities.concretes.User;

public interface IUserService {
    
    void logIn(String mail,String password);
    void signIn(User user);

}