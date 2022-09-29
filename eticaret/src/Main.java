import eticaret.business.concretes.EmailVerificationManager;
import eticaret.business.concretes.UserCheckManager;
import eticaret.business.concretes.UserManager;
import eticaret.core.FacebookLoginAdapter;
import eticaret.core.GoogleLoginAdaptor;
import eticaret.dataAcces.concretes.HibernateUserDao;
import eticaret.entities.concretes.User;

public class Main{
    public static void main(String[] args) {
        
        User user=new User( "Ýlknur","araç","ilknur@gmail.com","05052012012","223421");
        UserManager userManager= new UserManager(new HibernateUserDao(),new UserCheckManager(),new EmailVerificationManager());

          userManager.signIn(user);   

        userManager.logIn("metehansar2001@gmail.com",  "12345");

        User user1=new User();
        User user2=new User();
        UserManager userManagerAdaptor=new UserManager();
        userManagerAdaptor.withAdapterLogin(new GoogleLoginAdaptor(), user1);
        userManagerAdaptor.withAdapterLogin(new FacebookLoginAdapter(), user2);
    }
}