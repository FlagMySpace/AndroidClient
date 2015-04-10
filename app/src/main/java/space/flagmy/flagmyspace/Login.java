package space.flagmy.flagmyspace;

import android.util.Log;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


/**
 * Created by Sigitbn on 07/04/2015.
 */
public class Login implements LoginService {


    ParseUser parseUser = new ParseUser();
    public static final String TAG = SignupActivity.class.getSimpleName();
    private String toastString;
    int errorCode;


    @Override
    public void userAuthentication(String username, String password) {
        /*try {
            parseUser.logIn(username, password);
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }*/

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if ( user != null) {
                    toastString = "Successfully Logged in";
                    Toast.makeText(ParseApplication.getContext(), toastString, Toast.LENGTH_LONG).show();
                } else {
                    toastString = e.getCause().getMessage().toString();
                    Toast.makeText(ParseApplication.getContext(), toastString, Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public void userRegister(String username, String email, String password) {
// Enable Local Data store.


        try {
            ParseUser user = new ParseUser();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);

            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Toast.makeText(ParseApplication.getContext(), "Cek email untuk verifikasi", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ParseApplication.getContext(), e.getMessage().toString(), Toast.LENGTH_LONG).show();
                        Log.e(TAG, e.getLocalizedMessage());
                    }

                }
            });
            //Toast.makeText(ParseApplication.getContext(), "Cek email untuk verifikasi", Toast.LENGTH_LONG).show();
        } catch (ExceptionInInitializerError exc) {
            toastString = exc.getCause().toString();
            Toast.makeText(ParseApplication.getContext(), "gagal", Toast.LENGTH_LONG).show();
            exc.printStackTrace();
        }
    }
}
