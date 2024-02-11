package p.zahra.testtbl.Stu.Classes;
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

/**
 * Created by Lenovo Z on 27/01/2018.
 */

public class SRegisterClass {
    Context scontext;

    public SRegisterClass(final Context scontext, final String sname, final String slastname, final String semail,
                         final String spassword, final String seducode,final String sid) {
        this.scontext = scontext;
        final ProgressDialog dialog;
        final String keyconnecturl="http://avidsoft.ir/php/SRegister.php";
     //   final String keyscode="sid";
        final String keysname="sname";
        final String keyslastname="slastname";
        final String keysemail="semail";
        final String keyspassword="spassword";
        final  String keyseducode="educode";
        final  String keysSid="sid";

        dialog = new ProgressDialog(scontext);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle("Please Wait");
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.show();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, keyconnecturl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dialog.dismiss();
                //  if (response.trim().equals("ایمیل قبلا ثبت شده است")){
                //  Toast.makeText(context, "ایمیل قبلا ثبت شده است", Toast.LENGTH_SHORT).show();}
                //  else if(response.trim().equals("ثبت نام با موفقیت انجام شد")) {

                //    Toast.makeText(context, "ثبت نام با موفقیت انجام شد", Toast.LENGTH_SHORT).show();
                // }
                //  else {
                if (response.equals("You have registered successfully\n" +
                        "                welcome!")){
                    AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(scontext);
                    appPreferencesHelper.setCurrentEmail(semail);
                    appPreferencesHelper.setCurrentPassword(spassword);
                    appPreferencesHelper.setCurrentName(sname);
                    appPreferencesHelper.setCurrentLastName(slastname);
                    appPreferencesHelper.setCurrentEduCode(seducode);
                    appPreferencesHelper.setCurrentStudentId(sid);
                }
                Toast.makeText(scontext, response , Toast.LENGTH_SHORT).show();

                //}

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
                Toast.makeText(scontext,error+"",Toast.LENGTH_SHORT).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() {
                HashMap<String,String> shashMap=new HashMap<>();
                shashMap.put(keysname,sname);
                shashMap.put(keyslastname,slastname);
                shashMap.put(keysemail,semail);
                shashMap.put(keyspassword,spassword);
                shashMap.put(keyseducode,seducode);
                shashMap.put(keysSid,sid);
                return shashMap;
            }
        }; RequestQueue requestQueue= Volley.newRequestQueue(scontext);
        requestQueue.add(stringRequest);



    }}
