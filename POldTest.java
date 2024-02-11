package p.zahra.testtbl.Prof;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.List;

import p.zahra.testtbl.R;
import p.zahra.testtbl.Stu.Classes.ExamClass;
import p.zahra.testtbl.Stu.GetSets.GetsetExam;
import p.zahra.testtbl.Stu.GetSets.GetsetTestInfo;

public class POldTest extends AppCompatActivity {
    RecyclerView recyclerView;
    POldTestAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pold_test);
        recyclerView=(RecyclerView)findViewById(R.id.rcyold);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL) );
        pAllTestClass pAllTestClass=new pAllTestClass(this);

        pAllTestClass.getpost(new pAllTestClass.onpost() {
            @Override
            public void onpost(List<GetsetTestInfo> examdata) {

                adapter =new POldTestAdapter(POldTest.this,examdata);
                recyclerView.setAdapter(adapter);

            }
        });

    }
}
