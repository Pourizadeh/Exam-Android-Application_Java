package p.zahra.testtbl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import p.zahra.testtbl.Prof.PChangePassClass;

/**
 * Created by Lenovo Z on 27/12/2017.
 */

public class Profile extends AppCompatActivity {
    ImageView EditProfile;
    EditText Name;
    EditText LastName;
    EditText EduFieldCode;
    AppPreferencesHelper appPreferencesHelper;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        Name=(EditText)findViewById(R.id.ETprofname);
        LastName=(EditText)findViewById(R.id.ETproflastname);
        EduFieldCode=(EditText)findViewById(R.id.ETprofeducode);
        EditProfile=(ImageView) findViewById(R.id.editprofiledone);
        appPreferencesHelper=new AppPreferencesHelper(getApplicationContext());

        Name.setText(appPreferencesHelper.getCurrentName());
        LastName.setText(appPreferencesHelper.getCurrentLastName());
        EduFieldCode.setText(appPreferencesHelper.getCurrentEduCode());

        EditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Name.getText().toString().isEmpty())) {
                    Toast.makeText(Profile.this, "Please enter your Name", Toast.LENGTH_SHORT).show();
                } else if (LastName.getText().toString().isEmpty()) {
                    Toast.makeText(Profile.this, "Please enter your Last Name", Toast.LENGTH_SHORT).show();
                } else if (EduFieldCode.getText().toString().isEmpty()) {
                    Toast.makeText(Profile.this, "Please enter your Education Field Code", Toast.LENGTH_SHORT).show();
                }else {
                     new EditProfileClass(Profile.this, Name.getText().toString(), LastName.getText().toString()
                            ,EduFieldCode.getText().toString(),appPreferencesHelper.getCurrentEmail(),appPreferencesHelper.getIsStudent());

                }

            }
        });

    }
}