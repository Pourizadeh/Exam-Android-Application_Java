package p.zahra.testtbl.Prof;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import p.zahra.testtbl.R;

/**
 * Created by Lenovo Z on 26/12/2017.
 */

public class Login extends AppCompatActivity  {
    EditText useremail,userpassword;
    Button loginbtn;
    PLoginClass loginclass;
    String puserema, puserpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plogin);
        useremail = (EditText) findViewById(R.id.emaillogin);
        userpassword = (EditText) findViewById(R.id.pass);
        loginbtn = (Button) findViewById(R.id.loginbtn);

        TextView notregisteryet = (TextView) findViewById(R.id.notregisteryet);
        notregisteryet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, PRegister.class);
                startActivity(intent);
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                puserema = useremail.getText().toString().trim();
                puserpass = userpassword.getText().toString().trim();
                if ((puserema.isEmpty())) {
                    Toast.makeText(Login.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                } else if (puserpass.isEmpty()) {
                    Toast.makeText(Login.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                } else {
                    loginclass = new PLoginClass(Login.this, puserema, puserpass);

                }


            }
        });
    }}