package p.zahra.testtbl.Prof;
        import android.app.ProgressDialog;
        import android.content.Context;
        import android.content.Intent;
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
        import p.zahra.testtbl.Profile;
        import p.zahra.testtbl.Stu.Activities.StuFirstPage;

/**
 * Created by Lenovo Z on 28/12/2017.
 */

public class PLoginClass {
    Context pcon;
    ProgressDialog dialog;
    // public String res;
    public PLoginClass(final Context pcon,final String pemail,final String ppassword){
        this.pcon=pcon;
        String urllogin="http://avidsoft.ir/php/plogin.php";
        final String keypemail="pemail";
        final String keyppassword="ppassword";
        dialog = new ProgressDialog(pcon);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle("Please Wait");
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.show();
        StringRequest stringRequestLogin =new StringRequest(Request.Method.POST, urllogin, new Response.Listener<String>() {
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
                if(response.trim().equals("Done!")) {
                    AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(pcon);
                    appPreferencesHelper.setCurrentEmail(pemail);
                    appPreferencesHelper.setCurrentPassword(ppassword);
                    appPreferencesHelper.setIsStudent(false);
                    appPreferencesHelper.setIsTLogin(true);
                    pcon.startActivity(new Intent(pcon, ProfFirstPage.class));
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
                hashMap.put(keypemail,pemail);
                hashMap.put(keyppassword,ppassword);
                return hashMap;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(pcon);
        requestQueue.add(stringRequestLogin);
    }

}