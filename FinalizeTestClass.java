package p.zahra.testtbl.Stu.Classes;

import android.app.Activity;
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
 * Created by viv on 02/03/2018.
 */

public class FinalizeTestClass {

    Activity activity;
    ProgressDialog dialog;
    public FinalizeTestClass(final Activity activity, final String testid) {
        this.activity=activity;
        final String keyconnecturl="http://avidsoft.ir/php/finalizetest.php";
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
                activity.finish();

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
                HashMap<String,String> test=new HashMap<>();
                AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(activity);
                test.put("email",appPreferencesHelper.getCurrentEmail());
                test.put("testid",testid);
                return test;
            }
        }; RequestQueue requestQueue= Volley.newRequestQueue(activity);
        requestQueue.add(stringRequest);

    }

}
