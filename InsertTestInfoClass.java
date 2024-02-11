package p.zahra.testtbl.Prof;

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

/**
 * Created by Lenovo Z on 02/02/2018.
 */

public class InsertTestInfoClass {
    Context inscon;
    // public String res;
    ProgressDialog dialog;
    public InsertTestInfoClass(final Context inscon,
                               final String ccode,final String tname,final String date,final String time1,
                               final String timetake, final String teachid,final String professname,final String uniname,final String educode){
        this.inscon=inscon;
        String urllogin="http://avidsoft.ir/php/inserttestinfo.php";
        final String keyccode="tid";
        final String keytname="title";
        final String keydate="examdate";
        final String keytime1="endtime";
        final String keytimetake="taketime";
        final String keyteachid="pid";
        final String keyprofessname="teachername";
        final String keyuniname="university";
        final String keyteducode="educode";
        dialog = new ProgressDialog(inscon);
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
                if (!response.equals("failed")&&!response.equals("no information from user side")){
                    InsertTestInfo.Current_Exam_id= Integer.parseInt(response);
                    Toast.makeText(inscon,"Inserted Successfully",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(inscon,response,Toast.LENGTH_SHORT).show();

                }
            }
        }, new
                Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dialog.dismiss();
                        Toast.makeText(inscon,error+"",Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams(){
                HashMap<String,String> hashMap=new HashMap<>();
                hashMap.put(keyccode,ccode);
                hashMap.put(keytname,tname);
                hashMap.put(keydate,date);
                hashMap.put(keytime1,time1);
                hashMap.put(keytimetake,timetake);
                hashMap.put(keyteachid,teachid);
                hashMap.put(keyprofessname,professname);
                hashMap.put(keyuniname,uniname);
                hashMap.put(keyteducode,educode);
                return hashMap;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(inscon);
        requestQueue.add(stringRequestLogin);
    }

}