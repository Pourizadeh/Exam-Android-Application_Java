package p.zahra.testtbl.Prof;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.Window;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import p.zahra.testtbl.AppPreferencesHelper;

/**
 * Created by Lenovo Z on 23/12/2017.
 */

public class RegisterClass {
    Context pcontext;
    ProgressDialog dialog;
    public RegisterClass(final Context pcontext, final String pcode, final String pname, final String plastname, final String pemail,
                         final String ppassword, final String peducode) {
        this.pcontext = pcontext;
         final String keyconnecturl="http://avidsoft.ir/php/PRegister.php";
        final String keypcode="pid";
        final String keypname="pname";
        final String keyplastname="plastname";
        final String keypemail="pemail";
        final String keyppassword="ppassword";
        final  String keypeducode="educode";
        dialog = new ProgressDialog(pcontext);
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
                    AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(pcontext);
                    appPreferencesHelper.setCurrentEmail(pemail);
                    appPreferencesHelper.setCurrentPassword(ppassword);
                    appPreferencesHelper.setCurrentProffCode(pcode);
                    appPreferencesHelper.setCurrentName(pname);
                    appPreferencesHelper.setCurrentLastName(plastname);
                    appPreferencesHelper.setCurrentEduCode(peducode);
                }
                Toast.makeText(pcontext, response , Toast.LENGTH_SHORT).show();

                //}

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
                Toast.makeText(pcontext,error+"",Toast.LENGTH_SHORT).show();

                }
             }){
            @Override
            protected Map<String, String> getParams() {
                HashMap<String,String> hashMap=new HashMap<>();
                hashMap.put(keypcode,pcode);
                hashMap.put(keypname,pname);
                hashMap.put(keyplastname,plastname);
                hashMap.put(keypemail,pemail);
                hashMap.put(keyppassword,ppassword);
                hashMap.put(keypeducode,peducode);
                return hashMap;
            }
        }; RequestQueue requestQueue= Volley.newRequestQueue(pcontext);
        requestQueue.add(stringRequest);



}}
