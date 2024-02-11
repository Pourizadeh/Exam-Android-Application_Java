package p.zahra.testtbl.Stu.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import p.zahra.testtbl.AppPreferencesHelper;
import p.zahra.testtbl.R;
import p.zahra.testtbl.Stu.Classes.SLoginClass;

/**
 * Created by Lenovo Z on 27/01/2018.
 */

public class SLogin extends AppCompatActivity {
    EditText suseremail,suserpassword;
    Button sloginbtn;
    SLoginClass sloginclass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slogin);


    /*    if(stuSharedPrefManager.getsInstance(this).isLoggedIn())
        { finish();
            startActivity(new Intent(this,StuFirstPage.class));
            return;}*/
        suseremail=(EditText)findViewById(R.id.semaillogin);
        suserpassword=(EditText)findViewById(R.id.spass);
        sloginbtn=(Button)findViewById(R.id.sloginbtn);
        TextView notregisteryet =(TextView) findViewById(R.id.snotregisteryet);
        notregisteryet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SLogin.this,SRegister.class);
                startActivity(intent);
            }
        });
        sloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String suserema,suserpass;
                suserema=suseremail.getText().toString().trim();
                suserpass=suserpassword.getText().toString().trim();
                if ((suserema.isEmpty())){
                    Toast.makeText(SLogin.this,"Please enter your email",Toast.LENGTH_SHORT).show();}
                else if (suserpass.isEmpty())
                { Toast.makeText(SLogin.this,"Please enter your password",Toast.LENGTH_SHORT).show();}
                else {
                    sloginclass=new SLoginClass(SLogin.this,suserema,suserpass);


                }


            }
        });





}}
