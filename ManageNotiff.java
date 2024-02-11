package p.zahra.testtbl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class ManageNotiff extends AppCompatActivity {
    Switch managenotiff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_notiff);
        managenotiff= (Switch) findViewById(R.id.nswitch);

        final AppPreferencesHelper appPreferencesHelper=new AppPreferencesHelper(this);
        managenotiff.setChecked(appPreferencesHelper.getShowNotiff());

        managenotiff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                appPreferencesHelper.setShowNotiff(isChecked);
            }
        });

    }
}
