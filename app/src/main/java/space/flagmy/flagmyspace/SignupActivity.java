package space.flagmy.flagmyspace;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class SignupActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void SignupClick(View view) {
        EditText _username = (EditText) findViewById(R.id.usernameText);
        EditText _email = (EditText) findViewById(R.id.emailText);
        EditText _password = (EditText) findViewById(R.id.passwordText);

        String username = _username.getText().toString().trim();
        String email = _email.getText().toString().trim();
        String password = _password.getText().toString().trim();
        boolean validationError = false;
        String errorMessage = "Success";
        StringBuilder validationErrorMessage = new StringBuilder(getString(R.string.error_intro));
        if (username.length() == 0) {
            validationError = true;
            validationErrorMessage.append(getString(R.string.error_blank_name));
            errorMessage = getString(R.string.error_blank_name);
        }
        if (email.length() == 0) {
            if (validationError) {
                validationErrorMessage.append(getString(R.string.error_join));
                errorMessage = getString(R.string.error_join);
            } else {
                validationError = true;
                validationErrorMessage.append(getString(R.string.error_blank_email));
                errorMessage = getString(R.string.error_blank_email);
            }
        }
        if (password.length() == 0) {
            if (validationError) {
                validationErrorMessage.append(getString(R.string.error_join));
                errorMessage = getString(R.string.error_join);
            } else {
                validationError = true;
                validationErrorMessage.append(getString(R.string.error_blank_password));
                errorMessage = getString(R.string.error_blank_password);
            }
        }
        if (validationError) {
                Toast.makeText(ParseApplication.getContext(), errorMessage, Toast.LENGTH_LONG).show();
            }else {
            Toast.makeText(ParseApplication.getContext(), errorMessage, Toast.LENGTH_LONG).show();
            Login signup = new Login();
            signup.userRegister(username, email, password);

        }
        /*if (username.equals("") && email.equals("") && password.equals("")) {
            Toast.makeText(getApplicationContext(),
                    "Please complete the sign up form",
                    Toast.LENGTH_LONG).show();

        } else {
            // Save new user data into Parse.com Data Storage

            ParseUser parseUser = new ParseUser();
            parseUser.setUsername(username);
            parseUser.setEmail(email);
            parseUser.setPassword(password);
            parseUser.signUpInBackground(new SignUpCallback() {
                public void done(ParseException e) {
                    if (e == null) {
                        // Show a simple Toast message upon successful registration
                        Toast.makeText(getApplicationContext(),
                                "Successfully Signed up, please log in.",
                                Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                                startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Sign up Error",
                                Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
*/
    }
}

