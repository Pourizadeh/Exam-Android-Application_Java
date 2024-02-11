package p.zahra.testtbl.Stu.Activities;

/**
 * Created by Lenovo Z on 30/12/2017.
 */
 import android.content.Intent;
 import android.support.annotation.NonNull;
         import android.support.design.widget.BottomNavigationView;
         import android.support.v7.app.AppCompatActivity;
         import android.os.Bundle;
 import android.view.MenuItem;
         import android.view.View;
 import android.widget.RelativeLayout;
 import android.widget.TextView;

 import com.google.firebase.analytics.FirebaseAnalytics;
 import com.google.firebase.iid.FirebaseInstanceId;
 import com.google.firebase.messaging.FirebaseMessaging;

 import p.zahra.testtbl.AppPreferencesHelper;
 import p.zahra.testtbl.ChangePass;
 import p.zahra.testtbl.ChooseUser;
 import p.zahra.testtbl.ManageNotiff;
 import p.zahra.testtbl.Prof.PGetProfileClass;
 import p.zahra.testtbl.Prof.ProfFirstPage;
 import p.zahra.testtbl.Profile;
 import p.zahra.testtbl.R;
 import p.zahra.testtbl.SaveFireBaseTokenClass;
 import p.zahra.testtbl.Stu.Classes.SLoginClass;
 import p.zahra.testtbl.Stu.SGetProfileClass;

public class StuFirstPage extends AppCompatActivity {



TextView snewTest ;
    private TextView textFavorites;
    private TextView textSchedules;
    private TextView textMusic;

    TextView oldteststxts;

    private TextView changepasstxts;
    private TextView logouttxts;
    private TextView managenotifis;
    private TextView editproftxts;

    TextView Tvprofname;
    TextView Tvproflastname;
    TextView Tvprofeducode;
    TextView TvEmail,Sid;

    RelativeLayout relativeLayouts;
    RelativeLayout settingrls;
    RelativeLayout testsrls;
    SLoginClass sl;

    private FirebaseAnalytics mFirebaseAnalytics;


    @Override
     protected void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
                 setContentView(R.layout.stuactivity_main);

               mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
               FirebaseMessaging.getInstance().subscribeToTopic("news");
                SendToken();
             /* if(!sl.userLogin()){
                   finish();
                   startActivity(new Intent(this, SLogin.class));
               }*/
               changepasstxts=(TextView)findViewById(R.id.changepasstxts);
               logouttxts=(TextView)findViewById(R.id.logouttxts);
               managenotifis=(TextView)findViewById(R.id.managenotifis);
               editproftxts=(TextView)findViewById(R.id.editproftxts);

               Tvprofname=(TextView)findViewById(R.id.ETprofname);
               Tvproflastname=(TextView)findViewById(R.id.ETproflastname);
               Tvprofeducode=(TextView)findViewById(R.id.ETprofeducode);
               TvEmail=(TextView)findViewById(R.id.TvEmail);
               Sid=(TextView)findViewById(R.id.Sid);
               oldteststxts=(TextView)findViewById(R.id.oldteststxts);

               AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(getApplicationContext());
               new SGetProfileClass(this,appPreferencesHelper.getCurrentEmail());

               final TextView snewTest=(TextView)findViewById(R.id.newtesttxts);
           //  final TextView TVEditProfile=(TextView)findViewById(R.id.TVEditProfile);
               relativeLayouts =(RelativeLayout)findViewById(R.id.relativeLayouts) ;
              settingrls =(RelativeLayout)findViewById(R.id.settingrls) ;
               testsrls =(RelativeLayout)findViewById(R.id.testsrls) ;
               testsrls.setVisibility(View.VISIBLE);

//final TableRow tableRowone=(TableRow)findViewById(R.id.tablerowone) ;
              // final TableRow tableRowtwo=(TableRow)findViewById(R.id.tablerowtwo) ;
               // textFavorites = (TextView) findViewById(R.id.text_favorites);
               //textSchedules = (TextView) findViewById(R.id.text_schedules);
            // textMusic = (TextView) findViewById(R.id.text_music);

               oldteststxts.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent=new Intent(StuFirstPage.this,SOldTests.class);
                       startActivity(intent);
                   }
               });
               BottomNavigationView bottomNavigationView = (BottomNavigationView)
                                 findViewById(R.id.sbottom_navigation);


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
                                                    settingrls.setVisibility(View.VISIBLE);
                                                    relativeLayouts.setVisibility(View.GONE);
                                                   testsrls.setVisibility(View.GONE);
                                                       break;
                                            case R.id.action_person:
                                                     // tableLayoutone.setVisibility(View.GONE);
                                                       // tableRowtwo.setVisibility(View.VISIBLE);
                                                   // textMusic.setVisibility(View.GONE);
                                                settingrls.setVisibility(View.GONE);
                                                relativeLayouts.setVisibility(View.VISIBLE);
                                                testsrls.setVisibility(View.GONE);
                                                ShowProfile();
                                                        break;
                                              case R.id.action_tests:
                                                //  tableLayoutone.setVisibility(View.VISIBLE);
                                                 //       textFavorites.setVisibility(View.GONE);
                                                 //    textSchedules.setVisibility(View.GONE);
                                                 //        textMusic.setVisibility(View.VISIBLE);
                                                  settingrls.setVisibility(View.GONE);
                                                  relativeLayouts.setVisibility(View.GONE);
                                                  testsrls.setVisibility(View.VISIBLE);
                                                       break;
                                             }
                                        return false;
                                    }
                });


               snewTest.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent i = new Intent(StuFirstPage.this,ReceiveTestInfo.class);
                       startActivity(i);
                   }
               });

            changepasstxts.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(StuFirstPage.this, ChangePass.class);
                    startActivity(intent);
                }
            });
               logouttxts.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(getApplicationContext());
                       appPreferencesHelper.LogOut();
                       Intent intent=new Intent(StuFirstPage.this, ChooseUser.class);
                       startActivity(intent);
                       finish();
                   }
               });

               managenotifis.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent=new Intent(StuFirstPage.this, ManageNotiff.class);
                       startActivity(intent);
                   }
               });
               editproftxts.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent=new Intent(StuFirstPage.this, Profile.class);
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
        Sid.setText(appPreferencesHelper.getCurrentStudentId());
    }
    private  void SendToken() {
        AppPreferencesHelper appPreferencesHelper = new AppPreferencesHelper(getApplicationContext());
        if (!appPreferencesHelper.getIssendftoken()){
            SaveFireBaseTokenClass saveFireBaseTokenClass = new SaveFireBaseTokenClass(getApplicationContext(), FirebaseInstanceId.getInstance().getToken(), appPreferencesHelper.getCurrentEmail());
        }
    }

 }
