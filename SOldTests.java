package p.zahra.testtbl.Stu.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.List;

import p.zahra.testtbl.Prof.POldTest;
import p.zahra.testtbl.Prof.POldTestAdapter;
import p.zahra.testtbl.Prof.pAllTestClass;
import p.zahra.testtbl.R;
import p.zahra.testtbl.Stu.Classes.sAllTestsClass;
import p.zahra.testtbl.Stu.GetSets.GetsetTestInfo;
import p.zahra.testtbl.Stu.GetSets.STestScore;
import p.zahra.testtbl.Stu.adapters.sOldTestAdapter;

public class SOldTests extends AppCompatActivity {
    RecyclerView recyclerView;
    sOldTestAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sold_tests);
        recyclerView=(RecyclerView)findViewById(R.id.rcyold);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL) );
        sAllTestsClass AllTestClass=new sAllTestsClass(this);

        AllTestClass.getpost(new sAllTestsClass.onpost() {
            @Override
            public void onpost(List<STestScore> examdata) {

                adapter =new sOldTestAdapter(SOldTests.this,examdata);
                recyclerView.setAdapter(adapter);

            }
        });

    }
}
