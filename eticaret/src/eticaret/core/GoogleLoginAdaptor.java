package eticaret.core;

import eticaret.entities.concretes.User;

public class GoogleLoginAdaptor extends LogInManager{

    @Override
    public void logIn(User user) {
        System.out.println("Google ile giriþ yapýldý.");
    }
    
}