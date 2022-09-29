package eticaret.business.concretes;

import eticaret.business.abstracts.IVerificationService;

public class EmailVerificationManager implements IVerificationService {

    @Override
    public boolean checkVerifyAccount(String email) {
        if(ifClickedLink(email)==true){
            System.out.println("Hesap do�rulanm��t�r..");
            return true;

        }
        return false;
       
    }

    @Override
    public boolean ifClickedLink(String email) {
        
        return true;
    }

    @Override
    public void sendToVerifyMail(String email) {
        System.out.println("Do�rulama linki g�nderildi..");        
        
    }
    
    
    
}