package p.zahra.testtbl.Prof;

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

/**
 * Created by Lenovo Z on 15/01/2018.
 */

public class pAllTestClass {
    Context context;
    String url;
    ProgressDialog dialog;
    public pAllTestClass(Context context) {
        //context ro baraye requesti ke badan saf bandi mishe tarif mikonim
        this.context=context;
        AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(context);
        url="http://avidsoft.ir/php/pAllTests.php/?email="+appPreferencesHelper.getCurrentEmail();
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
                List<GetsetTestInfo> data=new ArrayList<>();
                // Toast.makeText(context,response,Toast.LENGTH_SHORT).show();
                for (int i=0;i<response.length();i++){

                    GetsetTestInfo getset=new GetsetTestInfo();
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                        getset.setRccode(jsonObject.getString("tid"));
                        getset.setRtname(jsonObject.getString("title"));
                        getset.setRdate(jsonObject.getString("examdate"));
                        getset.setRtime1(jsonObject.getString("endtime"));
                        getset.setRtimetake(jsonObject.getString("taketime"));
                        getset.setRteachid(jsonObject.getString("pid"));
                        getset.setRprofessname(jsonObject.getString("teachername"));
                        getset.setRuniname(jsonObject.getString("university"));
                        getset.setReducode(jsonObject.getString("educode"));
                        getset.setId(jsonObject.getString("id"));

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
        void onpost(List<GetsetTestInfo> data);
//ettelaat zamani ke amade shod be interface pas dade mishe va in mifrestatesh be main activity
    }
}
