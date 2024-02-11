package p.zahra.testtbl.Stu.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import p.zahra.testtbl.R;
import p.zahra.testtbl.Stu.Classes.SRegisterClass;

/**
 * Created by Lenovo Z on 27/01/2018.
 */

public class SRegister extends AppCompatActivity {
    SRegisterClass sclassServer;
   // EditText scode;
    EditText sname;
    EditText slastname;
    EditText semail;
    EditText spassword;
    EditText seducode;
    EditText sid;
    Button sbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sregister);
        sbutton=(Button)findViewById(R.id.sbutton);
        sname=(EditText)findViewById(R.id.sname);
        slastname=(EditText)findViewById(R.id.slastname);
        semail=(EditText)findViewById(R.id.semail);
        spassword=(EditText)findViewById(R.id.spassword);
        seducode=(EditText)findViewById(R.id.seducode);
        sid=(EditText)findViewById(R.id.sid);

        sbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String pid=scode.getText().toString().trim();
                String suser = sname.getText().toString().trim();
                String slast = slastname.getText().toString().trim();
                String sema = semail.getText().toString().trim();
                String spass = spassword.getText().toString().trim();
                String seduid=seducode.getText().toString().trim();
                String stuid=sid.getText().toString().trim();
                if (stuid.isEmpty()){
                    Toast.makeText(SRegister.this, " Please enter your Student Id", Toast.LENGTH_SHORT).show();
                }
                else if (suser.isEmpty())

                { Toast.makeText(SRegister.this, " Please enter your name", Toast.LENGTH_SHORT).show();}

                else if (slast.isEmpty()) {
                    Toast.makeText(SRegister.this, " please enter your lastname", Toast.LENGTH_SHORT).show();
                } else if (sema.isEmpty()) {
                    Toast.makeText(SRegister.this, " please enter an email", Toast.LENGTH_SHORT).show();
                } else if (spass.isEmpty()) {
                    Toast.makeText(SRegister.this, " please enter a password ", Toast.LENGTH_SHORT).show();
                }
                else if (seduid.isEmpty()) {
                    Toast.makeText(SRegister.this, " please enter your educationfielde code ", Toast.LENGTH_SHORT).show();
                }
                else

                { sclassServer=new SRegisterClass(SRegister.this,suser,slast,sema,spass,seduid,stuid);}
            }
        });}}