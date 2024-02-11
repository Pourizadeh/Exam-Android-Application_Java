package p.zahra.testtbl.Stu.Activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import p.zahra.testtbl.R;
import p.zahra.testtbl.Stu.Classes.GetTestInfoClass;
import p.zahra.testtbl.Stu.GetSets.GetsetTestInfo;
import p.zahra.testtbl.Stu.adapters.adapterGetTestInfo;

import static p.zahra.testtbl.R.id.rcoursecode;


public class ReceiveTestInfo extends AppCompatActivity {
RecyclerView recyclerView;
    adapterGetTestInfo examadapter;

   // Button startexam;
  //  int pid,tid,educode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receivetestinfo);
        recyclerView=(RecyclerView)findViewById(R.id.rcymain);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL) );
        GetTestInfoClass apiservis=new GetTestInfoClass(this);

        apiservis.getpost(new GetTestInfoClass.onpost() {
            @Override
            public void onpost(List<GetsetTestInfo> data) {
                if (data.size()==0){
                    Toast.makeText(getApplicationContext(),"There are no test",Toast.LENGTH_LONG).show();
                }

                examadapter =new adapterGetTestInfo(ReceiveTestInfo.this,data);
                recyclerView.setAdapter(examadapter);

               /* SQLiteDatabase db=SQLiteDatabase.openOrCreateDatabase("appdatabase", MODE_PRIVATE,null);
                db.execSQL("CREATE TABLE IF NOT EXIST testinfo (PID INT (10) , TID INT(10) , EDUCODE INT(10));");
                db.execSQL("INSERT INTO testinfo VALUES ("+pid+","+tid+","+educode+");");  */
            }
        });

    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//
//    }
}
