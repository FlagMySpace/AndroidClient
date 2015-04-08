package space.flagmy.flagmyspace;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseObject;


public class LoginActivity extends ActionBarActivity {

    boolean statusLogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "U5V4uuASo8mUG2X7W4hqlMLUBC6NhI8ellp1Kga3", "2c5sFixoGOo57cTmZxLmajv9VNO7bgxoG6LckQIg");

    }

    public void LoginClick(View view){
        EditText _username = (EditText)findViewById(R.id.usernameText);
        EditText _password = (EditText)findViewById(R.id.passwordText);
        String username = _username.getText().toString();
        String password = _username.getText().toString();

        Login login = new Login();
        statusLogin = login.userAuthentication(username, password);

        ParseObject testObject = new ParseObject("TestObject");
        testObject.put(username, username);
        testObject.saveInBackground();


        if(statusLogin){
            Toast.makeText(getApplicationContext(), "Redirecting...",
            Toast.LENGTH_SHORT).show();//Login success
            //Go to homepage
        }
        else{
            Toast.makeText(getApplicationContext(), "Wrong Credentials",
            Toast.LENGTH_SHORT).show();
            //Show error notification
        }

    }


}
