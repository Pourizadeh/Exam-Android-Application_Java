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

/**
 * Created by viv on 23/02/2018.
 */

public class EditProfileClass {

    Context pcon;
ProgressDialog dialog;
    public EditProfileClass(Profile profile, final String name, final String lastname, final String educationfield, final String currentEmail, final boolean isStudent) {

        this.pcon=profile;
        String urllogin="http://avidsoft.ir/php/EditProfile.php";

        final String keyemail="email";
        final String keyname="name";
        final String keylastname="lastname";
        final String keyeducationcode="educationfieldcode";
        final String keyisstudent="isstudent";
        dialog = new ProgressDialog(pcon);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle("Please Wait");
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.show();

        StringRequest stringRequestChangePass =new StringRequest(Request.Method.POST, urllogin, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dialog.dismiss();
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
                    appPreferencesHelper.setCurrentName(name);
                    appPreferencesHelper.setCurrentLastName(lastname);
                    appPreferencesHelper.setCurrentEduCode(educationfield);
                    Toast.makeText(pcon,"Profile Updated",Toast.LENGTH_SHORT).show();
                }
                else
                { Toast.makeText(pcon,response,Toast.LENGTH_SHORT).show();}



            }
        }, new
                Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dialog.dismiss();
                        Toast.makeText(pcon,error+"",Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams(){
                HashMap<String,String> hashMap=new HashMap<>();
                hashMap.put(keyemail,currentEmail);
                hashMap.put(keylastname,lastname);
                hashMap.put(keyname,name);
                hashMap.put(keyeducationcode,educationfield);
                if (isStudent)
                    hashMap.put(keyisstudent,"1");
                else
                    hashMap.put(keyisstudent,"0");

                return hashMap;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(pcon);
        requestQueue.add(stringRequestChangePass);


    }
}
