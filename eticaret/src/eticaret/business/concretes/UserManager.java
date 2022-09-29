package eticaret.business.concretes;

import java.util.ArrayList;
import java.util.List;

import eticaret.business.abstracts.IUserService;
import eticaret.business.abstracts.IVerificationService;
import eticaret.core.ILogInService;
import eticaret.dataAcces.abstracts.IUserDao;

import eticaret.entities.concretes.User;
public class UserManager implements IUserService {
    List<User> user = new ArrayList<User>();
    private IUserDao userDao;
    private UserCheckManager userCheckManager;
    private IVerificationService verificationService;

    

    public UserManager(IUserDao userDao, UserCheckManager userCheckManager, IVerificationService verificationService) {
        this.userDao = userDao;
        this.userCheckManager = userCheckManager;
        this.verificationService = verificationService;
    }

    public UserManager(List<User> user, IUserDao userDao, UserCheckManager userCheckManager,
            IVerificationService verificationService) {
        this.user = user;
        this.userDao = userDao;
        this.userCheckManager = userCheckManager;
        this.verificationService = verificationService;
    }

    public UserManager() {
    }

    @Override
    public void logIn(String mail, String password) {
        List<User> newUserList = userDao.getUsers();
        User user = null;
        for (User users : newUserList) {
            if (users.getEmail() == mail && users.getPassword() == password) {
                System.out.println("Giri� ba�ar�l� : " + users.getFirstName() + " " + users.getLastName());
                user = users;
            } else if (users.getEmail() == mail && users.getPassword() != password) {
                System.out.println("�ifre hatal�, kontrol ediniz..");
                user = users;

            }

        }
        if (user == null) {
            System.out.println("Bilgilerinizi kontrol ediniz.");
        }

    }

    public void withAdapterLogin(ILogInService logInService, User user) {
        logInService.logIn(user);
    }

    @Override
    public void signIn(User user) {
        System.out.println("signIn geldi");
        System.out.println(userCheckManager.toString());

        if (userCheckManager.isValid(user)) {
            System.out.println("Kay�t Ba�ar�l�");
            verificationService.sendToVerifyMail(user.getEmail());
            System.out.println("Kayd�n�z� tamamlamak i,�in do�rulama linkine t�klay�n�z.");
            if (verificationService.checkVerifyAccount(user.getEmail())) {
                System.out.println("Kayd�n�z tamamland�");
                userDao.add(user);
            }
        }

    }

}