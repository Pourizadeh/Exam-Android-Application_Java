package p.zahra.testtbl.Prof;

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

/**
 * Created by Lenovo Z on 24/01/2018.
 */

public class QuestionClass {

    Context context;
ProgressDialog dialog;
    public QuestionClass(final Context context, final String questionedt, final String choice1,
                         final String choice2, final String choice3, final String choice4 , final String ans,
                         final String teachid, final String ccode, final String testid) {
        this.context = context;
        final String keyconnecturl="http://avidsoft.ir/php/insertquestion.php";
        final String keyq="question";
        final String keych1="choice1";
        final String keych2="choice2";
        final String keych3="choice3";
        final String keych4="choice4";
        final String keyans="answer";
        final String keypid="pid";
        final String keytid="tid";
        final String keytestid="testid";
        dialog = new ProgressDialog(context);
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
                Toast.makeText(context, response , Toast.LENGTH_SHORT).show();



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
                Toast.makeText(context,error+"",Toast.LENGTH_SHORT).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() {
                HashMap<String,String> hashMap=new HashMap<>();
                hashMap.put(keytestid,testid);
                hashMap.put(keyq,questionedt);
                hashMap.put(keych1,choice1);
                hashMap.put(keych2,choice2);
                hashMap.put(keych3,choice3);
                hashMap.put(keych4,choice4);
                hashMap.put(keyans,ans);
                hashMap.put(keypid,teachid);
                hashMap.put(keytid,ccode);
                return hashMap;
            }
        }; RequestQueue requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);



    }
}
