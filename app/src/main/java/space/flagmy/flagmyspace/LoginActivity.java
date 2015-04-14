package space.flagmy.flagmyspace;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;


public class LoginActivity extends ActionBarActivity {

    boolean statusLogin = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void LoginClick(View view){
        EditText _username = (EditText)findViewById(R.id.usernameText);
        EditText _password = (EditText)findViewById(R.id.passwordText);
        String username = _username.getText().toString();
        String password = _password.getText().toString();

        Login login = new Login();
        login.userAuthentication(username, password);
    }

    public void SignupClick(View view){
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    public void ForgotPassword(View view){
        Intent intent = new Intent(this, ForgotActivity.class);
        startActivity(intent);
    }


}
