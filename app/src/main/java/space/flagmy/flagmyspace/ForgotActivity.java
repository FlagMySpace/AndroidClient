package space.flagmy.flagmyspace;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ForgotActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
    }

    public void ResetPassword(View view){
        EditText _email = (EditText)findViewById(R.id.emailText);
        String email = _email.getText().toString().trim();
        try {
            Login login = new Login();
            Toast.makeText(ParseApplication.getContext(), "please wait...", Toast.LENGTH_LONG).show();
            login.resetPassword(email);

        } catch (ExceptionInInitializerError exc) {
            Toast.makeText(ParseApplication.getContext(), "request password reset failed", Toast.LENGTH_LONG).show();
        }

    }

    public void LogIn(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
