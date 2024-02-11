package p.zahra.testtbl.Stu.Classes;

import android.app.Activity;
import android.app.Dialog;
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
import p.zahra.testtbl.Stu.Activities.Exam;
import p.zahra.testtbl.Stu.GetSets.GetsetExam;


public class ExamClass {

    Activity context;
     String url="";
    String eid="";
    ProgressDialog dialog;
    public ExamClass(Activity context, String Examid) {
        //context ro baraye requesti ke badan saf bandi mishe tarif mikonim
        this.context=context;
        eid=Examid;
    }
    public void  getexam (final onpostexam onpostexam){
        //Toast.makeText(context,eid+"",Toast.LENGTH_SHORT).show();
        AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(context);
      //  Toast.makeText(context,eid+"",Toast.LENGTH_SHORT).show();
        url="http://avidsoft.ir/php/gettestquestions.php/?testid="+eid+"&& email="+appPreferencesHelper.getCurrentEmail();
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
                List<GetsetExam> examdata=new ArrayList<>();
                // Toast.makeText(context,response,Toast.LENGTH_SHORT).show();
                for (int i=0;i<response.length();i++){

                    GetsetExam getsetexam=new GetsetExam();
                   try {
                       JSONObject jsonObject=response.getJSONObject(i);
                       getsetexam.setQuestion(jsonObject.getString("question"));
                       getsetexam.setChoice1(jsonObject.getString("choice1"));
                       getsetexam.setChoice2(jsonObject.getString("choice2"));
                       getsetexam.setChoice3(jsonObject.getString("choice3"));
                       getsetexam.setChoice4(jsonObject.getString("choice4"));
                       getsetexam.setAnswer(jsonObject.getString("answer"));
                       getsetexam.setTestid(jsonObject.getInt("testid"));
                       getsetexam.setQid(jsonObject.getInt("qid"));

                       //  Toast.makeText(context,jsonObject.getString("answer"),Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    examdata.add(getsetexam);
                }

                onpostexam.onpostexam(examdata);

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
                Toast.makeText(context,"this test is done",Toast.LENGTH_SHORT).show();
                context.finish();
            }
        });

        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(10000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        Volley.newRequestQueue(context).add(jsonArrayRequest);
    }

    public interface onpostexam
    {
        void onpostexam(List<GetsetExam> examdata);
//ettelaat zamani ke amade shod be interface pas dade mishe va in mifrestatesh be main activity
    }
}


