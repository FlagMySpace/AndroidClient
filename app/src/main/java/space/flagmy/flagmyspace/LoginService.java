package space.flagmy.flagmyspace;

/**
 * Created by Sigitbn on 07/04/2015.
 */
public interface LoginService {

    void userAuthentication(String username, String password);
    void userRegister(String username, String email, String password);
    void resetPassword(String email);
}
