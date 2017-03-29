package data.com.myapplication;

/**
 * Created by aman on 12/10/16.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


public class SharedPrefs {

    // Shared preferences file name
    private static final String PREF_NAME = "welcome";
    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_USER_NAME = "userName";
    private static final String KEY_MOBILE = "mobile";
    private static final String KEY_HELPLINE_MOBILE = "helpline_mobile";

    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_CITY = "city";
    private static final String KEY_LOCALITY = "locality";
    private static final String KEY_HOUSE_NO = "house";


    // LogCat tag
    private static String TAG = "Shared Preference";

    // Shared Preferences
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    public SharedPrefs(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void setLogin(boolean isLoggedIn) {

        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);
        // commit changes
        editor.commit();
        Log.d(TAG, "User login session modified!");
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGEDIN, false);
    }

    public void setEmailId(String emailId) {

        editor.putString(KEY_EMAIL, emailId);
        editor.commit();

    }

    public String getUserName() {

        return pref.getString(KEY_USER_NAME, "NA");

    }

    public void setUserName(String userName) {

        editor.putString(KEY_USER_NAME, userName);
        editor.commit();

    }

    public String getMobile() {

        return pref.getString(KEY_MOBILE, "NA");

    }

    public void setMobile(String userName) {

        editor.putString(KEY_MOBILE, userName);
        editor.commit();

    }

    public String getAccessToken() {

        return pref.getString(KEY_ACCESS_TOKEN, "1");
    }


    public void setAccessToken(String accessToken) {
        editor.putString(KEY_ACCESS_TOKEN, accessToken);
        editor.commit();

    }


    public String getHouseNo() {
        editor.commit();

        return pref.getString(KEY_HOUSE_NO, null);
    }

    public void setHouseNo(String houseNo) {
        editor.putString(KEY_HOUSE_NO, houseNo);
        editor.commit();

    }


    public void setLocality(String locality) {
        editor.putString(KEY_LOCALITY, locality);
        editor.commit();


    }


    public String getLocality() {

        return pref.getString(KEY_LOCALITY, null);
    }

    public void setCity(String city) {
        editor.putString(KEY_CITY, city);

        editor.commit();

    }


    public String getHelplineNumber() {

        return pref.getString(KEY_HELPLINE_MOBILE, "9549089999");
    }

    public void setHelplineNumber(String helpline_number) {
        editor.putString(KEY_HELPLINE_MOBILE, helpline_number);

        editor.commit();

    }


    public String getCity() {

        return pref.getString(KEY_CITY, null);
    }


    public String getEmail() {

        return pref.getString(KEY_EMAIL, "Not Available");

    }


}