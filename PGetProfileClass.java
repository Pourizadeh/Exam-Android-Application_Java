package p.zahra.testtbl.Prof;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Window;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import p.zahra.testtbl.AppPreferencesHelper;
import p.zahra.testtbl.Stu.Classes.GetTestInfoClass;
import p.zahra.testtbl.Stu.GetSets.GetsetTestInfo;

/**
 * Created by viv on 23/02/2018.
 */

public class PGetProfileClass {
    Activity context;
    ProgressDialog dialog;
     String url="http://avidsoft.ir/php/PGetProfile.php/?email=";
    public PGetProfileClass(final Activity context, final String email) {
        //context ro baraye requesti ke badan saf bandi mishe tarif mikonim
        this.context=context;
        url="http://avidsoft.ir/php/PGetProfile.php/?pemail="+email;
        dialog = new ProgressDialog(context);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle("Please Wait");
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.show();
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
               dialog.dismiss();
                List<GetsetTestInfo> data=new ArrayList<>();
                // Toast.makeText(context,response,Toast.LENGTH_SHORT).show();
                for (int i=0;i<response.length();i++){

                    GetsetTestInfo getset=new GetsetTestInfo();
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                        AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(context);
                        appPreferencesHelper.setCurrentName(jsonObject.getString("PNAME"));
                        appPreferencesHelper.setCurrentLastName(jsonObject.getString("PLASTNAME"));
                        appPreferencesHelper.setCurrentEduCode(jsonObject.getString("EDUCODE"));
                        appPreferencesHelper.setCurrentEmail(jsonObject.getString("PEMAIL"));
                        appPreferencesHelper.setCurrentProffCode(jsonObject.getString("PID"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
                Toast.makeText(context,""+error,Toast.LENGTH_SHORT).show();
            }
        });

        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        Volley.newRequestQueue(context).add(jsonArrayRequest);
    }


}
