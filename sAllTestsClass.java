package p.zahra.testtbl.Stu.Classes;

import android.app.ProgressDialog;
import android.content.Context;
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
import p.zahra.testtbl.Stu.GetSets.STestScore;

/**
 * Created by viv on 02/03/2018.
 */

public class sAllTestsClass {

    Context context;
    String url;
    ProgressDialog dialog;
    public sAllTestsClass(Context context) {
        //context ro baraye requesti ke badan saf bandi mishe tarif mikonim
        this.context=context;
        AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(context);
        url="http://avidsoft.ir/php/sAllTests.php/?email="+appPreferencesHelper.getCurrentEmail();
    }
    public void  getpost (final onpost onpost){
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
                List<STestScore> data=new ArrayList<>();
                // Toast.makeText(context,response,Toast.LENGTH_SHORT).show();
                for (int i=0;i<response.length();i++){

                    STestScore getset=new STestScore();
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                        getset.setScore(jsonObject.getString("score"));
                        getset.setTestid(jsonObject.getString("testid"));
                        getset.setId(jsonObject.getString("id"));
                        getset.setEducode(jsonObject.getString("educode"));
                        getset.setExamdate(jsonObject.getString("examdate"));
                        getset.setTid(jsonObject.getString("tid"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    data.add(getset);
                }

                onpost.onpost(data);

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

    public interface onpost
    {
        void onpost(List<STestScore> data);
//ettelaat zamani ke amade shod be interface pas dade mishe va in mifrestatesh be main activity
    }

}
