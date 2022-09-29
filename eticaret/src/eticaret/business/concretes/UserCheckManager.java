package eticaret.business.concretes;

import java.util.regex.Pattern;

import eticaret.business.abstracts.IUserCheckService;
import eticaret.entities.concretes.User;


public class UserCheckManager implements IUserCheckService {

    @Override
    public boolean checkEmail (eticaret.entities.concretes.User. user) {
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        if (user.getEmail().isEmpty()) {
            System.out.println("Email alaný boþ býrakýlamaz.");
            return false;
        } else {
            if (pattern.matcher(user.getEmail()).find() == false) {
                System.out.println("Girilen email adresi formata uygun deðil. Örnek: ornek@ornek.com");
                return false;
            }
        }
        return true;
        
    }

    @Override
    public boolean checkFirstName(User user) {
        if(user.getFirstName().isEmpty()){
            System.out.println("Ýsim alaný boþ býrakýlamaz");
            return false;
        }
        else if(user.getFirstName().length()<2){
            System.out.println("Ýsim alaný 2 karakterden küçük olamaz");
            return false;
        }
        System.out.println("isim alanýnýz doðru");
        return true;
        
    }

    @Override
    public boolean checkLastName(User user) {
        if(user.getLastName().isEmpty()){
            System.out.println("Soyisim alaný boþ býrakýlamaz");
            return false;
        }
        else if(user.getLastName().length()<2){
            System.out.println("Soyisim alaný 2 karakterden küçük olamaz");
            return false;
        }
      
            System.out.println("Soyisim alanýnýz doðru");
        return true;        
    }

    @Override
    public boolean checkPassword(User user) {
        if (user.getPassword().isEmpty()) {
            System.out.println("Lutfen sifre giriniz..");
            return false;
        } else if (user.getPassword().length() < 6) {
                System.out.println("Parola 6 karaktereden daha küçük olamaz..");
                return false;
            }
        
        return true;
    }

    @Override
    public boolean checkPhoneNumber(User user) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isValid(User user) {
         if (checkFirstName(user) && checkLastName(user) && checkEmail(user) == true) {
             return true;
           }
            return false;
    }

    @Override
    public boolean uniqueEmail(User user) {
        // TODO Auto-generated method stub
        return true;
    }

	@Override
	public boolean checkEmail(User user) {
		// TODO Auto-generated method stub
		return false;
	}
    



    
}