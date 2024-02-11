package p.zahra.testtbl;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;

/**
 * Created by Lenovo Z on 29/01/2018.
 */

public class SharedPrefManager {
    private static SharedPrefManager mInstance;
    private static Context shcon;
    private  final String Shared_Pref_Name="sharedpref";
    private static final String key_pid="sid";
    private static final String key_pname="sname";
    private static final String key_plastname="slastname";
    private static final String key_pemail="semail";
    private static final String key_educode="educode";

    private SharedPrefManager(Context context){
        shcon=context;
}

public static  synchronized SharedPrefManager getmInstance(Context context)
{

    if(mInstance==null)
    {

        mInstance=new SharedPrefManager(shcon);

    }

    return mInstance;
}

public  boolean userLogin(int sid,String sname, String slastname,String semail , int educode){

SharedPreferences sharedPreferences =shcon.getSharedPreferences(Shared_Pref_Name,Context.MODE_PRIVATE);
    //it means only this app can access this shared preferences
    SharedPreferences.Editor editor =sharedPreferences.edit();
    editor.putInt(key_pid,sid);
    editor.putString(key_pname,sname);
    editor.putString(key_plastname,slastname);
    editor.putString(key_pemail,semail);
    editor.putInt(key_educode,educode);
    editor.apply();
    return  true;

    }
    public  boolean isLoggedIn(){
        SharedPreferences sharedPreferences=shcon.getSharedPreferences(Shared_Pref_Name, Context.MODE_PRIVATE);
        if (sharedPreferences.getString(key_pemail,null)!=null){
return  true;
        }
        return  false;

    }

    public boolean Logout(){

        SharedPreferences sharedPreferences=shcon.getSharedPreferences(Shared_Pref_Name, Context.MODE_PRIVATE);
      SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return  true;

    }
    public static int getPid(Context context) {

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            return preferences.getInt("Pid",0);

    }
    public static int getPname(Context context) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt("Pname",0);

    }
    public static int getPlastname(Context context) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt("Plastname",0);

    }

    public static int getPemail(Context context) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt("Pemail",0);

    }
    public static int getPeducode(Context context) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt("educode",0);

    }
}


