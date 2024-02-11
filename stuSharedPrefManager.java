package p.zahra.testtbl.Stu;

import android.content.Context;
import android.content.SharedPreferences;

import p.zahra.testtbl.SharedPrefManager;

/**
 * Created by Lenovo Z on 31/01/2018.
 */

public class stuSharedPrefManager {
    private static stuSharedPrefManager sInstance;
    private static Context shscon;
    private  final String Shared_Pref_Name="sharedprefstu";
    private static final String key_sid="sid";
    private static final String key_sname="sname";
    private static final String key_slastname="slastname";
    private static final String key_semail="semail";
    private static final String key_educode="educode";

    private stuSharedPrefManager(Context context){
        shscon=context;
    }

    public static  synchronized stuSharedPrefManager getsInstance(Context context)
    {

        if(sInstance==null)
        {

            sInstance=new stuSharedPrefManager(context);

        }

        return sInstance;
    }


   public  boolean userLogin(int sid,String sname, String slastname,String semail , int educode){

                              SharedPreferences sharedPreferences =shscon.getSharedPreferences(Shared_Pref_Name,Context.MODE_PRIVATE);
    //it means only this app can access this shared preferences
    SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putInt(key_sid,sid);
                editor.putString(key_sname,sname);
                editor.putString(key_slastname,slastname);
                editor.putString(key_semail,semail);
                editor.putInt(key_educode,educode);
                editor.commit();
                return  true;

                }
    public  boolean isLoggedIn(){
        SharedPreferences sharedPreferences=shscon.getSharedPreferences(Shared_Pref_Name, Context.MODE_PRIVATE);
        if (sharedPreferences.getString(key_semail,null)!=null){
            return  true;
        }
        return  false;

    }

    public boolean Logout() {

        SharedPreferences sharedPreferences = shscon.getSharedPreferences(Shared_Pref_Name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        return true;

    }

}

