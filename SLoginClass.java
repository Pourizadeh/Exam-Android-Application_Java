package p.zahra.testtbl.Stu.Classes;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Window;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import p.zahra.testtbl.AppPreferencesHelper;
import p.zahra.testtbl.Stu.Activities.StuFirstPage;


/**
 * Created by Lenovo Z on 27/01/2018.
 */

public class SLoginClass {
    Context scon;
 /* final String Shared_Pref_Name="sharedprefstu";
   static final String key_sid="sid";
    static final String key_sname="sname";
     static final String key_slastname="slastname";
  public static final String key_semail="semail";
     static final String key_educode="educode";*/
   // public String res;
    public SLoginClass(final Context con,final String semail,final String spassword){
        this.scon=con;
        final ProgressDialog dialog;
        String urllogin="http://avidsoft.ir/php/slogin.php";

        final String keysid="sid";
        final String keysname="sname";
        final String keysladtname="slastname";
        final String keyspassword="spassword";
        final String keysemail="semail";
        final String keyseducode="educode";
        dialog = new ProgressDialog(con);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle("Please Wait");
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.show();
        StringRequest stringRequestLogin =new StringRequest(Request.Method.POST, urllogin, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dialog.dismiss();
                    if(response.trim().equals("Done!")) {
                 //userLogin("semail");
                        AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(con);
                        appPreferencesHelper.setCurrentEmail(semail);
                        appPreferencesHelper.setCurrentPassword(spassword);
                        appPreferencesHelper.setIsStudent(true);
                        appPreferencesHelper.setIsTLogin(true);
                        scon.startActivity(new Intent(scon, StuFirstPage.class));
                    }
else
                    { Toast.makeText(scon,response,Toast.LENGTH_SHORT).show();}



            }
        }, new
                Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dialog.dismiss();
                        Toast.makeText(scon,error+"",Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams(){
                HashMap<String,String> hashMap=new HashMap<>();
                hashMap.put(keysemail,semail);
                hashMap.put(keyspassword,spassword);
                return hashMap;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(con);
        requestQueue.add(stringRequestLogin);
    }

   /* public  boolean userLogin(String semail ){

        SharedPreferences sharedPreferences =scon.getSharedPreferences(Shared_Pref_Name,Context.MODE_PRIVATE);
        //it means only this app can access this shared preferences
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString(key_semail,semail);
        editor.commit();
        return  true;

    }*/


}

