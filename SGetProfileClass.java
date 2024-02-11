package p.zahra.testtbl.Stu;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Window;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import p.zahra.testtbl.AppPreferencesHelper;
import p.zahra.testtbl.Stu.GetSets.GetsetTestInfo;

/**
 * Created by viv on 24/02/2018.
 */

public class SGetProfileClass {

    Activity context;
    String url="";
    ProgressDialog dialog;
    public SGetProfileClass(final Activity context, final String email) {
        //context ro baraye requesti ke badan saf bandi mishe tarif mikonim
        this.context=context;
        url="http://avidsoft.ir/php/SGetProfile.php/?pemail="+email;
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
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                        AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(context);
                        appPreferencesHelper.setCurrentName(jsonObject.getString("SNAME"));
                        appPreferencesHelper.setCurrentLastName(jsonObject.getString("SLASTNAME"));
                        appPreferencesHelper.setCurrentEduCode(jsonObject.getString("EDUCODE"));
                        appPreferencesHelper.setCurrentEmail(jsonObject.getString("SEMAIL"));
                        appPreferencesHelper.setCurrentStudentId(jsonObject.getString("SID"));
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
