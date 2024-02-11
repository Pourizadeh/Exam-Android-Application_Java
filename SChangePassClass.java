package p.zahra.testtbl.Stu;

import android.app.ProgressDialog;
import android.content.Context;
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
import p.zahra.testtbl.ChangePass;

/**
 * Created by viv on 23/02/2018.
 */

public class SChangePassClass {
    Context pcon;
    ProgressDialog dialog;

    public SChangePassClass(ChangePass changePass, final String oldpas, final String newpas, final String email) {

        this.pcon=changePass;
        String urllogin="http://avidsoft.ir/php/schangepass.php";
        final String keyemail="email";
        final String keyoldpassword="oldpassword";
        final String keynewpassword="newpassword";
        dialog = new ProgressDialog(pcon);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle("Please Wait");
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.show();
        StringRequest stringRequestChangePass =new StringRequest(Request.Method.POST, urllogin, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dialog.dismiss();
                //  if(response.trim().equals("Done!")) {
             /*   if (!response.equals("Done!")) {
                    Toast.makeText(pcon, response, Toast.LENGTH_SHORT).show();

                    //     Toast.makeText(pcon,response,Toast.LENGTH_SHORT).show();
                }

                //  }
                else {
                    pcon.startActivity(new Intent(pcon, InsertTestInfo.class));
                    Toast.makeText(pcon, response, Toast.LENGTH_SHORT).show();
                }*/
                if(response.trim().equals("Done!")) {
                    AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(pcon);
                    appPreferencesHelper.setCurrentPassword(newpas);
                    Toast.makeText(pcon,"password changed",Toast.LENGTH_SHORT).show();
                }
                else
                { Toast.makeText(pcon,response,Toast.LENGTH_SHORT).show();}



            }
        }, new
                Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dialog.dismiss();
                        Toast.makeText(pcon,error+"",Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams(){
                HashMap<String,String> hashMap=new HashMap<>();
                hashMap.put(keyemail,email);
                hashMap.put(keyoldpassword,oldpas);
                hashMap.put(keynewpassword,newpas);
                return hashMap;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(pcon);
        requestQueue.add(stringRequestChangePass);

    }



}

