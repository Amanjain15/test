package data.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by aman on 2/2/17.
 */

public class Keys {

    private static String key_id ="0";
    private static final String PREF_NAME = "welcome";

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    private static String TAG = "Shared Preference";

    int PRIVATE_MODE = 0;

    public Keys(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        Keys.key_id = key_id;
    }
}
