package space.flagmy.flagmyspace;

import android.app.Application;
import android.content.Context;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by Sigitbn on 09/04/2015.
 */
public class ParseApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();

        // Add your initialization code here
        Parse.initialize(this, "L3POUewF4K1RgkRtKcZTDLne4Zp2kCgwQUmeW0Ru", "CnD1G0uFPkz0wf51R53IhHYtuOgh11UUhMYT9x03");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this
        // line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);
        context = getApplicationContext();

    }

    /**
     * Returns the application context
     *
     * @return application context
     */
    public static Context getContext() {
        return context;
    }
}
