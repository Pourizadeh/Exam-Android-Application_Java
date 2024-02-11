package p.zahra.testtbl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import p.zahra.testtbl.Prof.PChangePassClass;
import p.zahra.testtbl.Stu.SChangePassClass;

public class ChangePass extends AppCompatActivity {

    EditText Oldpass;EditText newpass;String Current_Req="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);

         Oldpass=(EditText)findViewById(R.id.editoldpass);
         newpass=(EditText)findViewById(R.id.ETnewpass);
        ImageView editpassdone=(ImageView)findViewById(R.id.editpassdone);
        Bundle b = this.getIntent().getExtras();
        if (b != null){
            Current_Req =b.getString("Current_Req","");
        }
        editpassdone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldpas = Oldpass.getText().toString().trim();
                String newpas = newpass.getText().toString().trim();
                AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(getApplicationContext());
                String email=appPreferencesHelper.getCurrentEmail();
                if ((oldpas.isEmpty())) {
                    Toast.makeText(ChangePass.this, "Please enter your old Password", Toast.LENGTH_SHORT).show();
                } else if (newpas.isEmpty()) {
                    Toast.makeText(ChangePass.this, "Please enter your New Password", Toast.LENGTH_SHORT).show();
                } else {
                    if (Current_Req.equals("pchangepass")){
                        PChangePassClass changePassClass = new PChangePassClass(ChangePass.this, oldpas, newpas,email);

                    }else {
                        SChangePassClass changePassClass = new SChangePassClass(ChangePass.this, oldpas, newpas,email);
                    }
                }

            }
        });

    }
}
