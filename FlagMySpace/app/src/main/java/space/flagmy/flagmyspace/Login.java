package space.flagmy.flagmyspace;

/**
 * Created by Sigitbn on 07/04/2015.
 */
public class Login implements LoginService {


    @Override
    public boolean userAuthentication(String username, String password) {
        if (username.equals("admin") && password.equals("admin")){
            return true;
        }
        else{
        return false;
        }
    }

    @Override
    public void userRegister() {

    }


}
