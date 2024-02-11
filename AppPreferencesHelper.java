package p.zahra.testtbl;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zahra on 23/02/2018.
 */

public class AppPreferencesHelper {
    private static final String SHARED_KEY_USERNAME="username" ;
    private static final String SHARED_KEY_PASS="password" ;
    private static final String SHARED_KEY_NAME="name" ;
    private static final String SHARED_KEY_LASTNAME="lastname" ;
    private static final String SHARED_KEY_EMAIL="email" ;
    private static final String SHARED_KEY_EDUCATIONFIELDCODE="edufieldcode" ;
    private static final String SHARED_KEY_PROFFCODE="proffcode" ;
    private static final String SHARED_KEY_ISLOGIN="islogin" ;
    private static final String SHARED_KEY_ISSTUDENT="isStudent" ;
    private static final String SHARED_KEY_SHOWNOTIFF="shownotiff" ;
    private static final String SHARED_KEY_STUDENTID = "studentid";
    private static final String SHARED_KEY_FireBaseToken = "firebasetoken";
    private static final String SHARED_KEY_ISFIREBASE_TOKEN = "issendfirebasetoken";



    private final SharedPreferences mPrefs;
    private final SharedPreferences.Editor Editor;

    public AppPreferencesHelper(Context context) {
        mPrefs =context.getSharedPreferences("Profile",0);
        Editor=mPrefs.edit();
    }


    public String getCurrentUserName() {
        String res="";
        if(mPrefs.contains(SHARED_KEY_USERNAME))
            res= mPrefs.getString(SHARED_KEY_USERNAME,"");
        return res;
    }

    public void setCurrentUserName(String userName) {
        Editor.putString(SHARED_KEY_USERNAME,userName);
        Editor.apply();
    }

    public String getCurrentPassword() {
        String res="";
        if(mPrefs.contains(SHARED_KEY_PASS))
            res= mPrefs.getString(SHARED_KEY_PASS,"");
        return res;
    }

     public void setCurrentPassword(String password) {
        Editor.putString(SHARED_KEY_PASS,password);
        Editor.apply();
    }

    public String getCurrentName() {
        String res="";
        if(mPrefs.contains(SHARED_KEY_NAME))
            res= mPrefs.getString(SHARED_KEY_NAME,"");
        return res;
    }

    public void setCurrentName(String password) {
        Editor.putString(SHARED_KEY_NAME,password);
        Editor.apply();
    }

    public String getCurrentLastName() {
        String res="";
        if(mPrefs.contains(SHARED_KEY_LASTNAME))
            res= mPrefs.getString(SHARED_KEY_LASTNAME,"");
        return res;
    }

    public void setCurrentLastName(String password) {
        Editor.putString(SHARED_KEY_LASTNAME,password);
        Editor.apply();
    }

    public String getCurrentEmail() {
        String res="";
        if(mPrefs.contains(SHARED_KEY_EMAIL))
            res= mPrefs.getString(SHARED_KEY_EMAIL,"");
        return res;
    }

    public void setCurrentEmail(String password) {
        Editor.putString(SHARED_KEY_EMAIL,password);
        Editor.apply();
    }

    public String getCurrentEduCode() {

        String res="";
        if(mPrefs.contains(SHARED_KEY_EDUCATIONFIELDCODE))
            res= mPrefs.getString(SHARED_KEY_EDUCATIONFIELDCODE,"");
        return res;
    }

    public void setCurrentEduCode(String password) {
        Editor.putString(SHARED_KEY_EDUCATIONFIELDCODE,password);
        Editor.apply();
    }

    public String getCurrentStudentId() {

        String res="";
        if(mPrefs.contains(SHARED_KEY_STUDENTID))
            res= mPrefs.getString(SHARED_KEY_STUDENTID,"");
        return res;
    }

    public void setCurrentStudentId(String sid) {
        Editor.putString(SHARED_KEY_STUDENTID,sid);
        Editor.apply();
    }



    public String getCurrentProffCode() {

        String res="";
        if(mPrefs.contains(SHARED_KEY_PROFFCODE))
            res= mPrefs.getString(SHARED_KEY_PROFFCODE,"");
        return res;
    }

    public void setCurrentProffCode(String password) {
        Editor.putString(SHARED_KEY_PROFFCODE,password);
        Editor.apply();
    }

    public boolean getIsTLogin() {
        boolean res=false;
        if(mPrefs.contains(SHARED_KEY_ISLOGIN))
            res= mPrefs.getBoolean(SHARED_KEY_ISLOGIN,false);
        return res;
    }

    public void setIsTLogin(boolean state) {
        Editor.putBoolean(SHARED_KEY_ISLOGIN,state);
        Editor.apply();
    }

    public boolean getIsStudent() {
        boolean res=false;
        if(mPrefs.contains(SHARED_KEY_ISSTUDENT))
            res= mPrefs.getBoolean(SHARED_KEY_ISSTUDENT,false);
        return res;
    }

    public void setIsStudent(boolean state) {
        Editor.putBoolean(SHARED_KEY_ISSTUDENT,state);
        Editor.apply();
    }

    public boolean getShowNotiff() {
        boolean res=false;
        if(mPrefs.contains(SHARED_KEY_SHOWNOTIFF))
            res= mPrefs.getBoolean(SHARED_KEY_SHOWNOTIFF,false);
        return res;
    }

    public void setShowNotiff(boolean state) {
        Editor.putBoolean(SHARED_KEY_SHOWNOTIFF,state);
        Editor.apply();
    }

    public boolean LogOut() {
        try {
            Editor.clear();
            Editor.apply();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public String getFireBaseToken() {

        String res="";
        if(mPrefs.contains(SHARED_KEY_FireBaseToken))
            res= mPrefs.getString(SHARED_KEY_FireBaseToken,"");
        return res;
    }

    public void setFireBaseToken(String token) {
        Editor.putString(SHARED_KEY_FireBaseToken,token);
        Editor.apply();
    }

    public boolean getIssendftoken() {
        boolean res=false;
        if(mPrefs.contains(SHARED_KEY_ISFIREBASE_TOKEN))
            res= mPrefs.getBoolean(SHARED_KEY_ISFIREBASE_TOKEN,false);
        return res;
    }

    public void setIssendftoken(boolean state) {
        Editor.putBoolean(SHARED_KEY_ISFIREBASE_TOKEN,state);
        Editor.apply();
    }

//     public boolean getIsFireBaseToken() {
//        boolean res=false;
//        if(mPrefs.contains(SHARED_KEY_ISFIREBASE_TOKEN))
//            res= mPrefs.getBoolean(SHARED_KEY_ISFIREBASE_TOKEN,false);
//        return res;
//    }
//
//     public void setIsFireBaseToken(boolean firebaseToken) {
//        Editor.putBoolean(SHARED_KEY_ISFIREBASE_TOKEN,firebaseToken);
//        Editor.apply();
//    }

}
