package p.zahra.testtbl.Prof;

/**
 * Created by Lenovo Z on 30/12/2017.
 */

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONException;

import p.zahra.testtbl.AppPreferencesHelper;
import p.zahra.testtbl.ChangePass;
import p.zahra.testtbl.ChooseUser;
import p.zahra.testtbl.ManageNotiff;
import p.zahra.testtbl.Profile;
import p.zahra.testtbl.R;
import p.zahra.testtbl.Stu.Activities.StuFirstPage;

public class ProfFirstPage extends AppCompatActivity {

TextView newTest ;
            private TextView textFavorites;
    private TextView textSchedules;
     private TextView textMusic;
     RelativeLayout relativeLayout;
    private TextView changepasstxts;
    private TextView logouttxts;
    private TextView managenotifis;
    private TextView editproftxts;

    TextView oldteststxt;
    TextView Tvprofname;
    TextView Tvproflastname;
    TextView Tvprofeducode;
    TextView TvEmail;
    TextView Tvproffcode;

    RelativeLayout settingrl;
    RelativeLayout testsrl;
           @RequiresApi(api = Build.VERSION_CODES.KITKAT)
           @Override
     protected void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
                 setContentView(R.layout.profactivity_main);

               changepasstxts=(TextView)findViewById(R.id.changepasstxts);
               logouttxts=(TextView)findViewById(R.id.logouttxt);
               managenotifis=(TextView)findViewById(R.id.managenotifi);
               editproftxts=(TextView)findViewById(R.id.editproftxt);

               oldteststxt=(TextView) findViewById(R.id.oldteststxt);
               Tvprofname=(TextView)findViewById(R.id.ETprofname);
               Tvproflastname=(TextView)findViewById(R.id.ETproflastname);
               Tvprofeducode=(TextView)findViewById(R.id.ETprofeducode);
               TvEmail=(TextView)findViewById(R.id.TvEmail);
               Tvproffcode=(TextView)findViewById(R.id.Tvproffcode);


               AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(getApplicationContext());
               new PGetProfileClass(this,appPreferencesHelper.getCurrentEmail());
               /*   if(!stuSharedPrefManager.getsInstance(this).isLoggedIn()){
                   finish();
                   startActivity(new Intent(this, SLogin.class));
               }*/
              final TextView newTest=(TextView)findViewById(R.id.newtesttxt);
           //  final TextView TVEditProfile=(TextView)findViewById(R.id.TVEditProfile);
               relativeLayout =(RelativeLayout)findViewById(R.id.relativeLayout) ;
              settingrl =(RelativeLayout)findViewById(R.id.settingrl) ;
               testsrl =(RelativeLayout)findViewById(R.id.testsrl) ;

               testsrl.setVisibility(View.VISIBLE);

//final TableRow tableRowone=(TableRow)findViewById(R.id.tablerowone) ;
              // final TableRow tableRowtwo=(TableRow)findViewById(R.id.tablerowtwo) ;
               // textFavorites = (TextView) findViewById(R.id.text_favorites);
               //textSchedules = (TextView) findViewById(R.id.text_schedules);
            // textMusic = (TextView) findViewById(R.id.text_music);

               oldteststxt.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                    Intent intent=new Intent(ProfFirstPage.this,POldTest.class);
                       startActivity(intent);
                   }
               });

               BottomNavigationView bottomNavigationView = (BottomNavigationView)
                                 findViewById(R.id.bottom_navigation);


                 bottomNavigationView.setOnNavigationItemSelectedListener(
                                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                     public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                                      switch (item.getItemId()) {
                                                case R.id.action_setting:
                                                  //  Intent in=new Intent(getBaseContext(),Profile.class);
                                                   // startActivity(in);
                                                   // Intent intent= new Intent(StuFirstPage.this,Profile.class);
                                                    //startActivity(intent);
                                                     // rl.setVisibility(View.VISIBLE);
                                                      // tableRowtwo.setVisibility(View.GONE);
                                                 // textMusic.setVisibility(View.GONE);
                                                    settingrl.setVisibility(View.VISIBLE);
                                                    relativeLayout.setVisibility(View.GONE);
                                                   testsrl.setVisibility(View.GONE);
                                                       break;
                                            case R.id.action_person:
                                                     // tableLayoutone.setVisibility(View.GONE);
                                                       // tableRowtwo.setVisibility(View.VISIBLE);
                                                   // textMusic.setVisibility(View.GONE);
                                                settingrl.setVisibility(View.GONE);
                                                relativeLayout.setVisibility(View.VISIBLE);
                                                testsrl.setVisibility(View.GONE);
                                                ShowProfile();
                                                        break;
                                              case R.id.action_tests:
                                                //  tableLayoutone.setVisibility(View.VISIBLE);
                                                 //       textFavorites.setVisibility(View.GONE);
                                                 //    textSchedules.setVisibility(View.GONE);
                                                 //        textMusic.setVisibility(View.VISIBLE);
                                                  settingrl.setVisibility(View.GONE);
                                                  relativeLayout.setVisibility(View.GONE);
                                                  testsrl.setVisibility(View.VISIBLE);
                                                       break;
                                             }
                                        return false;
                                    }
                });


               newTest.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent i = new Intent(ProfFirstPage.this,InsertTestInfo.class);
                       startActivity(i);
                   }
               });

               changepasstxts.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent=new Intent(ProfFirstPage.this, ChangePass.class);
                       intent.putExtra("Current_Req","pchangepass");
                       startActivity(intent);
                   }
               });
               logouttxts.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(getApplicationContext());
                       appPreferencesHelper.LogOut();
                       Intent intent=new Intent(ProfFirstPage.this, ChooseUser.class);
                       startActivity(intent);
                       finish();
                   }
               });

               managenotifis.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent=new Intent(ProfFirstPage.this, ManageNotiff.class);
                       startActivity(intent);
                   }
               });
               editproftxts.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent=new Intent(ProfFirstPage.this, Profile.class);
                       startActivity(intent);
                   }
               });

             }

    private void ShowProfile() {

        AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(getApplicationContext());
         Tvprofname.setText(appPreferencesHelper.getCurrentName());
         Tvproflastname.setText(appPreferencesHelper.getCurrentLastName());
         Tvprofeducode.setText(appPreferencesHelper.getCurrentEduCode());
         TvEmail.setText(appPreferencesHelper.getCurrentEmail());
         Tvproffcode.setText(appPreferencesHelper.getCurrentProffCode());
    }
}
