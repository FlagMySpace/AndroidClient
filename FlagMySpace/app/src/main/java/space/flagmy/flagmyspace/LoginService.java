package space.flagmy.flagmyspace;

/**
 * Created by Sigitbn on 07/04/2015.
 */
public interface LoginService {

    boolean userAuthentication(String username, String password);
    void userRegister();

}
