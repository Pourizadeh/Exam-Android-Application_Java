package p.zahra.testtbl.Prof;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import p.zahra.testtbl.R;

public class PRegister extends AppCompatActivity {
RegisterClass classServer;
   EditText pcode;
    EditText pname;
    EditText plastname;
    EditText pemail;
    EditText ppassword;
    EditText peducode;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregister);
        button=(Button)findViewById(R.id.button);
       pcode=(EditText)findViewById(R.id.profid);
        pname=(EditText)findViewById(R.id.name);
        plastname=(EditText)findViewById(R.id.lastname);
        pemail=(EditText)findViewById(R.id.email);
        ppassword=(EditText)findViewById(R.id.password);
        peducode=(EditText)findViewById(R.id.peducode);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String pid=pcode.getText().toString().trim();
                String puser = pname.getText().toString().trim();
                String plast = plastname.getText().toString().trim();
                String pema = pemail.getText().toString().trim();
                String ppass = ppassword.getText().toString().trim();
                String peduid=peducode.getText().toString().trim();
                if (puser.isEmpty())

                { Toast.makeText(PRegister.this, " Please enter your name", Toast.LENGTH_SHORT).show();}

                else if (plast.isEmpty()) {
                    Toast.makeText(PRegister.this, " please enter your lastname", Toast.LENGTH_SHORT).show();
                } else if (pema.isEmpty()) {
                    Toast.makeText(PRegister.this, " please enter an email", Toast.LENGTH_SHORT).show();
                } else if (ppass.isEmpty()) {
                    Toast.makeText(PRegister.this, " please enter a password ", Toast.LENGTH_SHORT).show();
                }
            else

            { classServer=new RegisterClass(PRegister.this,pid,puser,plast,pema,ppass,peduid);}
            }
        });}}