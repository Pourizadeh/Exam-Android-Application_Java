package p.zahra.testtbl;

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



public class SaveFireBaseTokenClass {
    Context pcon;
  //  ProgressDialog dialog;
    public SaveFireBaseTokenClass(Context context, final String token,final String currentEmail) {

        this.pcon=context;
        String urllogin="http://avidsoft.ir/php/SaveFToken.php";

        final String keyemail="email";
        final String keytoken="firebasetoken";

//        dialog = new ProgressDialog(pcon);
//        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        dialog.setCancelable(false);
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.setTitle("Please Wait");
//        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        dialog.show();

        StringRequest stringRequestChangePass =new StringRequest(Request.Method.POST, urllogin, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               // dialog.dismiss();
                //  if(response.trim().equals("Done!")) {
             /*   if (!response.equals("Done!")) {
                    Toast.makeText(pcon, response, Toast.LENGTH_SHORT).show();

                    //     Toast.makeText(pcon,response,Toast.LENGTH_SHORT).show();
                }

                //  }
                else {
                    pcon.startActivity(new Intent(pcon, InsertTestInfo.class));
                    Toast.makeText(pcon, response, Toast.LENGTH_SHORT).show();
                }*/
                if(response.equals("Done!")) {
                    AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(pcon);
                    appPreferencesHelper.setIssendftoken(true);
//                    appPreferencesHelper.setCurrentName(name);
//                    appPreferencesHelper.setCurrentLastName(lastname);
//                    appPreferencesHelper.setCurrentEduCode(educationfield);
                    Toast.makeText(pcon,"Token sent",Toast.LENGTH_SHORT).show();
                }
                else
                { Toast.makeText(pcon,response,Toast.LENGTH_SHORT).show();}



            }
        }, new
                Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                     //   dialog.dismiss();
                        Toast.makeText(pcon,error+"",Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams(){
                HashMap<String,String> hashMap=new HashMap<>();
                hashMap.put(keyemail,currentEmail);
                hashMap.put(keytoken,token);
                return hashMap;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(pcon);
        requestQueue.add(stringRequestChangePass);


    }
}
