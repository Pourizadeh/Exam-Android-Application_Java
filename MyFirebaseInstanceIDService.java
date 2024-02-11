package p.zahra.testtbl;

import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.io.IOException;


public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        sendRegistrationToServer(refreshedToken);
    }

    public  void sendRegistrationToServer(String token) {
        // TODO: Implement this method to send token to your app server.
        AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(getApplicationContext());
        appPreferencesHelper.setFireBaseToken(FirebaseInstanceId.getInstance().getToken());
        //SendToken();
    }

    public  void sendRegistrationToServer() {
        // TODO: Implement this method to send token to your app server.
        AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(getApplicationContext());
        appPreferencesHelper.setFireBaseToken(FirebaseInstanceId.getInstance().getToken());
       // SendToken();
    }




    public static void Token(){
//        Thread Services = new Thread(){
//            @Override
//            public void run() {
//                Boolean isConnected = Helpers.isNetworkAvailable();
//                pref=FontApplication.getPreffrences();
//                if (!isConnected) {
//                    editor.putBoolean(SHARED_KEY_ISFIREBASE_TOKEN,false);
//                    editor.apply();
//                    return ;
//                }
//
//                if (Helpers.Token()){
//                    SendToken();
//                }
//
//               // SharedPreferences pref = getSharedPreferences("Profile", 0);
//                String username = pref.getString(SHARED_KEY_PHONE, "");
//                String password=pref.getString(SHARED_KEY_PASS,"");
//                ApiService client = RestClient.createService(ApiService.class,"");
//                Call<LoginResponse> call= client.Login(username,password,"password");
//                call.enqueue(new Callback<LoginResponse>() {
//                    @Override
//                    public void onResponse(Call<LoginResponse> call, retrofit2.Response<LoginResponse> response) {
//                        if (response.isSuccessful()) {
//                            // request successful (status code 200, 201)
//                            LoginResponse  AddUserRes = response.body();
//                            try{
//                                if (AddUserRes.getAccessToken()!=null ){
//                                    IsUserLoggedIn userLoggedIn=new IsUserLoggedIn();
//                                    userLoggedIn.SaveToken(FontApplication.Current_activity,AddUserRes.getAccessToken());
//                                    SendToken();
//                                }
//                                else {
//                                    editor.putBoolean(SHARED_KEY_ISFIREBASE_TOKEN,false);
//                                    editor.apply();
//
//                                }
//
//                            }catch (Exception e){
//
//                                editor.putBoolean(SHARED_KEY_ISFIREBASE_TOKEN,false);
//                                editor.apply();
//                            }
//
//                        }
//                        else
//                        {
//                            editor.putBoolean(SHARED_KEY_ISFIREBASE_TOKEN,false);
//                            editor.apply();
//                        }
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<LoginResponse> call, Throwable t) {
//                        editor.putBoolean(SHARED_KEY_ISFIREBASE_TOKEN,false);
//                        editor.apply();
//                    }
//
//                });
//
//            }
//
//        };
//        Services.start();

    }

    private  void SendToken() {
        AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(getApplicationContext());

        SaveFireBaseTokenClass saveFireBaseTokenClass=new SaveFireBaseTokenClass(getApplicationContext(),FirebaseInstanceId.getInstance().getToken(),appPreferencesHelper.getCurrentEmail());
//        IsUserLoggedIn isUserLoggedIn=new IsUserLoggedIn();
//        editor=FontApplication.getEditor();
//        ApiService client =  JsonClient.createService(ApiService.class,isUserLoggedIn.Check(getContext()));
//        Call<Void> call = client.SendFireBaseToken(pref.getString(SHARED_KEY_FIREBASE_TOKEN,""));
//        call.enqueue(new Callback<Void>() {
//            @Override
//            public void onResponse(Call<Void> call, Response<Void> response) {
//                if(response.isSuccessful()){
//                    editor.putBoolean(SHARED_KEY_ISFIREBASE_TOKEN,true);
//                    editor.apply();
//                }else{
//                    editor.putBoolean(SHARED_KEY_ISFIREBASE_TOKEN,false);
//                    editor.apply();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//                editor.putBoolean(SHARED_KEY_ISFIREBASE_TOKEN,false);
//                editor.apply();
//            }
//        });
    }
}