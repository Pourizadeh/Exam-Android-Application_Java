package p.zahra.testtbl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import p.zahra.testtbl.Prof.Login;
import p.zahra.testtbl.Prof.ProfFirstPage;
import p.zahra.testtbl.Stu.Activities.SLogin;
import p.zahra.testtbl.Stu.Activities.StuFirstPage;

public class ChooseUser extends AppCompatActivity {
    Button profbtn;
    Button stubtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_user);
        AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(this);
        if (appPreferencesHelper.getIsTLogin()&&appPreferencesHelper.getIsStudent()){
            startActivity(new Intent(this,StuFirstPage.class));
            finish();
        }else if (appPreferencesHelper.getIsTLogin()&&!appPreferencesHelper.getIsStudent()){
            startActivity(new Intent(this,ProfFirstPage.class));
            finish();
        }
        profbtn = (Button) findViewById(R.id.proflogin);
        stubtn = (Button) findViewById(R.id.stulogin);
        profbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseUser.this, Login.class);
                startActivity(intent);
            }
        });
        stubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sintent = new Intent(ChooseUser.this, SLogin.class);
                startActivity(sintent);
            }
        });
    }
}
