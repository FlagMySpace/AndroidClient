package space.flagmy.flagmyspace;

import android.content.Intent;
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

        if (username.length() == 0) {
            validationError = true;
            errorMessage = getString(R.string.error_blank_name);
        }
        if (email.length() == 0) {
            if (validationError) {
            errorMessage = getString(R.string.error_join);
            } else {
                validationError = true;
                errorMessage = getString(R.string.error_blank_email);
            }
        }
        if (password.length() == 0) {
            if (validationError) {
                errorMessage = getString(R.string.error_join);
            } else {
                validationError = true;
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

    }

    public void LoginLink(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}

