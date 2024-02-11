package p.zahra.testtbl.Stu.Activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
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
 * Created by viv on 01/03/2018.
 */

public  class ExamAnswerClass {

    Context activity;
    HashMap<String, String> answer;
    ProgressDialog dialog;
    public ExamAnswerClass(final Context activity, HashMap<String, String> hashMap) {
        this.activity=activity;
        this.answer=hashMap;
        final String keyconnecturl="http://avidsoft.ir/php/insertanswer.php";
        dialog = new ProgressDialog(activity);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.show();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, keyconnecturl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dialog.dismiss();
                Toast.makeText(activity, response , Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
                Toast.makeText(activity,error+"",Toast.LENGTH_SHORT).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() {
                AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(activity);
                answer.put("email",appPreferencesHelper.getCurrentEmail());
                return answer;
            }
        }; RequestQueue requestQueue= Volley.newRequestQueue(activity);
        requestQueue.add(stringRequest);







    }
}
