package space.flagmy.flagmyspace;

import android.util.Log;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;
import com.parse.SignUpCallback;


/**
 * Created by Sigitbn on 07/04/2015.
 */
public class Login implements LoginService {


    ParseUser parseUser = new ParseUser();
    public static final String TAG = SignupActivity.class.getSimpleName();
    private String toastString;


    @Override
    public void userAuthentication(String username, String password) {
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
        try {
            ParseUser user = new ParseUser();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);

            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Toast.makeText(ParseApplication.getContext(), "registration success, please verify your email address by checking your inbox", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ParseApplication.getContext(), e.getMessage().toString(), Toast.LENGTH_LONG).show();
                        Log.e(TAG, e.getLocalizedMessage());
                    }

                }
            });
        } catch (ExceptionInInitializerError exc) {
            toastString = exc.getCause().toString();
            Toast.makeText(ParseApplication.getContext(), "registration failed", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void resetPassword(String email) {

        ParseUser user = new ParseUser();
        user.requestPasswordResetInBackground(email , new RequestPasswordResetCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(ParseApplication.getContext(), "request password reset success, please check your email to reset", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ParseApplication.getContext(), e.getMessage().toString(), Toast.LENGTH_LONG).show();
                    Log.e(TAG, e.getLocalizedMessage());
                }
            }
        });

    }
}
